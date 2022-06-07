package rpg;
// import rpg.MyMonster;
import java.util.*;

public class TeamMember {
    public ArrayList<MyMonster> myMonsters;

  public TeamMember(int number){
    myMonsters = createMyMonsters(number);
  }

    public ArrayList<MyMonster> monsters = new ArrayList<MyMonster>(){
        {
            add(new MyMonster("ene1", 100, 100, 70, 10, 3, 1));
            add(new MyMonster("ene2", 100, 100, 70, 10, 3, 1));
            add(new MyMonster("ene3", 100, 100, 70, 10, 3, 1));
            add(new MyMonster("ene4", 100, 100, 70, 10, 3, 1));
            add(new MyMonster("ene5", 100, 100, 70, 10, 3, 1));
            add(new MyMonster("ene6", 100, 100, 70, 10, 3, 1));
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
