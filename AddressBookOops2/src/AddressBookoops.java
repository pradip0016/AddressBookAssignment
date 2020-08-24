
import java.io.*;
import java.util.*;

public class AddressBookoops {
	static File ob;
	static File file;
	static FileWriter fwriter;
	String cho;
	public FileReader fr;
	static Scanner sc = new Scanner(System.in);

public static void main(String[] args) throws IOException, ReflectiveOperationException, RuntimeException {
		while (true) {
			System.out.println("1) create new Address Book \n" + "2) Open Address Book \n" + "3) Save Address Book \n"
					+ "4) Save As Address Book \n" + "5) Close Address Book \n" + "6) Quit \n"
					+ "7) Show AddressBooks\n");
			System.out.println("Please Enter Your Choice \n");
			int ch = sc.nextInt();
			AddressBookManager AddressbookManagerImplementation = new AddressBookManager();
			AddressBook addressbook=new AddressBook();
			
			switch (ch)

			{
			case 1:
				ob=AddressbookManagerImplementation.newaddressbook();
				break;
			case 2:			
				
				AddressbookManagerImplementation.openaddressbook();
				break;
			case 3:
				AddressbookManagerImplementation.saveaddressbook(ob);;
				break;
			case 4:
				AddressbookManagerImplementation.saveasaddressbook();
				break;
			case 5:
				AddressbookManagerImplementation.closeaddressbook(fwriter);
				break;
			case 6:
				AddressbookManagerImplementation.quit();
				break;
			case 7:
				AddressbookManagerImplementation.showAddressBook();
				break;
			default:
				System.out.println("Wrong choice please enter choice from above menu");

			}

		}
}
}