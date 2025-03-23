package org.example.dependencias.pokemon.pokemons;

import org.example.dependencias.pokemon.move.PokemonMove;

public class PokemonBulbasuar extends Pokemon{
    public PokemonBulbasuar(int level, PokemonMove[] moves, PokemonStats stats) throws IllegalArgumentException {
        super(1, level, "Bulbasaur", PokemonType.GRASS, moves, stats);
    }
}
