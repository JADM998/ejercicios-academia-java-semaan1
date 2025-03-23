package org.example.dependencias.pokemon.pokemons;

import org.example.dependencias.pokemon.move.PokemonMove;

public class PokemonSquirtle extends Pokemon{
    public PokemonSquirtle(int level, PokemonMove[] moves, PokemonStats stats) throws IllegalArgumentException {
        super(4, level, "Squirtle", PokemonType.WATER, moves, stats);
    }
}
