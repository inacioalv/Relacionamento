package br.com.inacio.OneToOne.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.inacio.OneToOne.model.Perfil;
import br.com.inacio.OneToOne.repository.PerfilRepository;

@Service
public class PerfilService {
	
	private PerfilRepository repository;

	public PerfilService(PerfilRepository repository) {
		super();
		this.repository = repository;
	}
	
	public Perfil salvar(Perfil perfil) {
		return repository.save(perfil);
	}
	
	public List<Perfil> buscarTodos() {
		return repository.findAll();
	}

}
