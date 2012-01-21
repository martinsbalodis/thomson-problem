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
		
		ThomsonSphere sphere = new ThomsonSphere(100);
		
		ThomsonPreview preview = new ThomsonPreview(sphere);
		
		double smallest_found_energy = -1;
		
		for(int i = 0;i<=100000;i++) {
			
			// Output current sphere energy
			double sphere_energy = sphere.get_energy();
			if(smallest_found_energy > sphere_energy || smallest_found_energy == -1) {
				smallest_found_energy = sphere_energy;
			}
			
			sphere.arrange_points();
			preview.repaint();
			
//			try {
//				//do what you want to do before sleeping
//				Thread.currentThread().sleep(100);//sleep for 1000 ms
//				//do what you want to do after sleeptig
//			} catch (Exception e) {
//				//If this thread was intrrupted by nother thread 
//			}

		}
		
		System.out.println("Smallest found energy " + smallest_found_energy);
	}
}
