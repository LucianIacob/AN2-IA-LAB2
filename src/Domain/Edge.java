package Domain;

public class Edge {

	private String source;
	private String destination;

	public Edge(String p1, String p2) {
		this.source = p1;
		this.destination = p2;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;

		if (other.source.compareTo(source) == 0 && other.destination.compareTo(destination) == 0
				|| other.destination.compareTo(source) == 0 && other.source.compareTo(destination) == 0)
			return true;

		return false;
	}

	@Override
	public String toString() {
		return "\nEdge [source=" + source + ", destination=" + destination + "]";
	}

}