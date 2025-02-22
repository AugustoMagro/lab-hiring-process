package Hiring;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class HiringProcess {
	public static void main(String[] args) {
		selectCadidates();
	}
	static void selectCadidates() {
		String [] candidates = {"Jonh", "Arthur", "Bob", "Eva"};
		for (String candidate: candidates) {
			double baseSalary = 2000.0;
			double intendedSalary = salaryGoal();
			System.out.println(candidate + " intended salary is $ " + intendedSalary);

			if (intendedSalary < baseSalary) {
				System.out.println(candidate + " go to next step ->");
				String answer = calling();
				System.out.println(answer);
			}else {
				System.out.println(candidate + " out of budget.");
			}
		}
	}
	static double salaryGoal() {
		return ThreadLocalRandom.current().nextDouble(1800,2300);
	}
	static String calling() {
		int callingTries = 0;
		boolean callingContinue = true;
		String contact = "Call falied";
		
		do {
			boolean answer = call();
			callingTries++;
			if (answer == true) {
				callingContinue = false;
				contact = "Answered";
			}else if (callingTries == 3){
				callingContinue = false;
				contact = "Do not Answered";
			}else {
				System.out.println("Calling again...");
			}
		}while(callingContinue == true);
		
		return contact;
	}
	static boolean call() {
		System.out.println("Calling...");
		return new Random().nextInt(3)==1;
	}
}
