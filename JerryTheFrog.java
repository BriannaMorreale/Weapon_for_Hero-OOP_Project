/*Jerry the Frog class that is a subclass of Weapon class
Brianna Morreale
CS1410
3-28-21
*/

import java.security.SecureRandom;
//Magic Weapon
public class JerryTheFrog extends Weapon{
	
	Hero h1 = new Hero(); //allows Jerry the Frog to interact with the hero
	
	public JerryTheFrog(){ //no arugment constructor
		super();
	}
	
	public JerryTheFrog(int strength, int durability){ //all argument constructor
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

	public void equip(Hero h1){ //allows the weapon to equp the hero and their stats
		this.h1 = h1;
	}
	
	public int basicAttack(){ //Jerry the Frog's basic attack
		super.basicAttack(); //inherits the basic attack from the parent
		System.out.println("Jerry the Frog has charmed the goblin with his great looks!");
		return durability;
	}
	
	public int specialAttack(){ //Jerry the Frog's special attack
		SecureRandom sr = new SecureRandom();
		
		if(h1.getManna() <=0){ //if the hero's manna is 0 or below, it returns nothing
			System.out.println("Your manna: "+h1.manna);
			System.out.println("You are out of manna! Jerry the Frog is tired and the attack fails.");
			return 0;
		}
		
		if(h1.getManna() > 0){ //checks manna status
		if(durability >0){     //checks weapon's durability status
			strength = (strength +50); //increases weapon's strength
			System.out.println();
			try{Thread.sleep(1000);}
			catch(InterruptedException e){System.out.print(e);} //slows the output
			System.out.println("Increasing Jerry the Frog's strength to: "+strength);
			try{Thread.sleep(1000);}
			catch(InterruptedException e){System.out.print(e);}
			System.out.println("Jerry the Frog licks the goblin aggressively, taking damage to himself and to you!");
			h1.hitPoints = (h1.hitPoints -h1.manna); //takes away hero's health points by using the manna
			h1.manna--; //reduces manna
			System.out.println("Your new manna: "+h1.manna);
			durability = (durability - (2*(1+sr.nextInt(strength)))); //takes away a random number times 2 from the durability
			try{Thread.sleep(1000);}
			catch(InterruptedException e){System.out.print(e);}
		}
		if(durability <=0){ //if durability is at or below 0, change strength to 0 and return no damage to the bad guy
			strength = 0;
			return 0;
			}
		}
		
		return durability;
	}
}