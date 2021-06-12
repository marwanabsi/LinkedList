
public class LinkedList {
	Node first = null;
	Node last = null;

//	public void InsertLast(Student num) {
//		Node newNode = new Node(num);
//		if (first == null) {
//			first = newNode;
//			last = first; // in this function we insrt data in linked lest at last
//		} else {
//			last.setNext(newNode);
//			last = newNode;
//
//		}
//
//	}

	public void InsertionSorted(Student data) {
		Node newNode = new Node(data);
		if (first == null) {
			first = newNode;
		} else if (data.compareTo(first.getData()) < 0) {
			newNode.setNext(first);
			first = newNode;
		} else {
			Node pre = first;
			Node curr = first.getNext();
			while (curr != null && (data.compareTo(curr.getData()) > 0)) {
				pre = curr;
				curr = curr.getNext();
			}
			newNode.setNext(curr);
			pre.setNext(newNode);
		}

	}

	public void avareg() {
		double count = 0;
		double sum1 = 0;
		double avg1 = 0;
		double count2 = 0;
		double sum2 = 0;
		double avg2 = 0;

		if (first == null)
			return;

		Node curr = first;

		while (curr != null) {

			if (curr.getData().getBranch().trim().equals("Scientific")) {
				sum1 += curr.getData().getAvg();
				count++;
				avg1 = sum1 / count;
			} else {
				sum2 += curr.getData().getAvg();
				count2++;
				avg2 = sum2 / count2;
			}
			curr = curr.getNext();
		}
		if (avg1 != 0.0) {
			System.out.println("Scientific student mean " + avg1);
		}
		if (avg2 != 0.0) {
			System.out.println("Literary student mean " + avg2);
		}
	}

//	public Node Mereg(Node a, Node b, Node s) {
//
//		Node newNode = null;
//
//		if (a == null)
//			return b;
//		if (b == null)
//			return a;
//
//		if (a != null && b != null) {
//			if (a.getData().compareTo(b.getData()) <= 0) {
//				s = a;
//				a = s.getNext();
//			} else {
//				s = b;
//				b = s.getNext();
//
//			}
//		}
//		newNode = s;
//		while (a != null && b != null) {
//			if(a.getData().compareTo(b.getData()) <= 0) {
//				s.setNext(a);
//				s=a;
//				a=s.getNext();
//			}
//			else {
//				s.setNext(b);
//				s=b;
//				b=s.getNext();
//			}
//
//		}
//		if(a==null)
//			s.setNext(b);
//		if(b==null)
//			s.setNext(a);
//
//		return newNode;
//
//	}

	public int delete(Student num) {
		if (first == null)
			return 0;
		if (first.getData().compareTo(num) == 0) {
			first = first.getNext();
			return 1;
		}
		Node pre = first;
		Node curr = first.getNext();

		while (curr != null) {
			if (curr.getData().compareTo(num) == 0) {
				pre.setNext(curr.getNext());
				return 1;
			}
			pre = curr;
			curr = curr.getNext();

		}
		return 0;

	}

	public Node search(Student num) {

		Node curr = first;
		while (curr != null) {
			if (curr.getData().compareTo(num) == 0) {
				System.out.println("We Find the Student : " + curr.getData().toString());
				return curr;
			}
			curr = curr.getNext();

		}

		return curr;

	}

	public void sortListByAvg() {
		Node curr = first;
		Node index = null;
		double temp;

		if (first == null) {
			return;

		} else {
			while (curr != null) {
				index = curr.getNext();
				while (index != null) {

					if (curr.getData().compareToa(index.getData()) > 0) {
						temp = curr.getData().getAvg();
						curr.getData().setAvg(index.getData().getAvg());
						;
						index.getData().setAvg(temp);
					}

					index = index.getNext();
				}
				curr = curr.getNext();
			}
		}
	}

	public Node midelSeatNumber(Node head) {
		Node n, m;
		n = head;
		m = head;

		while (m != null && m.getNext() != null) {
			// System.out.println("######################");
			n = n.getNext();
			m = m.getNext().getNext();

		}
		System.out.println("The Midel Seat Number is = " + n.getData().getSeatNumber());
		return n;

	}

	public int Size() {
		Node curr = first;
		int count = 0;
		while (curr != null) { // Find a linked list data Size using counteer
			count++;
			curr = curr.getNext();
		}
		return count;
	}

	public int searchabove(Student num) {
		int count = 0;
		int size = Size();
		Node curr = first;

		while (curr != null) {
			if (curr.getData().compareToa(num) == 0) {
				while (curr != null) {
					count++;
					curr = curr.getNext();
				}
				System.out.println("The number of students above the grade : " + count);
				System.out.println("the students percentage : " + ((double) count / (double) size));
				return count;
			}
			curr = curr.getNext();
		}

		return count;

	}

	void printReverse(Node head) {
		if (head == null)
			return;

		printReverse(head.getNext());
		System.out.print(head.getData() + "\n");
	}


	public void print() { // and in this function we print data
		Node curr = first;
		while (curr != null) {
			System.out.print(curr.getData());
			curr = curr.getNext();

		}
	}
}
