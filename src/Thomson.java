/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martins
 */
public class Thomson {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
		ThomsonSphere sphere = new ThomsonSphere(20);
		
		ThomsonPreview preview = new ThomsonPreview(sphere);
		
		for(int i = 0;i<=10000;i++) {
		
			sphere.arrange_points();
			preview.repaint();
			
			try {
				//do what you want to do before sleeping
				Thread.currentThread().sleep(1);//sleep for 1000 ms
				//do what you want to do after sleeptig
			} catch (Exception e) {
				//If this thread was intrrupted by nother thread 
			}

		}
	}
}
