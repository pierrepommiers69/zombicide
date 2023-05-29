package com.mon.projet.Items;

import com.mon.projet.Items.Enums.Rarity;

public class Armes
{
   private String nom;
   private int portee;
   private int degats;
   private String regleSpeciale;
   private Rarity rarity;
   private int chance;
   private int nmbAttaque;

   public Armes(String nom, int portee, int degats, String regleSpeciale, Enums.Rarity rarity, int chance, int nmbAttaque) 
   {
      this.nmbAttaque = nmbAttaque;
      this.chance = chance;
      this.rarity = rarity;
      this.nom = nom;
      int bonusAttaque = 0;
      int bonusDistance = 0;
      if(this.rarity == Enums.Rarity.LENGENDAIRE)
      {
         bonusAttaque += degats;
         bonusDistance += portee;
      }
      else if(this.rarity == Enums.Rarity.EPIC)
      {
         bonusAttaque += degats/2;
         bonusDistance += portee/2;
      }
      else
      {
         bonusAttaque += degats/4;
         bonusDistance += portee/4;
      }
      this.portee = portee + bonusDistance;
      this.degats = degats + bonusAttaque;
      this.regleSpeciale = regleSpeciale;
   }

   public int GetNmbAttque()
   {
      return this.nmbAttaque;
   }

   public String getNom()
   {
      return nom;
   }
   public int getChance()
   {
      return this.chance;
   }
   public Rarity getRarity()
   {
      return this.rarity;
   }

   public int getPortee()
   {
      return portee;
   }

   public void setPortee(Objets objets)
   {
      this.portee += objets.GetPrecision();
   }

   public int getDegats()
   {
      return degats;
   }

   public void setDegats(Objets objets)
   {
      this.degats += objets.GetAttaque();
   }

   public String getRegleSpeciale()
   {
      return regleSpeciale;
   }

   public void setRegleSpeciale(String regleSpeciale)
   {
      this.regleSpeciale = regleSpeciale;
   }

   public int GetChance()
   {
      return this.chance;
   }

   public void setChance(Objets chance)
   {
      this.chance += chance.GetChance();
   }

   public String[] getInfoArme()
   {
      String[] armeInfo = new String[5];
      armeInfo[0] = "nom: " + nom;
      armeInfo[1] = "portee: " + portee;
      armeInfo[2] = "degats: " + degats;
      armeInfo[3] = "regleSpeciale: " + regleSpeciale;
      armeInfo[4] = "Rarete: " + this.rarity;

      return armeInfo;
   }
}
