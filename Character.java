//Character class object. Inherits from Thing class
//Brianna Morreale
//CS1410
//3-28-21

abstract public class Character extends Thing
{
	protected int hitPoints; 
	protected int strength;
	
	protected enum STATUS {DEAD, ALIVE};
	protected STATUS status;

	
	public Character() //no argument constructor
	{
		hitPoints = 0;
		strength = 0;
	}

	public Character(String name, Field f1, int hitPoints, int strength) //all argument constructor
	{
		super(name);
		this.hitPoints = hitPoints; //Character's instances
		this.strength = strength;
		status = STATUS.ALIVE;
	}
	
	public Character(int hitPoints, int strength) //subclass variables constructors
	{
		this.hitPoints = hitPoints;
		this.strength = strength;
		status = STATUS.ALIVE;
	}
	
	public int getHitPoints() //getters
		{
		return hitPoints;
		}
	
	public int getStrength()
		{
		return strength;
		}
	
	public boolean isAlive() //Check to see if the character still alive
	{
		if (status==STATUS.DEAD){ 
		return false;
		}
		else {
			return true;
		}
	}
	
	public void destroyCharacter() //Destroy the character and move him off the grid. Not used in final product. 
	{
		x= -1;
		y= -1;
		status = STATUS.DEAD;
	}

	public void takeDamage(int damage){ //take damage to the character being attacked
		hitPoints -= damage;
		if(hitPoints <= 0){
			status = STATUS.DEAD;
		}
	}

}