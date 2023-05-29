package com.mon.projet.PlateauZombicide;

import java.util.ArrayList;
import java.util.Random;

import com.mon.projet.Items.Enums;
import com.mon.projet.Tools.Couple;



public class Plateau 
{

    private int taille;
    private Cases[] plateau;
    private int ligs;
    private int cols;
    
    public Plateau(int[] differentCase, ArrayList<Couple> block, int cols, int ligs)
    {
        this.taille = differentCase.length;
        this.plateau = new Cases[this.taille];
        this.cols = cols;
        this.ligs = ligs;
        
        
        //Parcours du style de plateau
        for(int i = 0; i<differentCase.length; i++)
        {
            if(differentCase[i] == 2)
            {
                Cases caseSombre = new Cases(i , cols, ligs, 0,Enums.FONCTIONCASE.SOMBRE);
                plateau[i] = caseSombre;
            }
            if(differentCase[i] == 1)
            {
                Cases caseClaire = new Cases(i,cols, ligs, 0, Enums.FONCTIONCASE.CLAIR);
                plateau[i] = caseClaire;
            }
            if(differentCase[i] == 0)
            {
                Cases caseObstacle = new Cases(i,cols, ligs,0, Enums.FONCTIONCASE.BONUS);
                plateau[i] = caseObstacle;
            }
            if(differentCase[i] == 3)
            {
                Cases caseSortie= new Cases(i,cols, ligs, 0, Enums.FONCTIONCASE.SORTIE);
                plateau[i] = caseSortie;
            }

        }
        for (int i = 0; i < cols ; i++) 
        {
            for(int j = 0; j < ligs; j++)
            {
                plateau[i*cols+j].InitVoisin(j, i, block, plateau);
            }
            
        }
    }

    /**
     * Methods 
     */ 

    //Cherche une case claire
    public Cases GetHasardCase()
    {
        int random = Plateau.Random(100);
        return this.plateau[random];
    }

    public Cases GetCase(int id)
    {
        for(int i = 0; i<this.taille; i++)
        {
            if(this.plateau[i].getID() == id)
            {
                return plateau[i];
            }
        }
        System.out.println("pas de case  trouvé");
        return null;
    }

    public Cases GetplusBruit()
    {
        int max  = 0;
        int index = 0;
        for (int i = 0; i < plateau.length; i++)
        {
            if(this.plateau[i].getNbBruits()>max)
            {
                max = this.plateau[i].getNbBruits();
                index = i;
            }            
        }
        return this.plateau[index];
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

    public void SetPlateau(Cases[] plateau) 
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

    public boolean OkDirection(Cases cases,Cases case2)
    {
        boolean result = false;
        for (int i = 0; i < cases.GetVoisin().size(); i++) 
        {
            if(cases.GetVoisin().get(i).getID() == case2.getID())
            {
                result = true;
                break;
            }
        }
        return result;

    }
}