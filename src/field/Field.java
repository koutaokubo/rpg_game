package field;
import rpg.EnemyMonster;
import java.util.*;

public class Field {

  public ArrayList<EnemyMonster> enemyMonsters;

  public Field(int number){
    enemyMonsters = createEnemyMonsters(number);
  }
  public ArrayList<EnemyMonster> monsters = new ArrayList<>(){
    {
      add(new EnemyMonster("ene1", 70, 70, 40, 10, 15));
      add(new EnemyMonster("ene2", 70, 70, 40, 10, 3));
      add(new EnemyMonster("ene3", 70, 70, 40, 10, 3));
      add(new EnemyMonster("ene4", 70, 70, 40, 10, 3));
      add(new EnemyMonster("ene5", 70, 70, 40, 10, 3));
      add(new EnemyMonster("ene6", 70, 70, 40, 10, 3));
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
