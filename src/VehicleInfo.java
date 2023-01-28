import java.util.Objects;

public class VehicleInfo {
    //model, year, type
    //of vehicle, and whether it was new, certified pre-owned or used.
    public String model;
    public String year;
    public String type;
    public String age;

    public VehicleInfo(String modelin, String yearin, String typein, String agein) {
        model = modelin;
        year = yearin;
        type = typein;
        age = agein;
    }

    public void updateModel(String modelin){
        model = modelin;
        System.out.println("Model successfully changed.");
    }

    public void updateYear(String yearin){
        year = yearin;
        System.out.println("Year successfully changed.");
    }

    public void updateType(String typein){
        type = typein;
        System.out.println("Type successfully changed.");
    }

    public void updateMethod(String agein){
        age = agein;
        System.out.println("Age marker successfully changed.");
            }

    public String getModel(){
        return model;
        }
    public String getYear(){ return year; }
    public String getType(){ return type; }
    public String getMethod(){ return age; }

    public void show_vehicle() {
            System.out.print("Vehicle Model: ");
            System.out.println(model);
            System.out.print("Vehicle year: ");
            System.out.println(year);
            System.out.print("Vehicle type: ");
            System.out.println(type);
            System.out.print("This vehicle is ");
            System.out.println(age);
        }
    public static void main (String[ ] args)
    {
        VehicleInfo mycar = new VehicleInfo("Jeep Wrangler", "2002", "hatchback", "new");
        mycar.show_vehicle();
        mycar.updateModel("Honda CRV");
        mycar.show_vehicle();
        mycar.updateMethod("certified pre-owned");
        mycar.show_vehicle();
        mycar.updateType("SUV");
        mycar.show_vehicle();
        mycar.updateYear("2004");
        mycar.show_vehicle();
        System.out.println(mycar.getMethod());
        System.out.println(mycar.getModel());
        System.out.println(mycar.getType());
        System.out.println(mycar.getYear());
    }
}
