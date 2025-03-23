package org.example.dependencias.pokemon.pokemons;

import org.example.dependencias.pokemon.move.PokemonMove;

public class PokemonCharmander extends Pokemon{
    public PokemonCharmander(int level, PokemonMove[] moves, PokemonStats stats) throws IllegalArgumentException {
        super(7, level, "Charmander", PokemonType.FIRE, moves, stats);
    }
}
