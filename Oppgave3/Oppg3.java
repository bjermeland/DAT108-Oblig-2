package no.hvl.dat108.Oppgave3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import no.hvl.dat108.Oppgave2.Ansatt;
import no.hvl.dat108.Oppgave2.Kjonn;

public class Oppg3 {

	public static void main(String[] args) {
		List<Ansatt> ansatte = Arrays.asList(new Ansatt("Markus", "Bjerm", Kjonn.M, "Sjefutvikler", 900000),
				new Ansatt("Erik", "Herm", Kjonn.M, "Frontendutvikler", 480000),
				new Ansatt("Maria", "Johansen", Kjonn.K, "DevOps utvikler", 450000),
				new Ansatt("Bjørnar", "Hansen", Kjonn.M, "Fullstack", 450000),
				new Ansatt("Kjartan", "Aas", Kjonn.M, "Konsulent", 450000));
		
		// 3a
		List<String> etternavn = ansatte.stream().map(a -> a.getEtternavn()).collect(Collectors.toList());
		System.out.println("3 a)");
		for(String a : etternavn) System.out.println(a);
		
		// 3b
		int antallKvinner = (int) ansatte.stream().filter(a -> a.getKjonn() == Kjonn.K).count();
		System.out.println("\n3 b)\nAntall kvinner: " + antallKvinner);
		
		// 3c
		int gjSnittKvinner = ansatte.stream().filter(a -> a.getKjonn() == Kjonn.K).map(a -> a.getLonn()).mapToInt(b -> b).sum() / antallKvinner;
		System.out.println("\n3 c)\nGj. snitt lønn til kvinnene: " + gjSnittKvinner);
		
		// 3d
		List<Ansatt> sjefer = ansatte.stream().filter(a -> a.getStilling().contains("Sjef")).collect(Collectors.toList());
		for(Ansatt s : sjefer) s.setLonn((int) (s.getLonn() * 1.07));
		System.out.println("\n3 d)");
		for(Ansatt a : ansatte) System.out.println(a.toString());
		
		// 3e
		boolean hoyLonn = ansatte.stream().filter(a -> a.getLonn() > 800000).count() > 0 ? true : false;
		System.out.println("\n3 e)\nNoen tjener over 800.000: " + (hoyLonn == true ? "Ja" : "Nei"));
		
		// 3f
		System.out.println("\n3 f)");
		ansatte.forEach(ansatt -> System.out.println(ansatt));
		
		// 3g
		List<Ansatt> sortertLonn = ansatte;
		Collections.sort(sortertLonn, (a, b) -> a.getLonn() - b.getLonn());
		System.out.println("\n3 g)\nLavest lønn:\n\n" + sortertLonn.get(0));
		for(int i = 0; i < sortertLonn.size() - 1; i++) {
			if(sortertLonn.get(0).getLonn() == sortertLonn.get(i+1).getLonn()) {
				System.out.println(sortertLonn.get(i+1));
			}
		}
		
		// 3h
		List<Integer> heltall = new ArrayList<Integer>();
		for(var i = 0; i < 1000; i++) heltall.add(i);
		int sum = heltall.stream().filter(a -> a % 3 == 0 || a % 5 == 0).mapToInt(Integer::intValue).sum();
		System.out.println("\n3 f)\nSum av heltall som er delelig med 3 eller 5: " + sum);

	}

}
