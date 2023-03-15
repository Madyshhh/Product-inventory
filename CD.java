package inventory;

public class CD extends Product {
	private String artist;
	private int numberOfSongs;
	private String label;
	
	public CD() {
		// TODO Auto-generated constructor stub
	}

	public CD(String name, String artist, String label, int numberOfSongs, int qty, double price, int number, boolean active) {
		super(number, name, qty, price, active);
		this.artist = artist;
		this.numberOfSongs = numberOfSongs;
		this.label = label;
	}

	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * @return the numberOfSongs
	 */
	public int getNumberOfSongs() {
		return numberOfSongs;
	}

	/**
	 * @param numberOfSongs the numberOfSongs to set
	 */
	public void setNumberOfSongs(int numberOfSongs) {
		this.numberOfSongs = numberOfSongs;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Item number: " + getItemNumber() +
				"\nName: " + getProductName() + 
				"\nArtist: " + getArtist() +
				"\nSongs on album: " + getNumberOfSongs() +
				"\nRecord label: " + getLabel() +
				"\nQuantity in stock: " + getUnitsInStock() +
				"\nPrice: " + getPrice() + 
				"\nStock value: " + getInventoryValue(getPrice(), getUnitsInStock()) +
				"\nProduct status: " + (active ? "Active" : "Discountinued"
						+ "\n");
				
	}
}
