package br.com.inacio.OneToOne.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.inacio.OneToOne.model.Usuario;
import br.com.inacio.OneToOne.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private UsuarioRepository repository;

	public UsuarioService(UsuarioRepository repository) {
		super();
		this.repository = repository;
	}
	
	
	public Usuario salvar(Usuario usuario) {
		return repository.save(usuario);
	}
	
	public Optional<Usuario> buscarPorId(UUID id) {
		return repository.findById(id);
	}
	
	public List<Usuario> buscarTodos(){
		return repository.findAll();
	}

}
