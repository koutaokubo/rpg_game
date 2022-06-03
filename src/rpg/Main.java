package rpg;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    MyMonster myMonster = new MyMonster("my1", 1200, 1200, 80, 20, 32);
    EnemyMonster enemyMonster = new EnemyMonster("ene1", 100, 100, 70, 10, 35);

    letsBattle(myMonster, enemyMonster);
  }

  public static void letsBattle(Monster myMonster, Monster enemyMonster){
    do{
      if(myMonster.agility > enemyMonster.agility){
        myMonster.attack(enemyMonster, myMonster);
        if(enemyMonster.hp > 0){
          enemyMonster.attack(myMonster, enemyMonster);
        }
      } else {
        enemyMonster.attack(myMonster, enemyMonster);
        if (myMonster.hp > 0) {
          myMonster.attack(enemyMonster, myMonster);
        }
      }
    }
    while(myMonster.hp > 0 && enemyMonster.hp > 0);
    isWin(myMonster, enemyMonster);
  }

  public static void isWin(Monster myMonster, Monster enemyMonster){
    if(myMonster.hp <= 0 && enemyMonster.hp > 0){
      System.out.println("敗北しました");
      return;
    }

    if(enemyMonster.hp <= 0 && myMonster.hp > 0){
      System.out.println("勝利しました");
      Scanner scanner = new Scanner(System.in);
      System.out.println("戦闘を続けますか？　続ける：１　回復して続ける：２　終了する：３");
      int selectCommand = scanner.nextInt();
      if(selectCommand == 1){
        isContinue(myMonster);
      }else if(selectCommand == 2){
        recovery(myMonster, enemyMonster);
        letsBattle(myMonster, enemyMonster);
      }else if(selectCommand == 3){
        scanner.close();
        return;
      }
      scanner.close();
    }
  }

  public static void recovery(Monster myMonster, Monster enemyMonster) {
    enemyMonster.hp = enemyMonster.max_hp;
    myMonster.hp = myMonster.max_hp;
  }

  public static void isContinue(Monster myMonster){
    EnemyMonster nextEnemyMonster = new EnemyMonster("ene2", 300, 300, 130, 30, 5);
    letsBattle(myMonster, nextEnemyMonster);
  }
}
