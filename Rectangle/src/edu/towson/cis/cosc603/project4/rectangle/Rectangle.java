package edu.towson.cis.cosc603.project4.rectangle;

// TODO: Auto-generated Javadoc
/**
 * The Class Rectangle.
 */
public class Rectangle {
	
	/** The p2. */
	private Point p1, p2; 
	
	/** The x axis length. */
	private double xAxisLength;
	
	/** The y axis width. */
	private double yAxisWidth;
	
	
	/**
	 * Instantiates a new rectangle, setting the length and width
	 *
	 * @param p1 the p1
	 * @param p2 the p2
	 */
	Rectangle(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
		
		xAxisLength = Math.abs(p2.x - p1.x);
		
		yAxisWidth = Math.abs(p2.y - p1.y);
	}
	
	/**
	 * Gets the area.
	 *
	 * @return the area
	 */
	public Double getArea() {	
		return xAxisLength * yAxisWidth;
	}
	
	/**
	 * Gets the diagonal.
	 *
	 * @return the diagonal
	 */
	public Double getDiagonal() {
		double valueToBeSquared = Math.pow((xAxisLength), 2) + Math.pow((yAxisWidth), 2);
		return Math.sqrt(valueToBeSquared);
	}
}
