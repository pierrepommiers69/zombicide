package com.mon.projet.Personnages;
import java.util.ArrayList;

import com.mon.projet.Personnage;
import com.mon.projet.Items.Armes;
import com.mon.projet.Items.Enums;
import com.mon.projet.Items.Objets;
public class RAMBO extends Personnage
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


    public RAMBO() 
    {
        this.nom = "RAMBO";
        this.pointsDeVie = 100;
        this.niveauExperience = 14;
        this.idCases = 0;
        this.pointsAction = 3;
        this.competenceUnique = "Guérilla";
        this.SpecialArme = new Armes("Arbalète explosive", 1, 30, "Dégats de zones", Enums.Rarity.LENGENDAIRE, 6,1);
        this.competencePassive = "Survie dans un millieux hosile";
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
    @Override
    public String GetCompetencePassive() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'GetCompetencePassive'");
    }
}
