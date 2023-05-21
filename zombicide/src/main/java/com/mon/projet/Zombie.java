package com.mon.projet;

import com.mon.projet.Items.Enums;

public class Zombie 
{
    
    private int pointsDeVie;
    private int puissance;
    private int deplacementZombie;
    private Enums.ZOMBIE typeZombie;
    
    public Zombie (int pointsDeVie, int puissance, int deplacementZombie,  Enums.ZOMBIE typeZombie)
    {
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

    public void setPointsDeVie(int pointsDeVie) 
    {
        this.pointsDeVie = pointsDeVie;
    }

    public int getPuissance() 
    {
        return puissance;
    }

    public void setPuissance(int puissance) 
    {
        this.puissance = puissance;
    }

    public int getDeplacementZombie() 
    {
        return deplacementZombie;
    }

    public void setDeplacementZombie(int deplacementZombie) 
    {
        this.deplacementZombie = deplacementZombie;
    }

    public Enums.ZOMBIE getTypeZombie() 
    {
        return typeZombie;
    }

    public void setTypeZombie(Enums.ZOMBIE typeZombie) 
    {
        this.typeZombie = typeZombie;
    }
    
    
}