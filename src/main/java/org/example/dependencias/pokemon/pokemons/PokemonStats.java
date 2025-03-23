package org.example.dependencias.pokemon.pokemons;

public class PokemonStats {

    protected int currentHealthPoints;
    protected int healthPoints;
    protected int defense;
    protected int attack;
    protected int speed;

    public PokemonStats(int healthPoints, int defense, int attack, int speed) {
        this.healthPoints = healthPoints;
        this.currentHealthPoints = healthPoints;
        this.defense = defense;
        this.attack = attack;
        this.speed = speed;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getCurrentHealthPoints() {
        return currentHealthPoints;
    }

    public int getDefense() {
        return defense;
    }

    public int getAttack() {
        return attack;
    }

    public int getSpeed() {
        return speed;
    }

    public void reduceHealth(int damage){
        currentHealthPoints = damage >= currentHealthPoints
            ? 0 : currentHealthPoints - damage;
    }
}
