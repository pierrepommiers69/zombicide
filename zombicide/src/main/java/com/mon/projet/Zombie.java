package com.mon.projet;

import java.util.ArrayList;

import com.mon.projet.Items.Enums;
import com.mon.projet.PlateauZombicide.Cases;
import com.mon.projet.PlateauZombicide.Plateau;
import com.mon.projet.Tools.Chemin;

public class Zombie 
{
    
    private int pointsDeVie;
    private int puissance;
    private int deplacementZombie;
    private Enums.ZOMBIE typeZombie;
    private int idCases;
    private int id;
    
    public Zombie (int pointsDeVie, int puissance, int deplacementZombie,  Enums.ZOMBIE typeZombie, int idCases, int id)
    {
        this.id = id;
        this.idCases = idCases;
        this.pointsDeVie =pointsDeVie;
        this.puissance=puissance;
        this.deplacementZombie=deplacementZombie;
        this.typeZombie=typeZombie;      
    }

    /**
     * Methods just below !
     */

    //Getters et Setters 

    public int getPointsDeVie() 
    {
        return pointsDeVie;
    }

    public int GetidCases() 
    {
        return pointsDeVie;
    }

    public int GetidZombie() 
    {
        return this.id;
    }

    public void setPointsDeVie(int pointsDeVie) 
    {
        this.pointsDeVie = pointsDeVie;
    }

    public int getPuissance() 
    {
        return puissance;
    }

    public Enums.ZOMBIE getTypeZombie() 
    {
        return typeZombie;
    }

    public void setTypeZombie(Enums.ZOMBIE typeZombie) 
    {
        this.typeZombie = typeZombie;
    }

    public void Deplacement(Cases bruits, Plateau plateau)
    {
        Cases depart = plateau.GetCase(this.idCases);
        ArrayList<Cases> cheminVersBruit = Chemin.Djisktra(plateau.GetCase(this.idCases), plateau, bruits);
        if(typeZombie == Enums.ZOMBIE.RODEUR)
        {
            Zombie zombie = null;
            for (int index = 0; index < depart.getListeZombie().size(); index++)
            {
                if(depart.getListeZombie().get(index).GetidZombie() == this.id)
                {
                    zombie = depart.getListeZombie().get(index);
                    break;
                }
            }
            depart.getListeZombie().remove(zombie);
            cheminVersBruit.get(2).getListeZombie().add(this);
        }
        else
        {
            Zombie zombie = null;
            for (int index = 0; index < depart.getListeZombie().size(); index++)
            {
                if(depart.getListeZombie().get(index).GetidZombie() == this.id)
                {
                    zombie = depart.getListeZombie().get(index);
                    break;
                }
            }
            depart.getListeZombie().remove(zombie);
            cheminVersBruit.get(1).getListeZombie().add(this);
        }
    }
    public void Attaque(Plateau plateau)
    {
        Cases depart = plateau.GetCase(this.idCases);
        ArrayList<Personnage> personnages = depart.GetListSurvivant();
        Personnage moinsViePersonnage = null;
        int moinsVie = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < personnages.size(); i++) 
        {
            if(moinsVie > personnages.get(i).GetPointsDeVie())
            {
                moinsVie = personnages.get(i).GetPointsDeVie();
                index = i;
            }
        }
        moinsViePersonnage = personnages.get(index);
        moinsViePersonnage.SetLifePerso(moinsViePersonnage.GetPointsDeVie()-this.puissance);
        if(moinsViePersonnage.GetPointsDeVie() <= 0)
        {
            plateau.GetCase(this.idCases).GetListSurvivant().remove(moinsViePersonnage);
        }
    }

    public void Game(Plateau plateau, Cases bruit)
    {
        Deplacement(bruit, plateau);
        if(plateau.GetCase(this.id).GetListSurvivant().size() > 0)
        {
            Attaque(plateau);
        }
        
    }
}