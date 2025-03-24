package org.example.dependencias;

import org.example.dependencias.pokemon.combat.PokemonCombat;
import org.example.dependencias.pokemon.move.*;
import org.example.dependencias.pokemon.pokemons.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    private final static Random randomGenerator = new Random();

    public static void main(String[] args) {

        //Bulbasaur
        PokemonMove[] bulbasuarMoves = {new MoveLatigoCepa(), new MoveTacleada()};
        PokemonStats bulbasaurStats = new PokemonStats(52, 37, 28, 29);

        //Squirtle
        PokemonMove[] squirtleMoves = {new MoveBurbujas(), new MoveTacleada()};
        PokemonStats squirtleStats = new PokemonStats(51, 33, 33, 33);

        //Charmander
        PokemonMove[] charmanderMoves = {new MoveAscuas(), new MoveTacleada()};
        PokemonStats charmanderStats = new PokemonStats(50, 30, 35, 32);

        //Pikachu
        PokemonMove[] pikachuMoves = {new MoveImpactrueno(), new MoveTacleada()};
        PokemonStats pikachuStats = new PokemonStats(47, 27, 35, 41);

        PokemonInyector inyector = new PokemonInyector();
        Pokemon bulbasaur = inyector.inyectPokemon(Pokemons.BULBASAUR, randomGenerator, bulbasaurStats, bulbasuarMoves);
        Pokemon squirtle = inyector.inyectPokemon(Pokemons.SQUIRTLE, randomGenerator, squirtleStats, squirtleMoves);
        Pokemon charmander = inyector.inyectPokemon(Pokemons.CAHRMANDER, randomGenerator, charmanderStats, charmanderMoves);
        Pokemon pikachu = inyector.inyectPokemon(Pokemons.PIKACHU, randomGenerator, pikachuStats, pikachuMoves);

        List<Pokemon> pokemons = new LinkedList<>();
        pokemons.add(bulbasaur);
        pokemons.add(squirtle);
        pokemons.add(charmander);
        pokemons.add(pikachu);

        Pokemon pokemon1 = getUniquePokemon(pokemons);
        Pokemon pokemon2 = getUniquePokemon(pokemons);
        Pokemon pokemon3 = getUniquePokemon(pokemons);
        Pokemon pokemon4 = getUniquePokemon(pokemons);

        PokemonCombat[] combats = {
                new PokemonCombat(pokemon1, pokemon2, new DefaultMove(), randomGenerator),
                new PokemonCombat(pokemon3, pokemon4, new DefaultMove(), randomGenerator)
        };

        for(PokemonCombat combat: combats){
            combat.start();

            while (!combat.hasFinished()) {
                combat.simulateNextTurn();
            }
        }
    }

    private static Pokemon getUniquePokemon(List<Pokemon> pokemons) {

        Pokemon pokemon = pokemons.get(randomGenerator.nextInt(pokemons.size()));
        pokemons.remove(pokemon);
        return pokemon;
    }
}
