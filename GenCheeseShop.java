import java.util.Random;
import java.util.Scanner;

public class GenCheeseShop {

	public static void main(String[] args) {

		final int MAXCHEESE = 1;

		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] pricesTotal = new double[MAXCHEESE];
		int[] amounts = new int[MAXCHEESE];

		for (int i = 0; i < MAXCHEESE; ++i) {
			names[0] = "Dalaran Sharp";
			prices[0] = 1.25;
			break;
		}

		for (int i = 1; i < MAXCHEESE; ++i) {
			names[1] = "Stormwind Brie";
			prices[1] = 10.00;
			break;
		}

		for (int i = 2; i < MAXCHEESE; ++i) {
			names[2] = "Alterac Swiss";
			prices[2] = 40.00;
			break;
		}

		System.out.println("We sell " + MAXCHEESE + " kinds of Cheese");


		for (int i = 0; i < MAXCHEESE; ++i) {
			System.out.println(names[0] + ": $" + prices[0] + " per pound");
			break;
		}

		for (int i = 1; i < MAXCHEESE; ++i) {
			System.out.println(names[1] + ": $" + prices[1] + " per pound");
			break;
		}

		for (int i = 2; i < MAXCHEESE; ++i) {
			System.out.println(names[2] + ": $" + prices[2] + " per pound");
			break;
		}

		Random ranGen = new Random(100);

		for (int i = 3; i < MAXCHEESE; i++) {
			names[i] = "Cheese Type " + (char)('A' + i);
			prices[i] = ranGen.nextInt(1000)/100.0;
			amounts[i] = 0;

			System.out.println(names[i] + ": $" + prices[i] + " per pound");
		}

		Scanner cheeseAmt = new Scanner(System.in);

		int SharpAmt = 0, BrieAmt = 0, SwissAmt = 0;
		double SharpTotal = 0, BrieTotal = 0, SwissTotal = 0;
		double subTotal, DiffSubTotal = 0;

		for (int i = 0; i < MAXCHEESE; ++i) {
			System.out.print("Enter the amount of Sharp in lbs: ");
			SharpAmt = cheeseAmt.nextInt();
			SharpTotal = SharpAmt * 1.25; 
			break;
		}
		for (int i = 1; i < MAXCHEESE; ++i) {
			System.out.print("Enter the amount of Brie in lbs: ");
			BrieAmt = cheeseAmt.nextInt();
			BrieTotal = BrieAmt * 10;
			break;
		}

		for (int i = 2; i < MAXCHEESE; ++i) {
			System.out.print("Enter the amount of Swiss in lbs: ");
			SwissAmt = cheeseAmt.nextInt();
			SwissTotal = SwissAmt * 40;
			break;
		}

		for (int i = 3; i < MAXCHEESE; i++) {
			System.out.print("Enter the amount of Cheese Type " + names[i] + ":");
			amounts[i] = cheeseAmt.nextInt();
			pricesTotal[i] = amounts[i] * prices[i];
			DiffSubTotal += pricesTotal[i];
		}

		subTotal = SharpTotal + BrieTotal + SwissTotal + DiffSubTotal;

		double subDiscount = 0;
		double totalFinal = 0;

		if (subTotal >= 50) {
			totalFinal = subTotal - 10;
			subDiscount = 10;
			if (subTotal >= 100) {
				totalFinal = subTotal - 25;
				subDiscount = 25;
			}
		} else {
			totalFinal = subTotal;
		}

		Scanner choice = new Scanner(System.in);

		int numChoice = 0;
		
		for (int i = 0; i < MAXCHEESE; ++i) {
		System.out.print("Display the itemized list? (1 for yes)");
		numChoice = choice.nextInt();
		break;
		}

		if (numChoice == 1) {
			if (SharpAmt != 0) {
				System.out.println(SharpAmt + " lbs of Sharp @ $1.25 = " + "$" + SharpTotal);
			}
			if (BrieAmt != 0) {
				System.out.println(BrieAmt + " lbs of Brie @ $10.00 = " + "$" + BrieTotal);
			}
			if (SwissAmt != 0) { 
				System.out.println(SwissAmt + " lbs of Swiss @ $40.00 = " + "$" + SwissTotal);
			}
		}

		for (int i = 3; i < MAXCHEESE; i++) {
			if (amounts[i] != 0) {
				System.out.println(amounts[i] + " lbs of " + names[i] + " @ " + prices[i] + " = " + "$" + pricesTotal[i]);
			}
		}

		System.out.println();
		
		System.out.println("Sub Total: " + "$" + subTotal);
		System.out.println("-Discount: " + "$" + subDiscount);
		System.out.println("Total    : " + "$" + totalFinal);
	}
}
