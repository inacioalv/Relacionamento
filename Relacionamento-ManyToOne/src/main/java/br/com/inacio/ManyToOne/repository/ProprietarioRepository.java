package br.com.inacio.ManyToOne.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inacio.ManyToOne.model.Proprietario;

public interface ProprietarioRepository extends JpaRepository<Proprietario,Long> {

}
