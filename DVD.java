package inventory;

public class DVD extends Product {
	
	int length;
	int ageRating;
	String filmStudio;
	

	public DVD() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param length
	 * @param ageRating
	 * @param filmStudio
	 */
	public DVD(String name, String filmStudio, int ageRating, int length, int qty, double price, int number, boolean active) {
		super(number, name, qty, price, active);
		this.length = length;
		this.ageRating = ageRating;
		this.filmStudio = filmStudio;
	}
	public double calculateInventoryValue(int qty, double price) {
		return (price * qty) + (((price * qty) * 5) /100);
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}


	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}


	/**
	 * @return the ageRating
	 */
	public int getAgeRating() {
		return ageRating;
	}


	/**
	 * @param ageRating the ageRating to set
	 */
	public void setAgeRating(int ageRating) {
		this.ageRating = ageRating;
	}


	/**
	 * @return the filmStudio
	 */
	public String getFilmStudio() {
		return filmStudio;
	}


	/**
	 * @param filmStudio the filmStudio to set
	 */
	public void setFilmStudio(String filmStudio) {
		this.filmStudio = filmStudio;
	}


	@Override
	public String toString() {
		return "Item number: " + getItemNumber() +
				"\nName: " + getProductName() + 
				"\nMovie lenght: " + getLength() +
				"\nAge rating: " + getAgeRating() +
				"\nFilm studio: " + getFilmStudio() +
				"\nQuantity in stock: " + getUnitsInStock() +
				"\nPrice: " + getPrice() + 
				"\nStock value: " + calculateInventoryValue(getUnitsInStock(), getPrice()) +
				"\nProduct status: " + (active ? "Active" : "Discountinued"
						+ "\n");
				
	}


}
