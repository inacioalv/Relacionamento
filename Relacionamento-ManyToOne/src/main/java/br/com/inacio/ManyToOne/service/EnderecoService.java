package br.com.inacio.ManyToOne.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.inacio.ManyToOne.exception.ResourceNotFoundException;
import br.com.inacio.ManyToOne.model.Endereco;
import br.com.inacio.ManyToOne.repository.EnderecoRepository;

@Service
public class EnderecoService {

	private EnderecoRepository repository;

	public EnderecoService(EnderecoRepository repository) {
		super();
		this.repository = repository;
	}

	public Endereco salvar(Endereco endereco) {
		return repository.save(endereco);
	}

	public List<Endereco> buscarTodos() {
		return repository.findAll();
	}

	public Optional<Endereco> buscarPorId(Long id) {
		return repository.findById(id);
	}

	public Endereco Update(Endereco obj) {
		verifyIfExists(obj.getNumero_id());
		return repository.save(obj);
	}


	private Endereco verifyIfExists(Long id) throws ResourceNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Endereço não encontrado com ID:" + id));
	}

}
