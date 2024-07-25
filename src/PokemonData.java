import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PokemonData {
    private List<Pokemon> pokemons;

    public PokemonData(List<Pokemon> pokemons){
        this.pokemons = pokemons;
    }

    public List<Pokemon> getPokemons(String fileName) {
        pokemons = loadPokemonData(fileName);
        return pokemons;
    }

    public  List<Pokemon> loadPokemonData(String fileName) {
        //List<Pokemon> pokemons = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                line = line.replace("\uFEFF", "");
                if (line.startsWith("#")) {
                    continue;
                }
                String[] dataLine = line.split(";");
                String name = dataLine[1];
                String type1 = dataLine[2];
                String type2 = dataLine[3];
                int total = Integer.parseInt(dataLine[4]);
                int hp = Integer.parseInt(dataLine[5]);
                List<Integer> attacks = new ArrayList<>();
                //for (int i = 6; i <= 7; i++) {
                    //attacks.add(Integer.parseInt(dataLine[i]));
                //}
                int attack = Integer.parseInt(dataLine[6]);
                int defense = Integer.parseInt(dataLine[7]);
                int spAtk = Integer.parseInt(dataLine[8]);
                int spDef = Integer.parseInt(dataLine[9]);
                int speed = Integer.parseInt(dataLine[10]);

                Pokemon pokemon = new Pokemon(name, type1, type2, total, hp, attack, defense, spAtk, spDef, speed, attacks);
                pokemons.add(pokemon);
            }
            return pokemons;
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

}
