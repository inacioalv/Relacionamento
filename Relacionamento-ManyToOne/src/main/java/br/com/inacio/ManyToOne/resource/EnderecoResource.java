package br.com.inacio.ManyToOne.resource;

import java.util.List;
import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.inacio.ManyToOne.model.Endereco;
import br.com.inacio.ManyToOne.service.EnderecoService;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {
	
	private EnderecoService  enderecoService;

	public EnderecoResource(EnderecoService enderecoService) {
		super();
		this.enderecoService = enderecoService;
	}
	
	@PostMapping
	public Endereco salvar(@RequestBody Endereco endereco) {
		return enderecoService.salvar(endereco);
	}
	
	@GetMapping
	public ResponseEntity<List<Endereco>> buscarTodos(){
		List<Endereco> buscarTodos = enderecoService.buscarTodos();
		return new ResponseEntity<>(buscarTodos,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Optional<Endereco> buscarPorId(@PathVariable Long id) {
		return enderecoService.buscarPorId(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> Update(@RequestBody Endereco endereco, @PathVariable Long id) {
		endereco.setId(id);
		enderecoService.Update(endereco);
		return ResponseEntity.noContent().build();
	}
	

}
