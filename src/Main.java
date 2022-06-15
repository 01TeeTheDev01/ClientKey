import com.client.classes.*;
import com.client.data.CustomerKeysList;
import com.client.interfaces.ICustomer;

import java.io.*;
import java.util.Scanner;


public class Main {

    private static File txtFile;
    private static FileWriter writer;
    private static Scanner reader;

    private static ICustomer _thabiso, _andy, _jermaine, _fred, _jones, _isaac, _idah;

    public static void main(String[] args) throws IOException
    {
        System.out.printf("%nCustomer keys data repository%n");

        try
        {
            //txtFile = new File("/home/developer/Documents/Customerdata.txt");

            txtFile = new File("customerdata.txt");

            if (!txtFile.exists())
            {
                boolean result = txtFile.createNewFile();

                System.out.printf("%nMessage -> %s created successfully!%nPath -> %s%n",
                                    txtFile.getName(), txtFile.getPath());

                if (result)
                {
                    writer = new FileWriter(txtFile);
                    writeDataToFile(writer);
                }
            }
            else
            {
                writer = new FileWriter(txtFile);
                writeDataToFile(writer);
                readerDataFromFile(txtFile);
            }
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    private static void writeDataToFile(FileWriter f) throws IOException
    {
        _thabiso = new CustomerBuilder();
        _thabiso.withFirstName("Thabiso")
                .withMiddleName("Joseph")
                .withLastName("Maleka")
                .withDOB("sa", "12", "2")
                .buildObject();

        _andy = new CustomerBuilder();
        _andy.withFirstName("Andy")
                .withMiddleName("Timothy")
                .withLastName("Wallace")
                .withDOB("1986", "3","20")
                .buildObject();

        _jermaine = new CustomerBuilder();
        _jermaine.withFirstName("Jermaine")
                .withMiddleName("")
                .withLastName("Hopkins")
                .withDOB("2004", "1","3")
                .buildObject();

        _fred = new CustomerBuilder();
        _fred.withFirstName("Freddie")
                .withMiddleName("Dusty")
                .withLastName("Walton")
                .withDOB("1976", "8","9")
                .buildObject();

        _jones = new CustomerBuilder();
        _jones.withFirstName("Amber")
                .withMiddleName("")
                .withLastName("Jones")
                .withDOB("1989", "9","13")
                .buildObject();

        _isaac = new CustomerBuilder();
        _isaac.withFirstName("Isaac")
                .withMiddleName("Mokwepa")
                .withLastName("Maleka")
                .withDOB("2004", "6","23")
                .buildObject();

        _idah = new CustomerBuilder();
        _idah.withFirstName("Idah")
                .withMiddleName("Ntswaki")
                .withLastName("Maleka")
                .withDOB("0", "11","5")
                .buildObject();


        for(Customer obj : CustomerKeysList.customerCollectedData)
        {
            try
            {
                f.write(String.format("%s\r", obj .toString()));
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }

        f.flush();

        f.close();

        System.out.printf("%nData processed: %s records%n", CustomerKeysList.customerCollectedData.size());
    }

    private static void readerDataFromFile(File txt)
    {
        System.out.printf("%nCustomer data read from file%n%n");

        try
        {
            reader = new Scanner(txt);

            int index = 0;

            while (reader.hasNextLine())
            {
                // define correct format for customer key
                String out = String.format("| %s %s\r", CustomerKeysList.getCustomerKeysCollectionData().get(index), reader.nextLine());

                System.out.println(out);

                writer = new FileWriter(txtFile);

                //write customer key data in correct format
                writer.write(out);

                index++;
            }

            writer.flush();

            writer.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }

        reader.close();
    }
}
