package br.com.inacio.ManyToOne.resource;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.inacio.ManyToOne.model.Proprietario;
import br.com.inacio.ManyToOne.service.ProprietarioService;

@RestController
@RequestMapping(value = "/proprietario")
public class ProprietarioResource {
	
	private ProprietarioService proprietarioService;

	public ProprietarioResource(ProprietarioService proprietarioService) {
		super();
		this.proprietarioService = proprietarioService;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Proprietario> salvar(@RequestBody Proprietario proprietario) {
		proprietarioService.salvar(proprietario);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(proprietario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Proprietario>> buscatTodos(){
		List<Proprietario> buscarTodos = proprietarioService.buscarTodos();
		return new ResponseEntity<>(buscarTodos,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Proprietario buscarPorId(@PathVariable Long id) {
		return proprietarioService.buscarPorId(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Proprietario> atualizar(@RequestBody Proprietario proprietario,@PathVariable Long id) {
		proprietario.setId(id);
		proprietarioService.atualizar(proprietario);
		return ResponseEntity.noContent().build();
	}

}
