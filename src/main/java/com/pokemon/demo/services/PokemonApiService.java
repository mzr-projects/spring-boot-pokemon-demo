package com.pokemon.demo.services;

import com.pokemon.demo.payloads.PokemonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PokemonApiService {

	private final WebClient webClient;

	public Mono<PokemonDto> getPokemon(int i) {
		return getEachPokemonData(i);
	}

	public Mono<PokemonDto> getEachPokemonData(int pokemon) {
		return webClient.get().uri("/" + pokemon).retrieve().bodyToMono(PokemonDto.class);
	}
}
