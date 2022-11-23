package br.com.inacio.ManyToOne.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inacio.ManyToOne.model.Imovel;

public interface ImovelRepository extends JpaRepository<Imovel,Long> {

}
