package rpg;
import java.util.*;
import item.ItemBox;
public class TeamMember {
  public static ArrayList<MyMonster> myMonsters;
  public static ItemBox itemBox;

  public TeamMember(int number){
    myMonsters = createMyMonsters(number);
    itemBox = new ItemBox();
  }

    public ArrayList<MyMonster> monsters = new ArrayList<MyMonster>(){
        {
          add(new MyMonster("my1", 100, 70, 10, 3, 1));
          add(new MyMonster("my2", 100, 70, 10, 3, 1));
          add(new MyMonster("my3", 100, 70, 10, 3, 1));
          add(new MyMonster("my4", 100, 70, 10, 3, 1));
          add(new MyMonster("my5", 100, 70, 10, 3, 1));
          add(new MyMonster("my6", 100, 70, 10, 3, 1));
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
