package com.mon.projet;

public class Armes
{
   private String nom;
   private int portee;
   private int degats;
   private String regleSpeciale;

   public Armes(String nom, int portee, int degats, String regleSpeciale) 
   {
      this.nom = nom;
      this.portee = portee;
      this.degats = degats;
      this.regleSpeciale = regleSpeciale;
   }

   public String getNom()
   {
      return nom;
   }

   public void setNom(String nom)
   {
      this.nom = nom;
   }

   public int getPortee()
   {
      return portee;
   }

   public void setPortee(int portee)
   {
      this.portee = portee;
   }

   public int getDegats()
   {
      return degats;
   }

   public void setDegats(int degats)
   {
      this.degats = degats;
   }

   public String getRegleSpeciale()
   {
      return regleSpeciale;
   }

   public void setRegleSpeciale(String regleSpeciale)
   {
      this.regleSpeciale = regleSpeciale;
   }

   public String[] getInfoArme()
   {
      String[] armeInfo = new String[4];
      armeInfo[0] = "nom: " + nom;
      armeInfo[1] = "portee: " + portee;
      armeInfo[2] = "degats: " + degats;
      armeInfo[3] = "regleSpeciale: " + regleSpeciale;

      return armeInfo;
   }
}
