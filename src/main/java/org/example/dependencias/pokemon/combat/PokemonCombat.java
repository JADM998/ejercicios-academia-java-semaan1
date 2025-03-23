package org.example.dependencias.pokemon.combat;

import org.example.dependencias.pokemon.pokemons.Pokemon;
import org.example.dependencias.pokemon.pokemons.PokemonStats;
import org.example.dependencias.pokemon.pokemons.PokemonType;
import org.example.dependencias.pokemon.move.PokemonMove;

import java.util.Random;

public class PokemonCombat {

    private final Pokemon pokemon;
    private final Pokemon adversary;
    private boolean adversaryGoesSecond = false;
    private final Random random = new Random();
    private final PokemonMove defaultMove;

    public PokemonCombat(Pokemon pokemon, Pokemon adversary, PokemonMove defaultMove) {
        this.pokemon = pokemon;
        this.adversary = adversary;
        this.defaultMove = defaultMove;
    }

    public PokemonCombatStatus start(){
        PokemonStats pokemonStats = pokemon.getStats();
        PokemonStats adversaryStats = adversary.getStats();

        if(pokemonStats.getSpeed() >= adversaryStats.getSpeed())
            adversaryGoesSecond = true;

        if(!adversaryGoesSecond){
            return adversaryTurn();
        }

        return PokemonCombatStatus.RUNNING;
    }

    public PokemonCombatStatus adversaryTurn(){
        int selectedMove = adversary.chooseValidMove();
        return attack(selectedMove, adversary, pokemon);
    }

    public PokemonCombatStatus attack(int movePosition)
        throws ArrayIndexOutOfBoundsException{

        return attack(movePosition, pokemon, adversary);
    }

    public Pokemon getPokemon(){
        return this.pokemon;
    }
    public Pokemon getAdversary(){
        return  this.adversary;
    }

    private PokemonCombatStatus attack(int movePosition, Pokemon attacker, Pokemon receiver){
        int damage = 0;

        if(!attacker.hasValidMoves()){
            damage = calculateDamage(attacker, defaultMove, receiver);
        }else{
            damage = calculateDamage(attacker, attacker.getMoves()[movePosition], receiver);
        }

        String moveName = movePosition == -1 ?
                defaultMove.getName() : attacker.getMoves()[movePosition].getName();
        PokemonStats receiverStats = receiver.getStats();
        receiverStats.reduceHealth(damage);
        System.out.println(attacker.getName() + " ha usado " +
                moveName + " y ha causado " +
                damage + " de daño!, a " + receiver.getName() + " le quedan " +
                receiverStats.getCurrentHealthPoints() + " puntos de vida"
        );
        if(receiverStats.getCurrentHealthPoints() == 0){
            System.out.println(receiver.getName() + " se ha debilitado!");
            return PokemonCombatStatus.FINALIZED;
        }

        return  PokemonCombatStatus.RUNNING;
    }

    private int calculateDamage(Pokemon attacker, PokemonMove move, Pokemon receiver){
        float multiplier = 1.0f;
        PokemonType moveType = move.getType();
        if(moveType == attacker.getMainType() || moveType == attacker.getSecondaryType()){
            multiplier = 1.5f;
        }

        move.use();
        int basePower = move.getBaseForce();
        int attack = attacker.getStats().getAttack();
        int defense = receiver.getStats().getDefense();
        int level = attacker.getLevel();

        int damage = ( ( (2 * level) / 5) + 2) * basePower * attack / defense;
        damage = damage / 50 + 2;
        int randomness = random.nextInt(85, 101);
        float modifier = multiplier * randomness / 100f;
        damage = (int) Math.floor(damage * modifier);

        return Math.max(damage, 1);
    }

    public boolean hasWinner(){
        PokemonStats pokemonStats = pokemon.getStats();
        PokemonStats adversaryStats = adversary.getStats();

        boolean pokemonIsFainted = pokemonStats.getCurrentHealthPoints() == 0;
        boolean adversaryIsFainted = adversaryStats.getCurrentHealthPoints() == 0;
        return (pokemonIsFainted || adversaryIsFainted);
    }

    public String getWinner(){
        PokemonStats pokemonStats = pokemon.getStats();

        if(!hasWinner()){
            return "Todavia no hay ganador";
        }

        String winnerMessage = "El ganador es: ";
        if(pokemonStats.getCurrentHealthPoints() == 0){
            return winnerMessage + adversary.getName();
        }else{
            return winnerMessage + pokemon.getName();
        }
    }
}
