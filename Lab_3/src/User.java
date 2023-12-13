
public class User {
	private String name;
	private int salary;
	private String email;
	
	public User() {}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void setSalary(String newSalary) throws NumberFormatException {
		try {
			salary = Integer.parseInt(newSalary);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Invalid salary format. Please enter a valid integer.");
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public String getEmail() {
		return email;
	}
	
	private boolean isValidEmail(String email) {
		return email.contains("@") && email.indexOf("@") == email.lastIndexOf("@") && email.indexOf("@") > 0 && email.indexOf("@") < email.length() - 1;
	}
	
	public String toString() {
		return "Name: " + name + ", Salary: " + salary + ", Email: " + email;
	}

	public void setEmail(String newEmail) throws MalformedEmailAddressException {
		if (isValidEmail(newEmail)) {
			email = newEmail;
		} else {
			throw new MalformedEmailAddressException("Malformed email address. Please enter a valid email address.");
		}	
	}
}
