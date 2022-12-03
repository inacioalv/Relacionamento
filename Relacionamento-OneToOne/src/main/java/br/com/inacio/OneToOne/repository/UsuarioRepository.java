package br.com.inacio.OneToOne.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inacio.OneToOne.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,UUID> {

}
