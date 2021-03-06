package com.pokemon.demo.controllers;

import com.pokemon.demo.payloads.PokemonDto;
import com.pokemon.demo.services.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
	public List<PokemonDto> getAllPokemons() {
		return pokemonService.getAllPokemons();
	}
}
