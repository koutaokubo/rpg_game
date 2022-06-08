package rpg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import field.BossField;
import field.Field;
import item.ItemBox;
import item.ShopList;

public class Main {
  public static void main(String[] args) {
    Field field = new Field(4);
    TeamMember teamMember = new TeamMember(6);

    //todo teamMemberがstaticになっているので変更するかどうか検討
    // Item item = new Attacker(1);
    // TeamMember.itemBox.add(item);
    letsBattle(teamMember.myMonsters, field.enemyMonsters, false);
  }

  public static void letsBattle(ArrayList<Monster2> myMonsters, ArrayList<Monster2> enemyMonsters, boolean isBoss){
    int selectNumber;
    int command;
    ArrayList<Integer> initialLevel = new ArrayList<Integer>();
    myMonsters.forEach(myMonster -> initialLevel.add(myMonster.getLevel()));

    // firstAttack(myMonsters.get(0), enemyMonsters.get(0));

    do{
      Monster2 myMonster = myMonsters.get(0);
      Monster2 enemyMonster = enemyMonsters.get(0);

      //todo 現在戦闘中のモンスターの名前とHPを表示させる
      int currentLevel = myMonster.getLevel();
      firstAttack(myMonster, enemyMonster);

      if(!myMonsters.get(0).getBattle()){
        myMonsters.remove(0);
        initialLevel.remove(0);
      }
      if(!enemyMonsters.get(0).getBattle()){
        enemyMonsters.remove(0);
        System.out.println(enemyMonster.getName() + "を倒した！");
        myMonster.gainExp(20);
        System.out.println(myMonster.getName() + "は" + 20 + "の経験値を得た！");
        if(currentLevel > initialLevel.get(0)){
          System.out.println(myMonster.getName()+"はレベルアップした！ -> " + myMonster.getLevel() );
        }
      }
      if(myMonsters.isEmpty() || enemyMonsters.isEmpty()){
        break;
      }
      command =  selectCommand();
      switch(command) {
        case 1:
          // firstAttack(myMonster, enemyMonster);
          break;
        case 2:
          enemyMonsters.clear();
          return;
        case 3:
          selectNumber = changeMonsterNumber(myMonsters);
          changeMonster(myMonsters, 0, selectNumber);
          break;
      }
    } while(!myMonsters.isEmpty() && !enemyMonsters.isEmpty());

    System.out.println("戦闘終了");
    if(isBoss){
      clearBoss();
    }else{
      isWin(myMonsters, enemyMonsters);
    }
  }


  public static void isWin(ArrayList<Monster2> myMonsters, ArrayList<Monster2> enemyMonsters){
    // if(!myMonsters.get(myMonsters.size() -1).getBattle() && enemyMonsters.get(enemyMonsters.size() - 1).getBattle()){
    //   System.out.println("敗北しました");
    //   return;
    // }
    if(myMonsters.isEmpty() && !enemyMonsters.isEmpty()){
      Field.setBattleCount(0);
      System.out.println("敗北しました");
    }

    if(!myMonsters.isEmpty() && enemyMonsters.isEmpty()){
      TeamMember.money += 100;
      int selectCommand = inputCommand();
      //todo 買い物コマンド追加する・アイテム使用機能追加する
      if(selectCommand == 0) return;
      if(selectCommand == 1){
        Field.plusBattleCount();
        isContinue(myMonsters);
      }else if(selectCommand == 2){
        recovery(myMonsters, enemyMonsters);
      }else if(selectCommand == 3){
        if(TeamMember.itemBox.size() == 0){
          System.out.println("アイテムがありません");
          return;
        }
        System.out.println("使用するアイテムを選択してください");
        TeamMember.itemBox.showList();
        int index = selectItemIndex(TeamMember.itemBox);
        TeamMember.itemBox.useItem(index);
        isContinue(myMonsters);
      }else if(selectCommand == 4) {
        System.out.println("購入するアイテムを選択してください");
        TeamMember.shopList.showList();
        int index = buyItemIndex(TeamMember.shopList);
        TeamMember.shopList.buyItems(index);
        isContinue(myMonsters);
      }else if(selectCommand == 5){
        BossField bossField = new BossField();
        // firstAttack(myMonsters.get(0),bossField.enemyMonsters.get(0));
        letsBattle(myMonsters, bossField.enemyMonsters, true);
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
            continue;
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
            continue;
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
    System.out.println("勝利しました");
    Scanner scan = new Scanner(System.in);
    while(true) {
      if(Field.battleCount >= 3){
        System.out.println("戦闘を続けますか？　終了する：０　続ける：１　回復して続ける：２　アイテム使用：３  買い物：4　ボスと戦う：5");
        if(scan.hasNextInt()){
          int selectCommand = scan.nextInt();
          if(selectCommand < 0 || selectCommand > 4){
            System.out.println("数値は0,1,2,3,4のどれかを入力してください");
            continue;
          } else {
            return selectCommand;
          }
        } else {
          System.out.println("数値を入力してください");
          scan.next();
        }
      }else{
        System.out.println("戦闘を続けますか？　終了する：０　続ける：１　回復して続ける：２　アイテム使用：３ 買い物：４");
        if(scan.hasNextInt()){
          int selectCommand = scan.nextInt();
          if(selectCommand < 1 || selectCommand > 4){
            System.out.println("数値は1,2,3のどれかを入力してください");
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
        }else {
          System.out.println("数値を入力してください");
          scanner.next();
        }
      }
  }

  public static int changeMonsterNumber(ArrayList<Monster2> myMonsters){
    Scanner scanner = new Scanner(System.in);
    while(true) {
      System.out.println("交代するモンスターの番号を入力してください(1 ~ " + myMonsters.size() + ")");
      if(scanner.hasNextInt()){
        int selectCommand = scanner.nextInt();
        if(selectCommand < 1 || selectCommand > myMonsters.size()){
          System.out.println("数値は1 ~ " + myMonsters.size() + "のどれかを入力してください");
          continue;
        } else {
          return selectCommand;
        }
      } else {
        System.out.println("数値を入力してください");
        scanner.next();
      }
    }
  }


  public static void recovery(ArrayList<Monster2> myMonsters, ArrayList<Monster2> enemyMonsters) {
    // enemyMonster.hp = enemyMonster.max_hp;
    TeamMember teamMember = new TeamMember(6);

    myMonsters.clear();
    myMonsters.addAll(teamMember.myMonsters);
    isContinue(myMonsters);
  }

  public static void isContinue(ArrayList<Monster2> myMonsters){
    ArrayList<Monster2> nextEnemyMonsters = new Field(3).enemyMonsters;
    letsBattle(myMonsters, nextEnemyMonsters, false);
  }

  public static void firstAttack(Monster2 myMonster, Monster2 enemyMonster){
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


  public static void changeMonster(ArrayList<MyMonster> myMonsters, int currentNumber, int selectNumber){
    Collections.swap(myMonsters, currentNumber, selectNumber -1);
  }

  public static void bossBattle(ArrayList<Monster2> bossMonsters, ArrayList<Monster2> myMonsters){
    System.out.println("ボスモンスターが出現した");
    letsBattle(myMonsters, bossMonsters, true);
  }

  public static void clearBoss(){
    System.out.println("ボスモンスターに勝利した！！");
    System.out.println("こうして世界は平和になった！！");
    System.out.println("Thank you for playing!!");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("Special Thanks to Neiro♪");
  }
}