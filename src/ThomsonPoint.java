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
	
	double[] point;
	
	/**
	 * Puts point in a random place on sphere
	 * @param sphere 
	 */
	public void put_in_random_position(ThomsonSphere sphere) {
		
		double[] point1 = {0,0,0};
		double[] point2 = {0,0,1};
		
		this.point = Geometry.createVector(point1, point2);
		
		
		
		// @TODO check point colission
		
	}
	
	/**
	 * Calculate energy between two points
	 * @param vector
	 * @return 
	 */
	public double get_energy(double[] vector) {
		
		double distance = Geometry.length(this.point, vector);
		
		return 1/distance;
	}
	
}
