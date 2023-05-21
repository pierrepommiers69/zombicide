package com.mon.projet.Tools;

import java.util.ArrayList;

public class TableauCoupleArrayList 
{
    private ArrayList<Couple> myarArrayList = new ArrayList<Couple>();

    public TableauCoupleArrayList(ArrayList<Couple> couple) 
    {
        this.myarArrayList = couple;
    }

    public ArrayList<Couple> getArrayList()
    {
        return this.myarArrayList;
    }

    public void Add(Couple couple)
    {
        this.myarArrayList.add(couple);
    }

    public Couple minCouple()
    {
        Couple distanceMin = new Couple(Integer.MAX_VALUE, 0);
        for (int i = 0; i < myarArrayList.size(); i++)
        {
            if(distanceMin.getFirst() > myarArrayList.get(i).getFirst())
            {
                distanceMin = myarArrayList.get(i);
            }                
        }
        return distanceMin;
    }
}
