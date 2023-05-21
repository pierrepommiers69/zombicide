package com.mon.projet.Personnages;

import java.util.ArrayList;

import com.mon.projet.Personnage;
import com.mon.projet.Items.Armes;
import com.mon.projet.Items.Enums;
import com.mon.projet.Items.Objets;

public class JCVD extends Personnage
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


    public JCVD() 
    {
        this.nom = "Jean Claude Vendame(=JCDV pour les intimes)";
        this.pointsDeVie = 80;
        this.niveauExperience = 12;
        this.idCases = 0;
        this.pointsAction = 4;
        this.competenceUnique = "Acrobatie mortelle";
        this.SpecialArme = new Armes("Couteau de combat", 0, 30, 
                            "Lorsque Jean-Claude attaque avec son couteau de combat,"+
                            "il peut effectuer une attaque supplémentaire gratuite s'il a éliminé un ennemi avec la première attaque.", 
                            Enums.Rarity.LENGENDAIRE, 6,1);
        this.competencePassive = "Esquive";
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
        personnageInfo[7] = "Description : peut sauter par-dessus les obstacles et les ennemis, infligeant 20 dégâts à tous les ennemis dans la zone d'atterrissage";
        personnageInfo[8] = "competencePassive: " + competencePassive;
        personnageInfo[9] = "Description: peut esquiver l'attaque d'un enemi";
        return personnageInfo;
    }
    @Override
    public String GetCompetencePassive() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'GetCompetencePassive'");
    }
}
