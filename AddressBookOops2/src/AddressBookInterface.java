import java.io.*;


public interface AddressBookInterface {
	public String addperson(String fileuse) throws IOException;

	public String editperson(String fileuse) throws FileNotFoundException, IOException;

	public String deleteperson(String fileuse) throws IOException;

	public String searchperson(String fileuse) throws ReflectiveOperationException, RuntimeException, FileNotFoundException, IOException;

	public String sortbyzipperson(String fileuse) throws FileNotFoundException, IOException;

	public String sortbynameperson(String fileuse) throws FileNotFoundException, IOException;
	
	public String Display(String fileuse) throws IOException;
 
	public String acess() throws FileNotFoundException, IOException;
}

