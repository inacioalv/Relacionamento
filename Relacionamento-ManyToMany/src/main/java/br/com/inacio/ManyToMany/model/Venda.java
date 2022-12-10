package br.com.inacio.ManyToMany.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.inacio.ManyToMany.enums.Formadepagamento;
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
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable
	private Set<Integer> forma = new HashSet<Integer>();
	
	private String endereco;
	private double totalgeral;
	
	@OneToMany(mappedBy = "id.venda")
	private Set<ProdutoVenda> produtovenda = new HashSet<>();
	
	public List<Produto> getproduto(){
		List<Produto> produtos = new ArrayList<Produto>();
		for(ProdutoVenda o:produtovenda) {
			produtos.add(o.getProduto());
		}
		return produtos;
	}
	
	public Set<Formadepagamento> getForma() {
		return forma.stream().map(x -> Formadepagamento.toEnum(x)).collect(Collectors.toSet());
	}

	public void addforma(Formadepagamento formadepagamento) {
		forma.add(formadepagamento.getCodigo());
	}
	
	
	
//	@ManyToMany(mappedBy = "vendas",fetch = FetchType.LAZY)
//	private List<Produto> produtos;

}
