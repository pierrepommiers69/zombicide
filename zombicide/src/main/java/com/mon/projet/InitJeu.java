package com.mon.projet;
import java.util.ArrayList;
import java.util.Scanner;


public class InitJeu
{
    public enum Difficulte 
    {
        DIFFICILE,
        NORMAL,
        FACILE;
    }
    public int nmbJoueur;
    public String nomPartie;
    public String diff;
    public Personnage listJoueur;

    public InitJeu(String nompartie,int nbJoueurs, String difficulte)
    {

        Scanner scanner = new Scanner(System.in);
        this.nmbJoueur = nbJoueurs;
        this.nomPartie = nompartie;
        this.diff = difficulte;
        Personnage[] persoJouable = Personnage.PersonnageJouable();
        System.out.println("Choisi ton joueur !");

        for(int i = 0; i<nbJoueurs; i++)
        {
            System.out.println("Choisi ton joueur !");
            System.out.println("Joueur " + i + " : ");
            System.out.println("List de joueur disponible");

            for(int j = 0; j < persoJouable.length; j++)
            {
                System.out.print(persoJouable[j].GetNom() + " | ");
            }
            System.out.println();
            System.out.println("Pour avoir plus d'info sur les personnages tapez : help");
            String nom = scanner.nextLine();
            if(nom.charAt(0) == 'h')
            {
                System.out.println();


                for (int j = 0; j < persoJouable.length; j++)
                {
                    String[] infoJoueur = persoJouable[j].GetInfo();
                    for(int h = 0; h<infoJoueur.length; h++)
                    {
                        
                        System.out.println(infoJoueur[h]);
                    }
                    System.out.println("------------------------------------------");
                    System.out.println();

                }
            }
            
        }
    }
}
