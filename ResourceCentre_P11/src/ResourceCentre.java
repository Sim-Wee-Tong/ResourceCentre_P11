import java.util.ArrayList;

public class ResourceCentre {


	public static void main(String[] args) {

		ArrayList<Camcorder> ccList = new ArrayList<Camcorder>();
		ArrayList<Chromebook> cbList = new ArrayList<Chromebook>();

		ccList.add(new Camcorder("CC001", "Sony HDR-CX405", 35));
		ccList.add(new Camcorder("CC002", "Panasonic HC-MDH2", 10));
		cbList.add(new Chromebook("CB001", "ASUS Chromebook ", "Win 10"));
		cbList.add(new Chromebook("CB002", "HP Chromebook", "Win 10"));
		
		int option = 0;

		while (option != 5) {

			ResourceCentre.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				ResourceCentre.viewAllCamcorder(ccList);
				ResourceCentre.viewAllChromebook(cbList);

			} else if (option == 2) {
				// Add a new item
				ResourceCentre.setHeader("ADD");			
				ResourceCentre.setHeader("ITEM TYPES");
				System.out.println("1. Camcorder");
				System.out.println("2. Chromebook");
				
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Add a camcorder
					Camcorder cc = inputCamcorder();
					ResourceCentre.addCamcorder(ccList, cc);

				} else if (itemType == 2) {
					// Add Chromebook
					Chromebook cb = inputChromebook();
					ResourceCentre.addChromebook(cbList, cb);

				} else {
					System.out.println("Invalid type");
				}
// test1
			} else if (option == 3) {
				// Loan item
				ResourceCentre.setHeader("LOAN");			
				ResourceCentre.setHeader("ITEM TYPES");
				System.out.println("1. Camcorder");
				System.out.println("2. Chromebook");
				
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Loan camcorder
					ResourceCentre.loanCamcorder(ccList);
				} else if (itemType == 2) {
					// Loan Chromebook
					ResourceCentre.loanChromebook(cbList);
				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 4) {
				// Return item
				ResourceCentre.setHeader("RETURN");				
				ResourceCentre.setHeader("ITEM TYPES");
				System.out.println("1. Camcorder");
				System.out.println("2. Chromebook");
				
				int itemType = Helper.readInt("Enter option to select item type > ");
				if (itemType == 1) {
					// Return camcorder
					ResourceCentre.returnCamcorder(ccList);
				} else if (itemType == 2) {
					// Return Chromebook
					ResourceCentre.returnChromebook(cbList);
				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 5) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void menu() {
		ResourceCentre.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. Display Inventory");
		System.out.println("2. Add item");
		System.out.println("3. Loan item");
		System.out.println("4. Return item");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}

	//================================= Option 1 View (CRUD - Read) =================================
	public static String retrieveAllCamcorder(ArrayList<Camcorder> ccList) {
		String output = "";

		for (int i = 0; i < ccList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10s %-20d\n", ccList.get(i).getAssetTag(),
					ccList.get(i).getDescription(), 
					ResourceCentre.showAvailability(ccList.get(i).getIsAvailable()),
					ccList.get(i).getDueDate(),ccList.get(i).getOpticalZoom());
		}
		return output;
	}
	public static void viewAllCamcorder(ArrayList<Camcorder> ccList) {
		ResourceCentre.setHeader("CAMCORDER LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION",
				"AVAILABLE", "DUE DATE","OPTICAL ZOOM");
		 output += retrieveAllCamcorder(ccList);	
		System.out.println(output);
	}

	public static String retrieveAllChromebook(ArrayList<Chromebook> chromebookList) {
		String output = "";
		// write your code here
		for (int i = 0; i < chromebookList.size(); i++) {

			output += String.format("%-10s %-30s %-10s %-10s %-20s\n", chromebookList.get(i).getAssetTag(),
					chromebookList.get(i).getDescription(), 
					ResourceCentre.showAvailability(chromebookList.get(i).getIsAvailable()),
					chromebookList.get(i).getDueDate(),chromebookList.get(i).getOs());
		}
		return output;
	}
	public static void viewAllChromebook(ArrayList<Chromebook> chromebookList) {
		
		ResourceCentre.setHeader("CHROMEBOOK LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION",
				 "AVAILABLE", "DUE DATE","OPERATING SYSTEM");
		 output += retrieveAllChromebook(chromebookList);
		System.out.println(output);
	}

	//================================= Option 2 Add (CRUD - Create)=================================
	public static Camcorder inputCamcorder() {
		String tag = Helper.readString("Enter asset tag > ");
		String description = Helper.readString("Enter description > ");
		int zoom = Helper.readInt("Enter optical zoom > ");

		Camcorder cc= new Camcorder(tag, description, zoom);
		return cc;
		
	}
	public static void addCamcorder(ArrayList<Camcorder> ccList, Camcorder cc) {
		
		ccList.add(cc);
		System.out.println("Camcorder added");
	}
	
	public static Chromebook inputChromebook() {
		String tag = Helper.readString("Enter asset tag > ");
		String description = Helper.readString("Enter description > ");
		String os = Helper.readString("Enter operating system > ");

		Chromebook cb= new Chromebook(tag, description, os);
		return cb;
		
	}	
	public static void addChromebook(ArrayList<Chromebook> chromebookList, Chromebook cb) {

		chromebookList.add(cb);
		System.out.println("Chromebook added");
	}
	
	//================================= Option 3 Loan (CURD- Update) =================================
	public static boolean doLoanCamcorder(ArrayList<Camcorder> ccList, String tag, String dueDate) {
		
		boolean isLoaned = false;

		for (int i = 0; i < ccList.size(); i++) {
			
			String assetTag = ccList.get(i).getAssetTag();
			
			if (tag.equalsIgnoreCase(assetTag)				
					&& ccList.get(i).getIsAvailable() == true) {
				
				ccList.get(i).setIsAvailable(false);
				ccList.get(i).setDueDate(dueDate);
				
				isLoaned = true;
				
			}
		}
		return isLoaned;
	}

	public static void loanCamcorder(ArrayList<Camcorder> ccList) {
		ResourceCentre.viewAllCamcorder(ccList);
		String tag = Helper.readString("Enter asset tag > ");
		String due = Helper.readString("Enter due date > ");
		Boolean isLoaned =doLoanCamcorder(ccList, tag, due);
		if (isLoaned == false) {
			System.out.println("Invalid asset tag");
		} else {
			System.out.println("Camcorder " + tag + " loaned out");
		}
	}
	

	public static boolean doLoanChromebook(ArrayList<Chromebook> chromebookList, String tag, String dueDate) {
		// write your code here
		boolean isLoaned = false;

		for (int i = 0; i < chromebookList.size(); i++) {
			String assetTag = chromebookList.get(i).getAssetTag();
			
			if (tag.equalsIgnoreCase(assetTag)
					
					&& chromebookList.get(i).getIsAvailable() == true) {
				
				chromebookList.get(i).setIsAvailable(false);
				chromebookList.get(i).setDueDate(dueDate);
				
				isLoaned = true;
				
			}
		}
		return isLoaned;
	}

	public static void loanChromebook(ArrayList<Chromebook> chromebookList) {
		// write your code here
		ResourceCentre.viewAllChromebook(chromebookList);
		String tag = Helper.readString("Enter asset tag > ");
		String due = Helper.readString("Enter due date > ");
		Boolean isLoaned =doLoanChromebook(chromebookList, tag, due);
		if (isLoaned == false) {
			System.out.println("Invalid asset tag");
		} else {
			System.out.println("Chromebook " + tag + " loaned out");
		}	
		
	}
	//================================= Option 4 Return (CURD- Update)=================================
	public static boolean doReturnCamcorder(ArrayList<Camcorder> ccList,String tag) {
		boolean isReturned = false;

		for (int i = 0; i < ccList.size(); i++) {
			if (tag.equalsIgnoreCase(ccList.get(i).getAssetTag())
					&& ccList.get(i).getIsAvailable() == false) {
				ccList.get(i).setIsAvailable(true);
				ccList.get(i).setDueDate("");
				isReturned = true;
				
			}
		}
		return isReturned;
		
	}

	public static void returnCamcorder(ArrayList<Camcorder> ccList) {
		ResourceCentre.viewAllCamcorder(ccList);
		String tag = Helper.readString("Enter asset tag > ");
		Boolean isReturned = doReturnCamcorder(ccList, tag);
		
		if (isReturned == false) {
			System.out.println("Invalid asset tag");
		} else {
			System.out.println("Camcorder " + tag + " returned");
		}
	}
	// write your doReturnChromebook code here
	public static boolean doReturnChromebook(ArrayList<Chromebook> chromebookList,String tag) {
		boolean isReturned = false;

		for (int i = 0; i < chromebookList.size(); i++) {
			if (tag.equalsIgnoreCase(chromebookList.get(i).getAssetTag())
					&& chromebookList.get(i).getIsAvailable() == false) {
				chromebookList.get(i).setIsAvailable(true);
				chromebookList.get(i).setDueDate("");
				isReturned = true;
				
			}
		}
		return isReturned;
		
	}
	public static void returnChromebook(ArrayList<Chromebook> chromebookList) {
		// write your code here
		ResourceCentre.viewAllChromebook(chromebookList);
		String tag = Helper.readString("Enter asset tag > ");
		Boolean isReturned = doReturnChromebook(chromebookList, tag);
		
		if (isReturned == false) {
			System.out.println("Invalid asset tag");
		} else {
			System.out.println("Chromebook " + tag + " returned");
		}
	}


}
