package com.mon.projet;
import java.util.ArrayList;


public class Chemin 
{
    public static final Cases Djisktra(Cases start,  Plateau plateau, Cases end)
    {
        Cases casePlusCourtes = null;
        boolean[] seen = new boolean[100];
        for (int i = 0; i < seen.length; i++)
        {
            seen[i] = false;
        }

        int[] distance = new int[100];
        for (int i = 0; i < seen.length; i++)
        {
            distance[i] = 1;
        }

        distance[start.getID()] = 0;
        ArrayList<Couple> plusCourtChemin = new ArrayList<Couple>();
        Couple newCouple = new Couple(0, start.getID());
        plusCourtChemin.add(newCouple);

        TableauCoupleArrayList[] tabMonChemin = new TableauCoupleArrayList[plateau.getTaille()];
        tabMonChemin[0].Add(newCouple);

        ArrayList<Cases> nodes = new ArrayList<Cases>();
        nodes.add(start);

        boolean endSeen = false;


        while(!nodes.isEmpty() && endSeen == false)
        {
            Couple distanceMin = new Couple(Integer.MAX_VALUE, 0);
            Cases mysmallCase;
            int index = 0;
            for (int i = 0; i < tabMonChemin.length; i++)
            {
                if(tabMonChemin[index].getArrayList().size() == 0 && seen[i] == false)
                {
                    if(distanceMin.getFirst() >= tabMonChemin[i].minCouple().getFirst())
                    {
                        distanceMin = tabMonChemin[i].minCouple();
                        index = i;
                    }
                }               
            }

            mysmallCase = nodes.get(index);
            nodes.remove(index);
            seen[mysmallCase.getID()] = true;
            for (int i = 0; i < mysmallCase.GetVoisin().size(); i++)
            {
                Couple newCouple2 = new Couple(distance[mysmallCase.GetVoisin().get(i).getID()]+distance[mysmallCase.getID()], mysmallCase.getID());
                tabMonChemin[mysmallCase.GetVoisin().get(i).getID()].Add(newCouple2);
                if(!seen[mysmallCase.GetVoisin().get(i).getID()])
                {
                    if(end.getID() == mysmallCase.GetVoisin().get(i).getID())
                    {
                        endSeen = true;
                    }
                    nodes.add(mysmallCase.GetVoisin().get(i));
                }
            } 
        }

        return casePlusCourtes;
    }    
}
