package br.com.inacio.OneToOne.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = -4834257346219938057L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String email;
	private String senha;
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "perfil_id")
	private Perfil perfil;

}
