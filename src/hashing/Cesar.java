package hashing;

import java.util.Scanner;

public class Cesar {
    static char[] alphabet1 = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static String crypt(int n, String sIn)  {
        /* 
         * On convertit le string en un tableau de char
         * On cr�e un tableau Out de m�me taille
         * On prend chaque lettre du string
         * On prend sa position actuelle dans l'alphabet
         * On calcule sa nouvelle position en fonction de n
         * On va chercher dans l'alphabet la lettre correspondant � la nouvelle position
         * On assigne cette lettre dans le tableau de sortie au mm emplacement
         * On transforme le tableau Out en un string   
         */

         char[] charSIn = sIn.toCharArray();
         char[] charSOut = new char[charSIn.length];      
         int pos1, pos2;      
         for(int i = 0; i < charSIn.length; i++)   {
             pos1 = posChar(charSIn[i], alphabet1);    
             pos2 = newPos(pos1, n);    
             if(pos2 == -1) charSOut[i] = ' '; // si -1, c'est que ce n'est pas une lettre, on met un espace � la place    
             else charSOut[i] = alphabet1[pos2];   
         }      
         return new String(charSOut); // on fait un string avec le tableau de char
     }    


    // Renvoie la position du caractere dans le tableau  
    // -1 si il n'est pas dans le tableau  

    private static int posChar(char c, char[] tab)  {
       for(int i = 0; i < tab.length; i++)   { 
           if(tab[i] == c) return i;
       }   return -1; 
    }   

    // Donne la nouvelle position dans l'alphabet en fonction de n  
    private static int newPos(int pos,int n)  {
        int pos2 = pos;
        if(pos <= -1) { // -1 signifie que le caractere n'a pas �t� trouv� dans l'alphabet (caractere sp�cial, chiffre, espace, etc.)
            pos2 = -1;   
        } else {
            int i = 0;
            while(i < abs(n)) {
                if(n < 0) {
                    if(pos2 - 1 == -1) pos2 = 25;
                    else pos2--;
                } else {
                    if(pos2 + 1 >= 25) pos2 = 0;
                    else pos2++;
                }
                i++;
            }
        }
        return pos2;
    }

    // Valeur absolue de a  
    public static int abs(int a)  {
        if(a >= 0) return a;
        else return -a;
    }

    public static void main(String[] args)  {
   	 System.out.println("donner une chaine � crypter");
    	Scanner scanner = new Scanner(System.in);
	    String t = scanner.nextLine();
	    System.out.println("donner la cl� de cryptage");
    	
	    int x = scanner.nextInt();
	       
	    
	    System.out.print("cryptage c�sare cl� "+x+" ");
	    System.out.println(crypt(x,t));
	  
    }
}