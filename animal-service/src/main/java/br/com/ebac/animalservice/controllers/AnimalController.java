package br.com.ebac.animalservice.controllers;

import br.com.ebac.animalservice.entidades.Animal;
import br.com.ebac.animalservice.repositorios.AnimalRepository;
import br.com.ebac.animalservice.repositorios.CuidadorRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private AnimalRepository animalRepository;

    private CuidadorRepository cuidadorRepository;

    public AnimalController(AnimalRepository animalRepository,
                            CuidadorRepository cuidadorRepository) {
        this.animalRepository = animalRepository;
        this.cuidadorRepository = cuidadorRepository;
    }
    @GetMapping
    private List<Animal> findAll() {
        return animalRepository.findAll();
    }

    @PostMapping
    private Animal create(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }

    @GetMapping("/not-adopted")
    private List<Animal> FindNotAdoptedAnimals() {
        return animalRepository.FindNotAdoptedAnimals();
    }

    @GetMapping("/adopted")
    private List<Animal> FindAdoptedAnimals() {
        return animalRepository.FindAdoptedAnimals();
    }

    @GetMapping("/not-adopted-dog")
    private List<Animal> FindNotAdoptedDog() {
        return animalRepository.FindNotAdoptedDog();
    }

    @GetMapping("/adopted-dog")
    private List<Animal> FindAdoptedDog() {
        return animalRepository.FindAdoptedDog();
    }

    @GetMapping("/not-adopted-cat")
    private List<Animal> FindNotAdoptedCat() {
        return animalRepository.FindNotAdoptedCat();
    }

    @GetMapping("/adopted-cat")
    private List<Animal> FindAdoptedCat() {
        return animalRepository.FindAdoptedCat();
    }

    @GetMapping("/employee-gap")
    private List<String> FindEmployees() {
        Date startDate = Date.valueOf("2023-02-05");
        Date endDate =  Date.valueOf("2023-07-05");
        return animalRepository.FindEmployees(startDate, endDate);
    }

    // /month?startDate=2023-02-05&endDate=2023-07-05
//    http://localhost:8082/animais/month?
//    &startDate=2023-02-05&endDate=2023-07-05
    @GetMapping("/month")
    private List<Animal> FindMonthAnimals(
            @RequestParam(name = "startDate",required = true)
            @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate startDate,
            @RequestParam(name = "endDate",required = true)
            @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate endDate)
             {
        return animalRepository.FindMonthAnimals(startDate, endDate);
    }
}





