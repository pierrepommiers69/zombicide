package com.mon.projet;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class Cases
{
    
    private int nbBruits;
    private float chance;
    private List<Personnage> listeSurvivant =new ArrayList<Personnage>();
    private Enum.FONCTIONCASE  fonctionCase;
    private ArrayList<Zombie> listeZombie = new ArrayList<Zombie>();
    
    public Cases(int nbBruits, float chance, int nombreSurvivant, int nombreZombie, Enum.FONCTIONCASE fonctionCase)
    {
        this.nbBruits = nbBruits;
        this.chance = chance;
        this.fonctionCase= fonctionCase;

        // creeer x zombie dans la case 
        for(int i = 0; i<nombreZombie; i++)
        {
            int random = Plateau.Random(4);
            if(random == 1)
            {
                Zombie zombie = new Zombie(200, 10, 1,Enum.ZOMBIE.MOLOSSE);
                listeZombie.add(zombie);
            }
            else
            {
                Zombie zombie = new Zombie(100, 5, 2, Enum.ZOMBIE.RODEUR);
                listeZombie.add(zombie);
            }
        }      
        
    }

    /**
     * Methods just below ! 
     */
    

//Getters et Setters
	public int getNbBruits()  
	{
	    return nbBruits;
	}
	
	public void setNbBruits(int nbBruits) 
	{
	    this.nbBruits = nbBruits;
	}
	
	public float getChance() 
	{
	    return chance;
	}
	
	public void setChance(float chance) 
	{
	    this.chance = chance;
	}
	
	public List<Zombie> getListeZombie() 
	{
	    return listeZombie;
	}
	
	public Enum.FONCTIONCASE GetMonType()
	{
	    return this.fonctionCase;
	}
	    
	public void setMonType(Enum.FONCTIONCASE fonctionCase) 
	{
	    this.fonctionCase = fonctionCase;
	}


    public List<Personnage> GetListSurvivant()
    {
        return this.listeSurvivant;
    }

    public void setListSurvivant(List<Personnage> listeSurvivant) 
    {
        this.listeSurvivant = listeSurvivant;
    }
    
//savoir contenu de la case
    public void PrintCase()
    {
        System.out.print("|"+this.fonctionCase+"|");
    }
}







