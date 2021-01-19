
/**
 *  InsertionSortedArraywithCounting:
 *  classe qui étend la classe ArrayWithCounting en ajoutant une méthode 
 *  réalisant un tri par l'algorithme du tri par insertion.  
 */
public class InsertionSortedArrayWithCounting extends ArrayWithCounting
{
    

    /**
     * Constructeur d'objets de classe InsertionSortedArraywithCounting
     */
    public InsertionSortedArrayWithCounting()
    {
        super(); 
    }

    
    
    /**
     *  ShiftArray
     *  
     *  décale d'une case vers la droite le contenu initial du tableau 
     *  à partir de la case i jusqu'à la case j-1 (le contenu écrasé de la 
     *  case j est retourné par la méthode)  
     */
    public int ShiftArray(int i, int j)
    {
     int val = get(j);    
     
     for (int l = j; l > i ; l--) set(get(l-1),l);
        
     return val;
    }  
    

    
    /**
     *  InsertionSorting
     *  
     *  réalise le tri par insertion : pour chaque case, on insère 
     *  le contenu de celle-ci dans la portion déjà triée, à savoir celle 
     *  précédent exactement cette case. 
     *  
     */
    public void InsertionSorting()
    {
     for (int i=1; i<=(this.length()-1); i++)
     { // pour chaque case différente de la première case
       // on insère le contenu de la case i dans la partie 
       // 0..i-1 du tableau déjà trié à la bonne position
              
       // si le tableau n'est pas déjà trié pour la case i
       if (!(lessthan(i-1,i))) {    
           
       // on identifie la position où l'insertion doit se faire     
       int j = 0;
       while (lessthan(j,i)) j++; 
       
       //on décale le tableau entre j et i
       int temp=ShiftArray(j,i);
       
       //on positionne l'élément à insérer
       set(temp,j);
       
    }
         
        } 
       
    }  
}
