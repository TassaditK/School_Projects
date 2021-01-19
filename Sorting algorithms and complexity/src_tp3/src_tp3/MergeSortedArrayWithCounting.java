
/**
 * MergeSortedArraywithCounting:
 *  classe qui étend la classe ArrayWithCounting en ajoutant une méthode 
 *  réalisant un tri par l'algorithme du tri fusion.  
 */

public class MergeSortedArrayWithCounting extends ArrayWithCounting
{
   
    /**
     * Constructeur d'objets de classe MergeSortedArraywithCounting
     */
    public MergeSortedArrayWithCounting()
    {
       super(); 
    }
    
    
    /**
     * i,j,k sont ordonnés selon cet ordre
     * fusionne les sous-tableaux triés [i..j] et [j+1..k] en un sous-tableau
     * [i..k] trié. 
     */
    public void Merge(int i, int j, int k)
    {
     int p1 = i;
     int p2 = j+1; 
     int p = 0; 
     
     // definition d'un tableau auxiliaire
     int[] tempArray = new int[k-i+1];
    
     // on fusionne les deux tableaux triés en un tableau auxiliaire triés
     //
     // tant qu'aucun des deux tableaux a été lu complètement 
     while ((p1<=j) && (p2<=k)){
         
         if (this.lessthan(p1,p2)){
             tempArray[p] = this.get(p1);
             p1++; 
            }
            else {
             tempArray[p] = this.get(p2);
             p2++;    
         }; 
         p++;
     }    
     
     // on recopie celui des deux tableaux pour lequel on n'a pas encore 
     // atteint la fin   
     if (p1>j){
        while (p2<=k){
         tempArray[p] = this.get(p2);
         p2++;
         p++; 
        }    
     }   
        
     if (p2>k){
        while (p1<=j){
         tempArray[p] = this.get(p1);
         p1++;
         p++; 
        }    
     }   
       
     // on recopie dans le tableau varArray 
     for (int l = i; l<=k; l++){ 
        this.set(tempArray[l-i],l); 
    }
    
    }   
        
    
    /**
     * i,j sont ordonnés selon cet ordre
     * trie le sous-tableau entre i et j par la méthode du tri fusion
     */
    public void MergeSorting(int i, int j)
    { // si le sous-tableau est de taille 0 ou 1, alors il est trié   
     if (i<j) //le sous-tableau est au moins de taille 2
        {
        int middle = (i+j)/2; 
        MergeSorting(i,middle); // on trie la première moitié 
        MergeSorting(middle+1,j); // on trie la seconde moitié 
        Merge(i,middle,j); // on fusionne les deux sous-tableaux triés. 
     }       
    }
    
    
    /**
     * trie le sous-tableau par la méthode du tri fusion
     */
    public void MergeSorting()
    {
      MergeSorting(0,this.length()-1);  
        
    }       
}
    
    
