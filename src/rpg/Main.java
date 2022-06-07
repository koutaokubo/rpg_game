package rpg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import field.Field;

public class Main {
  public static void main(String[] args) {
    Field field = new Field(4);
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

    letsBattle(myMonsters, field.enemyMonsters);
  }

  public static void letsBattle(ArrayList<MyMonster> myMonsters, ArrayList<EnemyMonster> enemyMonsters){
    int selectNumber;
    int command;

    firstAttack(myMonsters.get(0), enemyMonsters.get(0));

    while(!myMonsters.isEmpty() && !enemyMonsters.isEmpty()){
      if(!myMonsters.get(0).getBattle()){
        myMonsters.remove(0);
      }
      if(!enemyMonsters.get(0).getBattle()){
        enemyMonsters.remove(0);
      }
      if(myMonsters.isEmpty() || enemyMonsters.isEmpty()){
        break;
      }
      MyMonster myMonster = myMonsters.get(0);
      EnemyMonster enemyMonster = enemyMonsters.get(0);
      command =  selectCommand();
      switch(command) {
        case 1:
          firstAttack(myMonster, enemyMonster);
          break;
        case 2:
          enemyMonsters.clear();
          return;
        case 3:
          selectNumber = changeMonsterNumber();
          changeMonster(myMonsters, 0, selectNumber);
          break;
      }
    }
    System.out.println("戦闘終了");
    isWin(myMonsters, enemyMonsters);
  }


  public static void isWin(ArrayList<MyMonster> myMonsters, ArrayList<EnemyMonster> enemyMonsters){
    // if(!myMonsters.get(myMonsters.size() -1).getBattle() && enemyMonsters.get(enemyMonsters.size() - 1).getBattle()){
    //   System.out.println("敗北しました");
    //   return;
    // }
    if(myMonsters.isEmpty() && !enemyMonsters.isEmpty()){
      System.out.println("敗北しました");
    }

    if(!myMonsters.isEmpty() && enemyMonsters.isEmpty()){
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
    Scanner scan = new Scanner(System.in);
    while(true) {
      System.out.println("戦闘を続けますか？　続ける：１　回復して続ける：２　終了する：３");
      if(scan.hasNextInt()){
        int selectCommand = scan.nextInt();
        if(selectCommand < 1 || selectCommand > 3){
          System.out.println("数値は1,2,3のどれかを入力してください");
          continue;
        } else {
          return selectCommand;
        }
      } else {
        System.out.println("数値を入力してください");
        scan.next();
      }
      scan.close();
    }
  }

  public static int selectCommand(){
    Scanner scanner = new Scanner(System.in);
    while(true) {
      System.out.println("戦闘を続けますか？　たたかう：１　逃げる：２　交代する：３");
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

  public static int changeMonsterNumber(){
    Scanner scanner = new Scanner(System.in);
    while(true) {
      System.out.println("交代するモンスターの番号を入力してください");
      if(scanner.hasNextInt()){
        int selectCommand = scanner.nextInt();
        if(selectCommand < 0 || selectCommand > 5){
          System.out.println("数値は0,1,2,3,4,5,のどれかを入力してください");
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
    enemyMonsters.forEach(enemyMonster -> enemyMonster.hp = enemyMonster.max_hp);
    isContinue(myMonsters);
  }

  public static void isContinue(ArrayList<MyMonster> myMonsters){
    ArrayList<EnemyMonster> nextEnemyMonsters = new Field(3).enemyMonsters;
    letsBattle(myMonsters, nextEnemyMonsters);
  }

  public static void firstAttack(MyMonster myMonster, EnemyMonster enemyMonster){
    if(myMonster.agility > enemyMonster.agility && myMonster.getBattle() && enemyMonster.getBattle()){
      myMonster.attack(enemyMonster, myMonster);
      if(enemyMonster.getBattle()){
        enemyMonster.attack(myMonster, enemyMonster);
      }
    }else if(myMonster.agility < enemyMonster.agility && enemyMonster.getBattle() && myMonster.getBattle()){
      enemyMonster.attack(myMonster, enemyMonster);
      if(myMonster.getBattle()){
        myMonster.attack(enemyMonster, myMonster);
      }
    }else{
      Random rand = new Random();
      int num = rand.nextInt(2);
      if (num == 0){
        if(myMonster.getBattle() && enemyMonster.getBattle()){
          myMonster.attack(enemyMonster, myMonster);
          if(enemyMonster.getBattle()){
            enemyMonster.attack(myMonster, enemyMonster);
          }
        }
      }else{
        if(enemyMonster.getBattle() && myMonster.getBattle()){
          enemyMonster.attack(myMonster, enemyMonster);
          if(myMonster.getBattle()){
            myMonster.attack(enemyMonster, myMonster);
          }
        }
      }
    }
    
  }

  public static void changeMonster(ArrayList<MyMonster> myMonsters, int currentNumber, int selectNumber){
    Collections.swap(myMonsters, currentNumber, selectNumber);
  }
}
