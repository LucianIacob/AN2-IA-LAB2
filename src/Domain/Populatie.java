package Domain;

import java.util.ArrayList;
import java.util.List;

import Main.*;

@SuppressWarnings("unused")
public class Populatie {

	int currentIndex = 0;
	private Individ[] listaIndivizi;

	public Populatie(int pop) {
		listaIndivizi = new Individ[pop];
	}

	public void addIndivid(Individ i) {
		listaIndivizi[currentIndex] = i;
		++currentIndex;
	}

	public Individ getIndivid(int index) {
		return listaIndivizi[index];
	}

	public int size() {
		return listaIndivizi.length;
	}

	public Individ[] getAllIndivizi() {
		return listaIndivizi;
	}

	public Individ getFittest() {
		int minFit = listaIndivizi[0].getFitness(), poz = 0;
		for (int i = 1; i < listaIndivizi.length; i++) {
			if (minFit > listaIndivizi[i].getFitness()) {
				minFit = listaIndivizi[i].getFitness();
				poz = i;
			}
		}
		return listaIndivizi[poz];
	}
}
