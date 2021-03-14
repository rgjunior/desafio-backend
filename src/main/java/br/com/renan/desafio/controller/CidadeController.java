package br.com.renan.desafio.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.renan.desafio.controller.dto.CidadeDto;
import br.com.renan.desafio.controller.dto.ClienteDto;
import br.com.renan.desafio.controller.form.CidadeForm;
import br.com.renan.desafio.controller.form.ClienteForm;
import br.com.renan.desafio.modelo.Cidade;
import br.com.renan.desafio.modelo.Cliente;
import br.com.renan.desafio.repository.CidadeRepository;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@GetMapping
	public Page<CidadeDto> listar(@RequestParam (required = false)String cidade, 
			@RequestParam (required = false)String estado,
			@PageableDefault(sort = "id", direction = Direction.DESC, page = 0, size = 20) Pageable paginacao) {
		
		if (cidade == null && estado == null) {
			Page<Cidade> cidades = cidadeRepository.findAll(paginacao);
			return CidadeDto.converter(cidades);
		} if (estado != null) {
			Page<Cidade> cidades = cidadeRepository.findByEstado(estado, paginacao);
			return CidadeDto.converter(cidades);
		} else {
			Page<Cidade> cidades = cidadeRepository.findByCidade(cidade, paginacao);
			return CidadeDto.converter(cidades);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<CidadeDto> cadastrar(@RequestBody @Valid CidadeForm form, UriComponentsBuilder uriBuilder) {
		
		Cidade cidade = form.converter();
		cidadeRepository.save(cidade);
		
		URI uri = uriBuilder.path("/cidades/{id}").buildAndExpand(cidade.getId()).toUri();
		return ResponseEntity.created(uri).body(new CidadeDto(cidade));
	}

}
