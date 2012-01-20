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
	
	/**
	 * Move this away from p1
	 * @param p1
	 * @param p2 
	 */
	public void move_point(ThomsonPoint p1, double distance_move) {

		double[] v1 = new double[3];

		// vector p1->p2
		v1 = Geometry.createVector(p1.point, this.point);

		double distance = Geometry.length(v1);
		double distance_koef = distance_move / distance;

		// strech vector
		v1[0] *= distance_koef;
		v1[1] *= distance_koef;
		v1[2] *= distance_koef;
		
		// add resulting vector to p1
		this.point[0] = p1.point[0] + v1[0];
		this.point[1] = p1.point[1] + v1[1];
		this.point[2] = p1.point[2] + v1[2];
		
		normalizeVector(this.point);
		
	}
}
