package supplierApplication;

/**
 * This class deals with all of the data related to the product.
 * @author Matthew
 *
 */

public class Product {

	private  int proCode;
	private   String proMake;
	private  String proModel;
	private  double proPrice;
	private  int proQtyAvailable;
	private  boolean proDiscontinued;

	

	public Product(int proCode, String proMake, String proModel, double proPrice, int proQtyAvailable, boolean proDiscontinued) {
		this.proCode = proCode;
		this.proMake = proMake;
		this.proModel = proModel;
		this.proPrice = proPrice;
		this.proQtyAvailable = proQtyAvailable;
		this.proDiscontinued = proDiscontinued;

	}
	
	/**
	 * This method sets out how the data will be displayed to the user, when it is printed in the main system.
	 * @return returnString
	 */
	
	public  String getProductDetails() {
		String returnString = "\nProduct Code: " + getProCode();
		returnString += "\nMake: " + getProMake() ;
		returnString += "\nModel: " + getProModel();
		returnString += "\nPrice: �" + getProPrice() ;
		returnString += "\nQuantity Available: " + getProQtyAvailable();
		returnString += "\nDiscontinued? ";
		if (proDiscontinued == true) {
			returnString += "True";
		} else {
			returnString += "False";
		}

		return returnString;
	
	}
	
	public  int getProCode() {
		return proCode;
	}

	public  String getProMake() {
		return proMake;
	}

	public  String getProModel() {
		return proModel;
	}

	public  double getProPrice() {
		return proPrice;
	}

	public  int getProQtyAvailable() {
		return proQtyAvailable;
	}

	public  boolean getProDiscontinued() {
		return proDiscontinued;
	}

	public void setProCode(int proCode) {
		this.proCode = proCode;
	}

	public void setProMake(String proMake) {
		this.proMake = proMake;
	}

	public void setProModel(String proModel) {
		this.proModel = proModel;
	}

	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}

	public void setProQtyAvailable(int proQtyAvailable) {
		this.proQtyAvailable = proQtyAvailable;
	}

	public void setProDiscontinued(boolean proDiscontinued) {
		this.proDiscontinued = proDiscontinued;
	}



	
}