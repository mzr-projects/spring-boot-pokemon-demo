package com.pokemon.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pokemons")
public class Pokemon {

	@Id
	private String name;
	private BigDecimal weight;
	private BigDecimal height;
	private List<String> moves = new ArrayList<>();
	private List<String> pokemonTypes = new ArrayList<>();
}

