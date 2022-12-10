package br.com.inacio.ManyToOne.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.inacio.ManyToOne.exception.ResourceNotFoundException;
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
	
	public Optional<Proprietario> buscarPorId(Long id) {
		return repository.findById(id);
	}
	
	public Proprietario atualizar(Proprietario obj) {
		verifyIfExists(obj.getId());
		return repository.save(obj);
	}
	
	private Proprietario verifyIfExists(Long id) throws ResourceNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Proprietario não encontrado com ID:" + id));
	}

}
