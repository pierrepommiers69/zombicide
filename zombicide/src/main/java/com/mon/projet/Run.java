package com.mon.projet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import com.mon.projet.Items.Enums;
import com.mon.projet.PlateauZombicide.Plateau;
import com.mon.projet.Tools.Couple;


public class Run 
{
	public static void main(String[] args) 	
	{
		int[] plateauTest = new int[]{3,1,1,1,1,1,0,0,1,1,0,0,0,0,1,1,0,0,1,1,1,1,0,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,0,1,1,1,1,1,1,0,0,1,0,1,1,0,1,1,1,0,0,1,1,1,1,0,1,1,1};
		ArrayList<Couple> block = new ArrayList<Couple>();
		block.add(new Couple(3, 0));
		block.add(new Couple(3, 1));
		block.add(new Couple(3, 2));
		block.add(new Couple(0, 3));
		block.add(new Couple(1, 3));

		Plateau newPaPlateau = new Plateau(plateauTest,block, 10, 10);
		Scanner scanner = new Scanner(System.in);
		int verifyNmbJoueur = 0;
		System.out.println("entrer une nom de partie");
		String nomPartie = scanner.nextLine();
		System.out.println("entrer un nombre de joueur");
		String nmbJoueur = scanner.nextLine();
		System.out.println("entrer une Difficulté HARD/MEDIUM/EASY");
		String difficulte = scanner.nextLine();
		newPaPlateau.PrintPlateau();
		for (int i = 0; i < newPaPlateau.getPlateau()[2].GetVoisin().size(); i++) 
		{
			newPaPlateau.getPlateau()[2].GetVoisin().get(i).PrintCase();			
		}

		while(verifyNmbJoueur == 0)
		{
			System.out.println("nombre de joueur, 2-6");
			String inputString = scanner.nextLine();
			verifyNmbJoueur = 1;
			Jeu newJeu = new Jeu(5, plateauTest, block, Enums.Difficulte.Facile);
		}
	}
	

}
