/**
 * 
 */
package roadgraph;

import geography.GeographicPoint;

/**
 * @author prajjwol
 *
 */
public class MapEdge1 {
	private GeographicPoint start;
	private GeographicPoint end;
	private String roadName;
	private String roadType;
	private double length;

	/**
	 * @param start
	 * @param end
	 * @param roadName
	 * @param roadType
	 * @param length
	 */
	public MapEdge1(GeographicPoint start, GeographicPoint end, String roadName, String roadType, double length) {
		super();
		this.start = start;
		this.end = end;
		this.roadName = roadName;
		this.roadType = roadType;
		this.length = length;
	}

	/**
	 * @return the start
	 */
	public GeographicPoint getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(GeographicPoint start) {
		this.start = start;
	}

	/**
	 * @return the end
	 */
	public GeographicPoint getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(GeographicPoint end) {
		this.end = end;
	}

	/**
	 * @return the roadName
	 */
	public String getRoadName() {
		return roadName;
	}

	/**
	 * @param roadName the roadName to set
	 */
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	/**
	 * @return the roadType
	 */
	public String getRoadType() {
		return roadType;
	}

	/**
	 * @param roadType the roadType to set
	 */
	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}
	
	

}
