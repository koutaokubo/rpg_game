package field;
import java.util.ArrayList;
import java.util.Random;

import monster.Crobat;
import monster.Electrode;
import monster.HoOh;
import monster.Magicarp;
import monster.Monster;
import monster.Onix;
import monster.Parasect;
import monster.Pippi;
import monster.Raticate;

public class Field {

  public ArrayList<Monster> enemyMonsters;

  public Field(int number, boolean isBoss){
    if(isBoss) {
    	enemyMonsters = new ArrayList<Monster>() {
    		{
    			add(new HoOh("ホウオウ", 180, 100, 25, 0, 15));
    		}
    	};
    }else {
    	try{
    		enemyMonsters = createEnemyMonsters(number);
    	}catch(CloneNotSupportedException e) {
    		System.out.println("例外が発生しました");
    		System.exit(0);
    	}
    }
  }
  public ArrayList<Monster> monsters = new ArrayList<>(){
    {
      add(new Pippi("ピッピ", 70, 30, 10, 3, 1));
      add(new Crobat("クロバット", 90, 50, 10, 20, 1));
      add(new Parasect("パラセクト", 80, 40, 10, 1, 1));
      add(new Raticate("ラッタ", 90, 60, 10, 12, 1));
      add(new Magicarp("コイキング", 50, 10, 5, 15, 1));
      add(new Onix("イワーク", 110, 30, 15, 3, 1));
      add(new Electrode("マルマイン", 85, 40, 10, 30, 1));
    }
  };

  public ArrayList<Monster> createEnemyMonsters(int number) throws CloneNotSupportedException{
      ArrayList<Monster> enemyMonsters = new ArrayList<>();
      if (number == 1){
          enemyMonsters.add(monsters.get(monsters.size() -1));
      }else{
    	  Random random = new Random();
          for (int i =0; i < number; i++){
              enemyMonsters.add(monsters.get(random.nextInt(monsters.size())).clone());
          }
      }
      return enemyMonsters;
  }

  public boolean allKnockedOut() {
	  for(int i = 0; i < enemyMonsters.size(); i++) {
		  if(!enemyMonsters.get(i).isKnockedOut()) {
			  return false;
		  }
	  }
	  return true;
  }

}
