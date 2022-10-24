package br.com.jntour.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jntour.models.Acesso;

@Repository
public interface AcessoRepository extends JpaRepository<Acesso, Long> {

}
