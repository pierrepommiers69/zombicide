package com.mon.projet;
import java.util.ArrayList;
import java.util.Scanner;


public class InitJeu extends Personnage
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
        this.listJoueur = new Personnage();
        String[] persoJouable = this.listJoueur.GetPersonnageJouable();
        System.out.println("Choisi ton joueur !");

        for(int i = 0; i<nbJoueurs; i++)
        {
            System.out.println("Choisi ton joueur !");
            System.out.println("Joueur " + i + " : ");
            System.out.println("List de joueur disponible");

            for(int j = 0; j < persoJouable.length; j++)
            {
                System.out.print(persoJouable[j] + " | ");
            }
            System.out.println();
            System.out.println("Pour avoir plus d'info sur les personnages tapez : help");
            String nom = scanner.nextLine();
            if(nom.charAt(0) == 'h')
            {
                ArrayList<String[]> infoPerso = listJoueur.GetInfoPerso();
                for (int j = 0; j < infoPerso.size(); j++)
                {
                    for (String info : infoPerso.get(j)) 
                    {
                        System.out.println(info);
                    }
                    System.out.println();
                    System.out.println();

                }
            }
            
        }
    }
}
