package week6Practice;

public class ArrayList implements Listable {
	
	//instance vars
	private int size;
	private int[] arr;
	private static final int CAPACITY = 10;
	
	//default constructor
	public ArrayList() {
		this.size = 0;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public int get(int i) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void set(int e, int i) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(int e, int i) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub

	}

	@Override
	public int remove(int i) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return 0;
	}

}
