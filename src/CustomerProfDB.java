import java.util.Arrays;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CustomerProfDB {

    private int numCustomer;
    public CustomerProf[] customerList;
    private String fileName;
    private int currentCustomerIndex = 0;


    //Constructor for DB of customer profiles
    public CustomerProfDB(String fileName){
        this.fileName = fileName;
        initializeDatabase(fileName); //Initializes database upon creation of the database
    }

    public void initializeDatabase(String fileName) {
        try { //This try and catch method sees if file exists within the local directory, if not, creates the file
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File DOES NOT exist, creation and initialization started . . .");
            } else {
                System.out.println("File exists, initialization started . . .");
            }
        } catch (IOException e) { //Will throw exception if fileName is incorrect in its shape/form
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) { //Another try and catch method for buffered reading of file
            String str;
            int lineCount = 0;

            List<String> rawData = new ArrayList<String>(); //Stores data read from file in an ArrayList called rawData
            while((str = in.readLine()) != null){
                rawData.add(str);
                lineCount++; //Counts total lines in file for later use
            }

            String[] stringRawData = rawData.toArray(new String[0]);

            numCustomer = lineCount / 12;
            customerList = new CustomerProf[numCustomer];

            int i = 0;

            while ( i < numCustomer) {                       //Every 12 lines are input to the corresponding customer number
                for (int j = 12; j < lineCount + 1; j+= 12){ //Ex of this: customer 1 is lines 1-12, 2 is 13-25, etc . . .
                    customerList[i] = new CustomerProf(stringRawData[j - 12],
                            stringRawData[j - 11],
                            stringRawData[j - 10],
                            stringRawData[j - 9],
                            stringRawData[j - 8],
                            Float.parseFloat(stringRawData[j - 7]),
                            stringRawData[j - 6],
                            stringRawData[j - 5],
                            new VehicleInfo(stringRawData[j - 4], stringRawData[j - 3], stringRawData[j - 2], stringRawData[j - 1]));
                    i++;
                }
            }

        } catch (IOException e) { //Will throw exception if reading of file does not work as expected
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //Gets fileName (Function we added to easily check fileName)
    public String getFileName(){
        return fileName;
    }

    //Appends new customer profile to end of the list of customers
    public void insertNewProfile(CustomerProf newProfile){
        customerList = Arrays.copyOf(customerList, customerList.length + 1);
        customerList[customerList.length - 1] = newProfile;
        currentCustomerIndex = customerList.length - 1;
        System.out.println("New profile inserted successfully.");
    }

    //Finds profile based on adminID and lastName
    public CustomerProf findProfile(String aID, String lN) {
        for (int i = 0; i < customerList.length; i++) {
            if ((customerList[i].getAdminID().equals(aID)) && (customerList[i].getLastName().equals(lN))) {
                System.out.println("Profile found! This profile belongs to " + customerList[i].getFirstName() + " " + customerList[i].getLastName() + "." );
                currentCustomerIndex = i;
                return customerList[i];
            }
        }
        System.out.println("No such profile exists.");
        return null;
    }

    //Deletes customer profile according to adminID and last name, returns true if went through false if not
    public boolean deleteProfile(String aID, String lN){
        for (int i = 0; i < customerList.length; i ++){
            if ((customerList[i].getAdminID().equals(aID)) && (customerList[i].getLastName().equals(lN))){
                System.arraycopy(customerList, i + 1 , customerList, i, customerList.length - 1 - i);
                customerList = Arrays.copyOf(customerList, customerList.length  - 1);
                System.out.println("Profile deleted successfully.");
                currentCustomerIndex = i;
                return true;
            }
        }
        System.out.println("It looks like that customer profile you want to delete does not exist.");
        return false;
    }

    public CustomerProf findFirstProfile(){
        System.out.println("Profile found! The first profile belongs to " + customerList[0].getFirstName() + " " + customerList[0].getLastName() + "." );
        currentCustomerIndex = 0;
        return customerList[0]; //The first customer profile is returned
    }

    public CustomerProf findNextProfile() throws Exception {
        if (currentCustomerIndex >= numCustomer) {
            throw new Exception("There is no next profile.");
        }
        else {
            System.out.println("Profile found! The next found profile belongs to " + customerList[currentCustomerIndex + 1].getFirstName() + " " + customerList[currentCustomerIndex + 1].getLastName() + ".");
            return customerList[currentCustomerIndex + 1];
        }
    }

    public void writeAllCustomerProf(){
        try {
            FileWriter w = new FileWriter(fileName);
            for (int i = 0; i < customerList.length; i++) {
                w.write("" + customerList[i].getAdminID() + "\n");
                w.write("" + customerList[i].getFirstName() + "\n");
                w.write("" + customerList[i].getLastName() + "\n");
                w.write("" + customerList[i].getAddress() + "\n");
                w.write("" + customerList[i].getPhone() + "\n");
                w.write("" + customerList[i].getIncome() + "\n");
                w.write("" + customerList[i].getStatus() + "\n");
                w.write("" + customerList[i].getUse() + "\n");
                w.write("" + customerList[i].getVehicleInfo().getModel() + "\n");
                w.write("" + customerList[i].getVehicleInfo().getYear() + "\n");
                w.write("" + customerList[i].getVehicleInfo().getType() + "\n");
                w.write("" + customerList[i].getVehicleInfo().getMethod() + "\n");
            }
            w.close();
            System.out.println("Wrote to the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        VehicleInfo mycar = new VehicleInfo("Jeep Wrangler", "2002", "car", "n");
        CustomerProf p = new CustomerProf("LMD123","Liam","Devlin","2 Belle Haven Drive", "406 434 3362", 90000, "Single", "None", mycar);

        CustomerProfDB DB1 = new CustomerProfDB("TCs.txt");


        DB1.findProfile("PA1", "Munira");
        DB1.deleteProfile("PA1", "Munira");
        DB1.insertNewProfile(p);
        DB1.findProfile("LMD123", "Devlin");
        DB1.deleteProfile("LMD123", "Devlin");
        DB1.findProfile("PA1", "Munira");
        DB1.findProfile("LMD123", "Devlin");
        DB1.findFirstProfile();
        DB1.findNextProfile();
        DB1.writeAllCustomerProf();
    }
}
