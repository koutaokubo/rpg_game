package item;
import java.util.*;

import party.Party;

public class ShopList {
  public ArrayList<Item> shopList;
  public ShopList(){
    Item attacker = new Attacker(10);
    Item defender = new Defender(10);
    shopList = new ArrayList<Item>(){
      {
        add(attacker);
        add(defender);
      }
    };
  }

  public void showList(){
    for (int i=0; i < this.shopList.size(); i++){
      System.out.printf("%d: %s\n", i + 1, this.shopList.get(i));
    }
  }

  public void buyItems(int index) {
		if(index < 0 || this.shopList.size() <= index) {
			System.out.println("存在しないアイテムです");
			return ;
		}
		this.shopList.get(index).buyItems();
    Party.money -= 100;
	}

  public int size(){
    return this.shopList.size();
  }
}
