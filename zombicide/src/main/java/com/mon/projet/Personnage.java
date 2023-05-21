package com.mon.projet;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.mon.projet.Items.Armes;
import com.mon.projet.Items.Enums;
import com.mon.projet.Items.Objets;
import com.mon.projet.Items.Enums.Rarity;
import com.mon.projet.Personnages.BruceLee;
import com.mon.projet.Personnages.JCVD;
import com.mon.projet.Personnages.JohnWick;
import com.mon.projet.Personnages.RAMBO;
import com.mon.projet.Personnages.RobertMcCall;
import com.mon.projet.PlateauZombicide.Cases;
import com.mon.projet.PlateauZombicide.Plateau;
import com.mon.projet.Tools.Couple;

public abstract class Personnage 
{
    
    private static final int JOHNWICK = 0;
    private static final int RAMBO = 1;
    private static final int McCALL = 2;
    private static final int BRUCELEE = 3;
    private static final int JCVD = 4;

    private static String[] personnagesJouables = new String[5];
    private static JohnWick johnWick = new JohnWick();
    private static JCVD jcvd = new JCVD();
    private static RobertMcCall robertMcCall = new RobertMcCall();
    private static BruceLee bruceLee = new BruceLee();
    private static RAMBO rambo = new RAMBO();

    public abstract String GetNom();
    public abstract Armes GetSpecialeArme();
    public abstract int GetPointsDeVie();
    public abstract String GetCompetencePassive();
    public abstract int GetNiveauExperience();
    public abstract ArrayList<Armes> GetArmes();
    public abstract int GetPointsAction() ;
    public abstract String GetCompetenceUnique();
    public abstract String[] GetInfo();
    public abstract ArrayList<Objets> GetEquipement();
    public abstract void SetLife(Objets objets);
    public abstract int GetPosition();
    public abstract void SetPosition(int x);
   
    


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
    public static Personnage WhoPersonnage(String nom)
    {
        if(nom.equals(bruceLee.GetNom()))
        {
           return bruceLee;
        }
        else if(nom.equals(johnWick.GetNom()))
        {
            return johnWick;
        }
        else if(nom.equals(rambo.GetNom()))
        {
            return rambo;
        }
        else if(nom.equals(robertMcCall.GetNom()))
        {
            return robertMcCall;
        }
        else
        {
            return jcvd;
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

    public int LanceDe()
    { 
        Random random = new Random();
        int randomNumber = random.nextInt(6);
        return randomNumber;
    }

    public boolean Deplacement(Plateau plateau, Cases myCase)
    {
        int indexPersoDansCase = 0;
        Cases myCasePerso = plateau.GetCase(this.GetPosition());
        
        for (int j = 0; j < myCasePerso.GetListSurvivant().size(); j++)
        {
            if(this.GetNom() == myCasePerso.GetListSurvivant().get(j).GetNom())
            {
                indexPersoDansCase = j;
            }                
        }
        if(plateau.OkDirection(myCasePerso, myCase))
        {
            myCasePerso.GetListSurvivant().remove(indexPersoDansCase);
            myCase.GetListSurvivant().add(this);
            this.SetPosition(myCase.getID());
            myCase.setNbBruits(myCase.getNbBruits()+1);

            return true;
        }
        else
        {
            return false;
        }
    }

    public Objets GetObjetsRecherche(Enums.Rarity rarity)
    {
        int random = Plateau.Random(4);
        Objets newObjets = null;
        switch(random)
        {
            case(1):
                newObjets = new Objets(Enums.Objets.SANTE, 50, rarity);
                break;
            case(2):
                newObjets = new Objets(Enums.Objets.PRESICION, 2, rarity);
                break;
            case(3):
                newObjets = new Objets(Enums.Objets.ATTAQUE, 25, rarity);
                break;
            case(4):
                newObjets = new Objets(Enums.Objets.CHANCE, 5, rarity);
                break;
        
        }
        return newObjets;
    }

    public Armes GetArmesRecherche(Enums.Rarity rarity)
    {
        int random = Plateau.Random(4);
        Armes armes = null;
        switch(random)
        {
            case(1):
                armes = new Armes("Fusil de précision", 4, 95, null, rarity, 5, 1);
                break;
            case(2):
                armes = new Armes("Épée enflammée", 0, 50, null, rarity, 6, 4);
                break;
            case(3):
                armes = new Armes("Fusil à pompe", 1, 80, null, rarity, 3, 2);
                break;
            case(4):
                armes = new Armes("Pistolet mitrailleur", 2, 50, null, rarity, 4, 3);
                break;
        
        }

        return armes;
    }
    public void Recherche(Plateau plateau)
    {
        Cases myCases = plateau.GetCase(this.GetPosition());
        Enums.FONCTIONCASE myCaseType = myCases.GetMonType();
        Armes newArmes = null;
        Objets objets = null;
        if(myCaseType == Enums.FONCTIONCASE.BONUS)
        {
            int random = Plateau.Random(3);
            if(random == 2)
            {
                newArmes = GetArmesRecherche(Enums.Rarity.LENGENDAIRE);
                objets = GetObjetsRecherche(Enums.Rarity.LENGENDAIRE);
            }
            else if(random == 1)
            {
                newArmes = GetArmesRecherche(Enums.Rarity.EPIC);
            }
            else
            {
                objets = GetObjetsRecherche(Enums.Rarity.EPIC);
            }
                      
        }
        else if(myCaseType == Enums.FONCTIONCASE.CLAIR)
        {
            int random = Plateau.Random(3);
            if(random == 2)
            {
                newArmes = GetArmesRecherche(Enums.Rarity.COMMUN);
            }
            else if(random == 1)
            {
                objets = GetObjetsRecherche(Enums.Rarity.RARE);
            }       
        }
        if(myCaseType == Enums.FONCTIONCASE.SOMBRE)
        {
            int random = Plateau.Random(2);
            if(random == 2)
            {
                objets = GetObjetsRecherche(Enums.Rarity.EPIC);
            }
            else
            {
                objets = GetObjetsRecherche(Enums.Rarity.COMMUN);
                newArmes = GetArmesRecherche(Enums.Rarity.RARE);
            }            
        }
        myCases.setNbBruits(myCases.getNbBruits()+2);
        this.GetArmes().add(newArmes);
        this.GetEquipement().add(objets);
    }

    public void Attaque(Armes armes, Plateau plateau, Cases caseXY, int chance)
    {
        if(armes.getChance() > chance)
        {
            int nmbAttaque = armes.GetNmbAttque(); 
            while(nmbAttaque > 0)
            {
                Zombie zombieMoinsVie = null;
                int index = 0;
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < caseXY.getListeZombie().size(); i++)
                {
                    if(caseXY.getListeZombie().get(i).getPointsDeVie() < min)
                    {
                        zombieMoinsVie = caseXY.getListeZombie().get(i);
                        index = i;
                    }
                }
                zombieMoinsVie.setPointsDeVie(zombieMoinsVie.getPointsDeVie()-armes.getDegats());
                if(zombieMoinsVie.getPointsDeVie() <= 0)
                {
                    caseXY.getListeZombie().remove(index);
                }
                nmbAttaque--;
            }
        }
        caseXY.setNbBruits(caseXY.getNbBruits()+2);
    }

    public void Equipement(Objets equipement, Armes armes)
    {
        if(equipement.GetMyType() == Enums.Objets.ATTAQUE)
        {
            equipement.AddCombatsArme(armes);
        }
        else if(equipement.GetMyType() == Enums.Objets.SANTE)
        {
            equipement.AddLife(this);
        }
        else if(equipement.GetMyType() == Enums.Objets.PRESICION)
        {
            equipement.AddPrecision(armes);
        }
        else
        {
            equipement.AddChance(armes);
        }
    }

    public void Game(Plateau plateau)
    {
        System.out.println("Lancez le dé");
        int nmbAction = LanceDe();
        System.out.println("Vous avez" + nmbAction + " Actions possible");
        while(nmbAction > 0)
        {
            System.out.println("Choisissez votre action");
            System.out.println("Vous pouvez :");
            System.out.println("    - Deplacer, coûte 1 Action");
            System.out.println("    - Rechercher, coûte 2 Actions");
            System.out.println("    - Attaquer, coûte 2 Actions");
            System.out.println("    - Equiper, coûte 1 Action");
            System.out.println("Il vous reste "+ nmbAction +" Actions");
            System.out.println("Votre choix : ");
            Scanner scanner = new Scanner(System.in);
            String action = scanner.nextLine();

            if(action.charAt(0) == 'D')
            {
                boolean coorectDeplacement = true;
                while(coorectDeplacement)
                {
                    System.out.println("Vous avez choisis de vous deplacer");
                    System.out.println("Ou voulez vous, vous deplacer ?");
                    System.out.println("Vous pouvez vous deplacer : ");
                    ArrayList<Integer> deplacement = new ArrayList<Integer>();
                    for (int i = 0; i < plateau.GetCase(this.GetPosition()).GetVoisin().size(); i++)
                    {
                        System.out.print(plateau.GetCase(this.GetPosition()).GetVoisin().get(i).GetMonType());
                        System.out.println("Type : " + i);
                        deplacement.add(plateau.GetCase(this.GetPosition()).GetVoisin().get(i).getID());
                    }
                    System.out.println("Votre choix  : ");
                    String choix = scanner.nextLine();
                    boolean done = Deplacement(plateau, plateau.GetCase(Integer.parseInt(choix)));
                    if(done)
                    {
                        System.out.println("Bravo! ");
                        coorectDeplacement = false;
                    }
                    else
                    {
                        System.out.println("Vous ne pouvez vous déplacer ici ! Il y a un mur");
                    }
                }
                nmbAction--;
            }
            else if(action.charAt(0) == 'R')
            {
                System.out.println("Vous avez choisis de Rechercher");
                Recherche(plateau);
                nmbAction-=2;
                if(this.GetArmes().size() != 0)
                {
                    String[] info = this.GetArmes().get(this.GetArmes().size()-1).getInfoArme();
                    for (int i = 0; i < info.length; i++) 
                    {
                        System.out.println(info[i]);                        
                    }
                }
                if(this.GetEquipement().size() != 0)
                {
                    String[] info = this.GetEquipement().get(this.GetEquipement().size()-1).getInfoEquipement();
                    for (int i = 0; i < info.length; i++) 
                    {
                        System.out.println(info[i]);                        
                    }
                } 
            }
            else if(action.charAt(0) == 'A')
            {
                System.out.println("Vous avez choisis d attaquer");
                System.out.println("Choisissez votre arme");
                for (int i = 0; i < this.GetArmes().size(); i++)
                {
                    String[] info = this.GetArmes().get(i).getInfoArme();
                    for (int j = 0; j < this.GetArmes().get(i).getInfoArme().length; j++)
                    {
                        System.out.println(info[j]);
                    }
                }
                System.out.println("Votre choix  : ");
                String choix = scanner.nextLine();
                Attaque(this.GetArmes().get(Integer.parseInt(choix)), plateau, null, nmbAction);
                nmbAction-=2;
            }
            else
            {
                System.out.println("Vous avez choisis d equiper");
                System.out.println("Choisissez votre Equipement");
                for (int i = 0; i < this.GetEquipement().size(); i++)
                {
                    String[] info = this.GetEquipement().get(i).getInfoEquipement();
                    for (int j = 0; j < this.GetEquipement().get(i).getInfoEquipement().length; j++)
                    {
                        System.out.println(info[j]);
                    }
                }
                System.out.println("Votre choix  : ");
                String choix = scanner.nextLine();
                String choix2 = "";
                if(this.GetEquipement().get(Integer.parseInt(choix)).GetMyType() != Enums.Objets.SANTE)
                {
                    System.out.println("Sur quel arme voulez vous l'équiper");
                    for (int i = 0; i < this.GetArmes().size(); i++)
                    {
                        String[] info = this.GetArmes().get(i).getInfoArme();
                        for (int j = 0; j < this.GetArmes().get(i).getInfoArme().length; j++)
                        {
                            System.out.println(info[j]);
                        }
                    }
                    System.out.println("Votre choix  : ");
                    choix2 = scanner.nextLine();
                }
                Equipement(this.GetEquipement().get(Integer.parseInt(choix)), this.GetArmes().get(Integer.parseInt(choix2)));
                Cases cases = plateau.GetCase(this.GetPosition());
                cases.setNbBruits(cases.getNbBruits()+4);
                nmbAction--;
            }
        }


    }

    

}
