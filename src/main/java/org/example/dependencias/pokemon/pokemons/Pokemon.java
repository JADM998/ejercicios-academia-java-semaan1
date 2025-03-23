package org.example.dependencias.pokemon.pokemons;

import org.example.dependencias.pokemon.move.PokemonMove;

import java.util.Random;

public class Pokemon {
    protected final int id;
    protected int level;
    protected final String name;
    protected final PokemonType mainType;
    protected final PokemonType secondaryType;
    protected final PokemonMove[] moves;
    protected final PokemonStats stats;
    private static final Random random = new Random();

    public Pokemon(int id, String name, PokemonMove[] moves, PokemonStats stats)
            throws IllegalArgumentException{
        this(id, 5, name, PokemonType.NORMAL, PokemonType.NONE, moves, stats);
    }

    public Pokemon(int id, int level, String name, PokemonMove[] moves, PokemonStats stats)
            throws IllegalArgumentException{
        this(id, level, name, PokemonType.NORMAL, PokemonType.NONE, moves, stats);
    }

    public Pokemon(int id, int level, String name, PokemonType mainType, PokemonMove[] moves,
                   PokemonStats stats)
            throws IllegalArgumentException{
        this(id, level, name, mainType, PokemonType.NONE, moves, stats);
    }

    public Pokemon(
            int id, int level, String name, PokemonType mainType, PokemonType secondaryType,
            PokemonMove[] moves, PokemonStats stats)
            throws IllegalArgumentException{
        this.id = id;
        this.level = level;
        this.name = name;
        this.mainType = mainType;
        this.secondaryType = secondaryType;
        if(moves.length > 4) throw new IllegalArgumentException("Pokemon Cannot have more than 4 moves");
        if(moves.length == 0) throw new IllegalArgumentException("Cannot have a pokemon with 0 moves");
        this.moves = new PokemonMove[4];
        System.arraycopy(moves, 0, this.moves, 0, moves.length);
        this.stats = stats;
    }

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

    public boolean isValidMove(int position){
        if(position < 0 || position > 3) return false;
        PokemonMove move = moves[position];
        if(move == null) return  false;

        return move.getCurrentPoints() > 0;
    }

    public  boolean hasValidMoves(){
        int validMoves = 0;
        for(PokemonMove move: moves){
            if(move == null) break;

            if(move.getCurrentPoints() > 0) validMoves++;
        }

        return  validMoves > 0;
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
