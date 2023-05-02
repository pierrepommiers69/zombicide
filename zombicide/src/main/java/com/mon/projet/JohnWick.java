package com.mon.projet;

import java.util.ArrayList;

public class JohnWick
{
    private String nom;
    private int pointsDeVie;
    private int niveauExperience;
    private ArrayList<String> competences;
    private ArrayList<String> equipement;
    private ArrayList<Armes> armes;
    private int positionX;
    private Armes SpecialArme;

    private int positionY;
    private int pointsAction;
    private String competenceUnique;


    public JohnWick() 
    {
        this.nom = "JohnWick (Croquemitaine)";
        this.pointsDeVie = 75;
        this.niveauExperience = 5;
        this.competences = new ArrayList<String>();
        this.equipement = new ArrayList<String>();
        this.positionX = 0;
        this.positionY = 0;
        this.pointsAction = 5;
        this.competenceUnique = "Légende Vivante";
        this.SpecialArme = new Armes("Chien", 4, 0, "Le chien peut effectuer une recherche et faire du bruit");

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
    
    public String getCompetenceunique() 
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
        personnageInfo[7] = "Description : peut continuer à agir même à 0 PV pour un tour supplémentaire et fais fuir les enemis avec moins de vie que lui";

        return personnageInfo;
    }
}
