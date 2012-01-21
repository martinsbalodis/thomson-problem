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
		
		ThomsonSphere sphere = new ThomsonSphere(3);
		
		ThomsonPreview preview = new ThomsonPreview(sphere);
		
		for(int i = 0;i<=100;i++) {
			
			// Output current sphere energy
			System.out.println(sphere.get_energy());
			
			
			sphere.arrange_points();
			preview.repaint();
			
			try {
				//do what you want to do before sleeping
				Thread.currentThread().sleep(10);//sleep for 1000 ms
				//do what you want to do after sleeptig
			} catch (Exception e) {
				//If this thread was intrrupted by nother thread 
			}

		}
	}
}
