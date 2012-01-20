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
			
			this.points[i] = new ThomsonPoint();
			this.points[i].put_in_random_position();
			
		}
		
	}
	
	/**
	 * Update point energy
	 */
	private void update_point_energy() {
		
		for(ThomsonPoint p : this.points) {
			p.calculate_energy(this.points);
		}
		
	}
	
	/**
	 * Returns point with maximum energy
	 * @return ThomsonPoint
	 */
	public ThomsonPoint get_maximum_energy_point() {

		ThomsonPoint maximum_energy_point = points[0];

		for (ThomsonPoint p : this.points) {
			if (p.energy > maximum_energy_point.energy) {
				maximum_energy_point = p;
			}
		}

		return maximum_energy_point;
	}
	
	/**
	 * Find point closest points and put them in array. Closest point is array[0]
	 * @param points
	 * @param point 
	 */
	public void find_closest_points(ThomsonPoint points[], ThomsonPoint point) {

		double min_distance = 2;
		// Find first closest points
		for (int i = 0; i < this.points.length; i++) {

			if (point != this.points[i]) {

				// point is closer than previous one
				// @TODO here I might want to take <
				if (point.get_distance(this.points[i]) <= min_distance) {

					// Move previous points up in the array
					for (int j = points.length-2; j >= 0; j--) {
						
						if(points[j] != null) {
							points[j+1] = points[j];
						}
					}
					
					// Add this point to the array
					points[0] = this.points[i];
				}
			}
		}
	}
	
	/**
	 * Arrange to their correct places
	 */
	public void arrange_points() {
		
		// update point energy
		this.update_point_energy();
		
		// Find point with maximum energy
		ThomsonPoint maximum_energy_point = this.get_maximum_energy_point();
		
		// Find closest, second closest neighbour
		ThomsonPoint[] max_energy_points = new ThomsonPoint[2];
		this.find_closest_points(max_energy_points, maximum_energy_point);
		
		// Move p0 away as far as p1 goes. in direction max_e_p->p0
		
	}
}
