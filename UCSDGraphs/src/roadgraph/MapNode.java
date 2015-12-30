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
public class MapNode {
	private GeographicPoint vertex;
	private List<MapEdge> edges;

	/**
	 * 
	 */
	public MapNode(GeographicPoint location) {
		super();
		this.vertex = location;
		edges = new ArrayList<MapEdge>();
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
	public List<MapEdge> getEdges() {
		return edges;
	}

	/**
	 * @param edges
	 *            the edges to set
	 */
	public void setEdges(List<MapEdge> edges) {
		this.edges = edges;
	}

}
