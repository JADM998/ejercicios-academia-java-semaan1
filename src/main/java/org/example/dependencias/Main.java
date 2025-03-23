package org.example.dependencias;

import org.example.dependencias.pokemon.combat.PokemonCombat;
import org.example.dependencias.pokemon.combat.PokemonCombatStatus;
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

        Pokemon bulbasaur = new PokemonBulbasuar(10, bulbasuarMoves, bulbasaurStats);
        Pokemon squirtle = new PokemonSquirtle(10, squirtleMoves, squirtleStats);
        Pokemon charmander = new PokemonCharmander(10, charmanderMoves, charmanderStats);
        Pokemon pikachu = new PokemonPikachu(10, pikachuMoves, pikachuStats);

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
                new PokemonCombat(pokemon1, pokemon2, new DefaultMove()),
                new PokemonCombat(pokemon3, pokemon4, new DefaultMove())
        };

        for (PokemonCombat combat : combats) {

            Pokemon pokemon = combat.getPokemon();
            Pokemon adversary = combat.getAdversary();
            System.out.println(
                    "El combate ha comenzado entre " + pokemon.getName() + " y " + adversary.getName());
            PokemonCombatStatus status = combat.start();
            if (status == PokemonCombatStatus.FINALIZED) {
                System.out.println(combat.getWinner());
            }

            while (!combat.hasWinner()) {
                int movePosition = pokemon.chooseValidMove();

                if (movePosition == -1) {
                    status = combat.attack(0);
                }else{
                    status = combat.attack(movePosition);
                }

                if (status == PokemonCombatStatus.FINALIZED) {
                    System.out.println(combat.getWinner());
                    break;
                }

                status = combat.adversaryTurn();
                if (status == PokemonCombatStatus.FINALIZED) {
                    System.out.println(combat.getWinner());
                }
            }

        }
    }

    private static Pokemon getUniquePokemon(List<Pokemon> pokemons) {

        Pokemon pokemon = pokemons.get(randomGenerator.nextInt(pokemons.size()));
        pokemons.remove(pokemon);
        return pokemon;
    }
}
