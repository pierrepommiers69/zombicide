package com.mon.projet.PlateauZombicide;

import com.mon.projet.Personnage;
import com.mon.projet.Zombie;
import com.mon.projet.Items.Enums;
import com.mon.projet.Tools.Couple;

import java.util.List;
import java.util.ArrayList;


public class Cases
{
    
    private int nbBruits;
    private ArrayList<Personnage> listeSurvivant =new ArrayList<Personnage>();
    private Enums.FONCTIONCASE  fonctionCase;
    private ArrayList<Zombie> listeZombie = new ArrayList<Zombie>();
    private ArrayList<Cases> voisin = new ArrayList<Cases>();
    private int cols;
    private int ligs;
    private int id;
    
    public Cases(int id, int cols, int ligs, int nbBruits, Enums.FONCTIONCASE fonctionCase)
    {
        this.cols = cols;
        this.ligs = ligs;
        this.nbBruits = nbBruits;
        this.fonctionCase= fonctionCase;        
        this.id = id;
    }

    /**
     * Methods just below ! 
     */
    

//Getters et Setters
    public int getID()  
	{
	    return this.id;
	}
	public int getNbBruits()  
	{
	    return nbBruits;
	}
	
	public void setNbBruits(int nbBruits) 
	{
	    this.nbBruits = nbBruits;
	}
    	
	public List<Zombie> getListeZombie() 
	{
	    return listeZombie;
	}
	
	public Enums.FONCTIONCASE GetMonType()
	{
	    return this.fonctionCase;
	}
	    
	public void setMonType(Enums.FONCTIONCASE fonctionCase) 
	{
	    this.fonctionCase = fonctionCase;
	}


    public ArrayList<Personnage> GetListSurvivant()
    {
        return this.listeSurvivant;
    }

    public ArrayList<Cases> GetVoisin() 
    {
        return this.voisin;
    }
    
//savoir contenu de la case
    public void PrintCase()
    {
        System.out.print("|"+this.fonctionCase+"|");
    }

    private boolean IsAnglePlateau(int x, int y)
    {
        boolean bool0 = x == 0 && y == 0;
        boolean bool1 = x == 0 && y == this.ligs-1;
        boolean bool2 = x == this.cols-1 && y == 0;
        boolean bool3 = x == this.cols-1 && y == this.ligs-1;
        return bool0 || bool1 || bool2 || bool3;
    }

    private boolean IsCotePlateau(int x, int y)
    {
        boolean bool0 = x == 0;
        boolean bool1 = y == this.ligs-1;
        boolean bool2 = x == this.cols-1;
        boolean bool3 = y == 0;
        return bool0 || bool1 || bool2 || bool3;
    }

    private void AjoutVoisinAngles(int x, int y, Cases[] plateau)
    {
        if(x == 0 && y == 0)
        {
            this.voisin.add(plateau[x*this.cols+y+1]);
            this.voisin.add(plateau[(x+1)*this.cols+y]);
            this.voisin.add(plateau[(x+1)*this.cols+y+1]);
        }
        else if(x == this.cols-1 && y == 0)
        {
            this.voisin.add(plateau[x*this.cols+y+1]);
            this.voisin.add(plateau[(x-1)*this.cols+y+1]);
            this.voisin.add(plateau[(x-1)*this.cols+y]);
        }
        else if(x == 0 && y == this.ligs-1)
        {
            this.voisin.add(plateau[x*this.cols+y-1]);
            this.voisin.add(plateau[(x+1)*this.cols+y]);
            this.voisin.add(plateau[(x+1)*this.cols+y-1]);            
        }
        else
        {
            this.voisin.add(plateau[x*this.cols+y-1]);
            this.voisin.add(plateau[(x-1)*this.cols+y]);
            this.voisin.add(plateau[(x-1)*this.cols+y-1]);            
        }
    }

    private boolean isBlockVoisin(int x, int y, ArrayList<Couple> block)
    {
        boolean result = false;
        for (int i = 0; i < block.size(); i++)
        {
            if(x == block.get(i).getFirst() && y == block.get(i).getSecond())
            {
                result = true;
                break;
            }            
        }
        return result;

    }

    private void AjoutVoisinCote(int x, int y, Cases[] plateau, ArrayList<Couple> block)
    {
        if(x == 0)
        {
            //format += days < 10 ?  "0"+days+"/" : days+"/"
            boolean _0 = isBlockVoisin(x, y-1, block) ?  this.voisin.add(plateau[(x)*this.cols+y-1]) : false;
            boolean _1 = isBlockVoisin(x, y+1, block) ?  this.voisin.add(plateau[(x)*this.cols+y+1]) : false;
            boolean _2 = isBlockVoisin(x-1, y+1, block) ?  this.voisin.add(plateau[(x-1)*this.cols+y+1]) : false;
            boolean _3 = isBlockVoisin(x+1, y, block) ?  this.voisin.add(plateau[(x+1)*this.cols+y]) : false;
            boolean _4 = isBlockVoisin(x+1, y+1, block) ?  this.voisin.add(plateau[(x+1)*this.cols+y+1]) : false;
        }
        else if(x == this.cols-1)
        {
            boolean _0 = isBlockVoisin(x-1, y-1, block) ?  this.voisin.add(plateau[(x-1)*this.cols+y-1]) : false;
            boolean _1 = isBlockVoisin(x, y+1, block) ?  this.voisin.add(plateau[(x+1)*this.cols+y+1]) : false;
            boolean _2 = isBlockVoisin(x-1, y, block) ?  this.voisin.add(plateau[(x-1)*this.cols+y]) : false;
            boolean _3 = isBlockVoisin(x-1, y-1, block) ?  this.voisin.add(plateau[(x-1)*this.cols+y-1]) : false;
            boolean _4 = isBlockVoisin(x-1, y+1, block) ?  this.voisin.add(plateau[(x-1)*this.cols+y+1]) : false;
        }
        else if(y == this.ligs-1)
        {
            boolean _0 = isBlockVoisin(x-1, y, block) ?  this.voisin.add(plateau[(x-1)*this.cols+y]) : false;
            boolean _1 = isBlockVoisin(x+1, y, block) ?  this.voisin.add(plateau[(x+1)*this.cols+y]) : false;
            boolean _2 = isBlockVoisin(x, y-1, block) ?  this.voisin.add(plateau[(x)*this.cols+y-1]) : false;
            boolean _3 = isBlockVoisin(x-1, y-1, block) ?  this.voisin.add(plateau[(x-1)*this.cols+y-1]) : false;
            boolean _4 = isBlockVoisin(x+1, y-1, block) ?  this.voisin.add(plateau[(x+1)*this.cols+y-1]) : false;            
        }
        else
        {
 
            boolean _0 =  !isBlockVoisin(x-1, y, block) ?  this.voisin.add(plateau[(x-1)*this.cols+y]) : false;
            boolean _1 = !isBlockVoisin(x+1, y, block) ?  this.voisin.add(plateau[(x+1)*this.cols+y]) : false;
            boolean _2 = !isBlockVoisin(x-1, y+1, block) ?  this.voisin.add(plateau[(x-1)*this.cols+y+1]) : false;
            boolean _3 = !isBlockVoisin(x+1, y+1, block) ?  this.voisin.add(plateau[(x+1)*this.cols+y+1]) : false;
            boolean _4 = !isBlockVoisin(x, y+1, block) ?  this.voisin.add(plateau[x*this.cols+y+1]) : false;            
        }
    }

    public void InitVoisin(int x, int y, ArrayList<Couple> block, Cases[] plateau)
    {
        System.out.println("x =  "+x);
        System.out.println("y =  "+ y);

        System.out.println("Is angle "+ IsAnglePlateau(x, y));
        System.out.println("Is "+IsCotePlateau(x, y));
        if(IsAnglePlateau(x, y))
        {
            AjoutVoisinAngles(x, y, plateau);
        }
        else if(IsCotePlateau(x,y))
        {
            AjoutVoisinCote(x, y, plateau, block);
        }
        else
        {
            int[] tabOfVoisinPourX = {-1,0,1,-1,1,-1,0,1};
            int[] tabOfVoisinPourY = {-1,-1,-1,0,0,1,1,1};
            for (int i = 0; i < tabOfVoisinPourY.length; i++)
            {
                boolean _0 = isBlockVoisin(x + tabOfVoisinPourX[i], y + tabOfVoisinPourY[i], block) ?  
                                this.voisin.add(plateau[(x+ tabOfVoisinPourX[i])*this.cols+y + tabOfVoisinPourY[i]]) : false;
            }
        }
    }
}







