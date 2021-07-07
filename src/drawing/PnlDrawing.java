package drawing;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import geometry.Shape;
import geometry.SurfaceShape;

@SuppressWarnings("serial")
public class PnlDrawing extends JPanel 
{
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	
	public PnlDrawing() 
	{
		
	}
	
	
	
	public void paint (Graphics g)
	{
		super.paint(g);
		Iterator<Shape> it = shapes.iterator();
		while(it.hasNext()){
			Shape newShape = it.next();
			if(newShape instanceof SurfaceShape){
				
				((SurfaceShape) newShape).fill(g);
			}
			newShape.draw(g);
		}
	}

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

}
