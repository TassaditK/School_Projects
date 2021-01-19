public class TryLinkedList {
    static void printIntList(LinkedIntList l) {
        Cell current = l.getHead();
        if (current == null) {
            System.out.println("List is empty ! ");
            return;
        }
        System.out.print("[");
        while (current != null) {
            if (current != l.getHead()) {
                System.out.print(",");
            }
            System.out.print(current.getDataCell());
            current = current.getNextCell();
        }
        System.out.print("]");
        System.out.println();
    }

    static int sumIterator(LinkedIntList list) {
        if (list.isEmpty()) return 0;
        IntListIterator iterator = new IntListIterator(list);
        int sum = 0;
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        return sum;
    }

    public static void main(String[] args) {
        LinkedIntList myList = new LinkedIntList();
        myList.cons(3).cons(2).cons(1);
        printIntList(myList);   //[1,2,3]

        System.out.println("sum = " + sumIterator(myList));   //sum = 6

        myList.add(4);
        printIntList(myList);   //[4,1,2,3]

        myList.remove();
        printIntList(myList);   //[1,2,3]

        myList.add(5, 2);
        printIntList(myList);   //[1,5,2,3]

        myList.remove(5, 2);
        printIntList(myList);   //[1,2,3]

        // test Exercice 12:
        LinkedIntList myNewList = myList.getTail();
        printIntList(myList);    //[1,2,3]
        printIntList(myNewList);    //[2,3]
        myNewList.remove();
        printIntList(myNewList);    //[3]
        printIntList(myList);      //[1,2,3]

    }
}
