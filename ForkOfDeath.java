/*Fork of Death Weapon class that is a subclass of Weapon
Brianna Morreale
CS1410
3-28-21
*/

import java.security.SecureRandom;
//Melee Weapon
public class ForkOfDeath extends Weapon{
	
	public ForkOfDeath(){ //no argument constructor
		super();
	}
	
	public ForkOfDeath(int durability, int strength){ //all argument constructor
		super(strength, durability);
		this.strength = strength;
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
	
	public int basicAttack(){ //Fork of Death's Basic Attack
		super.basicAttack(); //inherits the basic attack from Weapon class
		try{Thread.sleep(1000);} //slows the output down
		catch(InterruptedException e){System.out.print(e);}
		System.out.println("You have gracefully stabbed the goblin with your Fork of Death!");
		return durability;
	}
	
	public int specialAttack(){// Fork of Death's Special Attack
		SecureRandom sr = new SecureRandom();
	
		if(durability > 0){ //check's durability status
			strength = (strength +10); //increases the strength by 10
			try{Thread.sleep(1000);}//slows the output down
			catch(InterruptedException e){System.out.print(e);}
			System.out.println("Fork of Death's strength increased to: "+strength); //shows new strength
			try{Thread.sleep(1000);} //slows the output down
			catch(InterruptedException e){System.out.print(e);}
			System.out.println("You stab the goblin with great strength!");
			durability = (durability - (10+(1+sr.nextInt(strength))));
		}//subtracts a random number from 0- weapon's strength +10 to take more damage to the weapon
		if(durability <=0){ //if durability is at or below 0, change strength to 0 and return no damage to the bad guy
			strength = 0;
			return 0; 
		}
		return durability;
	}
}
