package com.mon.projet.Personnages;
import java.util.ArrayList;

import com.mon.projet.Personnage;
import com.mon.projet.Items.Armes;
import com.mon.projet.Items.Objets;

public class RobertMcCall extends Personnage
{
    private String nom;
    private int pointsDeVie;
    private int niveauExperience;    
    private ArrayList<Armes> armes = new ArrayList<Armes>();
    private ArrayList<Objets> objets = new ArrayList<Objets>();
    private int idCases;
    private int pointsAction;
    private String competenceUnique;
    private String competencePassive;

    public RobertMcCall() 
    {
        this.nom = "RobertMcCall";
        this.pointsDeVie = 60;
        this.niveauExperience = 12;
        this.idCases = 0;
        this.pointsAction = 5;
        this.competenceUnique = "Architecte Suprême";
        this.competencePassive = "Chronomètre";
    }
    @Override
    public String GetNom() 
    {
        return this.nom;
    }

    @Override
    public Armes GetSpecialeArme() 
    {
        return null;
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
        personnageInfo[4] += "SpecialArme: yen a pas";
        personnageInfo[5] = "pointsAction: " + pointsAction;
        personnageInfo[6] = "competenceUnique: " + competenceUnique;
        personnageInfo[7] = "Description: peut créer des pièges ou des armes improvisées à partir d'objets"+
        " trouvés dans l'environnement";
        personnageInfo[8] = "competencePassive: " + competencePassive;
        personnageInfo[9] = "Description: peut planifier sa stratégie, lui permettant de gagner 2 points d'action supplémentaires pour le tour suivant";
        return personnageInfo;
    }
    @Override
    public String GetCompetencePassive() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'GetCompetencePassive'");
    }
}
