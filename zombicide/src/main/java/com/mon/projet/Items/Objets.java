package com.mon.projet.Items;

import com.mon.projet.Personnage;

public class Objets
{
    private Enums.Objets myType;
    private Enums.Rarity rarity;
    private int soin;
    private int chance;
    private int attaque;
    private int precision;

    public Objets(Enums.Objets myType, int pouvoir, Enums.Rarity rarity)
    {
        this.myType = myType;
        this.rarity = rarity;
        int bonus = 0;
        if(this.rarity == Enums.Rarity.LENGENDAIRE)
        {
            bonus += pouvoir;
        }
        else if(this.rarity == Enums.Rarity.EPIC)
        {
            bonus += pouvoir/2;
        }
        else
        {
            bonus += pouvoir/4;
        }
        if(myType == Enums.Objets.ATTAQUE)
        {
            this.attaque = pouvoir + bonus;
        }
        else if(myType == Enums.Objets.CHANCE)
        {
            this.chance = pouvoir + bonus;
        }
        else if(myType == Enums.Objets.SANTE)
        {
            this.soin = pouvoir + bonus ; 
        }
        else
        {
            this.precision = pouvoir + bonus;
        }
    }

    public Enums.Objets GetMyType()
    {
        return this.myType;
    }

    public Enums.Rarity GetRarity()
    {
        return this.rarity;
    }

    public int GetSoin()
    {
        return this.soin;
    }

    public int GetChance()
    {
        return this.chance;
    }

    public int GetAttaque()
    {
        return this.attaque;
    }

    public int GetPrecision()
    {
        return this.precision;
    }

    public void AddLife(Personnage personnage)
    {
        personnage.SetLife(this);
    }

    public void AddCombatsArme(Armes armes)
    {
        armes.setDegats(this);
        armes.setPortee(this);
    }

    public void AddChance(Armes armes)
    {
        armes.setChance(this);
    }

    public void AddPrecision(Armes armes)
    {
        armes.setPortee(this);
    }

    public String[] getInfoEquipement()
    {
        String[] armeInfo = new String[5];
        armeInfo[0] = "type: " + this.myType;
        armeInfo[1] = "soin: " + this.soin;
        armeInfo[2] = "attaque: " + this.attaque;
        armeInfo[3] = "chance: " + this.chance;
        armeInfo[4] = "precision: " + this.precision;
        return armeInfo;
    }
}

