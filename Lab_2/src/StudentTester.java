
public class StudentTester {
	 public static void main(String[] args) {

	        Student jim = new Student();


	        CSStudent kim = new CSStudent(120, 20, 24);

	        System.out.println("Jim has " + jim.hoursLeft() + " hours left.");
	        System.out.println("Kim has " + kim.hoursLeft() + " hours left.");
	    }
}
