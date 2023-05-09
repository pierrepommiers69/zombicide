package com.mon.projet;


public class Zombie 
{
    
    private int pointsDeVie;
    private int puissance;
    private int deplacementZombie;
    private Enum.ZOMBIE typeZombie;
    
    public Zombie (int pointsDeVie, int puissance, int deplacementZombie,  Enum.ZOMBIE typeZombie)
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

    public Enum.ZOMBIE getTypeZombie() 
    {
        return typeZombie;
    }

    public void setTypeZombie(Enum.ZOMBIE typeZombie) 
    {
        this.typeZombie = typeZombie;
    }     
}