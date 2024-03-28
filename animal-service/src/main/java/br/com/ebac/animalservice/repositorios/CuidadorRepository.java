package br.com.ebac.animalservice.repositorios;

import br.com.ebac.animalservice.entidades.Cuidador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuidadorRepository extends JpaRepository<Cuidador, Long> {
    Cuidador findByNome(String nome);

}