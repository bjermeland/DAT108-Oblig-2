package no.hvl.dat108.Oppgave2;

public class Ansatt {
	
	private String fornavn;
	private String etternavn;
	private Kjonn kjonn;
	private String stilling;
	private int aarslonn;
	
	public Ansatt(String f, String e, Kjonn k, String s, int a) {
		this.fornavn = f;
		this.etternavn = e;
		this.kjonn = k;
		this.stilling = s;
		this.aarslonn = a;
	}
	
	public String getEtternavn() {
		return etternavn;
	}
	
	public Kjonn getKjonn() {
		return kjonn;
	}
	
	public String getStilling() {
		return stilling;
	}
	
	public int getLonn() {
		return aarslonn;
	}
	
	public int setLonn(int d) {
		return this.aarslonn = d;
	}
	
	public String toString() {
		return fornavn + " " + etternavn + "	| Kjønn: " + kjonn + " | Stilling: " + stilling + "	| Årslønn: " + aarslonn;
	}
}
