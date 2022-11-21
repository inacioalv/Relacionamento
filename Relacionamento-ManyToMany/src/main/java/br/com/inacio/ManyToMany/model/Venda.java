package br.com.inacio.ManyToMany.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venda implements Serializable {
	
	private static final long serialVersionUID = 8105771382221692674L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome_cliente;
	private String data;
	private double quantidade;
	
	@OneToMany(mappedBy = "id.venda")
	private Set<ProdutoVenda> produtovenda = new HashSet<>();
	
	public List<Produto> getproduto(){
		List<Produto> produtos = new ArrayList<Produto>();
		for(ProdutoVenda o:produtovenda) {
			produtos.add(o.getProduto());
		}
		return produtos;
	}
	
	
//	@ManyToMany(mappedBy = "vendas",fetch = FetchType.LAZY)
//	private List<Produto> produtos;

}
