package application;

import java.util.Locale;
import java.util.Scanner;

import boardgame.Board;


public class Program {

	public static void main(String[] args) {
		
		// jogo de xadrez- 30/01/2020
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		 Board board = new Board(8,8);
		
		sc.close();

	}

}
