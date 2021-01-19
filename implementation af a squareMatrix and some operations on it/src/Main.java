import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {
    public static void main(String[] args) throws IOException {


        Writer file1 = new FileWriter("ProductSquareMatrices.dat");
        for (int i = 0; i < 150; i++) {
            squareMatrix A = squareMatrix.createRandomMatrix(i);
            squareMatrix B = squareMatrix.createRandomMatrix(i);
            squareMatrix C = A.product(B);
            int additionsCounter =A.getAdditionsCounter() ;
            int multiplicationsCounter = A.getMultiplicationsCounter();
            int sumOfOperations = additionsCounter +multiplicationsCounter;
            file1.write(additionsCounter + " " + multiplicationsCounter +" "+sumOfOperations+ "\n");
        }
        file1.close();

        Writer file2 = new FileWriter("StrassenProductSquareMatrices.dat");
        for (int i = 0; i < 150; i++) {
            squareMatrix A = squareMatrix.createRandomMatrix(i);
            squareMatrix B = squareMatrix.createRandomMatrix(i);
            A.quickProduct(B);
            int additionsCounter =A.getAdditionsCounter();
            int multiplicationsCounter = A.getMultiplicationsCounter();
            int sumOfOperations = additionsCounter +multiplicationsCounter;
            file2.write(additionsCounter + " " + multiplicationsCounter +" "+sumOfOperations+ "\n");
        }
        file2.close();











    }

    }


