package edu.towson.cis.cosc603.project4.rectangle;

/**
 * The Point Class.
 */
public class Point {
	
	/** x and y coordinates. */
	double x, y; 
	
	/**
	 * Instantiates a new point.
	 *
	 * @param x the x
	 * @param y the y
	 */
	Point(Double x, Double y) {
		this.x = x; // Here it is!!!! It was y
		this.y = y;
	}
}
