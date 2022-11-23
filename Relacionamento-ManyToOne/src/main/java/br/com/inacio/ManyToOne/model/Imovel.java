package br.com.inacio.ManyToOne.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Imovel implements Serializable {

	private static final long serialVersionUID = -8654891696196923215L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String tipo;
	private String cep;
	private String logradouro;
	private String bairro;
	@ManyToOne
	@JoinColumn(name = "proprietario_id",nullable = false)
	private Proprietario proprietario;

}
