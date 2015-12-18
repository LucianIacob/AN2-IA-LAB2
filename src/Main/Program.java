package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import AE.AlgoritmEvolutiv;
import Domain.Individ;

public class Program {

	public static void main(String[] args) throws IOException {
		Loader loader = new Loader("src/input.txt");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int marimeaPopulatiei, nrMaxGeneratii;
		System.out.println("Datele se citesc din fisierul 'input.txt'");
		System.out.print("Dati marimea populatiei: ");
		String s = br.readLine();
		marimeaPopulatiei = Integer.parseInt(s);

		System.out.print("Dati numarul maxim de generatii: ");
		s = br.readLine();
		nrMaxGeneratii = Integer.parseInt(s);

		AlgoritmEvolutiv ae = new AlgoritmEvolutiv(marimeaPopulatiei, nrMaxGeneratii, loader);
		Individ individ = ae.solutie();

		System.out.println();
		if (individ.getFitness() == 0) {
			System.out.println("Solutia gasita (fitness = " + individ.getFitness() + "):");
			System.out.println("---------------------------");
			System.out.println(individ.toString());
		} else {
			System.out.println("Am ajuns la sfarsitul generatiei si solutia cea mai buna este (fitness = "
					+ individ.getFitness() + "):");
			System.out.println(individ.toString());
		}

	}
}