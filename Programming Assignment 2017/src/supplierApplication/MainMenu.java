package supplierApplication;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Scanner;
import java.util.InputMismatchException;


/**
 * This Class allows the user to view and add data held inside of the system.
 * @author Matthew de Leeuwe (40210062)
 * @version 1.0
 */
public class MainMenu {

	private static Scanner sc;
	private static ArrayList<Supplier> Suppliers = new ArrayList<Supplier>();
	private static ArrayList<Product> Products = new ArrayList<Product>();


	public static void main(String[] args) {
		Address ATest1 = new Address(1,"AddressVille","TownsVille","BT38 9BA","United Kingdom");		
	
		
		Product PTest1 = new Product(1,"Dell","Inspiron-15",1500.00,10, false);
		Product PTest2 = new Product(2,"Razer","Blade-15",2000.00,5,false);
		Product PTest3 = new Product(3,"HP","Spectre",1000.00,2,false);
		
		Products.add(PTest1);
		Products.add(PTest2);
		Products.add(PTest3);

		Supplier STest1 = new Supplier(1,"Supplier One",ATest1,SupRegion.UNITED_KINGDOM, Products);	

		
		Suppliers.add(STest1);



		
		menu();	
	}
	
/**
 * This method prints all of the products in the arrays. 
 * It is sorted by suppliers, so the user can see which suppliers have which products.	
 */
	private static void printProduct() {
		System.out.println("Product Details:");


		for (Supplier eachSupplier : Suppliers) {
			eachSupplier.PrintProductList();
		}
		
		menu();
	}
	

	
	/**
	 * This method allows the user to enter Supplier data into the system to be held.
	 * This takes in Address and Supplier data.
	 * @return tempSupplier
	 */
	
	private static  Supplier addSupplier() {
		//Address Entry
		System.out.println("Please Enter Supplier Details: ");
		System.out.println("Address");
		System.out.println("Building Number: ");
		while (!sc.hasNextInt()) sc.next();
		int number = sc.nextInt();
		
		System.out.println("Street: ");
		String street = sc.next();
		
		System.out.println("Town:");
		String town = sc.next();
		
		System.out.println("Post Code: ");
		String pcode = sc.next();
		
		System.out.println("Country");
		String country = sc.next();
		//Supplier Details Entry		
		System.out.println("Supplier Details");
		System.out.println("Supplier Code:");
		while (!sc.hasNextInt()) sc.next();
		int code = sc.nextInt();
		
		System.out.println("Supplier Name:");
		String name = sc.next();
		
		System.out.println("Supplier Region:");
		System.out.println("Choose From Below:");
		
		int index = 1;
		int numofRegions = EnumSet.allOf(SupRegion.class).size();
		printRegionItems(index,numofRegions);
		System.out.println("Enter your choice:");
		
		SupRegion region = SupRegion.values()[sc.nextInt()-1];
		sc.nextLine();
		
		ArrayList<Product> emptyProducts = new ArrayList<Product>();
		
		Address tempAddress = new Address(number,street,town,pcode,country);
		Supplier tempSupplier = new Supplier(code,name,tempAddress,region,emptyProducts);
		Suppliers.add(tempSupplier);
		
		
		menu();
		
		return tempSupplier;
	}
	
	/**
	 * This method prints regions stored inside of the Enum class.
	 * @param index
	 * @param numOfEnumItems
	 */
	
	public static void printRegionItems(int index, int numOfEnumItems) {
		if (index <= numOfEnumItems) {
			System.out.println(index + ": " + SupRegion.values()[index-1].regionAsString());
			index++;
			
			printRegionItems(index, numOfEnumItems);
		}
	}
	
	/**
	 * This method allows the user to add a product to a specific Supplier.
	 */
	
	private static void addProduct() {
		boolean pDiscontinued = false;
		System.out.println("Please Enter Product Details: ");	
		System.out.println("Product Code:");
		while (!sc.hasNextInt()) sc.next();
		int pCode = sc.nextInt();
		System.out.println("Product Make:");
		String pMake = sc.next();
		System.out.println("Product Model:");
		String pModel = sc.next();
		System.out.println("Product Price:");
		while (!sc.hasNextDouble()) sc.next();
		double pPrice = sc.nextDouble();
		System.out.println("Quantity Available:");
		while (!sc.hasNextInt()) sc.next();
		int pQtyAvail = sc.nextInt();
		
		System.out.println("Is Product Discontinued? Y/N");
		String pdis = sc.next();
		if (pdis.equalsIgnoreCase("y")) {
			pDiscontinued = true;
		} else if (pdis.equalsIgnoreCase("n")) {
			pDiscontinued = false;
		} else {
			System.out.println("Invalid Entry");
			
		}
		
		
		Product tempProduct = new Product(pCode,pMake,pModel,pPrice,pQtyAvail,pDiscontinued);
		
		System.out.println("Which Supplier is Supplying the Product: ");
		for (int i = 0; i<Suppliers.size(); i++) {
			System.out.println((i+1) + ": " + Suppliers.get(i).getSupName());
			Suppliers.get(i).getSupName();
		}
		
		System.out.println("Enter Correspodning Supplier Number:");
		int SuppNo = sc.nextInt()-1; sc.nextLine();
		Supplier myS = Suppliers.get(SuppNo);
		myS.getSupProducts().add(tempProduct);
		
		
		menu();
		
	}
	

	/**
	 * This method allows the user to search for a product that is stored inside of the system.
	 */
	public static void searchProduct(ArrayList<Supplier> Suppliers) {
		System.out.println("Enter Model name of the Product");
		String searchProductName = sc.next();
		//Double For Loop to get the Products
		for (int i = 0; i < Suppliers.size(); i++) {
			for (int j = 0; j < Suppliers.get(i).getSupProducts().size(); j++) {
				//If Statement to allow search function to work off Model Name
				if (searchProductName.equals(Suppliers.get(i).getSupProducts().get(j).getProModel())) {
					System.out.println("The Supplier of Product: " + searchProductName + " is " + Suppliers.get(i).getSupName());
					System.out.println("Price: " + Suppliers.get(i).getSupProducts().get(j).getProPrice());
					System.out.println("Quantity Avialable: " + Suppliers.get(i).getSupProducts().get(j).getProQtyAvailable());
					System.out.println("Discontinued: " + Suppliers.get(i).getSupProducts().get(j).getProDiscontinued());
				}

			}
			
		}
		
		menu();
	}
	/**
	 * This method allows the user to check the stock of any item stored inside the system.
	 */
	public static void stockChecker(ArrayList<Supplier> Suppliers) {
		System.out.println("Enter a product name:");
		String searchProductName = sc.next();
		//Double For Loop to get the Products
		for (int i = 0; i < Suppliers.size(); i++) {
			for (int j = 0; j < Suppliers.get(i).getSupProducts().size(); j++) {
				if (searchProductName.equals(Suppliers.get(i).getSupProducts().get(j).getProModel())) {
					System.out.println("Stock Level for " + searchProductName + " is " + Suppliers.get(i).getSupProducts().get(j).getProQtyAvailable());
				}

			}
			
		}
		
		menu();
	}
	/**
	 * This method is a confirmation menu to check if the user really wishes to delete all of the data held inside of the system.
	 */
	public static void removeAllMenu() {
		int removeOption;
		sc = new Scanner(System.in);
		System.out.println("If you wish to remove all data in the program press 1");
		System.out.println("To go back press 0");
		
		try {
			removeOption = sc.nextInt();
			switch (removeOption)
			{
			case 1: removeAll();
				break;
			case 0: menu();
				break;
			default: System.out.println("Try Again");	
			}
		}
		catch(InputMismatchException ex) {
			System.out.println("Invalid Input");
			menu();
		}
	}
	/**
	 * This method allows for the data held inside the system to be removed.
	 */
	public static void removeAll() {
		Suppliers.clear();
		System.out.println("All data has been Cleared");
		menu();
	}
	
	/**
	 * This method allows the quantity of a product held in the system to be altered.
	 * @param Suppliers
	 */
	
	public static void changeQuantity(ArrayList<Supplier> Suppliers) {
		System.out.println("Product List:");		
		for (int i = 0; i<Suppliers.size(); i++) {
			for (int j = 0; j < Suppliers.get(i).getSupProducts().size(); j++) {
				System.out.println(Suppliers.get(i).getSupProducts().get(j).getProCode() + ": " + Suppliers.get(i).getSupProducts().get(j).getProMake() + " " +Suppliers.get(i).getSupProducts().get(j).getProModel());
			}
			}
		System.out.println("Enter Correspodning Product Number:");
		int prodNo = sc.nextInt();
		System.out.println("Please Enter the updated stock value:");
		int sValue = sc.nextInt();
		for (int i = 0; i < Suppliers.size(); i++) {
			for (int j = 0; j < Suppliers.get(i).getSupProducts().size(); j++) {
				if(prodNo == Suppliers.get(i).getSupProducts().get(j).getProCode()) {
					Suppliers.get(i).getSupProducts().get(j).setProQtyAvailable(sValue);
					System.out.println("New Stock Level has been set");
				}
			
		
		}
			}
		menu();
	}
	
	
	/**
	 * This method is the main menu for the system and allows the user to perform various functions.
	 */
	public static void menu(){
        int MenuOption;
        sc = new Scanner(System.in);
        System.out.println("----------------------------");
        System.out.println("Menu");
        System.out.println("1 - Print All Products");
        System.out.println("2 - Add New Supplier");
        System.out.println("3 - Add New Product");
        System.out.println("4 - Search for a Product");
        System.out.println("5 - Stock Checker");
        System.out.println("6 - Clear All Data");
        System.out.println("7 - Change Stock Level");
        System.out.println("0 - Exit");
        System.out.println("----------------------------");
        System.out.print("Enter Choice: ");
        
        
        try {
        MenuOption = sc.nextInt();
        
        switch (MenuOption)
        {
        case 1:printProduct();
            break;
        case 2:addSupplier();
            break;
        case 3:addProduct();
            break;
        case 4:searchProduct(Suppliers);
        		break;
        case 5: stockChecker(Suppliers);
        		break;
        case 6: removeAllMenu();
        	break;
        case 7: changeQuantity(Suppliers);
        break;
        case 0: System.out.println("Program Terminated"); System.exit(0);
            break;
        default: System.out.println("Try Again");
        menu();
        }
        }
        catch(InputMismatchException ex){
            System.out.println("Non Integer Value Entered");
           menu();
        }
        
        
        
        }


    
    
	

	
	
}
	
