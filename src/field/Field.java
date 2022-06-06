package field;
import rpg.EnemyMonster;
import java.util.*;

public class Field {
  public ArrayList<EnemyMonster> monster;

  public EnemyMonster[] createEnemyMonsters(int number){
    EnemyMonster[] monsters = new EnemyMonster[number];
    for (int i =0; i < number; i++){
       monsters[i] = monster.get(i);
    }
    return monsters;
  }
}
