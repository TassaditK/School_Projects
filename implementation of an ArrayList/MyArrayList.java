import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements List<T> {
    private int size;
    private int capacity;
    private T[] List;


    @SuppressWarnings("unchecked")
    public MyArrayList(int capacity){
        if(capacity < 0) throw new IllegalArgumentException("Le nombre d'éléments doit être positif , Erreur : "+capacity);
        this.List = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;

    }

    public MyArrayList(){
      this(10);
    }


    @Override
    public boolean  add(T element) {
        ensureCapacity(size+1);
        if(size >= capacity){
            return false;
        }
       List[size] = element;
       size++;
       return true;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return (size() == 0) ? true : false;
    }


    @Override
    public T get(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index >size() ){
            throw new IndexOutOfBoundsException();
        }
	    return List[index];
    }


    @Override
    public Iterator iterator() {
	    return  new ArrayIterator(this);

    }
    
    
    @Override
    public T remove(int index) {
        for(int i=0 ; i<size();i++){
            if(i==index){
                //on décale à gauche tous les élements qui se situent apès l'element o
                System.arraycopy(List,index+1, List,index,size-index-1);
                size--;
            }
        }
        return (T) List;
    }

    
    @Override
    public boolean contains(Object o) {
	     for(Object object : List){
	         if (object.equals(o)){
	            return true;
             }
         }
	     return false;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        if(!this.isEmpty()) {
            builder.append("[");
            builder.append(this.get(0));
            for (int index = 1; index <size() ; index++) {
                    builder.append(", ");
                  builder.append(this.get(index));

            }

            builder.append("]");
        }

	return builder.toString();
    }


    // this method makes sure that the table has enough places for "capacity" elements
    public void ensureCapacity(int capacity){
        if( capacity > this.capacity){
            this.capacity = capacity;
            T[] tempList = (T[]) new Object[capacity*2];
            for (int i = 0; i <this.size ; i++) {
                tempList[i] = List[i];
            }
            List=tempList;
        }
    }

    @Override
    public Object[] toArray() {
	    Object[] newArray = new Object[size];
	    System.arraycopy(List,0,newArray,0,size);
	    return newArray;
    }

    @Override
    public boolean remove(Object o) {
        for(int index=0 ; index<size();index++){
            if(List[index].equals(o)){
                //on décale à gauche tous les élements qui se situent apès l'element o
                System.arraycopy(List,index+1, List,index,size-index-1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            List[i]=null;
        }
        size=0;

    }

    @Override
    public Object set(int i, Object o) {
        if(i>= size()){
            throw new IndexOutOfBoundsException();
        }
        Object oldValue = List[i];
        List[i]= (T) o;
        return oldValue;
    }

    @Override
    public void add(int i, Object o) {
        ensureCapacity(size+1);
        List[i] = (T) o;
        size++;

    }

    @Override
    public int indexOf(Object o) {
        for(int index=0; index <size ; index++){
            if (List[index].equals(o)){
                return index;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int index=size()-1;index >=0;index-- ){
            if(List[index].equals(o)){
                return index;
            }
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int i) {
        return null;
    }

    @Override
    public List subList(int i, int i1) {
        return null;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof List<?>)) {
            return false;
        }
        List<?> other = (List<?>) obj;
        // TODO: check whether this and other are equal.
        if(other.equals(this)){
            return true;
        }
        return false;
    }
}
