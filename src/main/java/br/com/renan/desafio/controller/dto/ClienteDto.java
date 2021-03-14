package br.com.renan.desafio.controller.dto;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.renan.desafio.modelo.Cidade;
import br.com.renan.desafio.modelo.Cliente;

public class ClienteDto {

	private Long id;
	private String nome;
	private String sexo;
	private LocalDate data;
	private int idade;
	private Cidade cidade;
	
	public ClienteDto (Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.sexo = cliente.getSexo();
		this.data = cliente.getData();
		this.idade = cliente.getIdade();
		this.cidade = cliente.getCidade();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSexo() {
		return sexo;
	}

	public LocalDate getData() {
		return data;
	}

	public int getIdade() {
		return idade;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public static Page<ClienteDto> converter(Page<Cliente> clientes) {
		return clientes.map(ClienteDto::new);
	}

}
