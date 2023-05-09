package com.mon.projet;
import java.util.ArrayList;

public class BruceLee extends Personnage
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


    public BruceLee() 
    {
        this.nom = "BruceLee (Le Dragon)";
        this.pointsDeVie = 80;
        this.niveauExperience = 12;
        this.competences = new ArrayList<String>();
        this.equipement = new ArrayList<String>();
        this.positionX = 0;
        this.positionY = 0;
        this.pointsAction = 4;
        this.competenceUnique = "Énergie du dragon";
        this.competencePassive = "Maîtrise du chi";
        this.SpecialArme = new Armes("Nunchaku", 0, 20, "Lorsque Bruce attaque avec ses Nunchakus,"+
                                                                        " il peut effectuer une deuxième attaque sur un autre ennemi"
                                                                        +"adjacent sans coût supplémentaire en points d'action.");
    }
    
    @Override
    public String GetNom() 
    {
        return this.nom;
    }

    @Override
    public Armes GetSpecialeArme() 
    {
        return this.SpecialArme;
    }

    @Override
    public int GetPointsDeVie() 
    {
        return this.pointsDeVie;
    }

    @Override
    public int GetNiveauExperience() 
    {
        return this.niveauExperience;
    }

    @Override
    public ArrayList<String> GetCompetences() 
    {
        return this.competences;
    }

    @Override
    public ArrayList<String> GetEquipement() 
    {
        return this.equipement;
    }

    @Override
    public ArrayList<Armes> GetArmes() 
    {
        return this.armes;
    }

    @Override
    public int GetPositionX() 
    {
        return this.positionX;
    }

    @Override
    public int GetPositionY()
    {
        return this.positionY;
    }

    @Override
    public int GetPointsAction() 
    {
        return this.pointsAction;
    }

    @Override
    public String GetCompetenceUnique() 
    {
        return this.competenceUnique;
    }

    @Override
    public String[] GetInfo() 
    {
        String[] personnageInfo = new String[10];
        personnageInfo[0] = "nom: " + nom;
        personnageInfo[1] = "pointsDeVie: " + pointsDeVie;
        personnageInfo[2] = "niveauExperience: " + niveauExperience;
        personnageInfo[3] = "competences: " + competences.toString();
        personnageInfo[4] += "SpecialArme: ";
        for (String string : this.SpecialArme.getInfoArme())
        {
            personnageInfo[4] += string;
            personnageInfo[4] += " ";
        }
        personnageInfo[5] = "pointsAction: " + pointsAction;
        personnageInfo[6] = "competenceUnique: " + competenceUnique;
        personnageInfo[7] = "Description : peut lancer une attaque à distance avec les mains nues, infligeant 2 dégâts et repoussant l'ennemi d'une case";
        personnageInfo[8] = "competencePassive: " + competencePassive;
        personnageInfo[9] = "Description: récupère 1 PV à chaque fois qu'il élimine un ennemi";
        return personnageInfo;
    }

    @Override
    public String GetCompetencePassive() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'GetCompetencePassive'");
    }
    
}
