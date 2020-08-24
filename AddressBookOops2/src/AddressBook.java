import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AddressBook implements AddressBookInterface {
	public String firstname;
	public String lastname;
	public String city;
	public String state;
	public int zipcode;
	public String phonenumber;
	public String fileuse;
	public static File file;
	public FileReader fr;
	public FileWriter fileWriter;
	public BufferedWriter bw;
	public BufferedReader br;
	public PrintWriter pw;
	public static String path = "E:\\Pradip\\AddressBookOops2\\";
	public static Scanner sc = new Scanner(System.in);
	public ArrayList<Person> personarraylist1 = new ArrayList<Person>(100);

	@Override
	public String acess() throws FileNotFoundException, IOException {
		System.out.println("In which AddressBook You want to Perform Operation\n");
		fileuse = sc.next();
		file = new File(path + fileuse + ".txt");
		if (file.isFile()) {
			return fileuse;
		} else

			return null;
	}

	@Override
	public String addperson(String fileuse) throws IOException {
		System.out.println("Enter First Name :");
		firstname = sc.next();
		System.out.println("Enter Last Name :");
		lastname = sc.next();
		System.out.println("Enter City :");
		city = sc.next();
		System.out.println("Enter State :");
		state = sc.next();
		System.out.println("Enter Zip Code :");
		zipcode = sc.nextInt();
		System.out.println("Enter Phone Number:");
		phonenumber = sc.next();
		personarraylist1.add(new Person(firstname, lastname, city, state, zipcode, phonenumber));
		fileWriter = new FileWriter(path + fileuse + ".txt", true);
		bw = new BufferedWriter(fileWriter);
		for (int J = 0; J < personarraylist1.size(); J++) {
			bw.write(personarraylist1.get(J).toString() + "\n");
		}
		System.out.println("Data Saved in AddressBook ");

		bw.close();
		fileWriter.close();
		return null;
	}

	@Override
	public String Display(String fileuse) throws IOException {
		System.out.println("Data Present in System :");
		System.out.println("FirstName || LastName || City || State || Zipcode || PhoneNumber ||");
		Scanner scanner = new Scanner(new File(path + fileuse + ".txt"));
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			System.out.println(line);
		}
		System.out.println(" \n\n");
		file.exists();
		scanner.close();

		return null;
	}

	@Override
	public String editperson(String fileuse) throws FileNotFoundException, IOException {

		return null;
	}

	@Override
	public String deleteperson(String fileuse) throws IOException {
		System.out.println("Enter Name for Delete");
		String lineToRemove = sc.next();
		File inFile = new File((path + fileuse + ".txt"));
		File tempFile = new File(path + fileuse + ".tmp");
		BufferedReader br = new BufferedReader(new FileReader(inFile));
		PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

		String line = null;
		while ((line = br.readLine()) != null) {

			if (!line.trim().contains(lineToRemove)) {

				pw.println(line);
				pw.flush();
			}
		}
		pw.close();
		br.close();

		inFile.delete();
		System.out.println("Data deleted From AddressBook");
		tempFile.renameTo(inFile);
		System.out.println(" ");

		return null;
	}

	@Override
	public String searchperson(String fileuse)
			throws ReflectiveOperationException, RuntimeException, FileNotFoundException, IOException {
		File input = new File((path + fileuse + ".txt"));
		FileReader fr = null;
		Scanner ob = new Scanner(System.in);
		String search, str;
		System.out.println("Please enter number for search :");
		search = ob.nextLine();
		fr = new FileReader(input);
		br = new BufferedReader(fr);
		while ((str = br.readLine()) != null) {
			if (str.contains(search))

				System.out.println("Data found: \n" + str);
			System.out.println("-------------------------------");
		}
		fr.close();
		br.close();
		return null;
	}

	@Override
	public String sortbyzipperson(String fileuse) throws FileNotFoundException, IOException {

		File inFile = new File((path + fileuse + ".txt"));
		File inFile2 = new File((path + fileuse + "SortByzip.txt"));
		BufferedReader reader = new BufferedReader(new FileReader(inFile));
		ArrayList<Person> lines2 = new ArrayList<Person>();
		String currentLine = reader.readLine();
		while (currentLine != null) {
			String[] persondrtails = currentLine.split("  ");
			String firstname = persondrtails[0];
			String lastname = persondrtails[1];
			String city = persondrtails[2];
			String state = persondrtails[3];
			int zipcode = Integer.valueOf(persondrtails[4]);
			String phonenumber = persondrtails[5];
			lines2.add(new Person(firstname, lastname, city, state, zipcode, phonenumber));
			currentLine = reader.readLine();
		}
		Collections.sort(lines2, new Sortbyzip());
		BufferedWriter writer = new BufferedWriter(new FileWriter(inFile2));

		System.out.println("Data after Sort By Zip: ");
		for (Person P : lines2) {
			System.out.println(P);
			writer.write(P.firstname);
			writer.write("  " + P.lastname);
			writer.write("  " + P.city);
			writer.write("  " + P.state);
			writer.write("  " + P.zipcode);
			writer.write("  " + P.phonenumber);
			writer.newLine();
		}
		System.out.println("");
		writer.close();
		reader.close();

		return null;
	}

	@Override
	public String sortbynameperson(String fileuse) throws FileNotFoundException, IOException {
		File inFile = new File((path + fileuse + ".txt"));
		File inFile2 = new File((path + fileuse + "SortByname.txt"));
		BufferedReader reader = new BufferedReader(new FileReader(inFile));
		ArrayList<String> lines = new ArrayList<String>();
		String currentLine = reader.readLine();
		while (currentLine != null) {
			lines.add(currentLine);
			currentLine = reader.readLine();
		}
		Collections.sort(lines);
		BufferedWriter writer = new BufferedWriter(new FileWriter(inFile2));
		System.out.println("Data after Sort By Name: ");
		for (String line : lines) {
			writer.write(line);
			writer.newLine();
		}
		System.out.println("");
		writer.close();
		reader.close();

		return null;
	}

}