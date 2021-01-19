import java.util.NoSuchElementException;

public class IntListIterator implements IntIterator {
    private Cell node;
    private Cell previousNode;
    private LinkedIntList linkedIntList;

    public IntListIterator(LinkedIntList linkedIntList){
        this.linkedIntList= linkedIntList;
    }


    @Override
    public int next() throws NoSuchElementException {
        if(! this.hasNext())    throw new  NoSuchElementException();
        if(this.node == null){
            this.node= linkedIntList.getHead();
        }
        else{
            previousNode = node;
            node = node.getNextCell();
        }
        return node.getDataCell();
    }

    @Override
    public boolean hasNext() throws  NoSuchElementException{
       if(linkedIntList.isEmpty())  return false;
       if(node == null) return true;
       else{
           return node.getNextCell() != null;
       }

    }

}
