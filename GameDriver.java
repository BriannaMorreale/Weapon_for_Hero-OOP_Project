//Game driver for testing inheritance demonstration files
//Brianna Morreale
//CS1410
//3-28-21

import java.security.SecureRandom;
import java.util.Scanner; //imported scanner to get answer from user

public class GameDriver
{
	public static void main(String [] args)
	{
		Scanner scn = new Scanner(System.in);
		Field f1 = new Field(); //Field was created but not used. It was for class demo. 
		
		Hero h1 = new Hero("Hero/Player 1", f1, 175, 20, 5); //creating the items needed for the battle
		Baddy bg1 = new Baddy("Generic Goblin 1", f1, 150, 30);
		BowandArrow b1 = new BowandArrow(25, 60); //25 = strength, 60 = durability
		ForkOfDeath fd1 = new ForkOfDeath(85, 35); //85 = strength, 35 = durability
		JerryTheFrog j1 = new JerryTheFrog(50, 150); //50 = strength, 150 = durability
		
		System.out.println(); //Introducing the player to the game
		System.out.println("Welcome to the fight to the death! Your goal will be to kill the mighty goblin and win the battle!");
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		try{Thread.sleep(2000);} //slowing down the output
		catch(InterruptedException e){System.out.print(e);}
		System.out.println("Here are your stats:"); //showing player's items and stats
		System.out.println("Your strength: "+h1.getStrength());
		System.out.println("Your hitpoints: "+h1.gethitPoints());
		System.out.println("Your manna: "+h1.getManna());
		System.out.println();
		
		try{Thread.sleep(2000);}
		catch(InterruptedException e){System.out.print(e);}
		System.out.println("Here are the mighty goblin's stats:"); //showing the bad guy's stats
		System.out.println("Strength: "+bg1.getStrength());
		System.out.println("Hitpoints: "+bg1.gethitPoints());
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		try{Thread.sleep(2000);}
		catch(InterruptedException e){System.out.print(e);}
		System.out.println("To begin, you must choose a weapon:"); //showcases weapon's items and list
		System.out.println();
		
		System.out.println("Weapon 1: Bow and Arrow. Bow and Arrow has a strength of "+b1.getStrength()+" and durability of "+b1.getDurability());
		System.out.println("For it's basic attack, there is a chance of missing your opponent (how embarrassing).");
		System.out.println("It's super attack has a smaller chance of missing but will take away more durability.");
		System.out.println();
		
		try{Thread.sleep(6000);}
		catch(InterruptedException e){System.out.print(e);}
		System.out.println("Weapon 2: Fork of Death. This shiny piece of silverware has a strength of "+fd1.getStrength()+" and durability of "+fd1.getDurability());
		System.out.println("It's basic attack is... basic with a simple stab.");
		System.out.println("It's special attack not only increases the strength of the mighty fork...");
		System.out.println("but it will also have a greater inpact on your durability. (It is a fork if you remember.)");
		System.out.println();
	
		try{Thread.sleep(6000);}
		catch(InterruptedException e){System.out.print(e);}
		System.out.println("Weapon 3: ~Jerry the Frog~. This aquatic wizard frog has a strength of "+j1.getStrength()+" and a durability of "+j1.getDurability());
		System.out.println("For it's basic attack, Jerry will simply use his good looks to attack the opponent. (He is a charmer.)");
		System.out.println("His special attack however, inscreases his own strength by 50 but takes two times the damage to himself...");
		System.out.println("WARNING: The special attack hurts you!");
		System.out.println();
		
		int selection;
		do{
		try{Thread.sleep(2000);}
		catch(InterruptedException e){System.out.print(e);}
		System.out.println("It is time to select a weapon! Which will you pick: 1, 2 or 3");
		selection = scn.nextInt(); //takes the user's input
		
		
		switch(selection){
			case 1: h1.equip(b1); //hero equips the bow and arrow
					System.out.println("Bow and Arrow Equipped!"); //if they select 1, they will get Bow and Arrow
			break;
			case 2: h1.equip(fd1); //hero equips the fork of death
			System.out.println("Fork of Death Equipped!"); //if they select 2, they will get the Fork of Death
			break;
			case 3: h1.equip(j1); //hero equips jerry the Frog
					j1.equip(h1); //Jerry the Frog equips the hero's stats and the hero himself
				System.out.println("Jerry the Frog Equipped!"); //if they select 3, they will get Jerry the Frog
			break;
			default: System.out.println("That is not a valid weapon selection!");
		} //if the answer is not 1,2, or 3, an invalid message appears and makes then try to select again
		}while(selection>3);
		
		System.out.println();
		try{Thread.sleep(1000);}
		catch(InterruptedException e){System.out.print(e);}
		fight(h1, bg1); //starts the battle loop
	}
	
	public static void fight(Hero h1, Baddy bg1)
	{
		SecureRandom sr = new SecureRandom();
		Scanner scn = new Scanner(System.in);

		int answer;
		int answer2;
		System.out.println("The battle begins!");
		while (h1.isAlive() && bg1.isAlive()) //loops until one player has died
		{
			if(h1.w1.getDurability() <= 0){ //If their weapon's durability is 0, their only option becomes....
				System.out.println();       //fighting without a weapon and it will loop until death of one person.
				try{Thread.sleep(1000);} //slows down the output
				catch(InterruptedException e){System.out.print(e);}
				System.out.println("Your weapon is destroyed! Press 1 to fight without a weapon!");
				answer2 = scn.nextInt();
				if(answer2 ==1){
				bg1.takeDamage(h1.attack());
				try{Thread.sleep(1000);}
				catch(InterruptedException e){System.out.print(e);}
				System.out.println();
				System.out.println("The goblin is greatly wounded with "+bg1.gethitPoints()+" hit points.");
				System.out.println("Status:");
				System.out.println("Your hitpoints: "+h1.gethitPoints());
				System.out.println("Your strength: "+h1.getStrength());
				}
				if(answer2 != 1){ //if they type the wrong input in, they get punished by their turn being skipped
					System.out.println("Incorrect input. Your turn is skipped.");
				}
			}
			
			if(h1.w1.getDurability() > 0){
			System.out.println();//list to select what type of attack method they would like
			System.out.println("Press 1 for attacking without a weapon...");
			System.out.println("Press 2 for attacking with your selected weapon...");
			System.out.println("Press 3 for a special attack with your weapon!");
			answer = scn.nextInt();
			if(answer ==1){
				bg1.takeDamage(h1.attack());
				System.out.println();
				try{Thread.sleep(1000);} //if they answer 1, they fight without a weapon 
				catch(InterruptedException e){System.out.print(e);}
				System.out.println("You attack bare handed! The goblin is now badly injured with "+bg1.gethitPoints()+" hit points.");
				System.out.println("Status:"); //showcases hero's stats
				System.out.println("Your hitpoints: "+h1.gethitPoints());
				System.out.println("Weapon's durability: "+h1.w1.getDurability());
				System.out.println("Weapon's strength: "+h1.w1.getStrength());
			}
			if(answer == 2){
				bg1.takeDamage(h1.attackWithWeapon());
				System.out.println();
				try{Thread.sleep(1000);} //if they choose 2, they use the basic attack method
				catch(InterruptedException e){System.out.print(e);}
				System.out.println("Your attack with your weapon results: The goblin's has "+bg1.gethitPoints()+" hit points.");
				System.out.println("Status:");//showcases hero's stats
				System.out.println("Your hitpoints: "+h1.gethitPoints());
				System.out.println("Weapon's durability: "+h1.w1.getDurability());
				System.out.println("Weapon's strength: "+h1.w1.getStrength());
			}
			if(answer ==3 ){
	
				bg1.takeDamage(h1.specialAttack());
				//bg1.takeDamage(h1.w1.specialAttack());
				System.out.println();
				try{Thread.sleep(1000);}//if they select 2, they use the special attack method
				catch(InterruptedException e){System.out.print(e);}
				System.out.println("Your attack with your intense special attack results: The goblin now has "+bg1.gethitPoints()+" hit points.");
				System.out.println("Status:");//showcases hero's stats
				System.out.println("Your hitpoints: "+h1.gethitPoints());
				System.out.println("Weapon's durability: "+h1.w1.getDurability());
				System.out.println("Weapon's strength: "+h1.w1.getStrength());
			}
			if(answer > 3 || answer <1){ //if they don't select 1,2, or 3, their turn gets skipped
				System.out.println("You did not answer the right number. As punishment, your turn gets skipped.");
			}
			}
			if(h1.isAlive() == false || bg1.isAlive() == false){ //checks to see their status after hero's turn
				break;
			}
			
			try{Thread.sleep(3000);}
			catch(InterruptedException e){System.out.print(e);} //slows down the output
			System.out.println();  
			System.out.println("The goblin attacks you!"); //After hero attacks, the goblin attacks the hero
			h1.takeDamage(sr.nextInt(bg1.getStrength()));
			System.out.println("Status:"); //showcases Goblin's (bad guy's) stats
				System.out.println("Your hitpoints: "+h1.gethitPoints());
				System.out.println("Weapon's durability: "+h1.w1.getDurability());
				System.out.println("Weapon's strength: "+h1.w1.getStrength());
			
			if(h1.isAlive() == false || bg1.isAlive() == false){ //checks to see their status after goblin's turn
				break;
			}
			
		}
		
		if(h1.isAlive() == true && bg1.isAlive() == false) //show the outcome of the battle
			{
				System.out.println();
				System.out.println("You have defeated the mighty goblin! Congrats!");
				System.out.println();
			}
			else{
				System.out.println();
				System.out.println("The goblin has defeated you! R.I.P.");
				System.out.println();
			}
	} 
}
