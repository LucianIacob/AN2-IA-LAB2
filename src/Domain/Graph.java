package Domain;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	public int lungime;
	public List<Edge> edges;
	public List<Edge> allEdges;

	public Graph(int l, List<Edge> ed, List<Edge> allEd) {
		this.lungime = l;
		this.edges = ed;
		this.allEdges = allEd;
	}

	public void addEdge(Edge e) {
		if (!edges.contains(e)) {
			edges.add(e);
		}
	}

	public int fitness() {
		int fitness = 0, i, j, k, nr;
		for (i = 1; i <= lungime - 2; i++)
			for (j = i + 1; j <= lungime - 1; j++)
				for (k = j + 1; k <= lungime; k++) {
					nr = 0;
					for (Edge ed : edges) {
						if (ed.getSource().compareTo(Integer.toString(i)) == 0
								&& ed.getDestination().compareTo(Integer.toString(j)) == 0
								|| ed.getDestination().compareTo(Integer.toString(i)) == 0
								&& ed.getSource().compareTo(Integer.toString(j)) == 0)
							nr++;
						if (ed.getSource().compareTo(Integer.toString(j)) == 0
								&& ed.getDestination().compareTo(Integer.toString(k)) == 0
								|| ed.getDestination().compareTo(Integer.toString(j)) == 0
								&& ed.getSource().compareTo(Integer.toString(k)) == 0)
							nr++;
						if (ed.getSource().compareTo(Integer.toString(i)) == 0
								&& ed.getDestination().compareTo(Integer.toString(k)) == 0
								|| ed.getDestination().compareTo(Integer.toString(i)) == 0
								&& ed.getSource().compareTo(Integer.toString(k)) == 0)
							nr++;
					}
					if (nr == 3)
						fitness++;
				}

		int ok = 0;
		List<Edge> secondEdges = new ArrayList<Edge>();
		for (Edge ed : allEdges) {
			ok = 0;
			for (Edge e : edges)
				if (ed.toString().compareTo(e.toString()) == 0)
					ok = 1;
			if (ok == 0)
				secondEdges.add(ed);
		}

		for (i = 1; i <= lungime - 2; i++)
			for (j = i + 1; j <= lungime - 1; j++)
				for (k = j + 1; k <= lungime; k++) {
					nr = 0;
					for (Edge ed : secondEdges) {
						if (ed.getSource().compareTo(Integer.toString(i)) == 0
								&& ed.getDestination().compareTo(Integer.toString(j)) == 0
								|| ed.getDestination().compareTo(Integer.toString(i)) == 0
								&& ed.getSource().compareTo(Integer.toString(j)) == 0)
							nr++;
						if (ed.getSource().compareTo(Integer.toString(j)) == 0
								&& ed.getDestination().compareTo(Integer.toString(k)) == 0
								|| ed.getDestination().compareTo(Integer.toString(j)) == 0
								&& ed.getSource().compareTo(Integer.toString(k)) == 0)
							nr++;
						if (ed.getSource().compareTo(Integer.toString(i)) == 0
								&& ed.getDestination().compareTo(Integer.toString(k)) == 0
								|| ed.getDestination().compareTo(Integer.toString(i)) == 0
								&& ed.getSource().compareTo(Integer.toString(k)) == 0)
							nr++;
					}
					if (nr == 3)
						fitness++;
				}

		return fitness;
	}

	@Override
	public String toString() {
		return "numar de noduri = " + lungime + "\n" + edges;
	}
}
