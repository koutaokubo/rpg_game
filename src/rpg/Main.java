package rpg;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    MyMonster myMonster = new MyMonster("my1", 1200, 1200, 80, 20, 32);
    EnemyMonster enemyMonster = new EnemyMonster("ene1", 100, 100, 570, 10, 35);

    letsBattle(myMonster, enemyMonster);
  }

  public static void letsBattle(MyMonster myMonster, EnemyMonster enemyMonster){
    while(myMonster.getBattle() && enemyMonster.getBattle()){
      if(myMonster.agility > enemyMonster.agility){
        myMonster.attack(enemyMonster, myMonster);
        if(enemyMonster.getBattle()){
          enemyMonster.attack(myMonster, enemyMonster);
        }
      } else if(myMonster.agility < enemyMonster.agility) {
        enemyMonster.attack(myMonster, enemyMonster);
        if(myMonster.getBattle()) {
          myMonster.attack(enemyMonster, myMonster);
        }
      }
    }
    isWin(myMonster, enemyMonster);
  }

  public static void isWin(MyMonster myMonster, EnemyMonster enemyMonster){
    if(!myMonster.getBattle() && enemyMonster.getBattle()){
      System.out.println("敗北しました");
      return;
    }

    if(!enemyMonster.getBattle() && myMonster.getBattle()){
      int selectCommand = inputCommand();
      if(selectCommand == 1){
        isContinue(myMonster);
      }else if(selectCommand == 2){
        recovery(myMonster, enemyMonster);
        letsBattle(myMonster, enemyMonster);
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

  public static void recovery(MyMonster myMonster, EnemyMonster enemyMonster) {
    // enemyMonster.hp = enemyMonster.max_hp;
    myMonster.hp = myMonster.max_hp;
    isContinue(myMonster);
  }

  public static void isContinue(MyMonster myMonster){
    EnemyMonster nextEnemyMonster = new EnemyMonster("ene2", 300, 300, 130, 30, 5);
    letsBattle(myMonster, nextEnemyMonster);
  }
}
