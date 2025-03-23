package org.example.dependencias.pokemon.move;

import org.example.dependencias.pokemon.pokemons.PokemonType;

public class DefaultMove extends PokemonMove {
    public DefaultMove() {
        super("default", PokemonType.NONE, 20, Integer.MAX_VALUE);
    }
}
