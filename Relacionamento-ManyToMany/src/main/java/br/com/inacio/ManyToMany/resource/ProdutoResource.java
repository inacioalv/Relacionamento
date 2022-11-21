package br.com.inacio.ManyToMany.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.inacio.ManyToMany.model.Produto;
import br.com.inacio.ManyToMany.service.ProdutoService;

@RestController
@RequestMapping(value = "/produto" )
public class ProdutoResource {
	
	private ProdutoService produtoService;

	public ProdutoResource(ProdutoService produtoService) {
		super();
		this.produtoService = produtoService;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Produto salvarProduto (@RequestBody Produto produto) {
		return produtoService.salvarProduto(produto);
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodosProdutos(){
		List<Produto> buscarTodosProdutos = produtoService.buscarTodosProdutos();
		return new ResponseEntity<>(buscarTodosProdutos,HttpStatus.OK);
	}

}
