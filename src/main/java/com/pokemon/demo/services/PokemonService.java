package com.pokemon.demo.services;

import com.pokemon.demo.entities.Pokemon;
import com.pokemon.demo.payloads.*;
import com.pokemon.demo.repositories.PokemonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PokemonService {

	private final PokemonRepository pokemonRepository;
	private final PokemonApiService pokemonApiService;

	public Flux<Pokemon> getAllPokemons() {
		return pokemonRepository.findAll();
	}

	private void createPokemonDto(Pokemon element, PokemonDto pokemonDto) {

		pokemonDto.setName(element.getName());
		pokemonDto.setHeight(element.getHeight());
		pokemonDto.setWeight(element.getWeight());

		List<String> moves = element.getMoves();
		List<PokemonMoveDto> pokemonMoveDtoSet = new ArrayList<>();
		moves.forEach((move) -> {
			PokemonMoveDto pokemonMoveDto = new PokemonMoveDto();
			Move moveToBeStored = new Move();
			moveToBeStored.setName(move);
			pokemonMoveDto.setMove(moveToBeStored);
			pokemonMoveDtoSet.add(pokemonMoveDto);
		});

		List<String> types = element.getPokemonTypes();
		List<PokemonTypeDto> pokemonTypeDtos = new ArrayList<>();
		types.forEach((type) -> {
			PokemonTypeDto pokemonType = new PokemonTypeDto();
			Type typeToBeStored = new Type();
			typeToBeStored.setName(type);
			pokemonType.setType(typeToBeStored);
			pokemonTypeDtos.add(pokemonType);
		});

		pokemonDto.setMoves(pokemonMoveDtoSet);
		pokemonDto.setTypes(pokemonTypeDtos);
	}

	public void saveToDatabase(int number) {
		for (int i = 1; i < number; i++) {
			Mono<PokemonDto> mono = pokemonApiService.getPokemon(i);
			mono.log().subscribe((data) -> {
				Pokemon pokemon = createPokemonEntity(data);
				pokemonRepository.save(pokemon).subscribe();
			}, error -> System.err.println("Error : " + error));
		}
	}

	private Pokemon createPokemonEntity(PokemonDto data) {
		Pokemon pokemon = new Pokemon();

		pokemon.setName(StringUtils.capitalize(data.getName()));
		pokemon.setHeight(data.getHeight());
		pokemon.setWeight(data.getWeight());

		List<String> types = new ArrayList<>();
		data.getTypes().forEach(element -> types.add(element.getType().getName()));
		pokemon.setPokemonTypes(types);

		List<String> moves = new ArrayList<>();
		data.getMoves().subList(0, 4).forEach(element -> moves.add(element.getMove().getName()));
		pokemon.setMoves(moves);

		return pokemon;
	}
}
