package rpg;
import java.util.ArrayList;

import item.ItemBox;
import item.ShopList;
public class TeamMember {
  public static ArrayList<Monster2> myMonsters;
  public static ItemBox itemBox;
  public static ShopList shopList;
  public static int money;

  public TeamMember(int number){
    myMonsters = createMyMonsters(number);
    itemBox = new ItemBox();
    shopList = new ShopList();
  }

    public ArrayList<Monster2> monsters = new ArrayList<Monster2>(){
        {
          add(new Pikachu("ピカチュウ1", 80, 70, 10, 5, 1));
          add(new Pikachu("ピカチュウ2", 80, 70, 10, 5, 1));
          add(new Lapras("ラプラス", 140, 50, 30, 3, 1));
          add(new Lucario("ルカリオ", 110, 80, 10, 5, 1));
          add(new Pikachu("ピカチュウ3", 80, 75, 8, 5, 1));
          add(new Mew("ミュウ", 130, 80, 20, 8, 1));
        }
    };

    public ArrayList<Monster2> createMyMonsters(int number){
        ArrayList<Monster2> myMonsters = new ArrayList<>();
        for (int i =0; i < number; i++){
           myMonsters.add(monsters.get(i));
        }
        return myMonsters;
    }
    public void clearChangesInBattle() {
      	for(int i = 0; i < myMonsters.size(); i++) {
      		myMonsters.get(i).clearStatusRise();
      		myMonsters.get(i).setPP(myMonsters.get(i).getMaxPP());
      	}
      }
}
