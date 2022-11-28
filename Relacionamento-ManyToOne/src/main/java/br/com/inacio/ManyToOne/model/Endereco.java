package br.com.inacio.ManyToOne.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 2428264574588188493L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "endereco_id")
	private Long id;
	private String cep;
	private String logradouro;
	private String bairro;
//	@OneToOne(cascade = CascadeType.DETACH)
//	@JoinColumn(name = "imovel_id")
//	private Imovel imovel;
}