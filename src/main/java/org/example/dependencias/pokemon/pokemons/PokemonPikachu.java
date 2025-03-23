package org.example.dependencias.pokemon.pokemons;

import org.example.dependencias.pokemon.move.PokemonMove;

public class PokemonPikachu extends Pokemon{
    public PokemonPikachu(int level,PokemonMove[] moves, PokemonStats stats) throws IllegalArgumentException {
        super(25, level, "Pikachu", PokemonType.ELECTRIC, moves, stats);
    }
}
