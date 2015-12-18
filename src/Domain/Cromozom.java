package Domain;

public class Cromozom {

	private Graph graf1, graf2;

	public Cromozom() {
	}

	public Cromozom(Graph g1, Graph g2) {
		graf1 = g1;
		graf2 = g2;
	}

	public Graph getGraf1() {
		return graf1;
	}

	public void setGraf1(Graph graf1) {
		this.graf1 = graf1;
	}

	public Graph getGraf2() {
		return graf2;
	}

	public void setGraf2(Graph graf2) {
		this.graf2 = graf2;
	}

	@Override
	public String toString() {
		return "Partitionarea 1: " + graf1 + "\n\nPartitionarea 2: " + graf2;
	}
}
