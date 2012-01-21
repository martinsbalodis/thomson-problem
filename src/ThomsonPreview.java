/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author martins
 */
public class ThomsonPreview extends Canvas {

	ThomsonSphere sphere;
	JFrame frame = new JFrame();

	public ThomsonPreview(ThomsonSphere sphere) {

		this.sphere = sphere;

		this.frame.setSize(640, 480);

		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.frame.getContentPane().add(canvas);
		this.frame.setTitle("Thomson circle preview");
		this.frame.setVisible(true);
//		

	}
	
	/**
	 * Zīmē attēlu
	 * @param graphics 
	 */
	@Override
	public void paint(Graphics graphics) {
		
	}
	
}
