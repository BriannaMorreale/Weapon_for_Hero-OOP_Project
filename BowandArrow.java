/*Bow and Arrow Class that extends Weapon
Brianna Morreale
CS1410
3-28-21
*/
import java.security.SecureRandom;
//Range Weapon
public class BowandArrow extends Weapon{
	
	public BowandArrow(){ //no arugment constructor
		super();
	}
	
	public BowandArrow(int strength, int durability){ //all argument constructor
		super(strength, durability);
	}
	
	public void setStrength(int strength){ //setters and getters
		this.strength = strength;
	}

	public int getStrength(){
		return strength;
		}

	public void setDurability(int durability){
		this.durability = durability;
	}

	public int getDurability(){
		return durability;
	}
	
	public int basicAttack(){ //Bow and Arrow's basic attack
		SecureRandom sr = new SecureRandom();
		int chanceOfMissing = sr.nextInt(11); //generates a number between 0-10
		
		if(durability >0){ //check's durability status
		if(chanceOfMissing <= 5){ //if the random number is smaller than 6, it will use the basic attack from parent
		super.basicAttack();
		System.out.println("You have successfully shot your arrow through the goblin!");
		return durability;
		}
		if(chanceOfMissing > 6){ //if the random number generated is greater than 6, it will miss
			System.out.println("You missed! (What a bad shot.)");
			return 0; //returns nothing
		}
		}
		if(durability <= 0){ //if durability is at or below 0, change strength to 0 and return no damage to the bad guy
			strength = 0;
			return 0;
		}
		return durability;
	}
	
	public int specialAttack(){ //Bow and Arrow's Special Attack
		SecureRandom sr = new SecureRandom();
		int chanceOfMissing = sr.nextInt(11); //generates a number between 0-10
		
		if(durability >0){ //check's durability status
			if(chanceOfMissing > 2){ //if random number is bigger than 2, the weapon hit
			durability = (durability - (4+(1+sr.nextInt(strength)))); //takes away 4+ the random strength number from the durability
			System.out.println("Your bow, now more special, has successfully shot the goblin!");
			}
			if(chanceOfMissing <=2 ){//smaller chance of missing, but if the random number is smaller than 3, it missed
				System.out.println("You missed your powerful shot! (Work on your aim.)");
				return 0; //returns nothing
			}
		}
		if(durability <= 0){ //if durability is at or below 0, change strength to 0 and return no damage to the bad guy
			strength = 0;
			return 0;
		}
		return durability;
	}
}