package rpg;

public class Pippi extends Monster2{

	public Pippi(String name, int max_hp, int attack_power, int defense_power, int agility, int level) {
		super(name,max_hp,attack_power,defense_power,agility,level);
		max_pp = 0;
	}


    @Override
	public String getSpeciesName() {
		return "ピッピ";
	}

    @Override
    public void attack(Monster2 enemyMonster, Monster2 myMonster) {
        int enemyHp = enemyMonster.getHp();
        int damage = ((myMonster.attack_power + myMonster.attack_rise) / 2)
        		- ((enemyMonster.defense_power + enemyMonster.defense_rise) / 4);
        damage = Math.max(damage, 1);
        enemyHp -= damage;
        enemyMonster.setHp(enemyHp);
        if(enemyHp < 0){
          enemyHp = 0;
        }
        System.out.println(enemyMonster.name + "へ" + damage + "のダメージ。残り体力は" + enemyHp);
    }

    // 特殊技を持たないので、specialAttackが呼ばれたら通常の攻撃に移行
    public void specialAttack(Monster2 enemyMonster, Monster2 myMonster) {
//    	System.out.println(myMonster.getName() + " は特殊技を持っていなかった！");
    	this.attack(enemyMonster, myMonster);
    }

}
