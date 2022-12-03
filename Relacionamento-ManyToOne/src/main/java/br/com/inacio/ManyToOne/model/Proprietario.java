package br.com.inacio.ManyToOne.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Proprietario implements Serializable {
	
	private static final long serialVersionUID = -2530536440519544967L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int idade;
	private String telefone;
	@OneToMany(mappedBy = "proprietario",fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Imovel> imovels;
}
