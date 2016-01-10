/**
 * 
 */
package roadgraph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import geography.GeographicPoint;

/**
 * @author prajjwol
 *
 */
public class MapNode1 {
	private GeographicPoint vertex;
	private List<MapEdge1> edges;

	/**
	 * 
	 */
	public MapNode1(GeographicPoint location) {
		super();
		this.vertex = location;
		edges = new ArrayList<MapEdge1>();
	}

	/**
	 * @return the vertex
	 */
	public GeographicPoint getVertex() {
		return vertex;
	}

	/**
	 * @param vertex
	 *            the vertex to set
	 */
	public void setVertex(GeographicPoint vertex) {
		this.vertex = vertex;
	}

	/**
	 * @return the edges
	 */
	public List<MapEdge1> getEdges() {
		return edges;
	}

	/**
	 * @param edges
	 *            the edges to set
	 */
	public void setEdges(List<MapEdge1> edges) {
		this.edges = edges;
	}
	
	public List<GeographicPoint> getNeighbors(){
		List<GeographicPoint> neighbors= new ArrayList<GeographicPoint>();
		for (MapEdge1 edge : getEdges()) {
			neighbors.add(edge.getEnd());
		}
		return neighbors;
	}

}
