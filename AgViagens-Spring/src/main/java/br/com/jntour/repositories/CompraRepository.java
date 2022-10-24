package br.com.jntour.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jntour.models.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

}
