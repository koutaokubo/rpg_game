package party;
import java.util.ArrayList;

import item.ItemBox;
import item.ShopList;
import monster.Blastoise;
import monster.Greninja;
import monster.Lapras;
import monster.Mew;
import monster.Monster;
import monster.Pikachu;
import monster.Venusaur;


public class Party {
  public ArrayList<Monster> myMonsters;
  public static ItemBox itemBox;
  public static ShopList shopList;
  public static int money;

  public Party(int number){
    myMonsters = createMyMonsters(number);
    itemBox = new ItemBox();
    shopList = new ShopList();
  }

    public ArrayList<Monster> monsters = new ArrayList<Monster>(){
        {
          add(new Pikachu("ピカチュウ", 80, 70, 10, 5, 1));
          add(new Lapras("ラプラス", 140, 50, 30, 3, 1));
          add(new Blastoise("カメックス", 100, 60, 20, 3, 1));
          //add(new Lucario("ルカリオ", 110, 80, 10, 5, 1));
          add(new Greninja("ゲッコウガ", 80, 75, 8, 5, 1));
          add(new Mew("ミュウ", 130, 80, 20, 8, 1));
          add(new Venusaur("フシギバナ", 100, 60, 20, 4, 1));
        }
    };

    public ArrayList<Monster> createMyMonsters(int number){
        ArrayList<Monster> myMonsters = new ArrayList<>();
        for (int i =0; i < number; i++){
           myMonsters.add(monsters.get(i));
        }
        return myMonsters;
    }
    public void clearChangesInBattle() {
      	for(int i = 0; i < myMonsters.size(); i++) {
      		myMonsters.get(i).clearStatusRise();
      	}
    }

    public void heal() {
    	for(int i = 0; i < myMonsters.size(); i++) {
    		myMonsters.get(i).setHp(myMonsters.get(i).getMaxHp());
    		myMonsters.get(i).setPp(myMonsters.get(i).getMaxPp());
    		myMonsters.get(i).setAsleep(0);
    	}
    }

    public boolean allKnockedOut() {
  	  for(int i = 0; i < myMonsters.size(); i++) {
  		  if(!myMonsters.get(i).isKnockedOut()) {
  			  return false;
  		  }
  	  }
  	  return true;
    }
}
