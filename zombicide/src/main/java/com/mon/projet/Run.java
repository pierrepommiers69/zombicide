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
		Couple newCoupletest = new Couple(2, 3);
		block.add(newCoupletest);
		int verifyNmbJoueur = 0;
		String nmbJoueur = "2";
		System.out.println("entrer une Difficulté Facile/Moyen/Difficile/Suicide");
		String difficulte = "Facile";
		Enums.Difficulte difficulteEnum = Enums.Difficulte.Facile;
		switch (difficulte)
		{
            case "Facile":
                difficulteEnum = Enums.Difficulte.Facile;
                break;
            case "Moyen":
				difficulteEnum = Enums.Difficulte.Moyen;
                break;
            case "Difficile":
				difficulteEnum = Enums.Difficulte.Difficile;
                break;
            case "Suicide":
				difficulteEnum = Enums.Difficulte.Suicide;
                break;
            default:
                System.out.println("Difficulté non reconnue");
                break;
        }

		while(verifyNmbJoueur == 0)
		{
			verifyNmbJoueur = 1;
			Jeu newJeu = new Jeu(Integer.parseInt(nmbJoueur), plateauTest, block, difficulteEnum);
		}
	}
	

}
