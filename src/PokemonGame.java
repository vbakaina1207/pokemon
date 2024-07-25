import java.util.ArrayList;
import java.util.List;

public class PokemonGame {

    private String filePokemon;
    private String fileAttacks;

    public PokemonGame(String filePokemon,String fileAttacks) {
        this.filePokemon = filePokemon;
        this.fileAttacks = fileAttacks;
    }

    public void start (){
        List<Pokemon> pokemons = new ArrayList<>();
        List<Attack> attacks = new ArrayList<>();
        PokemonData pokemonData = new PokemonData(pokemons);
        AttackData attacksData = new AttackData(attacks);
        try {
            pokemons = pokemonData.getPokemons(filePokemon);
            attacks = attacksData.getAttacks(fileAttacks);
            PokemonArena arena = new PokemonArena(pokemons, attacks);
            Pokemon userPokemon = arena.choosePokemon();
            Attack userAttack = arena.chooseAttack(userPokemon);

            Pokemon opponentPokemon = arena.chooseOpponent();
            Attack opponentAttack = arena.chooseOpponentAttack(opponentPokemon);
            arena.battle(userPokemon, userAttack, opponentPokemon, opponentAttack);
        } catch (Exception e) {
            System.out.println("Game over");
        }
    }
}
