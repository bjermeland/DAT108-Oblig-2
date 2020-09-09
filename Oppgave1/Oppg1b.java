package no.hvl.dat108.Oppgave1;

import java.util.function.BiFunction;

public class Oppg1b {
	
	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> summerFunksjon = (a, b) -> a + b;
		int sum = beregn(12, 13, summerFunksjon);
		System.out.println("Sum 12 og 13 = " + sum);
		 
		BiFunction<Integer, Integer, Integer> storsteVerdiFunksjon = (a, b) -> a > b ? a : b;
		int storsteVerdi = beregn(-5, 3, storsteVerdiFunksjon);
		System.out.println("Største verdi -5 og 3 = " + storsteVerdi);
		 
		BiFunction<Integer, Integer, Integer> differanseFunksjon = (a, b) -> a >= b ? a - b : b - a;
		int differanse = beregn(54, 45, differanseFunksjon);
		System.out.println("Differanse (absoluttverdi) 54 og 45 = " + differanse);
	}
	
	public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> bi) {
		return bi.apply(a, b);
	}

}
