import java.util.Random;
import java.util.Scanner;

public class GenCheeseShop {

	public static void main(String[] args) {

		final int MAXCHEESE = 0;
		// These are the arrays that were included in the lab already
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		int[] amounts = new int[MAXCHEESE];

		//Depending on what the final int MAXCHEESE is, the 3 basic Cheese Types will show
		if (0 < MAXCHEESE) {
			names[0] = "Dalaran Sharp";
			prices[0] = 1.25;
		}

		if (1 < MAXCHEESE) {
			names[1] = "Stormwind Brie";
			prices[1] = 10.00;
		}

		if (2 < MAXCHEESE) {
			names[2] = "Alterac Swiss";
			prices[2] = 40.00;
		}

		//Continuing on with the Cheeses, it will now show how much each cheese is
		System.out.println("We sell " + MAXCHEESE + " kinds of Cheese");


		if (0 < MAXCHEESE) {
			System.out.println(names[0] + ": $" + prices[0] + " per pound");
		}

		if (1 < MAXCHEESE) {
			System.out.println(names[1] + ": $" + prices[1] + " per pound");
		}

		if (2 < MAXCHEESE) {
			System.out.println(names[2] + ": $" + prices[2] + " per pound");
		}

		//Random price generator for the other types of Cheeses
		Random ranGen = new Random(100);

		for (int i = 3; i < MAXCHEESE; i++) {
			names[i] = "Cheese Type " + (char)('A' + i);
			prices[i] = ranGen.nextInt(1000)/100.0;
			amounts[i] = 0;

			System.out.println(names[i] + ": $" + prices[i] + " per pound");
		}

		/* Starting from here, the program asks the user for the amount of
cheese and calculates the total individually
		 */
		Scanner cheeseAmt = new Scanner(System.in);

		double SharpAmt = 0, BrieAmt = 0, SwissAmt = 0;
		double SharpTotal = 0, BrieTotal = 0, SwissTotal = 0, otherTotal = 0;
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
			BrieTotal = BrieAmt * 10.0;
			break;
		}

		for (int i = 2; i < MAXCHEESE; ++i) {
			System.out.print("Enter the amount of Swiss in lbs: ");
			SwissAmt = cheeseAmt.nextInt();
			SwissTotal = SwissAmt * 40.0;
			break;
		}

		for (int i = 3; i < MAXCHEESE; i++) {
			System.out.print("Enter the amount of Cheese Type " + names[i] + ":");
			amounts[i] = cheeseAmt.nextInt();
		}


		Scanner choice = new Scanner(System.in);

		int numChoice = 0;

		/*Asks the user whether or not they want their list of cheeses to be displayed
along with their total prices. */
		for (int i = 0; i < MAXCHEESE; ++i) {
			System.out.print("Display the itemized list? (1 for yes)");
			numChoice = choice.nextInt();
			break;
		}

		/* If the amount of cheese the user picks is 0, then that cheese will not be
displayed for the purpose of organization */
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
			otherTotal = amounts[i] * prices[i];
			DiffSubTotal += otherTotal;
			if (numChoice == 1) {
				if (amounts[i] != 0) {
					System.out.println(amounts[i] + " lbs of " + names[i] + " @ " + prices[i] + " = " + "$" + otherTotal);
				}
			}
		}

		//total of all the cheeses
		subTotal = SharpTotal + BrieTotal + SwissTotal + DiffSubTotal;

		double subDiscount = 0;
		double totalFinal = 0;

		/*Conditional statement to determine whether or not the user will get a discount
		or not */
		if (subTotal >= 50) {
			totalFinal = subTotal - 10.0;
			subDiscount = 10;
			if (subTotal >= 100) {
				totalFinal = subTotal - 25.0;
				subDiscount = 25;
			}
		} else {
			totalFinal = subTotal;
		}

		/* Prints out the subTotal of the cheeses, the discount, and the Final Total
with the Discount */
		System.out.println();

		System.out.println("Sub Total: " + "$" + subTotal);
		System.out.println("-Discount: " + "$" + subDiscount);
		System.out.println("Total    : " + "$" + totalFinal);
	}
}
