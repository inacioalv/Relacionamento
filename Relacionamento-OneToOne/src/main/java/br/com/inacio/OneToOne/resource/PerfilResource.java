package br.com.inacio.OneToOne.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.inacio.OneToOne.model.Perfil;
import br.com.inacio.OneToOne.service.PerfilService;

@RestController
@RequestMapping("/perfil")
public class PerfilResource {
	
	private PerfilService service;

	public PerfilResource(PerfilService service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public Perfil salvar(@RequestBody Perfil perfil) {
		return service.salvar(perfil);
	}
	
	@GetMapping
	private ResponseEntity<List<Perfil>> buscarTodos() {
		List<Perfil> buscarTodos = service.buscarTodos();
		return new ResponseEntity<>(buscarTodos,HttpStatus.OK);
	}

}
