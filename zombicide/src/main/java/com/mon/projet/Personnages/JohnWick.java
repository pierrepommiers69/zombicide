package com.mon.projet.Personnages;
import java.util.ArrayList;

import com.mon.projet.Personnage;
import com.mon.projet.Items.Armes;
import com.mon.projet.Items.Enums;
import com.mon.projet.Items.Objets;

public class JohnWick extends Personnage
{
    private String nom;
    private int pointsDeVie;
    private int niveauExperience;
    private ArrayList<Armes> armes = new ArrayList<Armes>();
    private ArrayList<Objets> objets = new ArrayList<Objets>();

    private int idCases;
    private Armes SpecialArme;
    private int pointsAction;
    private String competenceUnique;


    public JohnWick() 
    {
        this.nom = "JohnWick (Croquemitaine)";
        this.pointsDeVie = 75;
        this.niveauExperience = 5;
        this.idCases = 0;
        this.pointsAction = 5;
        this.competenceUnique = "Légende Vivante";
        this.SpecialArme = new Armes("Chien", 4, 0, "Le chien peut effectuer une recherche et faire du bruit",  Enums.Rarity.LENGENDAIRE, 6,1);

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
    public void SetPosition(int x)
    {
        this.idCases = x;
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
    public String[] GetInfo() 
    {
        String[] personnageInfo = new String[10];
        personnageInfo[0] = "nom: " + nom;
        personnageInfo[1] = "pointsDeVie: " + pointsDeVie;
        personnageInfo[2] = "niveauExperience: " + niveauExperience;
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
    @Override
    public String GetCompetencePassive() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'GetCompetencePassive'");
    }
}
