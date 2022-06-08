package field;
import java.util.ArrayList;

import rpg.Crobat;
import rpg.HoOh;
import rpg.Monster2;
import rpg.Pippi;

public class Field {

  public ArrayList<Monster2> enemyMonsters;
  public static int battleCount = 0;

  public Field(int number){
    enemyMonsters = createEnemyMonsters(number);
  }
  public ArrayList<Monster2> monsters = new ArrayList<>(){
    {
      add(new Pippi("ピッピ1", 70, 10, 10, 3, 1));
      add(new Pippi("ピッピ2", 70, 10, 10, 3, 1));
      add(new Pippi("ピッピ3", 70, 10, 10, 3, 1));
      add(new Crobat("クロバット1", 90, 20, 10, 20, 1));
      add(new Crobat("クロバット2", 90, 20, 10, 20, 1));
      add(new Crobat("クロバット3", 90, 20, 10, 20, 1));
      add(new HoOh("ホウオウ", 180, 100, 25, 0, 15));
    }
  };

  public ArrayList<Monster2> createEnemyMonsters(int number){
    ArrayList<Monster2> enemyMonsters = new ArrayList<>();
    if (number == 1){
      enemyMonsters.add(monsters.get(monsters.size() -1));
    }else{
      for (int i =0; i < number; i++){
        enemyMonsters.add(monsters.get(i));
     }
    }
    return enemyMonsters;
  }
  public static void plusBattleCount(){
    battleCount++;
  }
  public static void setBattleCount(int number){
    battleCount = number;
  }
}
