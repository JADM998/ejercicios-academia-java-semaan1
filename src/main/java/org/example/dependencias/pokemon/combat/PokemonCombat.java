package org.example.dependencias.pokemon.combat;

import org.example.dependencias.pokemon.pokemons.Pokemon;
import org.example.dependencias.pokemon.pokemons.PokemonStats;
import org.example.dependencias.pokemon.move.PokemonMove;

import java.util.Random;

public class PokemonCombat {

    private final Pokemon pokemon;
    private final Pokemon adversary;
    private boolean adversaryGoesSecond = false;
    private PokemonMove defaultMove;
    private Random random;
    int turn;

    public PokemonCombat(Pokemon pokemon, Pokemon adversary, PokemonMove defaultMove, Random random) {
        this.pokemon = pokemon;
        this.adversary = adversary;
        this.random = random;
        this.defaultMove = defaultMove;
        turn = 0;
    }

    public void start(){
        PokemonStats pokemonStats = pokemon.getStats();
        PokemonStats adversaryStats = adversary.getStats();

        if(pokemonStats.getSpeed() >= adversaryStats.getSpeed())
            adversaryGoesSecond = true;
    }

    public void simulateNextTurn(){
        if(adversaryGoesSecond){
            adversaryTurn();
            pokemonTurn();
        }else{
            pokemonTurn();
            adversaryTurn();
        }
        turn++;

        if(turn >= 5){
            System.out.println("El combate ha terminado");
            int winnerNumber = random.nextInt(0, 2);
            Pokemon winner = winnerNumber == 1 ? pokemon : adversary;
            System.out.println("El ganador es: " + winner);
        }
    }

    public boolean hasFinished(){
        return turn >= 5;
    }

    private void adversaryTurn(){
        attack(adversary, pokemon);
    }

    private void pokemonTurn(){
        attack(pokemon, adversary);
    }

    private void attack(Pokemon attacker, Pokemon receiver){

        int movePosition = attacker.chooseValidMove();
        PokemonMove move = random.nextInt(0, 5) == 4 ? defaultMove : attacker.getMoves()[movePosition];
        System.out.println(attacker + " ha atacado con " + move + " a " + receiver);
    }

    public Pokemon getPokemon(){
        return this.pokemon;
    }
    public Pokemon getAdversary(){
        return  this.adversary;
    }
}
