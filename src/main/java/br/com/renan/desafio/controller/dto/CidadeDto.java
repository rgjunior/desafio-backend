package br.com.renan.desafio.controller.dto;

import org.springframework.data.domain.Page;

import br.com.renan.desafio.modelo.Cidade;

public class CidadeDto {

	private Long id;
	private String cidade;
	private String estado;

	public CidadeDto(Cidade cidade) {
		this.id = cidade.getId();
		this.cidade = cidade.getCidade();
		this.estado = cidade.getEstado();
	}

	public Long getId() {
		return id;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public static Page<CidadeDto> converter(Page<Cidade> cidades) {
		return cidades.map(CidadeDto::new);
	}

}
