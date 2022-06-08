package item;

import java.util.ArrayList;

import rpg.MyMonster;
import rpg.TeamMember;

public class Defender extends Item{
  public Defender(int stock){
    super("ディフェンダー", 1, 10, "防御力がアップする");
  }

  public void useItem(){
    int selectCharacter;
    MyMonster target;
    ArrayList<MyMonster> myMonsters = TeamMember.myMonsters;

    while(true){
      System.out.println(this.itemName + "　をだれに使いますか？");
      for(int i=0; i < myMonsters.size(); i++){
        System.out.println((i + 1) + ": " + myMonsters.get(i));
      }
      selectCharacter = super.selectCharacter(myMonsters.size());
      break;
    }
    target = myMonsters.get(selectCharacter -1);
    System.out.println(target.getName() + "は防御力が１０上がった");
    target.setDefensePower(target.getDefensePower() + 10);
    setStock(stock - 1);
  }

  public void buyItems(){
    setStock(stock + 1);
    System.out.println(itemName+ "の所持数" + getStock() + "個");
  }
}
