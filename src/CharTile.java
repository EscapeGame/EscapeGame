import java.awt.Color;

import rlforj.ui.ascii.CharVisual;


public class CharTile extends CharVisual implements Tile
{

	public CharTile(char disp, Color col) 
	{
		super(disp, col);
	}

	public void display() 
	{
		System.out.print(this.darker());	
	}

}
