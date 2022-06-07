package rpg;
import rpg.MyMonster;
import java.util.*;


public class TeamMember {
  public ArrayList<MyMonster> myMonsters;

  public TeamMember(int number){
    myMonsters = createMyMonsters(number);
  }

    public ArrayList<MyMonster> monsters = new ArrayList<MyMonster>(){
        {
          add(new MyMonster("my1", 100, 100, 70, 10, 3, 1));
          add(new MyMonster("my2", 100, 100, 70, 10, 3, 1));
          add(new MyMonster("my3", 100, 100, 70, 10, 3, 1));
          add(new MyMonster("my4", 100, 100, 70, 10, 3, 1));
          add(new MyMonster("my5", 100, 100, 70, 10, 3, 1));
          add(new MyMonster("my6", 100, 100, 70, 10, 3, 1));
        }
    };

    public ArrayList<MyMonster> createMyMonsters(int number){
        ArrayList<MyMonster> myMonsters = new ArrayList<>();
        for (int i =0; i < number; i++){
           myMonsters.add(monsters.get(i));
        }
        return myMonsters;
      }
}
