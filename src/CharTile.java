import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;

import javax.swing.Icon;

import rlforj.ui.ascii.CharVisual;

/**
 * Class that represents a tile
 * @author Tatiana Braginets
 *
 */
public class CharTile extends CharVisual
{

	public CharTile(char disp, Color col) 
	{
		super(disp, col);
	}
	
	public static final int TILE_SIZE = 10;

}
