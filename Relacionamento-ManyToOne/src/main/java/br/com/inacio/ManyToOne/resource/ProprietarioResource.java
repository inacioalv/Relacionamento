package br.com.inacio.ManyToOne.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
	public Proprietario salvar(@RequestBody Proprietario proprietario) {
		return proprietarioService.salvar(proprietario);
	}
	
	@GetMapping
	public ResponseEntity<List<Proprietario>> buscatTodos(){
		List<Proprietario> buscarTodos = proprietarioService.buscarTodos();
		return new ResponseEntity<>(buscarTodos,HttpStatus.OK);
	}

}
