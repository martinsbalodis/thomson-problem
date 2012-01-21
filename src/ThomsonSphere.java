/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author martins
 */
public class ThomsonSphere {

	public ThomsonPoint[] points;
	
	/**
	 * Point energies
	 */
	public double[][] energies;

	/**
	 * initialize points
	 * @param points 
	 */
	public ThomsonSphere(int point_count) {

		this.points = new ThomsonPoint[point_count];
		
		this.energies = new double[point_count][point_count];
		
		// create points
		for (int i = 0; i < point_count; i++) {
			
			this.points[i] = new ThomsonPoint();
			this.points[i].put_in_random_position();
			
		}
		
		// calculate energy between points for the first time
		calculate_point_energy();
	}
	
	/**
	 * recalculate energy between points
	 */
	public void calculate_point_energy() {
		
		for (int i = 0; i < this.points.length; i++) {
			for (int j = i + 1; j < this.points.length; j++) {
				double energy = this.points[i].get_energy(this.points[j]);
				
				this.energies[i][j] = energy;
				this.energies[j][i] = energy;
			}
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
	 * Calculate spheres energy
	 * @return double
	 */
	public double get_energy() {

		double energy = 0;

		for (int i = 0; i < this.points.length; i++) {

			for (int j = i + 1; j < this.points.length; j++) {
				energy += this.points[i].get_energy(this.points[j]);
			}
		}

		return energy;

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
		
//		if(points.length != 2) {
//			throw new Exception("Sorry. this method is can only retur two closest points");
//		}
		
		// Load n points in response array so always points will get returned
		int loaded_points = 0;
		for (int i = 0; i < this.points.length; i++) {
			if (point != this.points[i]) {
				points[loaded_points] = this.points[i];
				loaded_points++;
				if(loaded_points == points.length) {
					break;
				}
			}
		}
		
		double d1 = point.get_distance(points[0]);
		double d2 = point.get_distance(points[1]);
		if (d2 < d1) {
			ThomsonPoint swap = points[0];
			points[0] = points[1];
			points[1] = swap;
		}
		
		double min_distance = 2;
		// Find first closest points
		for (int i = 1; i < this.points.length; i++) {

			if (point != this.points[i]) {

				// point is closer than previous one
				double distance_between = point.get_distance(this.points[i]);
				// @TODO here I might want to take <
				if (distance_between < min_distance) {

					min_distance = distance_between;
					
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
		double distance_move = max_energy_points[1].get_distance(maximum_energy_point);
		max_energy_points[0].move_point(maximum_energy_point, distance_move);

	}
}
