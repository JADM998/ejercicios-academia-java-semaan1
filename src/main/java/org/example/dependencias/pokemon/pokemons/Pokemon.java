package org.example.dependencias.pokemon.pokemons;

import java.util.Random;

import org.example.dependencias.pokemon.move.PokemonMove;

public class Pokemon {
    int id;
    int level;
    String name;
    PokemonType mainType;
    PokemonType secondaryType;
    PokemonMove[] moves;
    PokemonStats stats;
    Random random;

    public Pokemon(){}

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public PokemonType getMainType() {
        return mainType;
    }

    public PokemonType getSecondaryType() {
        return secondaryType;
    }

    public PokemonMove[] getMoves() {
        return moves.clone();
    }

    public PokemonStats getStats() {
        return stats;
    }

    @Override
    public String toString(){
        return this.name;
    }

    public int chooseValidMove(){
        int counter = 0;
        int validMoves = 0;
        for(PokemonMove move: moves){
            if(move != null) counter++;
            else break;

            if(move.getCurrentPoints() > 0) validMoves++;
        }

        if(validMoves == 0) return -1;

        int choosenMove = random.nextInt(counter);
        boolean isValid = moves[choosenMove].getCurrentPoints() > 0;
        while (!isValid){
            choosenMove = random.nextInt(counter);
            isValid = moves[choosenMove].getCurrentPoints() > 0;
        }

        return choosenMove;
    }
}
