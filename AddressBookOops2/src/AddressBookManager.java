import java.io.*;
import java.util.Scanner;

public class AddressBookManager implements AddressBookManagerInterface {
	public String fileName;
	public String fileuse;
	public FileReader fr;
	public FileWriter fileWriter;
	public BufferedWriter bw;
	public static File file;
	public static String path = "E:\\Pradip\\AddressBookOops2\\";
	public static Scanner sc = new Scanner(System.in);

	@Override
	public File newaddressbook() throws IOException {
		System.out.print("Enter the desired name of your Book: ");
		fileName = sc.next();
		fileName = fileName + ".txt";
		file = new File(path + fileName);
		return file;
	}

	@Override
	public void saveaddressbook(File fileName) throws IOException {
		System.out.println("Do U want To save created Address Book Y/N");
		String op = sc.next();
		if (op.equalsIgnoreCase("Y")) {
			fileName.createNewFile();
			System.out.println("Saved ");
		} else {
			System.out.println("Notsaved");
		}

	}

	@Override
	public void saveasaddressbook() {

		System.out.println("AddressBook Present in System \n");
		File f = new File(path);
		String[] s = f.list();
		for (String s1 : s) {
			System.out.println(s1);
		}
		System.out.println("Please enter name which book want to rename");
		String filename = sc.next();
		System.out.println("please enter new name of book");
		String newname = sc.next();
		File oldFile = new File((path + filename + ".txt"));
		File newFile = new File(path + newname + ".txt");
		if (oldFile.renameTo(newFile)) {
			System.out.println("file renamed and saved");
		} else

		{
			System.out.println("file not saved as ");

		}

	}

	@Override
	public void closeaddressbook(FileWriter fwriter) throws IOException {
		fwriter.close();
		System.out.println("AddressBook Closed");
	}

	@Override
	public void quit() {
		System.exit(0);
	}

	@Override
	public void showAddressBook() {

		System.out.println("AddressBook Present in System \n");
		File f = new File(path);
		String[] s = f.list();
		for (String s1 : s) {
			System.out.println(s1);
		}
		System.out.println("======================");

	}

	@Override
	public FileWriter openaddressbook() throws ReflectiveOperationException, RuntimeException, IOException {
		AddressBook AddressBook = new AddressBook();
		fileuse = AddressBook.acess();
		if (fileuse != null) {
			fileuse = fileuse;
			System.out.println("Please Enter Your Choice \n");
			System.out.println("1) Add Person \n" + "2) Edit Person \n" + "3) Delete Person \n" + "4) Search Person \n"
					+ "5) Sort ByZip \n" + "6) Sort ByName \n" + "7) Display");
			int ch2 = sc.nextInt();
			switch (ch2) {
			case 1:
				AddressBook.addperson(fileuse);
				break;
			case 2:
				AddressBook.editperson(fileuse);
				break;
			case 3:
				AddressBook.deleteperson(fileuse);
				break;
			case 4:
				AddressBook.searchperson(fileuse);
				break;
			case 5:
				AddressBook.sortbyzipperson(fileuse);
				break;
			case 6:
				AddressBook.sortbynameperson(fileuse);
				break;
			case 7:
				AddressBook.Display(fileuse);
				break;
			default:
				System.out.println("enter correct choice");
			}
		} else {
			System.out.println("Book not Present Create First and save Book");
		}
		return null;

	}

}
