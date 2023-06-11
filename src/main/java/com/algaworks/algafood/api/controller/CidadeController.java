package com.algaworks.algafood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.exception.EntidadeNaoExistenteException;
import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import com.algaworks.algafood.domain.service.CadastroCidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

	@Autowired
	CidadeRepository cidadeRepository;

	@Autowired
	CadastroCidadeService cadastroCidadeService;

	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}

	@GetMapping
	@RequestMapping(value = "/filtra-cidade")
	public List<Cidade> filtraCidade(@RequestParam String nomeCidade) {
		return cidadeRepository.findFiltraCidadeByNomeContainingIgnoreCase(nomeCidade);
	}

	@GetMapping
	@RequestMapping(value = "/{idCidade}")
	public ResponseEntity<Cidade> buscar(@PathVariable Long idCidade) {

		Optional<Cidade> cidade = cidadeRepository.findById(idCidade);
		if (cidade.isPresent()) {
			return ResponseEntity.ok(cidade.get());
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Cidade cidade) {

		try {
			cidade = cadastroCidadeService.salvar(cidade);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(cidade);

		} catch (EntidadeNaoExistenteException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PutMapping(value = "/{idCidade}")
	public ResponseEntity<?> atualizar(@PathVariable Long idCidade, @RequestBody Cidade cidade) {

		try {
			Optional<Cidade> cidadeAtual = cidadeRepository.findById(idCidade);
			
			if (cidadeAtual.isPresent()) {
				BeanUtils.copyProperties(cidade, cidadeAtual.get(), "id");
				Cidade cidadeAtualSalva = cadastroCidadeService.salvar(cidadeAtual.get());
				return ResponseEntity.ok(cidadeAtualSalva);
			}

		} catch (EntidadeNaoExistenteException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

		return ResponseEntity.notFound().build();
	}

	
	@DeleteMapping(value = "/{idCidade}")
	public ResponseEntity<?> remover(@PathVariable Long idCidade){
		try {
			cadastroCidadeService.remover(idCidade);
			return ResponseEntity.noContent().build();

		} catch (EntidadeNaoExistenteException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	
	
	@GetMapping
	@RequestMapping(value = "/filtra-primeira-cidade")
	public Cidade filtraPrimeiraCidade(@RequestParam String nomeCidade) {
		return cidadeRepository.findFirstBuscaPrimeiraCidadeByNomeContainingIgnoreCase(nomeCidade);
	}
	
	@GetMapping
	@RequestMapping(value = "/filtra-top2-cidades")
	public List<Cidade> filtraTop2Cidades(@RequestParam String nomeCidade) {
		return cidadeRepository.getTop2CidadesByNomeContainingIgnoreCase(nomeCidade);
	}
	
	@GetMapping
	@RequestMapping(value = "/filtra-exists-cidade")
	public boolean filtraExistsCidade(@RequestParam String nomeCidade) {
		return cidadeRepository.existsCidadeByNomeContainingIgnoreCase(nomeCidade);
	}
	
	@GetMapping
	@RequestMapping(value = "/filtra-count-cidades")
	public int filtraCountCidades(@RequestParam String nomeCidade) {
		return cidadeRepository.countCidadesByNomeContainingIgnoreCase(nomeCidade);
	}

}
