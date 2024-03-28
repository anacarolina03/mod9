package br.com.ebac.animalservice.controllers;

import br.com.ebac.animalservice.entidades.Cuidador;
import br.com.ebac.animalservice.repositorios.AnimalRepository;
import br.com.ebac.animalservice.repositorios.CuidadorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuidador")
public class CuidadorController {

	private AnimalRepository animalRepository;
	private final CuidadorRepository cuidadorRepository;

	public CuidadorController(AnimalRepository animalRepository, CuidadorRepository cuidadorRepository) {
		this.animalRepository = animalRepository;
		this.cuidadorRepository = cuidadorRepository;
	}

	@GetMapping
	private List<Cuidador> findAll() {
		return cuidadorRepository.findAll();
	}

	@PostMapping
	private Cuidador create(@RequestBody Cuidador cuidador) {
		return cuidadorRepository.save(cuidador);
	}

}





