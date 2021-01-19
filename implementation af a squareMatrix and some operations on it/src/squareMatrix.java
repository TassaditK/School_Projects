import java.util.Random;

public class squareMatrix {
    private int dimension;
    private int[][] matrix;
    public  int additionsCounter;
    public   int multiplicationsCounter;

    public squareMatrix(int dimension ){
        this.dimension = dimension;
        this.matrix = new int[dimension][dimension];
    }

    public int getMatrixDimension() {
        return dimension;
    }
    public int get(int row,int column){
        return matrix[row][column] ;
    }
    public int getAdditionsCounter(){return additionsCounter;}
    public int getMultiplicationsCounter(){return  multiplicationsCounter;}
    public void set(int row, int column, int value){
        matrix[row][column] = value;
    }

    public squareMatrix getSubMatrix(int firstRow , int firstColumn,int dimension) {
        squareMatrix subMatrix = new squareMatrix(dimension);
        for (int i = 0; i <subMatrix.dimension ; i++) {
            for (int j = 0; j <subMatrix.dimension ; j++) {
                subMatrix.set(i,j,get(i+firstRow,j+firstColumn));
            }
        }
        return subMatrix;
    }


    public squareMatrix sum(squareMatrix matrix){
        squareMatrix result =new squareMatrix(matrix.getMatrixDimension());
        for (int i = 0; i <this.dimension ; i++) {
            for (int j = 0; j <this.dimension ; j++) {
                int v= get(i,j);
                result.set(i,j,v+matrix.get(i,j));
               additionsCounter++;
            }
        }
        return result;
    }
    public squareMatrix subtract(squareMatrix matrix) {
        squareMatrix result =new squareMatrix(matrix.getMatrixDimension());
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                int v = get(i, j);
                result.set(i, j, v - matrix.get(i, j));
                additionsCounter++;
            }
        }
        return result;
    }
    public squareMatrix product (squareMatrix matrix){

        squareMatrix result = new squareMatrix(dimension);
        for(int i = 0; i <dimension; i++) {
            for(int j = 0; j <matrix.dimension; j++) {
                int s = 0;
                for(int k = 0; k <dimension; k++) {
                    s = s + (get(i, k) * matrix.get(k, j));
                    additionsCounter++;
                    multiplicationsCounter++;
                }
                result.set(i,j,  s);
            }
        }
        return result;
    }
    public static squareMatrix identity(int dimension){
        squareMatrix c = new squareMatrix(dimension);

        for(int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (i == j ) {
                    c.set(i,j,1);
                }
                else{c.set(i,j,0);}
            }
        }
        return c;
    }

    public squareMatrix power(int n){
        if (n==0){
            return identity(dimension);
        }
        return product(power(n-1));
    }


    public squareMatrix quickPower(int n){
        squareMatrix result = new squareMatrix(dimension);
        if(n==0){
            result = identity(dimension);
        }
        if(n%2 == 0){
            result = product(this).power(n/2);
        }
        if(n%2 !=0){
            result = product(product(this).power((n-1)/2));
        }
        return result;
    }

    public  squareMatrix quickProduct( squareMatrix matrix){
        squareMatrix result = new squareMatrix(dimension);
        int n = dimension;

        /** initialize the new matrices  **/


        squareMatrix a = new squareMatrix(n/2);
        squareMatrix b = new squareMatrix(n/2);
        squareMatrix c = new squareMatrix(n/2);
        squareMatrix d = new squareMatrix(n/2);




        squareMatrix e = new squareMatrix(n/2);
        squareMatrix f = new squareMatrix(n/2);
        squareMatrix g = new squareMatrix(n/2);
        squareMatrix h = new squareMatrix(n/2);



        /**divide "this" matrix  into 4 parts**/
        a= getSubMatrix(0,0,a.getMatrixDimension());
        b=getSubMatrix(0,n/2,b.getMatrixDimension());
        c=getSubMatrix(n/2,0,c.getMatrixDimension());
        d =getSubMatrix(n/2,n/2,d.getMatrixDimension());




        /**divide the matrix "matrix"  into 4 parts**/
        e= matrix.getSubMatrix(0,0,e.dimension);
        f=matrix.getSubMatrix(0,n/2,f.dimension);
        g=matrix.getSubMatrix(n/2,0,g.dimension);
        h = matrix.getSubMatrix(n/2,n/2,h.dimension);



        /**
         m1 = (a + d)(e + h)
         m2 = (c + d)e
         m3 = a(f - h)
         m4 = d(g - e)
         m5 = (a + b)h
         m6 = (c - a) (e + f)
         m7 = (b - d) (g + h)
         **/

        squareMatrix m1=(a.sum(d)).product(e.sum(h));
        additionsCounter += a.getAdditionsCounter();
        multiplicationsCounter += a.getMultiplicationsCounter();

        squareMatrix m2 =(c.sum(d)).product(e);
        additionsCounter += c.getAdditionsCounter();
        multiplicationsCounter += c.getMultiplicationsCounter();

        squareMatrix m3= a.product(f.subtract(h));
        additionsCounter += a.getAdditionsCounter();
        multiplicationsCounter += a.getMultiplicationsCounter();

        squareMatrix m4 =d.product(g.subtract(e));
        additionsCounter += d.getAdditionsCounter();
        multiplicationsCounter += d.getMultiplicationsCounter();

        squareMatrix m5 =(a.sum(b)).product(h);
        additionsCounter += a.getAdditionsCounter();
        multiplicationsCounter += a.getMultiplicationsCounter();


        squareMatrix m6 =(c.subtract(a)).product((e.sum(f)));
        additionsCounter += c.getAdditionsCounter();
        multiplicationsCounter += c.getMultiplicationsCounter();


        squareMatrix m7 = (b.subtract(d)).product((g.sum(h)));
        additionsCounter += b.getAdditionsCounter();
        multiplicationsCounter += b.getMultiplicationsCounter();


        /**
         ae + bg = m1 + m4 - m5 + m7
         af + ah = m3 + m5
         ce + dg = m2 + m4
         cf + dh = m1 - m2 + m3 +m6
       **/
        squareMatrix r = ((m1.sum(m4)).subtract(m5)).sum(m7);
        squareMatrix s = m3.sum(m5);
        squareMatrix t = m2.sum(m4);
        squareMatrix u= ((m1.subtract(m2)).sum(m3)).sum(m6);
        additionsCounter += r.getAdditionsCounter() + s.getAdditionsCounter() +t.getAdditionsCounter() + u.getAdditionsCounter();





        /** here I will put all the matrices r, s, t and u in result **/
        copySubMatrix(r,result,0,0);
        copySubMatrix(s,result,0,n/2);
        copySubMatrix(t,result,n/2,0);
        copySubMatrix(u,result,n/2,n/2);


        /** if we have matrices of odd dimension, we transform them into matrices of even dimension with the following code
         * then we put the sub matrix of odd dimension in result
         * even case dimension = 1 is included here
         */
        if ((this.getMatrixDimension() % 2 !=0) && (matrix.getMatrixDimension() % 2 !=0)) {
            int rows = getMatrixDimension();
            int cols = getMatrixDimension();

            squareMatrix matrix1 = new squareMatrix(getMatrixDimension()+1);
            squareMatrix matrix2= new squareMatrix(getMatrixDimension()+1);

            for(int i=0;i< matrix1.getMatrixDimension();i++) {
                for(int j=0;j<matrix1.getMatrixDimension();j++) {
                    if(j<cols && i<rows) {
                        matrix1.set(i,j,this.get(i,j));
                        matrix2.set(i,j,matrix.get(i,j));
                    } else {
                        matrix1.set(i,j,0);
                        matrix1.set(matrix1.getMatrixDimension()-1,matrix1.getMatrixDimension()-1,1);
                        matrix2.set(i,j,0);
                        matrix2.set(matrix2.getMatrixDimension()-1,matrix2.getMatrixDimension()-1,1);

                    }
                }
            }
            result = matrix1.quickProduct(matrix2).getSubMatrix(0,0,getMatrixDimension());
        }

        return result;
    }

    public squareMatrix veryQuickPower(int n){
        squareMatrix result = new squareMatrix(dimension);
        if(n==0){
            result = identity(dimension);
        }
        if(n%2 == 0){
            result = quickProduct(this).power(n/2);
        }
        if(n%2 !=0){
            result = quickProduct(quickProduct(this).power((n-1)/2));
        }
        return result;
    }

    public static squareMatrix createRandomMatrix(int dimension){
        squareMatrix randomMatrix = new squareMatrix(dimension);
        Random random =new Random();
        for(int i=0;i<dimension;i++) {
            for (int j = 0; j < dimension; j++) {
                randomMatrix.set(i, j, random.nextInt(10));
            }
        }
        return randomMatrix;
    }

    public void veryQuickProduct(squareMatrix matrix){
        if(matrix.getMatrixDimension()<50){
           this.product(matrix);
        }
        this.quickProduct(matrix);
    }


    /** This method displays a matrix  **/
    public void printMatrix(){
        int v;
        for(int i = 0; i <dimension; i++) {
            System.out.format("[");
            for(int j = 0; j < dimension; j++) {
                if(j>0)
                    System.out.format(" ");
                v = get(i, j);
                System.out.print(v);
            }
            System.out.format("]\n");
        }
    }

     /** This method copies the content of a matrix into another **/
    public static void copySubMatrix(squareMatrix C, squareMatrix P, int iB, int jB)
    {
        for(int i1 = 0, i2 = iB; i1 < C.getMatrixDimension(); i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.getMatrixDimension(); j1++, j2++)
                P.set(i2,j2,C.get(i1,j1));
    }








}
