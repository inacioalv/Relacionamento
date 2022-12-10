package br.com.inacio.ManyToOne.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.inacio.ManyToOne.exception.ResourceNotFoundException;
import br.com.inacio.ManyToOne.model.Imovel;
import br.com.inacio.ManyToOne.repository.ImovelRepository;

@Service
public class ImovelService {
	
	private ImovelRepository repository;

	public ImovelService(ImovelRepository repository) {
		super();
		this.repository = repository;
	}
	
	public Imovel salvar(Imovel imovel) {
		return repository.save(imovel);
	}
	
	public List<Imovel> buscarTodos(){
		return repository.findAll();
	}
	public Optional<Imovel> buscarPorId(Long id) {
		return repository.findById(id);
	}
	
	public Imovel atualizar(Imovel obj) {
		verifyIfExists(obj.getId());
		return repository.save(obj);
	}
	
	private Imovel verifyIfExists(Long id) throws ResourceNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado com ID:" + id));
	}

}
