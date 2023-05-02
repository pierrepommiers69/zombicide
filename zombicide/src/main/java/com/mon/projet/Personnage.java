package com.mon.projet;

import java.util.ArrayList;

public  class Personnage 
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


    public Personnage()
    {
        this.jcvd = new JCVD();
        personnagesJouables[0]= this.jcvd.getNom();
        this.robertMcCall = new RobertMcCall();
        personnagesJouables[1]= this.robertMcCall.getNom();
        this.rambo = new RAMBO();
        personnagesJouables[2]= this.rambo.getNom();
        this.bruceLee = new BruceLee();
        personnagesJouables[3]= this.bruceLee.getNom();
        this.johnWick = new JohnWick();
        personnagesJouables[4] = this.johnWick.getNom();
    }
    public int WhoPersonnage(String nom)
    {
        if(nom.equals(this.bruceLee.getNom()))
        {
           return  BRUCELEE;
        }
        else if(nom.equals(this.johnWick.getNom()))
        {
            return JOHNWICK;
        }
        else if(nom.equals(this.rambo.getNom()))
        {
            return RAMBO;
        }
        else if(nom.equals(this.robertMcCall.getNom()))
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
        persoInfos.add(this.bruceLee.getInfo());
        persoInfos.add(this.jcvd.getInfo());
        persoInfos.add(this.johnWick.getInfo());
        persoInfos.add(this.robertMcCall.getInfo());
        persoInfos.add(this.rambo.getInfo());
        return persoInfos;
    }

}
