package br.com.inacio.ManyToOne.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String numero;
	private String cep;
	private String logradouro;
	private String bairro;
	@OneToOne
	@JsonIgnore
	private Imovel imovel;
	
}
