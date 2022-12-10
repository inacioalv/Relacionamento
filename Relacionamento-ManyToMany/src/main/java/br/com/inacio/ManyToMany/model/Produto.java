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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto implements Serializable {

	private static final long serialVersionUID = -1248252608293478027L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeProduto;
	private double preco;

	@OneToMany(mappedBy = "id.venda")
	@JsonIgnore
	private Set<ProdutoVenda> produtovenda = new HashSet<>();
	
	public List<Venda> getvenda(){
		List<Venda> vendas = new ArrayList<Venda>();
		for(ProdutoVenda o :produtovenda) {
			vendas.add(o.getVenda());
		}
		return vendas;
	}
	
	
	

//	@ManyToMany()
//	@JoinTable(
//			  name = "produto_vendas", 
//			  joinColumns = @JoinColumn(name = "produto_fk"), 
//			  inverseJoinColumns = @JoinColumn(name = "venda_fk"))
//	private List<Venda> vendas;

}
