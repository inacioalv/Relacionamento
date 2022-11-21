package br.com.inacio.ManyToMany.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.inacio.ManyToMany.model.Venda;
import br.com.inacio.ManyToMany.repository.VendaRepository;

@Service
public class VendaService {
	
	private VendaRepository repository;

	public VendaService(VendaRepository repository) {
		super();
		this.repository = repository;
	}
	
	public Venda salvarCliente(Venda cliente ) {
		return repository.save(cliente);
	}
	
	public List<Venda> buscarTodosClientes (){
		return repository.findAll();
	}

}
