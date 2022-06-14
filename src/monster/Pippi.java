package monster;

public class Pippi extends Monster{

	public Pippi(String name, int max_hp, int attack_power, int defense_power, int agility, int level) {
		super(name,max_hp,attack_power,defense_power,agility,level);
		max_pp = 0;
		pp = max_pp;
	}


    @Override
	public String getSpeciesName() {
		return "ピッピ";
	}


    // 特殊技を持たないので、specialAttackが呼ばれたら通常の攻撃に移行
    @Override
    public void specialAttack(Monster enemyMonster) {
    	this.attack(enemyMonster);
    }

}
