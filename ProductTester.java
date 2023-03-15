package inventory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductTester {

	public static void main(String[] args) {

		// opens a scanner

		Scanner scanner = new Scanner(System.in);

		// asks user how many products want to enter
		int maxSize = getNumProducts(scanner);
		int menuChoice;
		int i;

		// if wants to input 0 products, display message
		if (maxSize == 0) {
			System.out.println("No products required!");

		} // end if

		else {
			// if wants to enter products, use an array to store them, as many as user wants
			Product products[] = new Product[maxSize];

			// for loop to ask for each product if it is CD or DVD
			for (i = 0; i < maxSize; i++) {

				addInventory(products, scanner, i);
			} // end for loop
			do {

				// after entering the products, shows menu options
				menuChoice = getMenuOption(scanner);
				executeMenuChoice(menuChoice, products, scanner, i);
			} while (menuChoice != 0);// end do while loop
		} // end else

	}// end main

	static void executeMenuChoice(int menuChoice, Product[] products, Scanner scanner, int i) {
		// tells what each menu option does
		switch (menuChoice) {
		case 1:
			System.out.println("--- View product list ---");
			displayInventory(products);
			break;
		case 2:
			System.out.println("--- Add stock ---");
			addToStock(products, scanner, i);
			break;
		case 3:
			System.out.println("--- Deduct stock ---");
			deductInventory(products, scanner, i);
			break;
		case 4:
			System.out.println("--- Discontinue stock ---");
			discontinueInventory(products, scanner, i);
		}// end switch
	}// end executeMenuChoice

	static void discontinueInventory(Product[] products, Scanner scanner, int i) {
		// allows to choose which product to discontinue
		int productChoice = getProductNumber(products, scanner, i);
		
		System.out.println("Product discontinued!");
		// sets active value to false in product class
		products[productChoice].setActive(false);
	}// end discontinueInventory

	static void deductInventory(Product[] products, Scanner scanner, int i) {
		// allows to choose which products stock to deduct
		int productChoice = getProductNumber(products, scanner, i);
		int updateValue = -1;

		do {
			// try to catch exception if wrong data type entered
			try {
				// asks user how many products to deduct
				System.out.println("How many products do you want to deduct?");
				updateValue = scanner.nextInt();

				// if number entered smalled than 0 show error message
				if (updateValue < 0) {
					System.out.println("Wrong value entered!" + "\nEnter only numbers above 0!");
				} // end if
				else if(updateValue > products[productChoice].getUnitsInStock()) {
					System.out.println("Wrong value entered!\n" + products[productChoice].getUnitsInStock() + " units in stock!"
							+ "\nCan`t deduct more than available in stock!");
				}

				// catch exception if wrong data type entered
			} catch (InputMismatchException e) {
				System.out.println("Incorrect data type entered! Please enter a number!");

				// clears the scanner buffer
				scanner.nextLine();
			} // end catch

		} while (updateValue < 0 || updateValue > products[productChoice].getUnitsInStock());// end do while

		// shows message that the items have been deducted from stock
		System.out.println(updateValue + " items deducted from stock!\n");
		// updates units in stock in Product class
		products[productChoice].deductFromInventory(updateValue);
	}

	// NEW METHOD TO ADD STOCK VALUES
	static void addToStock(Product[] products, Scanner scanner, int i) {
		// allows user to choose which products stock to add
		int productChoice = getProductNumber(products, scanner, i);
		int updateValue = -1;

		do {
			// try to catch exception if wrong data type entered
			try {
				// asks user how many products to add
				System.out.println("How many products do you want to add?");
				updateValue = scanner.nextInt();

				// if number entered smalled than 0 show error message
				if (updateValue < 0) {
					System.out.println("Wrong value entered!" + "\nEnter only numbers above 0!");
				} // end if

				// catch exception if wrong data type entered
			} catch (InputMismatchException e) {
				System.out.println("Incorrect data type entered! Please enter a number!");

				// clears the scanner buffer
				scanner.nextLine();
			} // end catch

		} while (updateValue < 0);// end do while

		// shows message that the items have been added to stock
		System.out.println(updateValue + " items added to stock!\n");
		// updates units in stock in Product class
		products[productChoice].addToInventory(updateValue);
	}// end addToStock

	static void addInventory(Product[] products, Scanner scanner, int i) {
		int stockChoice = -1;

		do {
			// try to catch exception if wrong data type entered
			try {
				// asks user to choose which to add
				System.out.println("Please enter the product type:" + "\n1: CD" + "\n2: DVD");
				stockChoice = scanner.nextInt();

				// if user chose 1, add CD
				if (stockChoice == 1) {
					addCDToInventory(scanner, products, i);
				} // end if
					// if user chose 2, add DVD
				else if (stockChoice == 2) {
					addDVDToInventory(scanner, products, i);
				} // end else if

				// if number entered smaller than 0 or bigger than 2, show error message
				if (stockChoice < 1 || stockChoice > 2) {
					System.out.println("Only numbers 1 or 2 allowed!");
					addInventory(products, scanner, i);
				} // end if
					// catch exception if wrong data type entered
			} catch (InputMismatchException e) {
				System.out.println("Incorrect data type entered!");

				// clears the scanner buffer
				scanner.nextLine();
			} // end catch

		} while (stockChoice < 0);// end do

	}// end addInventory

	static int getProductNumber(Product[] products, Scanner scanner, int i) {
		int productChoice = -1;

		System.out.println("Products entered: \n");
		
		// show list with all products
		for (i = 0; i < products.length; i++) {
			// shows product info in each loop
			System.out.println("Product index: " + (i));

			System.out.println("Product name: " + products[i].getProductName() + "\n");
		} // end for loop

		do {
			// try to catch exception if wrong data type entered
			try {
				// asks user which product to update
				System.out.println("Which product do you want to update?");
				productChoice = scanner.nextInt();

				// if number entered smalled than 0 or more than products in the list, show
				// error message
				if (productChoice < 0 || productChoice > products.length) {
					System.out.println("Wrong value entered!");
				} // end if
					// catch exception if wrong data type entered
			} catch (InputMismatchException e) {
				System.out.println("Incorrect data type entered! Enter only numbers.");

				// clears the scanner buffer
				scanner.nextLine();
			} // end catch

		} while (productChoice < 0 || productChoice > products.length);// end do

		return productChoice;
	}// end getProductNumber

	static int getMenuOption(Scanner scanner) {
		int menuChoice = -1;

		do {
			// try to catch exception if wrong data type entered
			try {
				// asks user to choose menu option from 0 - 4
				System.out.println("\n1. View inventory" + "\n2. Add stock" + "\n3. Deduct stock"
						+ "\n4. Discontinue product" + "\n0. Exit");
				menuChoice = scanner.nextInt();

				// if number entered smalled than 0 or bigger than 4, show error message
				if (menuChoice < 0 || menuChoice > 4) {
					System.out.println("Wrong value entered!");
				} // end if

			} catch (InputMismatchException e) {
				System.out.println("Incorrect data type entered!");

				// clears the scanner buffer
				scanner.nextLine();
			} // end catch

		} while (menuChoice < 0 || menuChoice > 4);// end do

		// return what option user chose
		return menuChoice;

	}// end getMenuOption

	static int getNumProducts(Scanner scanner) {
		int maxSize = -1;
		do {
			// try to catch exception if wrong data type entered
			try {
				// asks user to enter positive number
				System.out.println("Enter the number of products you would like to add\n"
						+ "Enter 0 if you do not wish to add products: ");
				maxSize = scanner.nextInt();

				// shows an error message if wrong value is entered
				if (maxSize < 0) {
					System.out.println("Wrong value entered!");
				} // end if
			} // end try
				// catches exception if wrong data type entered
			catch (InputMismatchException e) {
				System.out.println("Incorrect data type entered!");

				// clears the scanner buffer
				scanner.nextLine();
			} // end catch

		} while (maxSize < 0);// end do

		return maxSize;
	}//end getNumProducts

	// add products to inventory
	static void addCDToInventory(Scanner scanner, Product[] products, int i) {

		scanner.nextLine();

		// asks for values for products
		System.out.println("Enter the CD name: ");
		String tempCDName = scanner.nextLine();

		System.out.println("Enter the artist name: ");
		String tempCDArtist = scanner.nextLine();

		System.out.println("Enter record label name: ");
		String tempCDLabel = scanner.nextLine();

		System.out.println("Enter number of songs on the CD: ");
		int tempNoOfSongs = scanner.nextInt();

		System.out.println("Please enter the quantity of stock for this product: ");
		int tempCDQty = scanner.nextInt();

		System.out.println("Please enter the price for this product: ");
		double tempCDPrice = scanner.nextDouble();

		System.out.println("Please enter the item number: ");
		int tempCDNumber = scanner.nextInt();

		// makes a product with entered values
		products[i] = new CD(tempCDName, tempCDArtist, tempCDLabel, tempNoOfSongs, tempCDQty, tempCDPrice, tempCDNumber,
				true);

	}// end addToInventory

	// add products to inventory
	static void addDVDToInventory(Scanner scanner, Product[] products, int i) {

		// clears the scanner buffer
		scanner.nextLine();

		// asks for values for products
		System.out.println("Please enter the DVD name: ");
		String tempName = scanner.nextLine();

		System.out.println("Please enter the film studio name: ");
		String tempStudio = scanner.nextLine();

		System.out.println("Please enter the age rating: ");
		int tempAgeRating = scanner.nextInt();

		System.out.println("Please enter the length in minutes: ");
		int tempLength = scanner.nextInt();

		System.out.println("Please enter the quantity of stock for this product: ");
		int tempQty = scanner.nextInt();

		System.out.println("Please enter the price for this product: ");
		double tempPrice = scanner.nextDouble();

		System.out.println("Please enter the item number: ");
		int tempNumber = scanner.nextInt();

		// makes a product with entered values
		products[i] = new DVD(tempName, tempStudio, tempAgeRating, tempLength, tempQty, tempPrice, tempNumber, true);

	}// end addToInventory

	// display entered products to console
	static void displayInventory(Product[] products) {
		// for each loop to display all the entered products
		for (Product i : products) {
			// shows product info in each loop
			System.out.println(i);
			System.out.println("");
		} // end for loop
	}// end displayInventory

}// end class
