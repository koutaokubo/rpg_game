package item;

import java.util.ArrayList;

public class ItemBox {
  private ArrayList<Item> list;

  public ItemBox(){
    list = new ArrayList<Item>();
  }

  public void showList(){
    for (int i=0; i < this.list.size(); i++){
      System.out.printf("%d: %s\n", i + 1, this.list.get(i));
    }
  }

  public void remove(Item item) {
		int index = this.list.indexOf(item);
		if (index > -1) {
			this.list.remove(index);
		}
	}

  public void add(Item item) {
		int index = this.indexOf(item);
		
		if (index == -1) {
			this.list.add(item);
		} else {
			Item targetItem = this.list.get(index);
			
			if (targetItem.stock == targetItem.max_stock) {
				System.out.printf("%s はこれ以上持てません！！\n", item.itemName);
			}else {
				targetItem.stock += item.stock;
				if (targetItem.stock > targetItem.max_stock) {
					targetItem.stock = targetItem.max_stock;
					System.out.printf("%s のもちきれない分を捨てた…もったいない…\n", item.itemName);
				}
			}
		}
	}

  public int indexOf(Item item) {
		for (int i=0; i<this.list.size(); i++) {
			if (this.list.get(i).getClass() == item.getClass()) { 
				return (i);
			}
		}
		return (-1);
	}

  public int size() {
		return this.list.size();
	}

	public void useItem(int index) {
		if(index < 0 || this.list.size() <= index) {
			System.out.println("存在しないアイテムです");
			return ;
		}
		this.list.get(index).useItem();
		if (this.list.get(index).stock == 0) {
			this.list.remove(index);
		}
		return ;
	}

}
