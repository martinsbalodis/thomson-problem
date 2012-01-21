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

		this.frame.setSize(480, 480);

		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.getContentPane().add(this);
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
		
		//System.out.println("repaint");
		
		// Redraw each point
		for (ThomsonPoint p : sphere.points) {

			if (p.point[2] > 0) 
			{
				graphics.drawRect((int) (p.point[0] * 200.0 + 220), (int) (p.point[1] * 200.0 + 220), 1, 1);
			}
		}
		graphics.drawOval(20, 20, 400, 400);
	}
	
}
