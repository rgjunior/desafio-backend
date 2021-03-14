package br.com.renan.desafio.controller.form;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.renan.desafio.modelo.Cidade;

public class CidadeForm {

	@NotNull
	@NotEmpty
	private String cidade;
	@NotNull
	@NotEmpty
	private String estado;

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Cidade converter() {
		return new Cidade(cidade, estado);
	}

}
