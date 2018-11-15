import java.util.Scanner;

public class Combine {
	public static void main(String[] args) {

		combine();
	}

	private static void combine() {

		String all = "";

		Scanner sn = new Scanner(System.in);
		while (!sn.hasNextInt()) {
			String line = sn.nextLine();
			line = line.trim();
			if (line == null || "".equals(line))
				continue;
			all += line;
		}

		System.out.println(all);
	}
}
