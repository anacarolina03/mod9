package br.com.ebac.animalservice.repositorios;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import br.com.ebac.animalservice.entidades.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    @Query("SELECT a from Animal a WHERE a.dataSaida IS NULL ORDER BY a.dataEntrada")
    List<Animal> FindNotAdoptedAnimals();

    @Query("SELECT a from Animal a WHERE a.dataSaida IS NOT NULL")
    List<Animal> FindAdoptedAnimals();

    @Query("SELECT a FROM Animal a WHERE a.dataSaida IS NULL AND a.especie = 'cachorro'")
    List<Animal> FindNotAdoptedDog();

    @Query("SELECT a FROM Animal a WHERE a.dataSaida IS NOT NULL AND a.especie = 'cachorro'")
    List<Animal> FindAdoptedDog();

    @Query("SELECT a FROM Animal a WHERE a.dataSaida IS NULL AND a.especie = 'gato'")
    List<Animal> FindNotAdoptedCat();


    @Query("SELECT a FROM Animal a WHERE a.dataSaida IS NOT NULL AND a.especie = 'gato'")
    List<Animal> FindAdoptedCat();

    @Query("SELECT a.cuidador, COUNT(*) as quantidadeAnimais FROM Animal a WHERE a.dataEntrada >= :startDate AND a.dataEntrada <= :endDate " +
            "GROUP BY a.cuidador")
    List<String> FindEmployees(
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate
    );

    @Query("SELECT a FROM Animal a WHERE a.dataEntrada >= :startDate AND a.dataEntrada <= :endDate")
    List<Animal> FindMonthAnimals(LocalDate startDate, LocalDate endDate);

}
