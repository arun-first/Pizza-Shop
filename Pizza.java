/**
 * 																	Om Namah Shivaay
 * A typical pizza shop to take orders and receive payments.
 * Completely CLI based.
 *
 * @author: arun-first
 * Compilation: javac Pizza.java
 * Execution: java Pizza
 */

 package pizza_shop; // package

 // import packages
 import java.util.Scanner;
 import java.util.InputMismatchException;

 public class Pizza {
 	// necesary variables
 	int quantity = 0, order = 0, size = 0; // for ordering
 	double amt = 0.00d, total = 0.00d, rate = 0.00d; // for billing
 	double paid = 0.00d, left = 0.00d; // payment details

 	// arrays to hold the menus
	static String[] mainMenu = {"","Cheese Pizza","Non-Cheese Pizza","Chicken Pizza","Toppings Pizza"};
	static String[] sizeMenu = {"","Small", "Medium","Large","XX Large"};

	// Object Creation
	static Scanner stdInput = new Scanner(System.in);
	static Pizza pizz = new Pizza ();

	public static void main(String[] args) {
		pizz.startScreen(); // start screen
		pizz.mainMENU(); // main menu
		pizz.closingMenu(); // closing statement

		// bi-directional flow
		switch (pizz.order) {
			case 1: pizz.cheesePizza ();
					break;
			case 2: pizz.nonCheese ();
					break;
			case 3: pizz.chickenPizza ();
					break;
			case 4: pizz.toppingsPizza ();
					break;
		}
	}

	// main menu
	public void mainMENU () {
		// displaying menus
		for (int i = 1, n = mainMenu.length;i < n; i++) 
			System.out.println("\t\t["+i+"] "+mainMenu[i]);
		
		do {
			try {
				System.out.print("\t\tPress [1 - 4]: ");
				pizz.order = stdInput.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("ERROR: invalid input");
			}
		} while (pizz.order < 0 || pizz.order > 4); // order
	}
	
	public void startScreen () {
		System.out.println("\n\t\t\t\tALPHA PIZZA STORE");
		System.out.println("\t\t\t\t*****************");
		System.out.println("\t\t");
	}

	public void closingMenu () {
		System.out.println("\t###########################################################\n\n");
	}

	// size determination
	public void pizzaSize (String type) {
		pizz.startScreen();
		for (int i = 1, n = sizeMenu.length; i < n; i++)
			System.out.println("\t\t["+i+"] "+sizeMenu[i]+" "+type+" Pizza");
		
		do {
			System.out.print("\n\t\tPress [1 - 4]: ");
			pizz.size = stdInput.nextInt();
		} while (size < 0 || size > 4);
	}

	// quantity determination
	public void pizzaQuantity (String type) {
		System.out.print("\n\t\tHow many do you want ? ");
		pizz.quantity = stdInput.nextInt();
		pizz.closingMenu();
	}

	// cheese pizza
	public void cheesePizza () {
		pizz.pizzaSize ("Cheese"); // size determination
		pizz.pizzaQuantity ("Cheese"); // quantity determination

		// rate according to size calculation
		switch (pizz.size) {
			case 1: pizz.rate = 96.89;
					break;
			case 2: pizz.rate = 174.97;
					break;
			case 3: pizz.rate = 209.34;
					break;
			case 4: pizz.rate = 283.86;
					break;
		}

		// amount according to quantity
		pizz.amt = pizz.rate * pizz.quantity;

		// bill display
		pizz.startScreen();

		System.out.println("\t\t[ 1 ] Cheese Pizza \tRs."+pizz.rate+"\t"+pizz.quantity+"pieces");
		System.out.println("\t\tNet total: Rs. "+pizz.amt);
		pizz.payScheme(); // payment
	}

	// non-cheese pizza
	public void nonCheese () {
		pizz.pizzaSize ("Non-Cheese"); // size
		pizz.pizzaQuantity ("Non-Cheese"); // quantity

		// rate according to size
		switch (pizz.size) {
			case 1: pizz.rate = 45.98;
					break;
			case 2: pizz.rate = 115.85;
					break;
			case 3: pizz.rate = 165.48;
					break;
			case 4: pizz.rate = 208.65;
					break;
		}

		// amount according to the quantity
		pizz.amt = pizz.rate * pizz.quantity;

		// bill display
		pizz.startScreen();

		System.out.println("\t\t[ 1 ] Non-Cheese Pizza \tRs."+pizz.rate+"\t"+pizz.quantity+"pieces");
		System.out.println("\t\tNet total: Rs. "+pizz.amt);
		pizz.payScheme(); // payment
	}

	// chicken pizza
	public void chickenPizza () {
		pizz.pizzaSize("Chicken"); // size
		pizz.pizzaQuantity("Chicken"); // quantity

		// rate according to size
		switch (pizz.size) {
			case 1: pizz.rate = 125.62;
					break;
			case 2: pizz.rate = 203.95;
					break;
			case 3: pizz.rate = 295.34;
					break;
			case 4: pizz.rate = 345.02;
					break;
		}

		// amount according to quantity
		pizz.amt = pizz.rate * pizz.quantity;

		// bill display
		pizz.startScreen();

		System.out.println("\t\t[ 1 ] Chicken Pizza \tRs."+pizz.rate+"\t"+pizz.quantity+"pieces");
		System.out.println("\t\tNet total: Rs. "+pizz.amt);
		pizz.payScheme(); // payment
	}

	// toppings pizza
	public void toppingsPizza () {
		pizz.pizzaSize("Toppings"); // size
		pizz.pizzaQuantity("Toppings"); // quantity

		// rate according to size
		switch (pizz.size) {
			case 1: pizz.rate = 75.46;
					break;
			case 2: pizz.rate = 120.20;
					break;
			case 3: pizz.rate = 195.60;
					break;
			case 4: pizz.rate = 216.30;
					break;
		}

		// amount according to size
		pizz.amt = pizz.rate * pizz.size;

		// bill display
		pizz.startScreen();

		System.out.println("\t\t[ 1 ] Toppings Pizza \tRs."+pizz.rate+"\t"+pizz.quantity+" pieces");
		System.out.println("\t\tNet total: Rs. "+pizz.amt);
		pizz.payScheme(); // payment
	}

	// pay scheme 
	public void payScheme () {
		System.out.println();
		System.out.print("\t\tPlease Pay: Rs.");
		pizz.paid = stdInput.nextInt();

		if (pizz.paid > pizz.amt) {
			pizz.left = pizz.paid - pizz.amt;
			System.out.println("\t\tYour Change: Rs."+pizz.left);
		} else {
			System.out.println("\t\tERROR: Insufficient Fund");
			System.out.println("\t\tORDER CANCELLED");
		}
		pizz.closingMenu();
	}
 }
