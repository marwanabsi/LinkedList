
public class Student implements Comparable<Student>{

	private int seatNumber;
	private String branch;
	private double avg;
	
	
	
	public Student(int seatNumber, String branch, double avg) {
		super();
		setSeatNumber(seatNumber);
		setBranch(branch);
		setAvg(avg);
	}
	
	
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}


	@Override
	public String toString() {
		return " seatNumber=" + seatNumber + ", branch=" + branch + ", avg=" + avg +"\n";
	}


	@Override
	public int compareTo(Student o) {
		return this.seatNumber - o.getSeatNumber();
	}
	
	public double compareToa(Student a) {
		return this.avg - a.getAvg();
	}
	
	
	
	
}
