package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

public class DesafioMeuTimeApplication implements MeuTimeInterface {
	
	HashMap<Long, Time> times = new HashMap<Long, Time>();
	HashMap<Long, Jogador> jogadores = new HashMap<Long, Jogador>();
	
	
	@Desafio("incluirTime") //Ok
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		
		if(times.containsKey(id)) {
			throw new IdentificadorUtilizadoException();
		}else {
			times.put(id, new Time(nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
		}
		
	}

	@Desafio("incluirJogador") //Ok
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		
		if (times.containsKey(idTime)) {
			if(jogadores.containsKey(id)) {
				throw new IdentificadorUtilizadoException();
			}else {
				jogadores.put(id, new Jogador(idTime, nome, dataNascimento, nivelHabilidade, salario));
			}
		}else {
			throw new TimeNaoEncontradoException();
		}
		
	}

	@Desafio("definirCapitao") //Ok
	public void definirCapitao(Long idJogador) {
	
		if(jogadores.containsKey(idJogador)) {
			
			times.get(jogadores.get(idJogador).getIdTime()).setCapitao(idJogador);
			
		}else {
			throw new JogadorNaoEncontradoException();
		}
		
		
	}

	@Desafio("buscarCapitaoDoTime") //Ok
	public Long buscarCapitaoDoTime(Long idTime) {
		if(times.containsKey(idTime)) {
			if(times.get(idTime).getCapitao() == null) {
				throw new CapitaoNaoInformadoException();
			}else {
				return times.get(idTime).getCapitao(); 
			}
			
		}else {
			throw new TimeNaoEncontradoException();
		}
	}

	@Desafio("buscarNomeJogador") //Ok
	public String buscarNomeJogador(Long idJogador) {
		
		try {
			return jogadores.get(idJogador).getNome();
		} catch (Exception e) {
			throw new JogadorNaoEncontradoException();
		}
		
		
	}

	@Desafio("buscarNomeTime") //Ok
	public String buscarNomeTime(Long idTime) {
		try {
			return times.get(idTime).getNome();
		} catch (Exception e) {
			throw new TimeNaoEncontradoException();
		}
		
	}

	@Desafio("buscarJogadoresDoTime") //Ok
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		ArrayList<Long> list = new ArrayList<Long>();
		
		if (times.containsKey(idTime)) {
			
			for (Long key : jogadores.keySet()) {
	            
				if(jogadores.get(key).getIdTime().equals(idTime)) {
					list.add(key);
				}
				
			}
			
			Collections.sort(list);
			return list;
			
		}else {
			throw new TimeNaoEncontradoException();
		}
		
	}

	@Desafio("buscarMelhorJogadorDoTime") //OK
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		Integer melhorJogador = 0;
		Long idMelhorJogador = 0L;
		
		if (times.containsKey(idTime)) {
			
			for (Long key : jogadores.keySet()) {
				if(jogadores.get(key).getIdTime().compareTo(idTime) == 0) {
					if(jogadores.get(key).getNivelHabilidade() > melhorJogador || jogadores.get(key).getNivelHabilidade() == melhorJogador && key<idMelhorJogador || idMelhorJogador == 0L) {
						melhorJogador = jogadores.get(key).getNivelHabilidade();
						idMelhorJogador = key;
					}
				}
			}
			return idMelhorJogador;
			
		}else {
			throw new TimeNaoEncontradoException();
		}
	}

	@Desafio("buscarJogadorMaisVelho") //Ok
	public Long buscarJogadorMaisVelho(Long idTime) {
		if (times.containsKey(idTime)) {
			long dias = 0;
			long idJogador = 0;
			
			for (Long key : jogadores.keySet()) {
	            
				if(jogadores.get(key).getIdTime().compareTo(idTime) == 0) {
					long intervalo = ChronoUnit.DAYS.between(jogadores.get(key).getDataNascimento(), LocalDate.now());
					if(intervalo>dias || intervalo == dias && key < idJogador || idJogador == 0) {
						dias = intervalo;
						idJogador = key;
					}
					
				}
				
			}
			return idJogador;
			
			
		}else {
			throw new TimeNaoEncontradoException();
		}
		
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		ArrayList<Long> list = new ArrayList<Long>();
		
		if(times.isEmpty()) {
			return list;
		}else {
			for (Long key : times.keySet()) {
				list.add(key);
			}
			
			Collections.sort(list);
			return list;
		}
		
		
	}

	@Desafio("buscarJogadorMaiorSalario") //Ok
	public Long buscarJogadorMaiorSalario(Long idTime) {
		BigDecimal salario = new BigDecimal(0);
		Long idJogador = 0L;
		
		if (times.containsKey(idTime)) {
			
			for (Long key : jogadores.keySet()) {
				if(jogadores.get(key).getIdTime() == idTime) {
					if(jogadores.get(key).getSalario().compareTo(salario) == 1 || jogadores.get(key).getSalario().compareTo(salario) == 0 && key<idJogador || idJogador == 0) {
						salario = jogadores.get(key).getSalario();
						idJogador = key;
					}
				}
			}
			return idJogador;
			
		}else {
			throw new TimeNaoEncontradoException();
		}
		
		
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		if (jogadores.containsKey(idJogador)) {
			return jogadores.get(idJogador).getSalario();
		}else {
			throw new JogadorNaoEncontradoException();
		}
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		ArrayList<Long> list = new ArrayList<Long>();
		long idPiorJogador = 0;
		int nHabilidade = 0;
		
		if (jogadores.isEmpty()) {
			return list;
		}else {
			for (int i = 0; i<top; i++) {
				for (Long key : jogadores.keySet()) {
					boolean existe = false;
					if(jogadores.get(key).getNivelHabilidade() > nHabilidade || jogadores.get(key).getNivelHabilidade() == nHabilidade && key < idPiorJogador || idPiorJogador == 0) {
						for(int j = 0; j<list.size(); j++) {
							if(key == list.get(j)) {
								existe = true;
							}
						}
						if(!existe) {
							nHabilidade = jogadores.get(key).getNivelHabilidade();
							idPiorJogador = key;
						}
						
					}
				}
				list.add(idPiorJogador);
			}
			return list;
		}
		
		
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		if(times.containsKey(timeDaCasa) && times.containsKey(timeDeFora)) {
			if(times.get(timeDaCasa).getCorUniformePrincipal().equals(times.get(timeDeFora).getCorUniformePrincipal())) {
				return times.get(timeDeFora).getCorUniformeSecundario();
			}else {
				return times.get(timeDeFora).getCorUniformePrincipal();
			}
		}else {
			throw new TimeNaoEncontradoException();
		}
	}

}
