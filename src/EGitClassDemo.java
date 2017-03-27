import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EGitClassDemo {
	static Random rand = new Random();
	static int number;

	public static void main(String[] args) {
//		number = rand.nextInt(10);
		number = ThreadLocalRandom.current().nextInt(10, 20 + 1);
		// TODO Auto-generated method stub
		System.out.println("Hello EGit");
		System.out.println("Hello Eclipse");
		System.out.println("Welcome to eclipse");
		System.out.println(number);
	}
}
