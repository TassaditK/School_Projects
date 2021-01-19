import java.util.ArrayList;
import java.util.Iterator;

public class TestMyArrayList {
    public static void main(String[] args) {
		TestMyArrayList test = new TestMyArrayList();


		System.out.print("testIsEmpty1 : ");
		if (test.testIsEmpty1() == true)
			System.out.println("correct");
		else
			System.out.println("incorrect");

		System.out.print("testIsEmpty2 : ");
		if (test.testIsEmpty2() == true)
			System.out.println("correct");
		else
			System.out.println("incorrect");

		System.out.print("testGet() : ");
		if (test.testGet() == true)
			System.out.println("correct");
		else System.out.println("Incorrect");
		System.out.print("testToString : ");
		if (test.testToString() == true)
			System.out.println("correct");
		else
			System.out.println("Incorrect");
		System.out.print("testAdd1 : ");
		if (test.testAdd1() == true)
			System.out.println("correct");
		else
			System.out.println("incorrect");
		System.out.print("testEnsureCapacity : ");
		if(test.testEnsureCapacity() == true)
			System.out.println("correct");
		else
			System.out.println("incorrect");
		System.out.print("testSet : ");
		if(test.testSet() == true)
			System.out.println("correct");
		else
			System.out.println("incorrect");
		System.out.print("testAdd2 : ");
		if (test.testAdd2() == true)
			System.out.println("correct");
		else
			System.out.println("incorrect");
		System.out.print("testContains :");
		if(test.testContains() == true)
			System.out.println("correct");
		else
			System.out.println("incorrect");
		System.out.print("testIndexOf : ");
		if(test.testIndexOf() == true)
			System.out.println("correct");
		else
			System.out.println("incorrect");
		System.out.print("testLastIndexOf : ");
		if(test.testLastIndexOf() == true)
			System.out.println("correct");
		else
			System.out.println("incorrect");
		System.out.print("testRemove1 : ");
		if(test.testRemove1() == true)
			System.out.println("correct");
		else
			System.out.println("incorrect");
		System.out.print("testRemove2 : ");
		if(test.testRemove2() == true)
			System.out.println("correct");
		else
			System.out.println("incorrect");
		System.out.print("testClear : ");
		if (test.testClear() == true)
			System.out.println("correct");
		else
			System.out.println("incorrect");
		System.out.print("testToArray : ");
		if (test.testToArray()== true)
			System.out.println("correct");
		else
			System.out.println("incorrect");
		System.out.print("testIterator :");
		if(test.testIterator() == true)
			System.out.println("correct");
		else
			System.out.println("incorrect");
    }

    public boolean testIsEmpty1(){
	MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
	if(myArrayList.isEmpty() == true)
	    return true;
	else
	    return false;
    }
    
    public boolean testIsEmpty2(){
	MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
	myArrayList.add(1);
	if(myArrayList.isEmpty() == false)
	    return true;
	else
	    return false;

}

    public boolean testAdd1(){
	MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
	myArrayList.add(1);
	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	arrayList.add(1);
	if(arrayList.toString().equals(myArrayList.toString()))
	    return true;
	else
	    return false;
    }

    public boolean testGet(){
		MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
		myArrayList.add(1);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		if(arrayList.get(0).equals(myArrayList.get(0))){
			return true;
		}
		return false;
	}

	public boolean testToString(){
		MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
		myArrayList.add(1);
		myArrayList.add(2);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		if(arrayList.toString().equals(myArrayList.toString())){
			return true;
		}
		return false;
	}

	public boolean testEnsureCapacity(){
		MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
		myArrayList.add(1);
		myArrayList.ensureCapacity(20);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.ensureCapacity(20);
		if(arrayList.size() == myArrayList.size()){
			return true;
		}
		return false;

    }

    public boolean testSet(){
		MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
		myArrayList.add(1);
		myArrayList.add(2);
		myArrayList.set(0,3);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.set(0,3);
		if(arrayList.equals(myArrayList)){
			return true;
		}
		return false;
	}

	public boolean testAdd2(){
		MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
		myArrayList.add(1);
		myArrayList.add(1,2);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(1,2);
		if(arrayList.equals(myArrayList)){
			return true;
		}
		return false;

	}

	public boolean testContains(){
		MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
		myArrayList.add(1);
		myArrayList.add(2);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
	    if(arrayList.contains(2) == myArrayList.contains(2)){
	    	return true;
		}
	    return false;
	}

	public boolean testIndexOf(){
		MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
		myArrayList.add(1);


		if(myArrayList.indexOf(1) == 0 && myArrayList.indexOf(2)== -1){
			return true;
		}
		return false;
	}

	public boolean testLastIndexOf(){
		MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
		myArrayList.add(1);
		myArrayList.add(2);
		myArrayList.add(1);
		myArrayList.add(3);


		if(myArrayList.lastIndexOf(1) == 2 && myArrayList.lastIndexOf(4)==-1){
			return true;
		}
		return false;
	}

	public boolean testRemove1(){
		MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
		myArrayList.add(1);
		myArrayList.add(2);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);

		if(arrayList.remove(arrayList.get(1)) == myArrayList.remove(myArrayList.get(1))){
			return true;
		}
		return false;
	}

	public boolean testRemove2(){
		MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
		myArrayList.add(1);
		myArrayList.add(2);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);

		arrayList.remove(1);
		myArrayList.remove(1);
		if(arrayList.equals(myArrayList)){
			return true;
		}
		return false;
	}

	public boolean testClear(){
		MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
		myArrayList.add(1);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);

		myArrayList.clear();
		arrayList.clear();
		if(arrayList.equals(myArrayList)){
			return true	;
		}
		return false;
	}

	public boolean testToArray(){
		MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
		myArrayList.add(1);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);

		myArrayList.toArray();
		arrayList.toArray();

		if(arrayList.equals(myArrayList)){
			return true;
		}
		return false;
	}

	public boolean testIterator(){
		MyArrayList<Integer> myArrayList = new MyArrayList<Integer>();
		myArrayList.add(1);
		myArrayList.add(2);
		myArrayList.add(3);
		Iterator iterator = myArrayList.iterator();
		int index =0;
		while(iterator.hasNext()){
			if(iterator.next().equals(myArrayList.get(index))){
				index++ ;
			}
			else
				return false;
		}
		return true;

	}







}
