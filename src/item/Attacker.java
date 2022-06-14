package item;

import java.util.ArrayList;

import monster.Monster;
import party.Party;

public class Attacker extends Item{

  public Attacker(int stock){
    // super(stock);
    super("アタッカー", 1, 10, "攻撃力がアップする");
    // this.itemName = "アタッカー";
    // this.max_stock = 10;
    // this.item_detail = "攻撃力がアップする";
  }

  public void useItem(){
    int selectCharacter;
    Monster target;
    ArrayList<Monster> member = Party.myMonsters;

    while(true){
      System.out.println(this.itemName + "　をだれに使いますか？");
      for(int i=0; i < member.size(); i++){
        System.out.println((i + 1) + ": " + member.get(i));
      }
      selectCharacter = super.selectCharacter(member.size());
      break;
    }
    target = member.get(selectCharacter -1);
    System.out.println(target.getName() + "は攻撃力が１０上がった");
    target.setAttackPower(target.getAttackPower() + 10);
    setStock(stock - 1);
  }

  public void buyItems(){
    setStock(stock + 1);
    System.out.println(itemName+ "の所持数" + getStock() + "個");
  }
}
