package org.example.dependencias.pokemon.move;

import org.example.dependencias.pokemon.pokemons.PokemonType;

public class PokemonMove {

    protected final String name;
    protected final PokemonType type;
    protected final int baseForce;
    protected final int powerPoint;
    protected int currentPoints;

    public PokemonMove(String name, PokemonType type, int baseForce, int powerPoint){
        this.name = name;
        this.type = type;
        this.baseForce = baseForce;
        this.powerPoint = powerPoint;
        this.currentPoints = powerPoint;
    }

    public PokemonType getType(){
        return this.type;
    }
    public String getName() {
        return name;
    }
    public int getPowerPoint() {
        return powerPoint;
    }
    public int getCurrentPoints(){
        return currentPoints;
    }

    public boolean canUse(){
        return currentPoints > 0;
    }

    public int getBaseForce() {
        return baseForce;
    }

    public void use(){
        if(!canUse()) return;

        currentPoints--;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
