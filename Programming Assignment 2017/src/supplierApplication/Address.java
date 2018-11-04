package supplierApplication;

/**
 * This class deals with all of the data related to the address.
 * @author Matthew
 *
 */

public class Address {
	
	private int bldNum;
	private String bldStreet;
	private String bldTown;
	private String bldPcode;
	private String bldCountry;
	

	public Address(int bldNum, String bldStreet, String bldTown, String bldPcode, String bldCountry) {
		this.bldNum = bldNum;
		this.bldStreet = bldStreet;
		this.bldTown = bldTown;
		this.bldPcode = bldPcode;
		this.bldCountry = bldCountry;
	}
	
	/**
	 * This method sets out how the address will be displayed to the user.
	 * @return
	 */
	
	public String getFullAddress() {
		String returnString = "\nBuilding Number: " + getBldNum() ;
		returnString += "\nStreet: " + getBldStreet() ;
		returnString += "\nTown: " + getBldTown() ;
		returnString += "\nPost Code: " + getBldPcode() ;
		returnString += "\nCountry: " + getBldCountry() ;
		return  returnString;
	}

	public int getBldNum() {
		return bldNum;
	}

	public String getBldStreet() {
		return bldStreet;
	}

	public String getBldTown() {
		return bldTown;
	}

	public String getBldPcode() {
		return bldPcode;
	}

	public String getBldCountry() {
		return bldCountry;
	}

	public void setBldNum(int bldNum) {
		this.bldNum = bldNum;
	}

	public void setBldStreet(String bldStreet) {
		this.bldStreet = bldStreet;
	}

	public void setBldTown(String bldTown) {
		this.bldTown = bldTown;
	}

	public void setBldPcode(String bldPcode) {
		this.bldPcode = bldPcode;
	}

	public void setBldCountry(String bldCountry) {
		this.bldCountry = bldCountry;
	}
	
	
	
}

