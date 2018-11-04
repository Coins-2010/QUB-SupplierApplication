package supplierApplication;

import java.util.ArrayList;

/**
 * This class deals with all of the data related to the supplier.
 * @author Matthew
 *
 */

public class Supplier {

	private int supCode;
	private  String supName;
	private Address supAddress;
	private SupRegion supRegion;
	private  ArrayList<Product> supProducts = new ArrayList<Product>();
	

	public Supplier(int supCode, String supName, Address supAddress, SupRegion supRegion,
			ArrayList<Product> supProducts) {
		this.supCode = supCode;
		this.supName = supName;
		this.supAddress = supAddress;
		this.supRegion = supRegion;
		this.supProducts = supProducts;
	}
	
	/**
	 * This method allows the program to be able to print the list of Products, from all the suppliers, sorted by supplier.
	 */
	
	public  void PrintProductList() {
		System.out.println("Supplier Name: " + getSupName());
		System.out.println("Address " + getSupAddress().getFullAddress());
		System.out.println();
		System.out.println(this.supName +  " Supplies:");
		
		for(Product eachProduct: supProducts) {
			System.out.println(eachProduct.getProductDetails());
		}
		System.out.println();

		
	}
	
	public int getSupCodeNum() {
		return supCode;
	}

	public  String getSupName() {
		return supName;
	}

	public Address getSupAddress() {
		return supAddress;
	}

	public SupRegion getSupRegion() {
		return supRegion;
	}

	public ArrayList<Product> getSupProducts() {
		return supProducts;
	}


	public void setSupName(String supName) {
		this.supName = supName;
	}

	public void setSupAddress(Address supAddress) {
		this.supAddress = supAddress;
	}

	public void setSupRegion(SupRegion supRegion) {
		this.supRegion = supRegion;
	}

	public void setSupProducts(ArrayList<Product> supProducts) {
		this.supProducts = supProducts;
	}
}
