/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martins
 */
public class ThomsonSphere {

	public ThomsonPoint[] points;

	/**
	 * initialize points
	 * @param points 
	 */
	public ThomsonSphere(int point_count) {

		this.points = new ThomsonPoint[point_count];

		// create points
		for (int i = 0; i < point_count; i++) {
			
			ThomsonPoint point = this.points[i];
			point.put_in_random_position(this);
			
		}
		
	}
}
