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
    ArrayList<MyMonster> member = TeamMember.myMonsters;

    while(true){
      System.out.println(this.itemName + "　をだれに使いますか？");
      for(int i=0; i < member.size(); i++){
        System.out.println((i + 1) + ": " + member.get(i));
      }
      selectCharacter = super.selectCharacter(member.size());
      break;
    }
    target = member.get(selectCharacter -1);
    System.out.println(target.getName() + "は防御力が１０上がった");
    target.setDefensePower(target.getDefensePower() + 10);
    setStock(stock - 1);
  }
}
