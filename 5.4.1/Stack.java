class ArrayStack implements IStackable{

	ArrayList<Integer> a = new ArrayList<Integer>();

	public void push(int i){
		a.add(i);
	}
	public void pop(){
		a.remove(a.size()-1);
	}
	public int size(){
		return(a.size());
	}
}

class LinkedStack implements IStackable{

	LinkedList<Integer> a = new LinkedList<Integer>();

	public void push(int i){
		a.addLast(i);
	}
	public void pop(){
		a.removeLast(a.size()-1);
	}
	public int size(){
		return(a.size());
	}
}
