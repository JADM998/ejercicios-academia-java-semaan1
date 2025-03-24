package org.example.dependencias.pokemon.pokemons;

import java.util.Random;

import org.example.dependencias.pokemon.move.PokemonMove;

public class PokemonInyector {
    
    public Pokemon inyectPokemon(Pokemons pokemonName, Random random, PokemonStats stats, PokemonMove... moves){
        
        Pokemon pokemon;
        switch (pokemonName) {
            case BULBASAUR:
                pokemon = new PokemonBulbasuar();
                pokemon.id = 1;
                pokemon.name = "Bulbasaur";
                pokemon.mainType = PokemonType.GRASS;
                break;
            case SQUIRTLE:
                pokemon = new PokemonSquirtle();
                pokemon.id = 4;
                pokemon.name = "Squirtle";
                pokemon.mainType = PokemonType.WATER;
                break;
            case CAHRMANDER:
                pokemon = new PokemonCharmander();
                pokemon.id = 7;
                pokemon.name = "Charmander";
                pokemon.mainType = PokemonType.FIRE;
                break;
            case PIKACHU:
                pokemon = new PokemonPikachu();
                pokemon.id = 25;
                pokemon.name = "Pikachu";
                pokemon.mainType = PokemonType.ELECTRIC;
                break;
            default:
                throw new IllegalArgumentException("Pokemon doesnt exsits");
            }
            
        pokemon.random = random;
        pokemon.stats = stats;
        pokemon.moves = moves;
        pokemon.secondaryType = PokemonType.NONE;

        return pokemon;
    }

}
