package rpg;

import java.util.ArrayList;
import java.util.Scanner;
import rpg.Monster;

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
    
    //　① Monsterがいるかどうか
    while(!myMonsters.isEmpty() && !enemyMonsters.isEmpty()){
      
      // 敵味方どちらも残存している時
      if(i < myMonsters.size() && j < enemyMonsters.size()){
        MyMonster myMonster = myMonsters.get(i);
        EnemyMonster enemyMonster = enemyMonsters.get(j);
        
        // 1. Monsterの攻撃(myが速い版)
        if(myMonster.agility > enemyMonster.agility){
          myMonster.attack(enemyMonster, myMonster);
          if(enemyMonster.getBattle()){
            enemyMonster.attack(myMonster, enemyMonster);
            if(!myMonster.getBattle()){
              i++;
            }
          }else{
            j++;
          }
        }
        
        // 2. Monsterの攻撃(myが遅い版)
        if(myMonster.agility < enemyMonster.agility) {
          enemyMonster.attack(myMonster, enemyMonster);
          if(myMonster.getBattle()) {
            myMonster.attack(enemyMonster, myMonster);
            if(!enemyMonster.getBattle()){
              j++;
            }
          }
          else{
            i++;
          }
        }
        
        // 3. 選択肢
        if(!myMonsters.isEmpty() && !enemyMonsters.isEmpty()){
          switch(battleCommand()){
            case 1:
            break;
            case 2:
            System.out.println("戦闘を終了します");
            myMonsters.clear();
            enemyMonsters.clear();
            break;
          case 3:
          System.out.println("交代先を選んでください");
          
          break;
          }
        }
      // 
      }else if((i == myMonsters.size() && j < enemyMonsters.size()) || (i == myMonsters.size() && j >= enemyMonsters.size())){
        myMonsters.clear();
      }else if(i < myMonsters.size() && j == enemyMonsters.size()){
        enemyMonsters.clear();
      }
    }
    isWin(myMonsters, enemyMonsters);
  }

  public static void isWin(ArrayList<MyMonster> myMonsters, ArrayList<EnemyMonster> enemyMonsters){
    if((myMonsters.isEmpty() && !enemyMonsters.isEmpty()) || (!myMonsters.isEmpty() && !enemyMonsters.isEmpty())){
      System.out.println("敗北しました");
      return;
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

    public static int battleCommand(){
    System.out.println("どうする？");
    Scanner scanner = new Scanner(System.in);
    while(true) {
      System.out.println("たたかう：１　にげる：２　こうたい：３");
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

  // public static void nextBattle(ArrayList<MyMonster> myMonsters, ArrayList<EnemyMonster> enemyMonsters){
	// int i = 0;
	// int j = 0;
  //   MyMonster myMonster = myMonsters.get(i);
  //   EnemyMonster enemyMonster = enemyMonsters.get(j);
  //     if(myMonster.agility > enemyMonster.agility){
  //       myMonster.attack(enemyMonster, myMonster);
  //       if(enemyMonster.getBattle()){
  //         enemyMonster.attack(myMonster, enemyMonster);
  //         if(!myMonster.getBattle()){
  //           i++;
  //         }
  //       }else{
  //         j++;
  //       }
  //     }
      
  //     if(myMonster.agility < enemyMonster.agility) {
  //       enemyMonster.attack(myMonster, enemyMonster);
  //       if(myMonster.getBattle()) {
  //         myMonster.attack(enemyMonster, myMonster);
  //         if(!enemyMonster.getBattle()){
  //           j++;
  //         }
  //       }
  //       else{
  //         i++;
  //       }
  //     }
  // }

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
