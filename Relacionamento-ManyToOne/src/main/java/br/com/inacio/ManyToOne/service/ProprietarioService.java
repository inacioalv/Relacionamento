package br.com.inacio.ManyToOne.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.inacio.ManyToOne.model.Proprietario;
import br.com.inacio.ManyToOne.repository.ProprietarioRepository;

@Service
public class ProprietarioService {
	
	private ProprietarioRepository repository;

	public ProprietarioService(ProprietarioRepository repository) {
		super();
		this.repository = repository;
	}
	
	public Proprietario salvar(Proprietario proprietario) {
		return repository.save(proprietario);
	}
	
	public List<Proprietario> buscarTodos(){
		return repository.findAll();
	}

}
