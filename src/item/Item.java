package item;

import java.util.Scanner;

public abstract class Item {
  protected String itemName;
  protected int stock;
  protected int max_stock;
  protected String item_detail;

  public Item(String itemName, int stock, int max_stock, String item_detail){
    this.itemName = itemName;
    if(stock < 0) stock = 0;
    this.stock = stock;
    this.max_stock = max_stock;
    this.item_detail = item_detail;
  }

  public abstract void useItem();
  public abstract void buyItems();

  public String toString(){
    return (this.itemName);
  }

  public void setItemName(String itemName){
    this.itemName = itemName;
  }
  public void setStock(int stock){
    this.stock = stock;
  }
  public void setMaxStock(int max_stock){
    this.max_stock = max_stock;
  }
  public void setItemDetail(String item_detail){
    this.item_detail = item_detail;
  }

  public String getItemName(){
    return this.itemName;
  }
  public int getStock(){
    return this.stock;
  }
  public int getMaxStock(){
    return this.max_stock;
  }
  public String getItemDetail(){
    return this.item_detail;
  }
  public int selectCharacter(int size){
    Scanner scanner = new Scanner(System.in);
    while(true){
      if(scanner.hasNextInt()){
        int selectCommand = scanner.nextInt();
        if(selectCommand < 1 || selectCommand > size){
          System.out.println("数値は1~"+ size + "のどれかを入力してください");
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
}
