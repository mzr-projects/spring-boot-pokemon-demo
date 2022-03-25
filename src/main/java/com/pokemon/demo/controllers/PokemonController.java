package com.pokemon.demo.controllers;

import com.pokemon.demo.entities.Pokemon;
import com.pokemon.demo.services.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/pokemon")
@RequiredArgsConstructor
public class PokemonController {

	private final PokemonService pokemonService;

	@PostMapping(value = "/store/{number}")
	public void storePokemons(@PathVariable Integer number) {
		pokemonService.saveToDatabase(number);
	}

	@GetMapping(value = "/all")
	public Flux<Pokemon> getAllPokemons() {
		return pokemonService.getAllPokemons();
	}
}
