package br.com.inacio.ManyToOne.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

}
