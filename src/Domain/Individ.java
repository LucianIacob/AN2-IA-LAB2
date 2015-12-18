package Domain;

public class Individ {

	private Cromozom cromozom;

	public Individ(Cromozom c) {
		cromozom = c;
	}

	public Individ() {
		// TODO Auto-generated constructor stub
	}

	public Cromozom getCromozom() {
		return cromozom;
	}

	public void setCromozom(Cromozom cromozom) {
		this.cromozom = cromozom;
	}

	public int getFitness() {
		return cromozom.getGraf1().fitness();
	}

	@Override
	public String toString() {
		return cromozom + "";
	}
}
