package br.com.renan.desafio.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.renan.desafio.modelo.Cidade;
import br.com.renan.desafio.modelo.Cliente;
import br.com.renan.desafio.repository.CidadeRepository;
import br.com.renan.desafio.repository.ClienteRepository;

public class ClienteForm {

	@NotNull @NotEmpty
	private String nome;
	private String sexo;
	private LocalDate data;
	private int idade;
	private String nomeCidade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public Cliente converter(CidadeRepository cidadeRepository) {
		Cidade cidade = cidadeRepository.findByCidade(nomeCidade);
		return new Cliente(nome, sexo, data, idade, cidade);
	}

	public Cliente atualizar(Long id, ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.getOne(id);
		cliente.setNome(this.nome);
		return cliente;
	}

}
