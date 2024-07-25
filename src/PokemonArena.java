
import java.util.*;

public class PokemonArena {
    private final List<Pokemon> pokemons;
    private final List<Attack> attacks;

    public PokemonArena(List<Pokemon> pokemons, List<Attack> attacks) {
        this.attacks = attacks;
        this.pokemons = pokemons;
    }

    public Pokemon choosePokemon(){
        if(!pokemons.isEmpty()){
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose a Pokemon to battle:");
            for (int i = 0; i < pokemons.size(); i++) {
                Pokemon pokemon = pokemons.get(i);
                String name = pokemon.getName();
                System.out.println((i + 1) + ". " + name);
            }
            int choice = sc.nextInt();
            if ((choice-1) < 0 || (choice - 1) >= pokemons.size()) {
                System.out.println("Invalid Pokemon index");
                return choosePokemon();
            } else {
                Pokemon userPokemon = pokemons.get(choice - 1);
                System.out.print("\u001B[33m You have chosen a Pokemon: " );
                characteristicksPokemon(userPokemon);
                return userPokemon;
            }
        } else {
            System.out.println("The selection list is empty");
            return choosePokemon();
        }
    }

    public Pokemon chooseOpponent(){
        if(!pokemons.isEmpty()) {
            Random r = new Random();
            int index = r.nextInt(pokemons.size());
            Pokemon opponent = pokemons.get(index);
            System.out.print("\u001B[32m Your opponent Pokemon: ");
            characteristicksPokemon(opponent);
            return opponent;
        } else {
            System.out.println("The selection list is empty");
            return chooseOpponent();
        }
    }

    public void characteristicksPokemon (Pokemon pokemon) {
        System.out.println( pokemon.getName());
        System.out.println("Pokemon characteristics:");
        System.out.println("HP: " + pokemon.getHp());
        System.out.println("Type 1: " + pokemon.getType1());
        System.out.println("Type 2: " + pokemon.getType2());
        System.out.println("Possible attacks:");
        for (Integer attack : pokemon.getAttacks()) {
            System.out.println("- " + attack);
        }
        System.out.println("Defense: " + pokemon.getDefense());
        System.out.println("Attack speed: " + pokemon.getSpAtk());
        System.out.println("Defense speed: " + pokemon.getSpDef());
    }

    public void chooseRandomListAttack(Pokemon pokemon){
        AttackData attackData = new AttackData(attacks);
        Random r = new Random();
        List<Integer> attacksRand = new ArrayList<>();
        for (int i = 1; i<=2; i++) {
            int randomIndex = r.nextInt(attackData.size());
            attacksRand.add(randomIndex);
        }
        pokemon.setAttacks(attacksRand);
    }
    public Attack chooseOpponentAttack (Pokemon pokemon) {
        Random r = new Random();
        chooseRandomListAttack(pokemon);
        int index = r.nextInt(pokemon.getAttacks().size());
        Attack attack = attacks.get(index);
        characteristicksAttack(attack);
        return attack;
    }


    public Attack chooseAttack (Pokemon pokemon) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a Pokemon's attack: ");
        chooseRandomListAttack(pokemon);
        AttackData attackData = new AttackData(attacks);
        for (int i = 0; i < pokemon.getAttacks().size(); i++) {
            int attackId = pokemon.getAttacks().get(i)-1;
            Attack attack = attackData.getAttack(attackId);
            System.out.println((i+1) + " " + attack.getName());
        }
        int choice = sc.nextInt();
        if (choice-1 < 0 || choice-1 >= pokemon.getAttacks().size()) {
            System.out.println("Invalid attack choice. Please select again.");
            return chooseAttack(pokemon);
        } else {
            Attack attack = attackData.getAttack((pokemon.getAttacks().get(choice-1)) - 1);
            characteristicksAttack(attack);
            return attack;
        }
    }
    public void characteristicksAttack(Attack attack){
        System.out.println("Attack's name: " + attack.getName());
        System.out.println("Effect: " + attack.getEffect());
        System.out.println("Type: " + attack.getType());
        System.out.println("Kind: " + attack.getKind());
        System.out.println("Power: " + attack.getPower());
        System.out.println("Accuracy: " + attack.getAccuracy());
        System.out.println("PP: " + attack.getPp());
    }

    public void battle(Pokemon userPokemon, Attack userAttack, Pokemon opponentPokemon, Attack opponentAttack) {
        System.out.println("\u001B[36m The battle has begun:" + userPokemon.getName() + " against " + opponentPokemon.getName());
        Pokemon firstAttacker;
        Pokemon secondAttacker;
        Attack firstAttack;
        Attack secondAttack;

        Random r  = new Random();
        int randAccuracy = 0;
        int userAccuracy = 0;

        if (userPokemon.getSpeed() > opponentPokemon.getSpeed() ) {
                firstAttacker = userPokemon;
                firstAttack = userAttack;
                secondAttacker = opponentPokemon;
                secondAttack = opponentAttack;
                System.out.println(userPokemon.getName() + " has more attack speed, so he attacks first");

        } else {
                firstAttacker = opponentPokemon;
                firstAttack = opponentAttack;
                secondAttacker = userPokemon;
                secondAttack = userAttack;
                System.out.println(opponentPokemon.getName() + " has more attack speed, so he attacks first");
        }

        while (firstAttacker.getHp() > 0 && secondAttacker.getHp() > 0) {
            randAccuracy = r.nextInt(101);
            userAccuracy = Integer.parseInt(firstAttack.getAccuracy().replace("%", ""));
            System.out.println(userAccuracy + " userAccuracy");
            System.out.println(randAccuracy + " random Accuracy");

            if (userAccuracy >= randAccuracy) {
                int firstDamage = calculateDamage(firstAttack, firstAttacker, secondAttacker);
                firstAttacker.takeDamage(firstDamage);
                System.out.println("\u001B[34m" + firstAttacker.getName() + " uses an attack " + firstAttack.getName() + " and causes " + firstDamage + " damage.");
                System.out.println("He has a power " + firstAttacker.getHp());
                if (firstAttacker.getHp() == 0) {
                    System.out.println(firstAttacker.getName() + " lost...");
                    break;
                }
            } else {
                System.out.println("\u001B[34m" + firstAttacker.getName() + "'s attack " + firstAttack.getName() + " missed.");
            }

            randAccuracy = r.nextInt(101);
            int opponentAccuracy = Integer.parseInt(secondAttack.getAccuracy().replace("%", ""));
            if (opponentAccuracy >= randAccuracy) {
                int secondDamage = calculateDamage(secondAttack, secondAttacker, firstAttacker);
                secondAttacker.takeDamage(secondDamage);
                System.out.println("\u001B[35m" + secondAttacker.getName() + " uses an attack " + secondAttack.getName() + " and causes " + secondDamage + " damage.");
                System.out.println("He has a power " + secondAttacker.getHp());
                if (secondAttacker.getHp() == 0) {
                    System.out.println(secondAttacker.getName() + " lost...");
                    break;
                }
            }  else {
                System.out.println("\u001B[35m" + secondAttacker.getName() + "'s attack " + secondAttack.getName() + " missed.");
            }
        }
        if (firstAttacker.getHp() > 0) {
            System.out.println("Congratulations! " + firstAttacker.getName() + " won!");
        } else {
            System.out.println("Congratulations! " + secondAttacker.getName() + " won!");
        }
    }

    private int calculateDamage(Attack attack, Pokemon attacker, Pokemon defender) {
        double atk = 0;
        double def = 0;
        if (attack.getKind().equals("Physical")) {
            atk = attacker.getAttack();
            def = defender.getDefense();
        } else if (attack.getKind().equals("Special")) {
            atk = attacker.getSpAtk();
            def = defender.getSpDef();
        }

        //double damage = (attack.getPower() * ((double) attacker.getSpAtk() / defender.getSpDef())) * (1.0 / 25.0);
        double damage = (attack.getPower() * (atk / def)) * (1.0 / 25.0);
        return (int) damage;
    }

}
