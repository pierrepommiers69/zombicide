package com.mon.projet;

import java.util.ArrayList;
import java.util.Scanner;

import com.mon.projet.Items.Enums;
import com.mon.projet.PlateauZombicide.Cases;
import com.mon.projet.PlateauZombicide.Plateau;
import com.mon.projet.Tools.Chemin;
import com.mon.projet.Tools.Couple;

public class Jeu
{

    private int nmbJoueur;
    private ArrayList<Personnage> personnages = new ArrayList<Personnage>();
    private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    private Plateau plateau;
    private Enums.Difficulte difficulte;
    public int generationCasesSombre;

    public Jeu(int nmbJoueur, int[] plateauTest, ArrayList<Couple> block, Enums.Difficulte difficulte)
    {
        this.nmbJoueur = nmbJoueur;
        this.plateau = InitJeu(nmbJoueur, plateauTest, block);

        this.difficulte = difficulte;
        this.generationCasesSombre = GiveHardness();
        LanceMainLoop();
    }

    public int GiveHardness()
    {
        int generationCaseSombre = 1;
        if(this.difficulte == Enums.Difficulte.Difficile)
        {
            generationCaseSombre = 3;
        }
        else if(this.difficulte == Enums.Difficulte.Moyen)
        {
            generationCaseSombre = 2; 
        }
        else if(this.difficulte == Enums.Difficulte.Suicide)
        {
            generationCaseSombre = 4;
        }
        return generationCaseSombre;
    }


    public  Plateau InitJeu(int nbJoueurs, int[] plateauTest, ArrayList<Couple> block)
    {
        Plateau newPlateau = new Plateau(plateauTest,block, 10, 10);
        ArrayList<Cases> cases = Chemin.Djisktra(newPlateau.GetCase(75), newPlateau, newPlateau.GetCase(99));
        Scanner scanner = new Scanner(System.in);
        Personnage[] persoJouable = Personnage.PersonnageJouable();

        for(int i = 0; i<nbJoueurs; i++)
        {
            System.out.println("Choisi ton joueur !");
            System.out.println("Joueur " + (i+1) + " : ");
            System.out.println("List de joueur disponible");

            for(int j = 0; j < persoJouable.length; j++)
            {
                System.out.print(persoJouable[j].GetNom() + " | ");
            }
            System.out.println();
            System.out.println("Pour avoir plus d'info sur les personnages tapez : help");
            String nom = scanner.nextLine();
            if(nom.length() > 0 && nom.charAt(0) == 'h')
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
                System.out.println("Choisissez votre perso : ");
                String choix = scanner.nextLine();  
                Personnage perso = Personnage.WhoPersonnage(choix);
                System.out.println("Vous avez choisis "+ perso.GetNom());
                newPlateau.GetCase(0).GetListSurvivant().add(perso);
                this.personnages.add(perso);
            }
            else
            {
                Personnage perso = Personnage.WhoPersonnage(nom);
                System.out.println("Vous avez choisis "+ perso.GetNom());
                newPlateau.GetCase(99).GetListSurvivant().add(perso);
                this.personnages.add(perso);
            }
            
        }   
        return newPlateau;     
    }

    public void LanceMainLoop()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        while(this.personnages.size()>0)
        {
            
            for (int index = 0; index < this.plateau.getPlateau().length; index++)
            {
                Cases cases = this.plateau.getPlateau()[index];
                cases.setNbBruits(cases.getNbBruits()/2);
            }

            for (int i = 0; i < this.personnages.size(); i++)
            {
                
                System.out.println("PERSONNAGE : " + this.personnages.get(i).GetNom());
                this.personnages.get(i).Game(plateau);
            }
            
            for (int i = 0; i < this.zombies.size(); i++)
            {
                this.zombies.get(i).Game(plateau, plateau.GetplusBruit());
            }

            int indexZombie = 0;

            for(int i = 0; i<plateau.getPlateau().length; i++)
            {
                if(plateau.getPlateau()[i].GetMonType() == Enums.FONCTIONCASE.SOMBRE)
                {
                    int random = Plateau.Random(2);
                    if(random == 1)
                    {
                        Zombie zombie = new Zombie(200, 15, 1,Enums.ZOMBIE.MOLOSSE, i, indexZombie);
                        plateau.getPlateau()[i].getListeZombie().add(zombie);
                        zombies.add(zombie);
                    }
                    else
                    {
                        Zombie zombie = new Zombie(100, 10, 2, Enums.ZOMBIE.RODEUR, i, indexZombie);
                        plateau.getPlateau()[i].getListeZombie().add(zombie);
                        zombies.add(zombie);
                    }
                    indexZombie++;
                }                
            }

            
            for (int i = 0; i < this.personnages.size(); i++)
            {
                if(plateau.getPlateau()[this.personnages.get(i).GetPosition()].GetMonType() == Enums.FONCTIONCASE.SORTIE)
                {
                    this.personnages.remove(i);
                }
            }

            for (int i = 0; i < this.generationCasesSombre ; i++)
            {
                Cases casesTransformation = plateau.GetHasardCase();
                casesTransformation.setMonType(Enums.FONCTIONCASE.SOMBRE);    
            } 
            
            plateau.PrintPlateauZombie();
            plateau.PrintPlateau();
        }        
    }
}
