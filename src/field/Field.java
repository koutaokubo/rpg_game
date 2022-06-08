package field;
import rpg.EnemyMonster;
import java.util.*;

public class Field {

  public ArrayList<EnemyMonster> enemyMonsters;
  public static int battleCount = 0;

  public Field(int number){
    enemyMonsters = createEnemyMonsters(number);
  }
  public ArrayList<EnemyMonster> monsters = new ArrayList<EnemyMonster>(){
    {
      add(new EnemyMonster("ene1", 70, 10, 10, 15, 1));
      add(new EnemyMonster("ene2", 70, 10, 10, 3, 1));
      add(new EnemyMonster("ene3", 70, 10, 10, 3, 1));
      add(new EnemyMonster("ene4", 70, 10, 10, 3, 1));
      add(new EnemyMonster("ene5", 70, 10, 10, 3, 1));
      add(new EnemyMonster("ene6", 70, 10, 10, 3, 1));
      add(new EnemyMonster("Boss", 30, 150, 10, 0, 15));
    }
  };

  public ArrayList<EnemyMonster> createEnemyMonsters(int number){
    ArrayList<EnemyMonster> enemyMonsters = new ArrayList<>();
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
