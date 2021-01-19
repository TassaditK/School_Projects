import java.util.NoSuchElementException;

public class LinkedIntList implements IntList{

    private Cell first;

    public LinkedIntList(){
        first = null;
    }

    /**
     * @return la tête (le premier élément) de la liste si elle est non-vide
     */
    @Override
    public Cell getHead() {
        return first;
    }

    /**
     * @return la queue de la liste si elle est non-vide
     */
    @Override
    public LinkedIntList getTail() {
        LinkedIntList newLinkedIntList = new LinkedIntList();
        Cell currentCell=getHead().getNextCell();
        newLinkedIntList.first =currentCell;
        return newLinkedIntList;
    }

    /**
     * @return vrai si la liste est vide et faux sinon
     */
    @Override
    public boolean isEmpty() {
        return first==null;
    }

    /**
     * @param n l’entier à ajouter dans la liste
     * @return la liste à laquelle n est ajoutée
     */
    @Override
    public IntList cons(int n) {
        Cell oldHead = first;
        first = new Cell(n,oldHead);
        return this;

    }

    /**
     * @return la longueur de la liste
     */
    @Override
    public int length() {
       int length = 0;
       Cell currentCell= first;
       while (currentCell != null){
           length++;
           currentCell = currentCell.getNextCell();
       }
       return length;
    }

    /**
     * @return la somme des elments de la liste
     */
    @Override
    public int sum() {
        if(isEmpty())   return 0;
        return getHead().getDataCell()+getTail().sum();
    }

    /**
     * @param intList la liste avec laquelle on fait la comparaison
     * @return vrai si les deux listes sont égales et faux sinon
     */
    @Override
    public boolean equals(IntList intList) {
        if(isEmpty() && intList.isEmpty())  return true;
        if((isEmpty() && !intList.isEmpty()) || (!isEmpty() && intList.isEmpty()) )  return false;
        if(getHead() == intList.getHead() && getTail().equals(intList.getTail()))   return true;
        else return false;
    }

    public IntIterator intIterator(){ return  new IntListIterator(this); }

    /**
     * this method adds an element to the head of the list
     * @param n
     */
    public void add(int n){
        if(first == null){
            first =  new Cell(n,getHead());
        }
        else{
            Cell tempCell = new Cell(n,first);
            tempCell.setNextCell(first);
            first = tempCell;
        }

    }

    /** This method removes the first element of the list
     */
    public void remove(){
        first = first.getNextCell();
    }

    /**This method adds the element n at the given index "position" in the list
     *
     * @param n
     * @param position
     */
    public void add(int n, int position){
        Cell tempCell = getHead();
        int count=1;
        if(position==0){add(n);}
        else{
        while(tempCell != null && ++count != position){
            tempCell = tempCell.getNextCell();
        }
        Cell newCell = new Cell(n);
        newCell.setNextCell(tempCell.getNextCell());
        tempCell.setNextCell(newCell);}
    }

    /** This method removes the element n at the given index "position"
     * @param n
     * @param position
     */
    public void remove(int n , int position) throws NoSuchElementException {
        if(position<1 || position> length())  throw new NoSuchElementException();
        if(position == length()){
            // we are going to delete the last element of the list
            Cell currentCell = getHead();
            while(currentCell.getNextCell()!=null && currentCell.getNextCell().getNextCell() != null){
                currentCell = currentCell.getNextCell();
            }
            currentCell.setNextCell(null);
        }
        else{
            Cell currentCell = getHead();
            int count = 0;
            while( currentCell!= null && ++count != position){
                currentCell = currentCell.getNextCell();
            }
            currentCell.setDataCell(currentCell.getNextCell().getDataCell());
            currentCell.setNextCell(currentCell.getNextCell().getNextCell());
        }
    }




}
