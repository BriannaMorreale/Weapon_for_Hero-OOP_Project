/* Weapon Class that extends Thing
Brianna Morreale
CS1410
3-28-21
*/
import java.security.SecureRandom;
 public class Weapon extends Thing{

	protected int strength;
	protected int durability;

	public Weapon(){ //no argument constructor
		strength = 10;
		durability = 10;
	}

	public Weapon(int strength, int durability){ //all argument constructor
		this.strength = strength;
		this.durability = durability;
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
	
	public int basicAttack(){ //Weapon's basic attack
		SecureRandom sr = new SecureRandom();
		if(durability >0){ //checks durability
		durability = (durability - (1+sr.nextInt(strength))); //takes away a random number from 0- weapon's strength
		}
		if(durability <= 0){ //if durability is at or below 0, change strength to 0 and return no damage to the bad guy
			strength = 0;
			return 0;
		}
		return durability;
	}

	 public int specialAttack(){ //Wepon's special attack. This never gets used because every child overrides it
	 return durability;  //still needed it for the driver however
	 }
	 
}