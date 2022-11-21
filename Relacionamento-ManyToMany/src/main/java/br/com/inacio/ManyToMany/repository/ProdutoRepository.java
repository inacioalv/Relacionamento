package br.com.inacio.ManyToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inacio.ManyToMany.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

}
