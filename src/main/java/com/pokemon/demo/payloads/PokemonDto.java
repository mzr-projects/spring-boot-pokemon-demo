package com.pokemon.demo.payloads;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class PokemonDto {

	private String name;
	private BigDecimal weight;
	private BigDecimal height;
	private List<PokemonMoveDto> moves = new ArrayList<>();
	private List<PokemonTypeDto> types = new ArrayList<>();
}
