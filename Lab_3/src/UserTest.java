import java.util.Scanner;

public class UserTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		User user = new User();
		
		try {
			System.out.print("Enter name: ");
			String name= scanner.nextLine();
			user.setName(name);
			
			System.out.print("Enter salary: ");
			String salaryString = scanner.nextLine();
			user.setSalary(salaryString);
			
			System.out.print("Enter email: ");
			String email = scanner.nextLine();
			user.setEmail(email);
			
			System.out.println("User Information: ");
			System.out.println(user.toString());
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		} catch (MalformedEmailAddressException e) {
			System.out.println(e.getMessage());
		}
	}

}
