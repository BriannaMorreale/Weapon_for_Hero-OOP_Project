//Game play field class object
//At present this class object is for demonstration purposes only.
//It isn't used in the final product. 
//Brianna Morreale
//CS1410
//3-28-21

//1. Create a field represented by a 2 dimensional array to place objects in. Allow the 
//driver to select the size of the field.

import java.security.SecureRandom;

public class Field
{
	private int [][] field; 
	private int width; 
	private int height;
	
	public Field()
	{
		field = null;
	}
	
	public Field(int width, int height)
	{
		field = new int [width][height];
		this.width = width; 
		this.height = height;
		initializeField();
	}
	
	//Getters for field
	public int getWidth()
	{return width;}
	
	public int getHeight()
	{return height;}
	
	private void initializeField()
		{
			SecureRandom sr = new SecureRandom();
		
			for (int i = 0; i<width; i++)
				for (int j = 0; j<height; j++)
					{field[i][j] = sr.nextInt(9)+1;}
		}
}