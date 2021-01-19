
/**
 *  SelectionSortedArrayWithCounting:
 *  classe qui étend la classe ArrayWithCounting en ajoutant une méthode 
 *  réalisant un tri par l'algorithme du tri par sélection.  
 *  
 */
public class SelectionSortedArrayWithCounting extends ArrayWithCounting
{
    /**
     * Constructeur d'objets de classe SelectionSortedArrayWithCounting
     */
    public SelectionSortedArrayWithCounting()
    {
        super(); 
    }
    
    
    /**
     *  MinimumLocation
     *  
     *  retourne l'indice de la case contenant le minimum d'un tableau 
     *  lorsque celui-ci est considéré entre les indices i et longueur du tableau-1 
     */
    public int MinimumLocation(int i)
    {
     int lmin = i; 
     
     for (int l = i+1; l <= this.length()-1 ; l++) {
        if (this.lessthan(l,lmin)) {  
         lmin = l; 
        };
    };
     return lmin; 
    }
    
    
    /**
     *  Swap
     *  
     *  echange le contenu des cases i et j 
     */
    public void Swap(int i, int j)
    {   int temp;
        temp = this.get(j);
        this.set(this.get(i),j);
        this.set(temp,i);
    }
    
    
    /**
     *  SelectionSorting
     *  
     *  réalise le tri par sélection : on recherche le minimum dans la 
     *  portion non triée du tableau et on le place juste après cette 
     *  partie en échangeant avec la place où il se trouvait. 
     *  
     */
    
    public void SelectionSorting()
    {
        int lmin;
        int temp;
        
      for (int i=0 ; i < this.length(); i++){
        // on identifie la position du minimum
        lmin = MinimumLocation(i);
        // on échange les contenus de cases i et lmin
        Swap(lmin,i); 
        }
    }
}
