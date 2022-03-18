package com.pokemon.demo.payloads;

import lombok.Data;

import java.util.List;

@Data
public class PokemonBaseDto {

	private int count;
	private String next;
	private String previous;
	private List<PokemonDataDto> results;

}
