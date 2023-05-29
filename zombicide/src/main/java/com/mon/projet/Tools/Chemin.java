package com.mon.projet.Tools;
import java.util.ArrayList;
import java.util.Collections;

import com.mon.projet.PlateauZombicide.Cases;
import com.mon.projet.PlateauZombicide.Plateau;


public class Chemin 
{
    private static Couple plusPetitChemin(ArrayList<ArrayList<Couple>> traiter, boolean[] seen)
    {
        Couple couple = null;
        int mini = Integer.MAX_VALUE;

        for (int index = 0; index < traiter.size(); index++)
        {
            if(seen[index] == false)
            {
                for (int i = 0; i < traiter.get(index).size(); i++)
                {
                    if(mini> traiter.get(index).get(i).getFirst())
                    {
                        couple = new Couple(index, i);
                        mini = traiter.get(index).get(i).getFirst();
                    }
                }
            }
                        
        }
        return couple;      
    }

    private static Couple plusPetitChemin(ArrayList<Couple>traiter)
    {
        Couple couple = null;
        int mini = Integer.MAX_VALUE;

        for (int index = 0; index < traiter.size(); index++)
        {
            
            if(mini> traiter.get(index).getFirst())
            {
                couple = traiter.get(index);
                mini = traiter.get(index).getFirst();
            }
                        
        }
        return couple;      
    }

    public static final ArrayList<Cases> Djisktra(Cases start,  Plateau plateau, Cases end)
    {
        ArrayList<Cases> cheminRapide = new ArrayList<Cases>();
        cheminRapide.add(cheminRapide.size()-1, end);
        boolean[] seen = new boolean[plateau.getPlateau().length];
        for (int i = 0; i < seen.length; i++)
        {
            seen[i] = false;            
        }

        ArrayList<ArrayList<Couple>> allChemin = new ArrayList<ArrayList<Couple>>();
        for (int i = 0; i < seen.length; i++)
        {
            ArrayList<Couple> newCouple = new ArrayList<Couple>();
            allChemin.add(newCouple);            
        }

        Couple couplegenesis = new Couple(start.getID(), 0);
        allChemin.get(0).add(couplegenesis);
        int indexSeen = seen.length; 
        Couple indexCoupleFind = plusPetitChemin(allChemin, seen);
        while(indexSeen > 0 && plateau.GetCase(indexCoupleFind.getFirst()).getID() != end.getID())
        {
            for (int i = 0; i < plateau.GetCase(indexCoupleFind.getFirst()).GetVoisin().size(); i++)
            {
                Couple voisin = new Couple(indexCoupleFind.getFirst(), couplegenesis.getFirst()+1);
                if(seen[plateau.GetCase(indexCoupleFind.getFirst()).GetVoisin().get(i).getID()] == false)
                {
                    allChemin.get(plateau.GetCase(indexCoupleFind.getFirst()).GetVoisin().get(i).getID()).add(voisin);
                }
            }
            seen[indexCoupleFind.getFirst()] = true;
            indexSeen--;
            indexCoupleFind = plusPetitChemin(allChemin, seen);
            couplegenesis = allChemin.get(indexCoupleFind.getFirst()).get(indexCoupleFind.getSecond());    
        }
        for (int i = 0; i < seen.length; i++)
        {
            seen[i] = false;            
        }

        Couple findPere = plusPetitChemin(allChemin.get(end.getID()));

        while(plateau.GetCase(indexCoupleFind.getFirst()).getID() != start.getID())
        {
            cheminRapide.add(plateau.GetCase(findPere.getFirst()));
            int toVisit = findPere.getFirst();
            findPere = plusPetitChemin(allChemin.get(toVisit));
        }
        Collections.reverse(cheminRapide);

        return cheminRapide;
    }    
}
