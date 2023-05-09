package com.mon.projet;

import java.util.ArrayList;
import java.util.Random;



public class Plateau {

    private int taille;
    private Cases[] plateau;
    private int ligs;
    private int cols;
    
    public Plateau(int[] differentCase, int cols, int ligs)
    {
        this.taille = differentCase.length;
        this.plateau = new Cases[this.taille];
        this.cols = cols;
        this.ligs = ligs;
        
        
        //Parcours du style de plateau
        for(int i = 0; i<differentCase.length; i++)
        {
            if(differentCase[i] == 0)
            {
                Cases caseSombre = new Cases(0, Random(10), 0, 1, Enum.FONCTIONCASE.SOMBRE);
                plateau[i] = caseSombre;
            }
            if(differentCase[i] == 1)
            {
                Cases caseClaire = new Cases(0, Random(10), 0, 0, Enum.FONCTIONCASE.CLAIR);
                plateau[i] = caseClaire;
            }
            if(differentCase[i] == 2)
            {
                Cases caseObstacle = new Cases(0, 0, 0, 0, Enum.FONCTIONCASE.OBSTACLE);
                plateau[i] = caseObstacle;
            }
            if(differentCase[i] == 3)
            {
                Cases caseSortie= new Cases(0, 0, 0, 0, Enum.FONCTIONCASE.SORTIE);
                plateau[i] = caseSortie;
            }

        }
    }

    /**
     * Methods 
     */ 

    //Cherche une case claire
    public Cases GetCaseClaire()
    {
        for(int i = 0; i<this.taille; i++)
        {
            if(this.plateau[i].GetMonType() == Enum.FONCTIONCASE.CLAIR)
            {
                return plateau[i];
            }
        }
        System.out.println("pas de case claire trouvé");
        return null;
    }

    public static int Random(int intervalle)
    {
        Random random = new Random();
        int randomNumber = random.nextInt(intervalle);
        return randomNumber;
    }
// Affiche les cases sur le plateau
    public void PrintPlateau()
    {
        for(int i = 0; i<cols; i++)
        {
            for(int j = 0; j<ligs; j++)
            {
                this.plateau[i*cols+j].PrintCase();
            }
            System.out.println();
        }
    }
    
//Getters et Setters 
    public int getTaille() 
    {
        return taille;
    }

    public void setTaille(int taille) 
    {
        this.taille = taille;
    }

    public Cases[] getPlateau() 
    {
        return plateau;
    }

    public void setPlateau(Cases[] plateau) 
    {
        this.plateau = plateau;
    }

    public int getLigs() 
    {
        return ligs;
    }

    public void setLigs(int ligs) 
    {
        this.ligs = ligs;
    }

    public int getCols() 
    {
        return cols;
    }

    public void setCols(int cols) 
    {
        this.cols = cols;
    }
}