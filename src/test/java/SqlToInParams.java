import java.util.Scanner;

public class SqlToInParams {

	public static void main(String[] args) {

		Scanner sn = new Scanner(System.in);
		while (!sn.hasNextInt()) {
			String line = sn.nextLine();
			String[] lines = line.split("&");
			for (String temp : lines)
				System.out.println(temp.trim());

		}
	}
}
