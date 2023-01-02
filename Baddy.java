//Bad Guy's Class. Inherits from Character
//Brianna Morreale 
//CS1410
//3-28-21

import java.security.SecureRandom;

public class Baddy extends Character
{

	public Baddy() //no argument constructor
	{
		super();  //inherits from parent constructor
	}
	
	public Baddy(String name, Field f1, int hitPoints, int strength) //all argument constructor
	{
	SecureRandom sr = new SecureRandom();
	
	this.name = name;
	while (x==0 & y==0) //place him randomly on the map, but not at 0,0
		{
		x = sr.nextInt(f1.getWidth()); 
		y = sr.nextInt(f1.getHeight());
		}

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
	}
	
	public int gethitPoints(){ //getter for bad guy's hitPoints
		return hitPoints;
	}
}