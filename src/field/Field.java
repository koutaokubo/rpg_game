package field;
import rpg.EnemyMonster;
import java.util.*;

public class Field {

  public ArrayList<EnemyMonster> enemyMonsters;

  public Field(int number){
    enemyMonsters = createEnemyMonsters(number);
  }
  public ArrayList<EnemyMonster> monsters = new ArrayList<EnemyMonster>(){
    {
      add(new EnemyMonster("ene1", 100, 100, 70, 10, 3, 1));
      add(new EnemyMonster("ene2", 100, 100, 70, 10, 3, 1));
      add(new EnemyMonster("ene3", 100, 100, 70, 10, 3, 1));
      add(new EnemyMonster("ene4", 100, 100, 70, 10, 3, 1));
      add(new EnemyMonster("ene5", 100, 100, 70, 10, 3, 1));
      add(new EnemyMonster("ene6", 100, 100, 70, 10, 3, 1));
    }
  };

  public ArrayList<EnemyMonster> createEnemyMonsters(int number){
    ArrayList<EnemyMonster> enemyMonsters = new ArrayList<>();
    for (int i =0; i < number; i++){
       enemyMonsters.add(monsters.get(i));
    }
    return enemyMonsters;
  }
}
