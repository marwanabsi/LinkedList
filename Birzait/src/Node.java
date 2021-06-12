
public class Node {
	private Node next;
	private Student Data;

	public Node(Student data) {

		this.Data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Student getData() {
		return Data;
	}

	public void setData(Student data) {
		Data = data;
	}
	
	
}


