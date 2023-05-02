package com.mon.projet;

import java.util.ArrayList;

public class RAMBO
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
    private String competencePassive;


    public RAMBO() 
    {
        this.nom = "RAMBO";
        this.pointsDeVie = 100;
        this.niveauExperience = 14;
        this.competences = new ArrayList<String>();
        this.equipement = new ArrayList<String>();
        this.positionX = 0;
        this.positionY = 0;
        this.pointsAction = 3;
        this.competenceUnique = "Guérilla";
        this.SpecialArme = new Armes("Arbalète explosive", 1, 30, "Dégats de zones");
        this.competencePassive = "Survie dans un millieux hosile";

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
    
    public String getPouvoir() 
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
        personnageInfo[4] = "SpecialArme: ";
        for (String string : this.SpecialArme.getInfoArme())
        {
            personnageInfo[4] += string;
            personnageInfo[4] += " ";
        }
        personnageInfo[5] = "pointsAction: " + pointsAction;
        personnageInfo[6] = "competenceUnique: " + competenceUnique;
        personnageInfo[7] = "Description : peut tendre 3 pièges sur le terrain, infligeant 30 dégâts aux ennemis qui entrent dans la zone "
        +"et les immobilisant pendant 1 tour)";
        personnageInfo[8] = "competencePassive: " + competencePassive;
        personnageInfo[9] = "Description: Rambo récupère 10 PV lorsqu'il est seul autour de lui";
        return personnageInfo;
    }
}
