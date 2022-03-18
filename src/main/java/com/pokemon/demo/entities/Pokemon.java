package com.pokemon.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(scale = 3)
	private BigDecimal weight;

	@Column(scale = 2)
	private BigDecimal height;

	@ElementCollection
	private List<String> moves = new ArrayList<>();

	@ElementCollection
	private List<String> pokemonTypes = new ArrayList<>();
}

