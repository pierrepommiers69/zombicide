package com.mon.projet;

import java.util.ArrayList;

public  abstract class Personnage 
{
    
    private static final int JOHNWICK = 0;
    private static final int RAMBO = 1;
    private static final int McCALL = 2;
    private static final int BRUCELEE = 3;
    private static final int JCVD = 4;

    private static String[] personnagesJouables = new String[5];
    private JohnWick johnWick;
    private JCVD jcvd;
    private RobertMcCall robertMcCall;
    private BruceLee bruceLee;
    private RAMBO rambo;

    public abstract String GetNom();
    public abstract Armes GetSpecialeArme();
    public abstract int GetPointsDeVie();
    public abstract String GetCompetencePassive();
    public abstract int GetNiveauExperience();
    public abstract ArrayList<String> GetCompetences();
    public abstract ArrayList<String> GetEquipement();
    public abstract ArrayList<Armes> GetArmes();
    public abstract int GetPositionX(); 
    public abstract int GetPositionY();
    public abstract int GetPointsAction() ;
    public abstract String GetCompetenceUnique();
    public abstract String[] GetInfo(); 
    


    public static Personnage[] PersonnageJouable()
    {
        Personnage[] personnagesJouables =  new Personnage[5];
        JCVD jcvd = new JCVD();
        personnagesJouables[0]= jcvd;
        RobertMcCall robertMcCall = new RobertMcCall();
        personnagesJouables[1]= robertMcCall;
        RAMBO rambo = new RAMBO();
        personnagesJouables[2]= rambo;
        BruceLee bruceLee = new BruceLee();
        personnagesJouables[3]= bruceLee;
        JohnWick johnWick = new JohnWick();
        personnagesJouables[4] = johnWick;
        return personnagesJouables;
    }
    public int WhoPersonnage(String nom)
    {
        if(nom.equals(this.bruceLee.GetNom()))
        {
           return  BRUCELEE;
        }
        else if(nom.equals(this.johnWick.GetNom()))
        {
            return JOHNWICK;
        }
        else if(nom.equals(this.rambo.GetNom()))
        {
            return RAMBO;
        }
        else if(nom.equals(this.robertMcCall.GetNom()))
        {
            return McCALL;
        }
        else
        {
            return JCVD;
        }
    }

    public  String[] GetPersonnageJouable()
    {
        return personnagesJouables;
    }
    
    public ArrayList<String[]> GetInfoPerso()
    {
        ArrayList<String[]> persoInfos = new ArrayList<String[]>();
        persoInfos.add(this.bruceLee.GetInfo());
        persoInfos.add(this.jcvd.GetInfo());
        persoInfos.add(this.johnWick.GetInfo());
        persoInfos.add(this.robertMcCall.GetInfo());
        persoInfos.add(this.rambo.GetInfo());
        return persoInfos;
    }

    

}
