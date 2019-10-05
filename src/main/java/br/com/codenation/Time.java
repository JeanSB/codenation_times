package br.com.codenation;

import java.time.LocalDate;

public class Time {

	private Long capitao;
	private String nome;
	private LocalDate dataCriacao;
	private String corUniformePrincipal;
	private String corUniformeSecundario;
	


	@Override
	public String toString() {
		return "Time [capitao=" + capitao + ", nome=" + nome + ", dataCriacao=" + dataCriacao
				+ ", corUniformePrincipal=" + corUniformePrincipal + ", corUniformeSecundario=" + corUniformeSecundario
				+ "]";
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (capitao ^ (capitao >>> 32));
		result = prime * result + ((corUniformePrincipal == null) ? 0 : corUniformePrincipal.hashCode());
		result = prime * result + ((corUniformeSecundario == null) ? 0 : corUniformeSecundario.hashCode());
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Time other = (Time) obj;
		if (capitao != other.capitao)
			return false;
		if (corUniformePrincipal == null) {
			if (other.corUniformePrincipal != null)
				return false;
		} else if (!corUniformePrincipal.equals(other.corUniformePrincipal))
			return false;
		if (corUniformeSecundario == null) {
			if (other.corUniformeSecundario != null)
				return false;
		} else if (!corUniformeSecundario.equals(other.corUniformeSecundario))
			return false;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}



	public Time(String nome, LocalDate dataCriacao, String corUniformePrincipal,
			String corUniformeSecundario) {
	
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.corUniformePrincipal = corUniformePrincipal;
		this.corUniformeSecundario = corUniformeSecundario;
	}
	
	public Time(Long capitao) {
		this.capitao = capitao;
	}
	
	
	public Long getCapitao() {
		return capitao;
	}

	public void setCapitao(Long capitao) {
		this.capitao = capitao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getCorUniformePrincipal() {
		return corUniformePrincipal;
	}
	public void setCorUniformePrincipal(String corUniformePrincipal) {
		this.corUniformePrincipal = corUniformePrincipal;
	}
	public String getCorUniformeSecundario() {
		return corUniformeSecundario;
	}
	public void setCorUniformeSecundario(String corUniformeSecundario) {
		this.corUniformeSecundario = corUniformeSecundario;
	}
	
	
}
