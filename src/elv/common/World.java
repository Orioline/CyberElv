package elv.common;

import java.io.IOException;
import java.util.Scanner;

public class World {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Elv nand = new Elv();

		nand.learn(new Image("()", ""));
		nand.learn(new Image("(1)", "1"));
		nand.learn(new Image("(0)", "0"));

		nand.learn(new Image("1&1", "1"));
		nand.learn(new Image("1&0", "0"));
		nand.learn(new Image("0&1", "0"));
		nand.learn(new Image("0&0", "0"));

		nand.learn(new Image("1|1", "1"));
		nand.learn(new Image("1|0", "1"));
		nand.learn(new Image("0|1", "1"));
		nand.learn(new Image("0|0", "0"));

		while (true) {
			// byte[] input = new byte[100];
			// System.in.read(input);
			Scanner in = new Scanner(System.in);
			String signal = in.nextLine();

			System.out.println(nand.IPO(signal));
		}
	}

}
