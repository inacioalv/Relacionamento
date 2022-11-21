package br.com.inacio.ManyToMany.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class ProdutoVenda implements Serializable {
	
	private static final long serialVersionUID = 4742293368241589682L;

	@EmbeddedId
	private ProdutoVendaPK id = new ProdutoVendaPK();
	
	public ProdutoVenda() {}

	public ProdutoVenda(Produto produto, Venda venda) {
		super();
		id.setProduto(produto);
		id.setVenda(venda);
		
	}

	public Venda getVenda() {
		return id.getVenda();
	}

	public void setVenda(Venda venda) {
		id.setVenda(venda);
	}

	public Produto getProduto() {
		return id.getProduto();
	}

	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
	
	public ProdutoVendaPK getId() {
		return id;
	}

	public void setId(ProdutoVendaPK id) {
		this.id = id;
	}

}
