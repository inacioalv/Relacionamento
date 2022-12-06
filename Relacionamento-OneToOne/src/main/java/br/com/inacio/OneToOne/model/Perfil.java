package br.com.inacio.OneToOne.model;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_PERFIL")
public class Perfil implements Serializable {
	
	private static final long serialVersionUID = -6493221891289506206L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String idade;
	private String genero;
	private String telefone;
	//@OneToOne(mappedBy = "perfil")
	@OneToOne
	@JsonIgnore
	private Usuario usuario;

}
