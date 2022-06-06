package rpg;

import java.util.ArrayList;
import java.util.Scanner;

import field.Field;

public class Main {
  public static void main(String[] args) {
    Field field = new Field(4);
    // MyMonster myMonster = new MyMonster("my1", 1200, 1200, 80, 20, 32);
    ArrayList<MyMonster> myMonsters = new ArrayList<>(){
      {
        add(new MyMonster("my1", 100, 100,30, 30, 15));
        add(new MyMonster("my2", 100, 100,30, 30, 15));
        add(new MyMonster("my3", 100, 100,30, 30, 15));
        add(new MyMonster("my4", 100, 100,30, 30, 15));
        add(new MyMonster("my5", 100, 100,30, 30, 15));
        add(new MyMonster("my6", 100, 100,30, 30, 15));
      }
    };
    // EnemyMonster enemyMonster = new EnemyMonster("ene1", 100, 100, 70, 10, 35);

    letsBattle(myMonsters, field.enemyMonsters);
  }

  public static void letsBattle(ArrayList<MyMonster> myMonsters, ArrayList<EnemyMonster> enemyMonsters){
    int i = 0;
    int j = 0;
    MyMonster my = myMonsters.get(0);
    EnemyMonster enemy = enemyMonsters.get(0);

    while(!myMonsters.isEmpty() && !enemyMonsters.isEmpty()) {
    	my = myMonsters.get(0);
    	enemy = enemyMonsters.get(0);
        while(my.getBattle() && enemy.getBattle()) {
    	    if(my.agility > enemy.agility){
    		    my.attack(enemy, my);
    		    if(enemy.getBattle()) {
    			    enemy.attack(my, enemy);
    			    if(!my.getBattle()) {
    				    myMonsters.remove(0);
    			    }
    		    }else {
    			    enemyMonsters.remove(0);
    		    }
    	    }else if(enemy.agility > my.agility){
    		    enemy.attack(my, enemy);
    		    if(my.getBattle()) {
    			    my.attack(enemy, my);
    			    if(!enemy.getBattle()) {
    				    enemyMonsters.remove(0);
    			    }
    		    }else {
    			    myMonsters.remove(0);
    		    }
    	    }
    	    System.out.println("コマンドを入力>");
    	    int c = nextCommand();
    	    if(c > 0) {
    	    	System.out.println(c + "番と交代！");
    	    	MyMonster tmp = myMonsters.get(0);
    	    	myMonsters.set(0, myMonsters.get(c));
    	    	myMonsters.set(c, tmp);
    	    }
        }
    }
//    isWin(myMonsters, enemyMonsters);
    System.out.println("END");
  }

  public static int nextCommand() {
	  Scanner scanner = new Scanner(System.in);
	  int command = Integer.MIN_VALUE;
	  if(scanner.hasNextInt()) {
		  switch(scanner.nextInt()) {
		  case 1: //たたかう
			  break;
		  case 2: //にげる
			  System.out.println("うまくにげきれた！");
			  System.exit(0);
			  break;
		  case 3: //交代
			  System.out.println("何番と交代する？");
			  command = scanner.nextInt();
			  break;
		  default:
			  System.out.println("1, 2, 3のいずれかを入力してください");
			  nextCommand(); //これやばそう
			  break;
		  }
	  }
	  return command;
  }

  public static void isWin(ArrayList<MyMonster> myMonsters, ArrayList<EnemyMonster> enemyMonsters){
    if(!myMonsters.get(myMonsters.size() -1).getBattle() && enemyMonsters.get(enemyMonsters.size() - 1).getBattle()){
      System.out.println("敗北しました");
      return;
    }

    if(!enemyMonsters.get(enemyMonsters.size() - 1).getBattle() && myMonsters.get(myMonsters.size() - 1).getBattle()){
      int selectCommand = inputCommand();
      if(selectCommand == 1){
        isContinue(myMonsters);
      }else if(selectCommand == 2){
        recovery(myMonsters, enemyMonsters);
      }else if(selectCommand == 3){
        return;
      }
    }
  }

  public static int inputCommand(){
    System.out.println("勝利しました");
    Scanner scanner = new Scanner(System.in);
    while(true) {
      System.out.println("戦闘を続けますか？　続ける：１　回復して続ける：２　終了する：３");
      if(scanner.hasNextInt()){
        int selectCommand = scanner.nextInt();
        if(selectCommand < 1 || selectCommand > 3){
          System.out.println("数値は1,2,3のどれかを入力してください");
          continue;
        } else {
          return selectCommand;
        }
      } else {
        System.out.println("数値を入力してください");
        scanner.next();
      }
      scanner.close();
    }
  }

  public static void recovery(ArrayList<MyMonster> myMonsters, ArrayList<EnemyMonster> enemyMonsters) {
    // enemyMonster.hp = enemyMonster.max_hp;
    myMonsters.forEach(myMonster -> myMonster.hp = myMonster.max_hp);
    isContinue(myMonsters);
  }

  public static void isContinue(ArrayList<MyMonster> myMonsters){
    ArrayList<EnemyMonster> nextEnemyMonsters = new Field(3).enemyMonsters;
    letsBattle(myMonsters, nextEnemyMonsters);
  }
}
