package br.com.inacio.ManyToMany.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.inacio.ManyToMany.model.Produto;
import br.com.inacio.ManyToMany.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private ProdutoRepository repository;

	public ProdutoService(ProdutoRepository repository) {
		super();
		this.repository = repository;
	}

	public Produto salvarProduto(Produto produto) {
		return repository.save(produto);
	}

	public List<Produto> buscarTodosProdutos() {
		return repository.findAll();
	}

}
