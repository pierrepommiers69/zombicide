package com.mon.projet;

import java.util.ArrayList;

public class RobertMcCall
{
    private String nom;
    private int pointsDeVie;
    private int niveauExperience;
    private ArrayList<String> competences;
    private ArrayList<String> equipement;
    private ArrayList<Armes> armes;
    private int positionX;
    private int positionY;
    private int pointsAction;
    private String competenceUnique;
    private String competencePassive;

    public RobertMcCall() 
    {
        this.nom = "RobertMcCall";
        this.pointsDeVie = 60;
        this.niveauExperience = 12;
        this.competences = new ArrayList<String>();
        this.equipement = new ArrayList<String>();
        this.positionX = 0;
        this.positionY = 0;
        this.pointsAction = 5;
        this.competenceUnique = "Architecte Suprême";
        this.competencePassive = "Chronomètre";
    }
    public String getNom() 
    {
        return this.nom;
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
        personnageInfo[4] += "SpecialArme: yen a pas";
        personnageInfo[5] = "pointsAction: " + pointsAction;
        personnageInfo[6] = "competenceUnique: " + competenceUnique;
        personnageInfo[7] = "Description: peut créer des pièges ou des armes improvisées à partir d'objets"+
        " trouvés dans l'environnement";
        personnageInfo[8] = "competencePassive: " + competencePassive;
        personnageInfo[9] = "Description: peut planifier sa stratégie, lui permettant de gagner 2 points d'action supplémentaires pour le tour suivant";
        return personnageInfo;
    }
}
