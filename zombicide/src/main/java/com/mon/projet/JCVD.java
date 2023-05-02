package com.mon.projet;

import java.util.ArrayList;

public class JCVD 
{
    private String nom;
    private int pointsDeVie;
    private int niveauExperience;
    private ArrayList<String> competences;
    private ArrayList<String> equipement;
    private ArrayList<Armes> armes;
    private Armes SpecialArme;

    private int positionX;
    private int positionY;
    private int pointsAction;
    private String competenceUnique;
    private String competencePassive;


    public JCVD() 
    {
        this.nom = "Jean Claude Vendame(=JCDV pour les intimes)";
        this.pointsDeVie = 80;
        this.niveauExperience = 12;
        this.competences = new ArrayList<String>();
        this.equipement = new ArrayList<String>();
        this.positionX = 0;
        this.positionY = 0;
        this.pointsAction = 4;
        this.competenceUnique = "Acrobatie mortelle";
        this.SpecialArme = new Armes("Couteau de combat", 0, 30, "Lorsque Jean-Claude attaque avec son couteau de combat, il peut effectuer une attaque supplémentaire gratuite s'il a éliminé un ennemi avec la première attaque.");
        this.competencePassive = "Esquive";

    }
    public String getNom() 
    {
        return this.nom;
    }
    public Armes getSpecialeArme() 
    {
        return this.SpecialArme;
    }
    
    public int getPointsDeVie() 
    {
        return this.pointsDeVie;
    }
    public String getCompetencePassive() 
    {
        return this.competencePassive;
    }
    
    public int getNiveauExperience() 
    {
        return this.niveauExperience;
    }
    
    public ArrayList<String> getCompetences() 
    {
        return this.competences;
    }
    
    public ArrayList<String> getEquipement() 
    {
        return this.equipement;
    }
    
    public ArrayList<Armes> getArmes() 
    {
        return this.armes;
    }
    
    public int getPositionX() 
    {
        return this.positionX;
    }
    
    public int getPositionY()
    {
        return this.positionY;
    }
    
    public int getPointsAction() 
    {
        return this.pointsAction;
    }
    
    public String getCompetenceUnique() 
    {
        return this.competenceUnique;
    }
    

    public String[] getInfo() 
    {
        String[] personnageInfo = new String[10];
        personnageInfo[0] = "nom: " + nom;
        personnageInfo[1] = "pointsDeVie: " + pointsDeVie;
        personnageInfo[2] = "niveauExperience: " + niveauExperience;
        personnageInfo[3] = "competences: " + competences.toString();
        personnageInfo[4] = "SpecialArme: " ;
        for (String string : this.SpecialArme.getInfoArme())
        {
            personnageInfo[4] += string;
            personnageInfo[4] += " ";
        }
        personnageInfo[5] = "pointsAction: " + pointsAction;
        personnageInfo[6] = "competenceUnique: " + competenceUnique;
        personnageInfo[7] = "Description : peut sauter par-dessus les obstacles et les ennemis, infligeant 20 dégâts à tous les ennemis dans la zone d'atterrissage";
        personnageInfo[8] = "competencePassive: " + competencePassive;
        personnageInfo[9] = "Description: peut esquiver l'attaque d'un enemi";
        return personnageInfo;
    }
}
