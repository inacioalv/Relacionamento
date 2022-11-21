package br.com.inacio.ManyToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inacio.ManyToMany.model.Venda;

public interface VendaRepository extends JpaRepository<Venda,Long> {

}
