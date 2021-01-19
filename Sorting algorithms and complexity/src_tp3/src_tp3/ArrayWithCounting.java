import java.util.Random;
import java.util.Arrays;

/**
 * ArraywithCounting:
 *  classe qui définit une version d'Array avec de nouveaux accesseurs 
 *  comptant chacune des utilisations 
 *  Elle définit également les comparateurs entre deux cases 
 *  comptant chacune des utilisations
 */
public class ArrayWithCounting {
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int varArray[];
    private int readCount;
    private int writeCount; 
    private int lessCount;
    private int strictlylessCount;
    

    /**
     * Constructeur d'objets de classe ArrayWithCounting
     */
    public ArrayWithCounting()
    {
        // initialisation des variables d'instance
        readCount = 0;
        writeCount = 0; 
        lessCount = 0;
        strictlylessCount = 0; 
    }

    /**
     * accesseur nombre de lectures
     */
    public int getreadCount()
    {
        return this.readCount;
    }

    /**
     * accesseur nombre d'écritures
     */
    public int getwriteCount() {
        return this.writeCount;
    }

    
    /**
     * accesseur nombre de comparaisons
     */
    public int getlessCount()
    {
        return this.lessCount;
    }
    
    /**
     * accesseur nombre de comparaisons strictes
     */
    public int getstrictlylessCount()
    {
        return this.strictlylessCount;
    }
    
    /**
     * rempli un tableau de taille t avec des 0
     */
    public void fillwithZero(int t)
    {
     this.varArray = new int[t];
        
     for (int l=0; l<=(t-1); l++){ 
        varArray[l]=0; 
        } 
    }
    
    /**
     * rempli de manière croissante un tableau de taille t avec les entiers 
     * allant de 0 à t-1
     */
    public void fillAscending(int t)
    {
     this.varArray = new int[t];
        
     for (int l=0; l<=(t-1); l++){ 
        varArray[l]=l; 
        } 
    }
    
    
    /**
     * rempli de manière décroissante un tableau de taille t avec les entiers 
     * allant de t-1 à 0
     */
    public void fillDescending(int t)
    {
     this.varArray = new int[t];
        
     for (int l=0; l<=(t-1); l++){ 
        varArray[l]=(t-1)-l; 
        } 
    }
    
    
    /**
     * rempli un tableau de taille t avec des entiers aléatoires compris 
     * au sens large entre 0 et j-1
     */
    public void fillwithRandom(int t, int j)
    {
     this.varArray = new int[t];
        
     Random r = new Random();
        
     for (int l=0; l<=(t-1); l++){
        int d = r.nextInt(j); 
        varArray[l]=d; 
        } 
    }
    
    
   
    /**
     * méthode de conversion en chaine
     */
    public String toString()
    {
        String s="["; 
        if (varArray.length != 0) s=s+String.valueOf(varArray[0]);
        
        for (int i=1; i<varArray.length;i++)
        {
          s=s+","+String.valueOf(varArray[i]);  
        }
        s=s+"]"; 
        return s;
    }
    
    /**
     * longueur du tableau 
     */
    public int length()
    {
        return this.varArray.length;
    }
    
    
    /**
     * lecture comptabilisée d'une case du tableau
     */
    public int get (int pos)
    {
        this.readCount++;
        return varArray[pos];
    }
    
    
    /**
     * écriture comptabilisée d'une case du tableau
     */
    public void set (int data,int pos)
    {
        this.writeCount++;
        varArray[pos]=data;
    }
    
    
    /**
     * Comparaison au sens large <= comptabilisée  des cases i et j 
     */
    public boolean lessthan (int i,int j)
    {
        this.readCount= this.readCount + 2;
        this.lessCount++;
        return (varArray[i]<=varArray[j]);
    }
    
    
    /**
     * Comparaison au sens strict < comptabilisée  des cases i et j 
     */
    public boolean strictlylessthan (int i,int j)
    {
        this.readCount= this.readCount + 2;
        this.strictlylessCount++;
        return (varArray[i]<varArray[j]);
    }
    
}
