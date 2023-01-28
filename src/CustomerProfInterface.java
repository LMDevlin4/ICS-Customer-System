import java.util.Objects;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class CustomerProfInterface {
    CustomerProfDB current;

    public CustomerProfInterface(String filename)
    {
        current = new CustomerProfDB(filename);
    }
    public boolean deleteCustomerProf(String admin, String last)
    {
        return (current.deleteProfile(admin, last));

    }
    public String[] findCustomerProf(String admin, String last)
    {
        String[] cusInfo = displayCustomerProf(current.findProfile(admin, last));
        return cusInfo;
    }
    public int updateCustomerProf(String admin, String last, int choice, String newin)
    {
        CustomerProf c = current.findProfile(admin, last);

        int exists = 1;

        if (current.findProfile(admin, last) == null){
            exists = 0;
            return exists;
        }

        if(choice == 1)
        {
            c.updateAddress(newin);
        }
        else if(choice == 2)
        {
            c.updatePhone(newin);
        }
        else if(choice == 3)
        {
            c.updateUse(newin);
        }
        else if(choice == 4)
        {
            c.updateStatus(newin);
        }
        else if(choice == 5)
        {
            c.vehicleInfo.updateModel(newin);
        }
        else if(choice == 6)
        {
            c.vehicleInfo.updateYear(newin);
        }
        else if(choice == 7)
        {
            c.vehicleInfo.updateType(newin);
        }
        else if(choice == 8)
        {
            c.vehicleInfo.updateMethod(newin);
        }
        else if(choice == 9)
        {
            float f = Float.parseFloat(newin);
            c.updateIncome(f);
        }

        return exists;

    }
    public String[] displayCustomerProf(CustomerProf c) {

        if (c != null) {
            String sincome = Float.toString(c.getIncome());

            String[] cusInfo = {
                    c.getAdminID(),
                    c.getFirstName(),
                    c.getLastName(),
                    c.getAddress(),
                    sincome,
                    c.getPhone(),
                    c.getUse(),
                    c.getStatus(),
                    c.getVehicleInfo().getModel(),
                    c.getVehicleInfo().getYear(),
                    c.getVehicleInfo().getType(),
                    c.getVehicleInfo().getMethod(),
            };

            return cusInfo;

        }

        return null;
    };
    public ArrayList<String[]> displayAllCustomerProf(String admin)
    {
        ArrayList<String[]> customerMatches = new ArrayList<String[]>();
        for(int i = 0; i < current.customerList.length; i++)
        {
            if (current.customerList[i].getAdminID().equals(admin))
            {
                customerMatches.add(displayCustomerProf(current.customerList[i]));
            }
        }
        return customerMatches;
    }
    public void writeToDB()
    {
        current.writeAllCustomerProf();
    }
    public VehicleInfo createNewVehicleInfo(String model, String year, String type, String method)
    {
        VehicleInfo v = new VehicleInfo(model, year, type, method);
        return v;
    }
    public CustomerProf createNewCustomerProf(String admin, String first, String last, String address, String phone, float income, String status, String use, String model, String year, String type, String method)
    {
        VehicleInfo v = createNewVehicleInfo(model, year, type, method);
        CustomerProf c = new CustomerProf(admin, first, last, address, phone, income, status, use, v);
        return c;
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please Enter File you Wish to Work With");
        String file = in.nextLine();
        CustomerProfInterface DB = new CustomerProfInterface(file);
        new MainMenuGUI(DB);
    }
}
