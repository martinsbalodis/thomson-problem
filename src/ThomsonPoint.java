/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import no.geosoft.cc.geometry.Geometry;

/**
 *
 * @author martins
 */
public class ThomsonPoint {

	/**
	 * Point coordinates
	 */
	double[] point = new double[3];
	
	/**
	 * point energy comparing to other points
	 */
	double energy;
	
	/**
	 * Puts point in a random place on sphere
	 */
	public void put_in_random_position() {
		
		// create point as a normalized vector
		this.point[0] = Math.random() - .5;
		this.point[1] = Math.random() - .5;
		this.point[2] = Math.random() - .5;
		this.point = normalizeVector(this.point);

		// @TODO check point colission

	}

	/**
	 * Calculate energy between two points
	 * @param point
	 * @return double
	 */
	public double get_energy(ThomsonPoint point) {

		return 1 / this.get_distance(point);
	}
	
	/**
	 * Calculate distance between two points
	 * @param point
	 * @return double
	 */
	public double get_distance(ThomsonPoint point) {
		
		return Geometry.length(this.point, point.point);
	}

	/**
	 * Normalize vector
	 * @param vector
	 * @return vector
	 */
	public static double[] normalizeVector(double[] vector) {

		double length = Geometry.length(vector);

		vector[0] /= length;
		vector[1] /= length;
		vector[2] /= length;

		return vector;
	}

	/**
	 * calculate point energy 
	 */
	public void calculate_energy(ThomsonPoint[] points) {

		this.energy = 0;
		for (ThomsonPoint p : points) {
			if (p != this) {
				this.energy += this.get_energy(p);
			}
		}
	}
}
