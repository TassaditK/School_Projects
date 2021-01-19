
/**
 *  Complexite_Tableaux.java
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;



public  class complexite_tableaux {

    public static void main(String[] args) throws IOException {


        Writer file1 = new FileWriter("SelectionSortedArrayWithCountingRandom.dat");
        for (int i = 0; i < 1000; i++) {
            SelectionSortedArrayWithCounting tab1 = new SelectionSortedArrayWithCounting();
            tab1.fillwithRandom(i, 20);
            tab1.SelectionSorting();
            int accessCount = tab1.getreadCount() + tab1.getwriteCount();
            int comparisons = tab1.getlessCount() + tab1.getstrictlylessCount();
            file1.write(accessCount + " " + comparisons + "\n");
        }
        file1.close();


        Writer file2 = new FileWriter("InsertionSortedArrayWithCountingRandom.dat");
        for (int i = 0; i < 1000; i++) {
            InsertionSortedArrayWithCounting tab2 = new InsertionSortedArrayWithCounting();
            tab2.fillwithRandom(i, 20);
            tab2.InsertionSorting();
            int accessCount = tab2.getreadCount() + tab2.getwriteCount();
            int comparisons = tab2.getlessCount() + tab2.getstrictlylessCount();
            file2.write(accessCount + " " + comparisons + "\n");
        }
        file2.close();

        Writer file3 = new FileWriter("MergeSortedArrayWithCountingRandom.dat");
        for (int i = 0; i < 1000; i++) {
            MergeSortedArrayWithCounting tab3 = new MergeSortedArrayWithCounting();
            tab3.fillwithRandom(i, 20);
            tab3.MergeSorting();
            int accessCount = tab3.getreadCount() + tab3.getwriteCount();
            int comparisons = tab3.getlessCount() + tab3.getstrictlylessCount();
            file3.write(accessCount + " " + comparisons + "\n");
        }
        file3.close();


        Writer file4 = new FileWriter("SelectionSortedArrayWithCounting.dat");
        for (int i = 1; i < 70000; i=i+10000) {
            SelectionSortedArrayWithCounting tab4 = new SelectionSortedArrayWithCounting();
            tab4.fillwithRandom(i,i);
            tab4.SelectionSorting();

            SelectionSortedArrayWithCounting tab5 = new SelectionSortedArrayWithCounting();
            tab5.fillDescending(i);
            tab5.SelectionSorting();

            SelectionSortedArrayWithCounting tab6 = new SelectionSortedArrayWithCounting();
            tab6.fillAscending(i);
            tab6.SelectionSorting();

            int comparisionRandom = tab4.getlessCount() + tab4.getstrictlylessCount();
            int comparisionDescending = tab5.getlessCount() + tab5.getstrictlylessCount();
            int comparisionAscending = tab6.getlessCount() + tab6.getstrictlylessCount();

            file4.write(comparisionRandom + " " + comparisionDescending + " " + comparisionAscending + "\n");
        }
        file4.close();


        Writer file5 = new FileWriter("InsertionSortedArrayWithCounting.dat");
        for (int i = 1; i < 70000; i=i+10000) {
            InsertionSortedArrayWithCounting tab7=new InsertionSortedArrayWithCounting();
            tab7.fillwithRandom(i,i);
            tab7.InsertionSorting();

            InsertionSortedArrayWithCounting tab8=new InsertionSortedArrayWithCounting();
            tab8.fillDescending(i);
            tab8.InsertionSorting();

            InsertionSortedArrayWithCounting tab9=new InsertionSortedArrayWithCounting();
            tab9.fillAscending(i);
            tab9.InsertionSorting();

            int comparisionRandom = tab7.getlessCount() + tab7.getstrictlylessCount();
            int comparisionDescending = tab8.getlessCount() + tab8.getstrictlylessCount();
            int comparisionAscending = tab9.getlessCount() + tab9.getstrictlylessCount();

            file5.write(comparisionRandom + " " + comparisionDescending + " " + comparisionAscending + "\n");
        }
        file5.close();





        Writer file6 = new FileWriter("MergeSortedArrayWithCounting.dat");
        for (int i = 1; i < 70000; i=i+10000) {
            MergeSortedArrayWithCounting tab10 = new MergeSortedArrayWithCounting();
            tab10.fillwithRandom(i,i);
            tab10.MergeSorting();

            MergeSortedArrayWithCounting tab11 = new MergeSortedArrayWithCounting();
            tab11.fillDescending(i);
            tab11.MergeSorting();

            MergeSortedArrayWithCounting tab12 = new MergeSortedArrayWithCounting();
            tab12.fillAscending(i);
            tab12.MergeSorting();

            int comparisionRandom = tab10.getlessCount() + tab10.getstrictlylessCount();
            int comparisionDescending = tab11.getlessCount() + tab11.getstrictlylessCount();
            int comparisionAscending = tab12.getlessCount() + tab12.getstrictlylessCount();

            file6.write(comparisionRandom + " " + comparisionDescending + " " + comparisionAscending + "\n");
        }
        file6.close();


        Writer file7 = new FileWriter("ComparisionOfSortingAlgorithms.dat");        //Ce fichier contiendras les
        for (int i = 1; i < 70000; i=i+10000) {
            SelectionSortedArrayWithCounting tab13= new SelectionSortedArrayWithCounting();
            tab13.fillwithRandom(i,i);
            tab13.SelectionSorting();

            InsertionSortedArrayWithCounting tab14 = new InsertionSortedArrayWithCounting();
            tab14.fillwithRandom(i,i);
            tab14.InsertionSorting();

            MergeSortedArrayWithCounting tab15 = new MergeSortedArrayWithCounting();
            tab15.fillwithRandom(i,i);
            tab15.MergeSorting();

            int selectionComparision = tab13.getlessCount() + tab13.getstrictlylessCount();
            int InsertionComparision = tab14.getlessCount() + tab14.getstrictlylessCount();
            int MergeComparision = tab15.getlessCount() + tab15.getstrictlylessCount();
            file7.write(selectionComparision + " " + InsertionComparision + " " + MergeComparision + "\n");

        }
        file7.close();



    }







}










    
    
    
   
