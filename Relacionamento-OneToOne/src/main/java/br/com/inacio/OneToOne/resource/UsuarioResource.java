package br.com.inacio.OneToOne.resource;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.inacio.OneToOne.exception.ObjectNotFoundException;
import br.com.inacio.OneToOne.model.Perfil;
import br.com.inacio.OneToOne.model.Usuario;
import br.com.inacio.OneToOne.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

	private UsuarioService service;

	public UsuarioResource(UsuarioService service) {
		super();
		this.service = service;
	}

	@PostMapping
	public Usuario salvar(@RequestBody Usuario usuario) {
		return service.salvar(usuario);
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<Usuario> buscarPorId(@PathVariable UUID id) {
		Optional<Usuario> buscarPorId = service.buscarPorId(id);
		if (buscarPorId.isEmpty())
			throw new ObjectNotFoundException("Usuário não encontrado com ID"+id);
		return buscarPorId;
	}
	
	//Retorna o perfil do usuario
	@GetMapping("/{id}/perfil")
	@ResponseStatus(code = HttpStatus.OK)
	public Optional<Perfil> buscarPerfil(@PathVariable UUID id) {
		Optional<Usuario> buscarPorId = service.buscarPorId(id);
		if (buscarPorId.isEmpty())
			throw new ObjectNotFoundException("Usuário não encontrado com ID"+id);
		return Optional.of(buscarPorId.get().getPerfil());
	}

	@GetMapping
	public ResponseEntity<List<Usuario>> buscarTodos() {
		List<Usuario> buscarTodos = service.buscarTodos();
		return new ResponseEntity<>(buscarTodos, HttpStatus.OK);
	}

}
