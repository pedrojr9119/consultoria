package br.com.apr.sistema.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apr.sistema.entidade.QuemSomos;

@Repository
public interface IQuemSomosRepositorio extends JpaRepository<QuemSomos, Long> {

}