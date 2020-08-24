import java.io.*;

public interface AddressBookManagerInterface {

	public File newaddressbook() throws IOException;

	public FileWriter openaddressbook() throws ReflectiveOperationException, RuntimeException, IOException;

	public void saveaddressbook(File filename) throws IOException;

	public void saveasaddressbook();

	public void closeaddressbook(FileWriter fwriter) throws IOException;

	public void quit();
	
	public void showAddressBook();

}
