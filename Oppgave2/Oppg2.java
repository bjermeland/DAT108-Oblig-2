package no.hvl.dat108.Oppgave2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Oppg2 {

	public static void main(String[] args) {
		List<Ansatt> ansatte = Arrays.asList(new Ansatt("Markus", "Bjerm", Kjonn.M, "Systemutvikler", 600000),
				new Ansatt("Erik", "Herm", Kjonn.M, "Frontendutvikler", 480000),
				new Ansatt("Maria", "Johansen", Kjonn.K, "DevOps utvikler", 590000),
				new Ansatt("Bjørnar", "Hansen", Kjonn.M, "Fullstack", 450000),
				new Ansatt("Kjartan", "Aas", Kjonn.M, "Konsulent", 460000));
		
		
		Function<Ansatt, Integer> kroneTillegg = (a) -> a.setLonn(a.getLonn() + 10000); // 10000 kroner tillegg
		Function<Ansatt, Integer> prosentTillegg = (a) -> a.setLonn((int) (a.getLonn() * 1.02)); // 2 prosent tillegg
		Function<Ansatt, Integer> kroneTilleggForLavLonn = (a) -> a.setLonn(a.getLonn() + 20000); // 20000 kroner tillegg
		Function<Ansatt, Integer> kroneTilleggForMenn = (a) -> a.setLonn(a.getLonn() + 10000); // 10000 kroner tillegg
		
		lonnsoppgjor(ansatte, kroneTillegg);
		lonnsoppgjor(ansatte, prosentTillegg);
		
		List<Ansatt> ansattLavLonn = ansatte.stream().filter(a -> a.getLonn() < 500000).collect(Collectors.toList());
		lonnsoppgjor(ansattLavLonn, kroneTilleggForLavLonn);
		
		List<Ansatt> ansattMenn = ansatte.stream().filter(a -> a.getKjonn().equals(Kjonn.M)).collect(Collectors.toList());
		lonnsoppgjor(ansattMenn, kroneTilleggForMenn);
		
		
		skrivUtAlle(ansatte);
	}
	

	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> func) {
		for(Ansatt a : ansatte) func.apply(a);
	}
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		for(Ansatt a : ansatte) System.out.println(a.toString());
	}

}
