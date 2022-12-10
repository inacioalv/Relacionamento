package br.com.inacio.ManyToMany.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class ProdutoVenda implements Serializable {
	
	private static final long serialVersionUID = 4742293368241589682L;

	@EmbeddedId
	private ProdutoVendaPK id = new ProdutoVendaPK();
	private LocalDate dataVenda = LocalDate.now();
	
	public ProdutoVenda() {}

	public ProdutoVenda(Produto produto, Venda venda,LocalDate dataVenda) {
		super();
		id.setProduto(produto);
		id.setVenda(venda);
		this.dataVenda =dataVenda;
		
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

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}
	
}
