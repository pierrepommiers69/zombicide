package com.mon.projet.Tools;

import com.mon.projet.Items.Armes;
import com.mon.projet.Items.Objets;

// Couple.java

public class CoupleObjets
{
    private Armes first;
    private Objets second;

    public CoupleObjets(Armes first, Objets second) 
    {
        this.first = first;
        this.second = second;
    }

    public Armes getFirst()
    {
        return first;
    }

    public Objets getSecond()
    {
        return second;
    }
}
