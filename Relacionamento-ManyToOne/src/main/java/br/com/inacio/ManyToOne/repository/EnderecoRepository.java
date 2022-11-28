package br.com.inacio.ManyToOne.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inacio.ManyToOne.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {

}
