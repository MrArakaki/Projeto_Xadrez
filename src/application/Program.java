package application;

import java.util.Locale;
import java.util.Scanner;

import boardgame.Position;

public class Program {

	public static void main(String[] args) {
		
		// jogo de xadrez- 30/01/2020
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Position position = new Position(3,5);
		System.out.println(position);
		
		sc.close();

	}

}
