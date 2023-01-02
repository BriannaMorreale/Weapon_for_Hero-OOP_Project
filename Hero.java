//Playable hero object subclass of a Character
//Brianna Morreale
//CS1410
//3-28-21

import java.security.SecureRandom;
public class Hero extends Character
{
	Weapon w1 = new Weapon(); //hero can "have a" weapon
	private Thing inventory [];
	private final int INVENTORY_SIZE = 10;  //Inventory was created but not used. It was for class demo. 
	protected int manna;

	public Hero() //no argument constructor
		{
			inventory = null;
			manna =0;
		}
	
	public Hero(String name, Field f1, int hitPoints, int strength, int manna) //all argument constructor
		{ 
			this.manna = manna;
			this.name = name;
			x = 0; //We could have a board object with an array of "Thing" objects and use the coordindates. 
			y = 0; //Start him at position 0
			status = status.ALIVE; //Give him a status of alive
		
			if (hitPoints > 300){ //only allow for a max of 300 hit points
				this.hitPoints = 300; 
			}else{
				this.hitPoints = hitPoints;
			}
		
			if (strength > 100){ //only allow for a max of 100 strength
				this.strength =100;
			}else{
				this.strength = strength; 
			}
			
			inventory = new Thing [INVENTORY_SIZE]; //create an inventory of objects for the hero to carry around
		
			initInventory(); //initialize inventory array
		}

		
	private void initInventory()
	{
	 for (int i = 0; i< INVENTORY_SIZE; ++i)
	 	inventory[i] = new Thing ("EMPTY"); 
	}
	
	public int gethitPoints(){ //getters for Hero
		return hitPoints;
	}
	
	public int getStrength(){
		return strength;
	}
	
	public int getManna(){
		return this.manna;
	}
	
	public void equip(Weapon w1){ //allows hero to equip a weapon
		this. w1 = w1;
	}

	public int attack(){ //Hero's attack without a weapon
		SecureRandom sr = new SecureRandom();
		return 1+sr.nextInt(strength); //simply returns a random number from 0 to the hero's strength
	}
	
	public int attackWithWeapon(){ //Hero's basic attack with weapon
		SecureRandom sr = new SecureRandom();
		int damage = w1.basicAttack();
		if(damage ==0){ //if the basic attack misses, return no damage to the bad guy
			return 0;
		}
		return (damage + 1+sr.nextInt(strength)); //returns the damage amount from weapon + a random number from 0 to the hero's strength
	}
	
	public int specialAttack(){ //Hero's special attack with weapon
		SecureRandom sr = new SecureRandom();
		int damage = w1.specialAttack();
		if(damage ==0){ //if the special attack misses, return no damage to the bad guy
			return 0;
		}
		return (damage + (1+sr.nextInt(strength)));//returns the damage amount from weapon + a random number to the hero's strength
	}

}