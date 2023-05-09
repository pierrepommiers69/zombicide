package com.mon.projet;

import java.util.Scanner;


public class Run 
{
	public static void main(String[] args) 	
	{
		int[] plateauTest = new int[]{3,1,1,1,1,1,0,0,1,1,0,0,0,0,1,1,0,0,1,1,1,1,0,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,0,1,1,1,1,1,1,0,0,1,0,1,1,0,1,1,1,0,0,1,1,1,1,0,1,1,1};
		Plateau newPaPlateau = new Plateau(plateauTest, 10, 10);
		Scanner scanner = new Scanner(System.in);
		int verifyNmbJoueur = 0;
		InitJeu newJeu = null;
		System.out.println("entrer une nom de partie");
		String nomPartie = scanner.nextLine();
		System.out.println("entrer un nombre de joueur");
		String nmbJoueur = scanner.nextLine();
		System.out.println("entrer une Difficulté HARD/MEDIUM/EASY");
		String difficulte = scanner.nextLine();
		newPaPlateau.PrintPlateau();

		while(verifyNmbJoueur == 0)
		{
			System.out.println("nombre de joueur, 2-6");
			String inputString = scanner.nextLine();
			verifyNmbJoueur = 1;
			newJeu = new InitJeu(nomPartie, 5, difficulte);
		}
	}
	

}
