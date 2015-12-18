package AE;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Domain.Cromozom;
import Domain.Edge;
import Domain.Graph;
import Domain.Individ;
import Domain.Populatie;
import Main.Loader;

@SuppressWarnings("unused")
public class AlgoritmEvolutiv implements LocalSearch {

	private Populatie initPop;
	private int nrGeneratii;
	private Loader loader;

	public AlgoritmEvolutiv(int marimeaPopulatiei, int nrMaxGeneratii, Loader loader) {
		this.loader = loader;
		nrGeneratii = nrMaxGeneratii;
		initPop = initializeazaPopulatie(marimeaPopulatiei);
	}

	public Individ solutie() {
		Populatie populatie = initPop;
		Individ individ = null;
		for (int i = 0; i < nrGeneratii; i++) {
			Populatie popNou = evolutie(populatie);
			individ = popNou.getFittest();
			populatie = popNou;
			if (individ.getFitness() == 0)
				return individ;
		}

		return individ;
	}

	private Populatie initializeazaPopulatie(int marime) {
		Populatie pop = new Populatie(marime);
		for (int i = 0; i < marime; i++) {
			Graph g1 = generateRandomG1();
			Individ individ = new Individ(new Cromozom(g1, generateRandomG2(g1)));
			pop.addIndivid(individ);
		}
		return pop;
	}

	public Populatie evolutie(Populatie pop) {
		Populatie populatie = new Populatie(pop.size());
		for (int i = 0; i < pop.size(); i++) {
			Individ parinte1, parinte2;
			parinte1 = selectParinte(pop);
			parinte2 = selectParinte(pop);
			Individ copil = crossOver(parinte1, parinte2);
			mutatie(copil);
			populatie.addIndivid(copil);
		}
		return populatie;
	}

	private Graph generateRandomG1() {
		List<Edge> newList = new ArrayList<Edge>();
		Random random = new Random();
		int lungime = random.nextInt(loader.edges.size());
		for (int i = 0; i < lungime; i++) {
			int pozitie = random.nextInt(lungime);
			if (!newList.contains(loader.edges.get(pozitie))) {
				newList.add(loader.edges.get(pozitie));
			}
		}
		return new Graph(loader.nodes.size(), newList, loader.edges);
	}

	private Graph generateRandomG2(Graph g1) {
		int ok = 0;
		List<Edge> secondEdges = new ArrayList<Edge>();
		for (Edge ed : g1.allEdges) {
			ok = 0;
			for (Edge e : g1.edges)
				if (ed.toString().compareTo(e.toString()) == 0)
					ok = 1;
			if (ok == 0)
				secondEdges.add(ed);
		}
		return new Graph(loader.nodes.size(), secondEdges, g1.allEdges);
	}

	public Individ selectParinte(Populatie pop) {
		Random rand = new Random();
		int index = rand.nextInt(pop.getAllIndivizi().length);
		return pop.getIndivid(index);
	}

	public Individ crossOver(Individ parinte1, Individ parinte2) {

		Random rand = new Random();
		Cromozom cromozom = new Cromozom(parinte1.getCromozom().getGraf1(), parinte2.getCromozom().getGraf2());

		Individ copil1 = new Individ(cromozom);
		Individ copil2 = new Individ(cromozom);
		int index1 = rand.nextInt(parinte1.getCromozom().getGraf1().lungime);
		int index2 = rand.nextInt(parinte1.getCromozom().getGraf1().lungime);

		int mijloc = (parinte1.getCromozom().getGraf1().lungime * parinte1.getCromozom().getGraf1().lungime) / 2;

		int l = 0;
		for (int i = 0; i < parinte1.getCromozom().getGraf1().lungime; i++) {
			for (int j = 0; j < parinte1.getCromozom().getGraf1().lungime; j++) {
				if (l < mijloc) {
					copil1.getCromozom().setGraf1(parinte1.getCromozom().getGraf2());
					copil2.getCromozom().setGraf2(parinte2.getCromozom().getGraf2());
				} else {
					copil1.getCromozom().setGraf1(parinte2.getCromozom().getGraf2());
					copil2.getCromozom().setGraf2(parinte1.getCromozom().getGraf1());
				}
				l++;
			}
		}
		return new Individ(parinte1.getCromozom());
	}

	public void mutatie(Individ individ) {
		Random random = new Random();
		int number = random.nextInt(2);
		switch (number) {
		case 0:
			if (individ.getCromozom().getGraf1().edges.size() != 0) {
				int poz = random.nextInt(individ.getCromozom().getGraf1().edges.size());
				individ.getCromozom().getGraf2().addEdge(individ.getCromozom().getGraf1().edges.get(poz));
				individ.getCromozom().getGraf1().edges.remove(poz);
				break;
			}
		case 1:
			if (individ.getCromozom().getGraf2().edges.size() != 0) {
				int poz2 = random.nextInt(individ.getCromozom().getGraf2().edges.size());
				individ.getCromozom().getGraf1().addEdge(individ.getCromozom().getGraf2().edges.get(poz2));
				individ.getCromozom().getGraf2().edges.remove(poz2);
				break;
			}
		}
	}

	public Individ solutie(int nr) {
		return null;
	}
}
