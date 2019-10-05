package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {
	
	private Long idTime;
	private String nome;
	private LocalDate dataNascimento;
	private Integer nivelHabilidade;
	private BigDecimal salario;
	
	
	@Override
	public String toString() {
		return "Jogador [idTime=" + idTime + ", nome=" + nome + ", dataNascimento=" + dataNascimento
				+ ", nivelHabilidade=" + nivelHabilidade + ", salario=" + salario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + (int) (idTime ^ (idTime >>> 32));
		result = prime * result + ((nivelHabilidade == null) ? 0 : nivelHabilidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (idTime != other.idTime)
			return false;
		if (nivelHabilidade == null) {
			if (other.nivelHabilidade != null)
				return false;
		} else if (!nivelHabilidade.equals(other.nivelHabilidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		return true;
	}

	public Jogador(Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade,
			BigDecimal salario) {
		this.idTime = idTime;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.nivelHabilidade = nivelHabilidade;
		this.salario = salario;
	}
	
	public Long getIdTime() {
		return idTime;
	}
	public void setIdTime(Long idTime) {
		this.idTime = idTime;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Integer getNivelHabilidade() {
		return nivelHabilidade;
	}
	public void setNivelHabilidade(Integer nivelHabilidade) {
		this.nivelHabilidade = nivelHabilidade;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	

}
