package inventory;

public class Product {
	// Instance field declarations
	int itemNumber;
	String productName;
	int unitsInStock;
	double price;
	boolean active;

	// default constructor that allows to initialise default values
	Product() {
		this(00000, "NA", 0, 00.00, true);

	}// end Product default constructor

	// constructor to initialise instance fields with values from the driver class
	Product(int number, String name, int qty, double price, boolean active) {
		this.itemNumber = number;
		this.productName = name;
		this.unitsInStock = qty;
		this.price = price;
		this.active = active;
	}// end product constructor

	public void addToInventory(int qty) {
		if(active == false) {
		System.out.println("Stock not added. This product is discontinued!");
		}
		else if(active == true) {
			this.unitsInStock = (this.getUnitsInStock() + qty);
		}
	}// end addToInventory

	public void deductFromInventory(int updateValue) {
		this.unitsInStock = (this.getUnitsInStock() - updateValue);
	}// end deductfromInventory

	// calculates stock value

	public double getInventoryValue(double price, int qty) { // df = new
		// DecimalFormat("#.##");
		return price * qty;
	}
	// end getInventoryValue

	// allows to access what is stored in item number
	public int getItemNumber() {
		return itemNumber;
	}// end getItemNumber

	// allows to set the value for itemNumber
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}// end setItemNumber

	// allows to access what is stored in productName
	public String getProductName() {
		return productName;
	}// end getProductName

	// allows to set the value for productName
	public void setProductName(String productName) {
		this.productName = productName;
	}// end setProductName

	// allows to access what is stored in unitsInStock
	public int getUnitsInStock() {
		return unitsInStock;
	}// end getUnitsInStock

	// allows to set the value for unitsInStock
	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}// end setUnitsInStock

	// allows to access what is stored in price
	public double getPrice() {
		return price;
	}// end getPrice

	// allows to set the value for price
	public void setPrice(double price) {
		this.price = price;
	}// end setPrice

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/*
	 * public String toString() { return "Item number: " + itemNumber + ",\nName: "
	 * + productName + ",\nUnits in stock: " + unitsInStock + ",\nPrice: " + price +
	 * "\nStock value: " + this.getInventoryValue(price, unitsInStock) +
	 * "\nProduct status: " + (active ? "Active" : "Discountinued") + "\n"; }// end
	 * toString
	 */
}// end class
