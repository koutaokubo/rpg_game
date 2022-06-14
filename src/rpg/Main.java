package rpg;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import field.Field;
import item.Attacker;
import item.Item;
import item.ItemBox;
import item.ShopList;
import monster.Monster;
import party.Party;

public class Main {
  public static int defaultExp = 20;
  public static int battleCount = 0;

  public static Field field = new Field(4, false);
  public static Party party = new Party(6);

  public static void main(String[] args) {
    Item item = new Attacker(1);
    Party.itemBox.add(item);

    battle(false);
  }

  // 生き残っている中で一番前にいるモンスターを探してバトルに出す
  public static int sentMonsterNum(ArrayList<Monster> monsters, int monsterNum) {
	  int partySize = monsters.size();
	  while(true) {
		  if(!monsters.get(monsterNum).isKnockedOut()) {
			  return monsterNum;
		  }
		  monsterNum = (monsterNum + 1) % partySize;
	  }
  }

  public static void battle(boolean isBoss){
	System.out.println("モンスターが現れた！");

    ArrayList<Monster> myMonsters = party.myMonsters;
    ArrayList<Monster> enemyMonsters = field.enemyMonsters;

    // 出てきた敵のリストを表示
    for(int i = 0; i < enemyMonsters.size(); i++) {
    	System.out.println((i+1) + ": " + enemyMonsters.get(i).getName() + ", HP" + enemyMonsters.get(i).getMaxHp());
    }

    //何番目のモンスターがバトルに出ているか
    int myNumOnBattle = 0;
    int enemyNumOnBattle = 0;

    do{
      // コマンド選択：たたかう、にげる、交代
      int command =  selectCommand();
      switch(command) {
        case 1:
          break;
        case 2:
          if(!isBoss) {
        	  enemyMonsters.clear();
        	  System.out.println("戦闘から逃げた！");
        	  return;
          }else {
        	  System.out.println("ボスの威圧感が強すぎて逃げられない！");
        	  break;
          }
        case 3:
          myNumOnBattle = changeMonsterNumber(myMonsters);
          break;
      }

      // パーティの誰が場に出るか
      myNumOnBattle = sentMonsterNum(myMonsters, myNumOnBattle);
      Monster myMonster = myMonsters.get(myNumOnBattle);
      enemyNumOnBattle = sentMonsterNum(enemyMonsters, enemyNumOnBattle);
      Monster enemyMonster = enemyMonsters.get(enemyNumOnBattle);

      String textAsleep = myMonster.getAsleep() > 0 ? "【眠り】" : "";
      System.out.println("【じぶん】" + (myNumOnBattle+1) + ": " + myMonster.getName() + textAsleep);
      System.out.println("    レベル: " + myMonster.getLevel() + ", HP: " + myMonster.getHp() + "/" + myMonster.getMaxHp());
      System.out.println("【あいて】" + (enemyNumOnBattle+1) + ": " + enemyMonster.getName());
      System.out.println("    レベル: " + enemyMonster.getLevel() + ", HP: " + enemyMonster.getHp() + "/" + enemyMonster.getMaxHp());

      // １ターンの処理
      turn(myMonster, enemyMonster);

    } while(!party.allKnockedOut() && !field.allKnockedOut());

    System.out.println("戦闘終了");
    party.clearChangesInBattle();
    if(isBoss){
      clearBoss();
    }else{
      isWin();
    }
  }

  public static void turn(Monster myMonster, Monster enemyMonster){
	  // 味方・敵がそれぞれ特殊技を使うかどうか
	  boolean useSpecial_my = false;
	  boolean useSpecial_enemy = false;

	  // コマンド入力で味方の攻撃の仕方を指定
	  Scanner scanner = new Scanner(System.in);
	    while(true) {
	        System.out.println("どうやって攻撃する？ 通常攻撃：１ 特殊技：２");
	        if(scanner.hasNextInt()){
	          int selectCommand = scanner.nextInt();
	          if(selectCommand < 1 || selectCommand > 2){
	            System.out.println("数値は1,2のどれかを入力してください");
	          } else if(selectCommand == 2){
	            useSpecial_my = true;
	            break;
	          }else {
	        	  break;
	          }
	        }else {
	          System.out.println("数値を入力してください");
	        }
	    }
	    // 確率で敵も特殊技を使う
	    if(enemyMonster.getPp() > 0) {
	    	double randSpecial = new Random().nextDouble();
	        useSpecial_enemy = (randSpecial < 0.3);
	    }

	    try{
	    	// attackとspecialAttackどちらを呼び出すか
	        Method myAttackMethod;
	        Method enemyAttackMethod;
	    	myAttackMethod = useSpecial_my
	    		? myMonster.getClass().getMethod("specialAttack", Monster.class)
	    		: myMonster.getClass().getMethod("attack", Monster.class);
	    	enemyAttackMethod = useSpecial_enemy
		    	? enemyMonster.getClass().getMethod("specialAttack", Monster.class)
		    	: enemyMonster.getClass().getMethod("attack", Monster.class);

	        // 攻撃処理
	        if(myMonster.getAgility() * myMonster.getAgilityRise()
	        		> enemyMonster.getAgility()* enemyMonster.getAgilityRise()){
	        	attackSet(myMonster, myAttackMethod, enemyMonster, enemyAttackMethod);
			} else if (myMonster.getAgility() * myMonster.getAgilityRise()
					< enemyMonster.getAgility() * enemyMonster.getAgilityRise()) {
				attackSet(enemyMonster, enemyAttackMethod, myMonster, myAttackMethod);
			} else { // 同速
				Random rand = new Random();
				int num = rand.nextInt(2);
				if (num == 0) {
					attackSet(myMonster, myAttackMethod, enemyMonster, enemyAttackMethod);
				} else {
					attackSet(enemyMonster, enemyAttackMethod, myMonster, myAttackMethod);
				}
			}
	    } catch(NoSuchMethodException e) {
	    	e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

	    // 倒されたとき
	    if(myMonster.isKnockedOut()){
	        System.out.println(myMonster.getName() + "は倒されてしまった・・・");
	        myMonster.setAsleep(0);
	      }
	    if(enemyMonster.isKnockedOut()){
	        System.out.println(enemyMonster.getName() + "を倒した！");
	        // myMonster.gainExp(defaultExp);
	        int exp = enemyMonster.getMaxHp();
	        if(!myMonster.isKnockedOut()) {
	        	myMonster.gainExp(exp);
	        }
	    }

  }

  // １対の攻撃
  public static void attackSet(Monster firstMonster, Method firstAttack, Monster secondMonster, Method secondAttack) {
	  try{
		  firstAttack.invoke(firstMonster, secondMonster);
		  if(!secondMonster.isKnockedOut()) {
			  secondAttack.invoke(secondMonster, firstMonster);
		  }
	  } catch (IllegalAccessException e) {
		  e.printStackTrace();
	  } catch (IllegalArgumentException e) {
		  e.printStackTrace();
	  } catch (InvocationTargetException e) {
		  e.printStackTrace();
	  }
  }


  public static void isWin(){

    if(party.allKnockedOut()){
      System.out.println("敗北してしまった・・・");
    }

    if(field.allKnockedOut()){
      System.out.println("敵に勝利！");
      Party.money += 100;
      System.out.println("賞金 100円 を手に入れた！");
      int selectCommand = inputCommand();
      if(selectCommand == 0) { // 終了
    	  System.out.println("ゲームを終了します");
    	  return;
      }
      if(selectCommand == 1){ // 続ける
        battleCount++;
        isContinue();
      }else if(selectCommand == 2){ // 回復して続ける
        battleCount++;
        party.heal();
        isContinue();
      }else if(selectCommand == 3){ // アイテムを使う
        if(Party.itemBox.size() == 0){
          System.out.println("アイテムがありません");
          return;
        }
        System.out.println("使用するアイテムを選択してください");
        Party.itemBox.showList();
        int index = selectItemIndex(Party.itemBox);
        Party.itemBox.useItem(index);
        isContinue();
      }else if(selectCommand == 4) { // ショップで購入
        System.out.println("購入するアイテムを選択してください");
        Party.shopList.showList();
        int index = buyItemIndex(Party.shopList);
        Party.shopList.buyItems(index);
        isContinue();
      }else if(selectCommand == 5){ // ボス戦
        party.heal();
    	System.out.println("ボスモンスターが出現した！");
        field = new Field(1, true);
        battle(true);
      }
    }
  }

  public static int selectItemIndex(ItemBox itemBox){
    Scanner scanner = new Scanner(System.in);
    while(true) {
        if(scanner.hasNextInt()){
          int selectCommand = scanner.nextInt();
          if(selectCommand < 1 || selectCommand > itemBox.size()){
            System.out.println("数値は1 ~ " + itemBox.size() + "のどれかを入力してください");
          } else {
            return selectCommand - 1;
          }
        } else {
          System.out.println("数値を入力してください");
          scanner.next();
        }
    }
  }

  public static int buyItemIndex(ShopList shopList){
    Scanner scanner = new Scanner(System.in);
    while(true) {
        if(scanner.hasNextInt()){
          int selectCommand = scanner.nextInt();
          if(selectCommand < 1 || selectCommand > shopList.size()){
            System.out.println("数値は1 ~ " + shopList.size() + "のどれかを入力してください");
          } else {
            return selectCommand - 1;
          }
        } else {
          System.out.println("数値を入力してください");
          scanner.next();
        }
    }
  }

  public static int inputCommand(){
    Scanner scan = new Scanner(System.in);
    while(true) {
      if(battleCount >= 3){
        System.out.println("戦闘を続けますか？　終了する：０　続ける：１　回復して続ける：２　アイテム使用：３  買い物：4　ボスと戦う：5");
        if(scan.hasNextInt()){
          int selectCommand = scan.nextInt();
          if(selectCommand < 0 || selectCommand > 5){
            System.out.println("数値は0,1,2,3,4,5のどれかを入力してください");
            continue;
          } else {
            return selectCommand;
          }
        } else {
          System.out.println("数値を入力してください");
          scan.next();
        }
      }
        System.out.println("戦闘を続けますか？　終了する：０　続ける：１　回復して続ける：２　アイテム使用：３ 買い物：４");
        if(scan.hasNextInt()){
          int selectCommand = scan.nextInt();
          if(selectCommand < 0 || selectCommand > 5){
            System.out.println("数値は0,1,2,3,4のどれかを入力してください");
            continue;
          } else {
            return selectCommand;
          }
        } else {
          System.out.println("数値を入力してください");
          scan.next();
        }
    }
  }

  public static int selectCommand(){
    Scanner scanner = new Scanner(System.in);
    while(true) {
        System.out.println("何をする？　たたかう：１　逃げる：２　交代する：３");
        if(scanner.hasNextInt()){
          int selectCommand = scanner.nextInt();
          if(selectCommand < 1 || selectCommand > 3){
            System.out.println("数値は1,2,3のどれかを入力してください");
          } else {
            return selectCommand;
          }
        }else {
          System.out.println("数値を入力してください");
          scanner.next();
        }
    }
  }

  public static int changeMonsterNumber(ArrayList<Monster> myMonsters){
    Scanner scanner = new Scanner(System.in);
    while(true) {
      System.out.println("交代するモンスターの番号を入力してください");
      for(int i = 0; i < myMonsters.size(); i++) {
    	  String alive = myMonsters.get(i).isKnockedOut() ? "【戦闘不能】" : "";
    	  System.out.println((i+1) + ": " + alive + myMonsters.get(i).getName());
      }
      if(scanner.hasNextInt()){
        int selectCommand = scanner.nextInt();
        if(selectCommand < 1 || selectCommand > myMonsters.size()){
          System.out.println("数値は1 ~ " + myMonsters.size() + "のどれかを入力してください");
          continue;
        } else if(myMonsters.get(selectCommand-1).isKnockedOut()){
        	System.out.println(myMonsters.get(selectCommand-1).getName() + "はすでに戦闘不能です");
        } else {
          return selectCommand - 1;
        }
      } else {
        System.out.println("数値を入力してください");
        scanner.next();
      }
    }
  }

  public static void isContinue(){
    field = new Field(4, false);
    battle(false);
  }

  public static void clearBoss(){
    System.out.println("ボスモンスターに勝利した！！");
    System.out.println("こうして世界は平和になった");
    System.out.println("Thank you for playing!!");
    System.out.println("special thanks to Neiro♪");
  }
}