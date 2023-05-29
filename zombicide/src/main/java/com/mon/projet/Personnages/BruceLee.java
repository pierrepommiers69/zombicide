package com.mon.projet.Personnages;
import java.util.ArrayList;

import com.mon.projet.Personnage;
import com.mon.projet.Items.Armes;
import com.mon.projet.Items.Enums;
import com.mon.projet.Items.Objets;

public class BruceLee extends Personnage
{
    private String nom;
    private int pointsDeVie;
    private int niveauExperience;
    private ArrayList<Armes> armes = new ArrayList<Armes>();
    private ArrayList<Objets> objets = new ArrayList<Objets>();
    private Armes SpecialArme;
    private int idCases;
    private int pointsAction;
    private String competenceUnique;
    private String competencePassive;


    public BruceLee() 
    {
        this.nom = "BruceLee (Le Dragon)";
        this.pointsDeVie = 80;
        this.niveauExperience = 12;
        this.idCases = 0;
        this.pointsAction = 4;
        this.competenceUnique = "Énergie du dragon";
        this.competencePassive = "Maîtrise du chi";
        this.SpecialArme = new Armes("Nunchaku", 0, 20, "Lorsque Bruce attaque avec ses Nunchakus,"+
                                                                        " il peut effectuer une deuxième attaque sur un autre ennemi"
                                                                        +"adjacent sans coût supplémentaire en points d'action.", Enums.Rarity.LENGENDAIRE,6,1);
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
    public ArrayList<Objets> GetEquipement() 
    {
        return this.objets;
    }

    @Override
    public ArrayList<Armes> GetArmes() 
    {
        return this.armes;
    }

    @Override
    public int GetPosition() 
    {
        return this.idCases;
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
    public void SetLife(Objets object)
    {
        this.pointsDeVie += object.GetSoin();
    }

    @Override
    public void SetPosition(int x) 
    {
        this.idCases = x;
    }

    @Override
    public void SetLifePerso(int SetLife)
    {
        this.pointsDeVie = SetLife;
    }
    



    @Override
    public String[] GetInfo() 
    {
        String[] personnageInfo = new String[10];
        personnageInfo[0] = "nom: " + nom;
        personnageInfo[1] = "pointsDeVie: " + pointsDeVie;
        personnageInfo[2] = "niveauExperience: " + niveauExperience;
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
