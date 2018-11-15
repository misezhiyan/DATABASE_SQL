import java.util.Scanner;

public class toUPPER {
	public static void main(String[] args) {

		 toUPPER();

	}
	private static void toUPPER() {

		Scanner sn = new Scanner(System.in);
		while (!sn.hasNextInt()) {
			String line = sn.nextLine();
			System.out.println(line.trim().toUpperCase());
		}
	}

}