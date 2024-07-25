import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AttackData {
    private List<Attack> attacks;

    public AttackData(List<Attack> attacks){
        this.attacks = attacks;
    }

    public List<Attack> getAttacks(String fileName) {
        attacks = loadAttacksData(fileName);
        return attacks;
    }

    public List<Attack> loadAttacksData(String fileName)  {
        BufferedReader reader = null;
        try  {
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
                String effect = dataLine[2];
                String type = dataLine[3];
                String kind = dataLine[4];
                int power = Integer.parseInt(dataLine[5]);
                String accuracy = dataLine[6];
                int pp = Integer.parseInt(dataLine[7]);

                Attack attack = new Attack(name, effect, type, kind, power, accuracy, pp);
                attacks.add(attack);
            }
        }
        catch (IOException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return attacks;
    }

    public Attack getAttack(int index) {
        return attacks.get(index);
    }

    public int size() {
        return attacks.size();
    }
}
