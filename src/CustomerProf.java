public class CustomerProf {
    private String adminID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private float income;
    private String status;
    private String use;
    public VehicleInfo vehicleInfo;

    //Constructor for items within a customer's profile (when parameters are given)
    public CustomerProf(String adminID, String firstName, String lastName, String address, String phone, float income, String status, String use, VehicleInfo vehicleInfo) {
        this.adminID = adminID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.income = income;
        this.status = status;
        this.use = use;
        this.vehicleInfo = vehicleInfo;
        //System.out.println("Your Profile has been created successfully");
    }
    //Constructor for items within a customer's profile (when parameters are NOT given)
    public CustomerProf(){
        adminID = "";
        firstName = "";
        lastName = "";
        address = "";
        phone = "";
        income = 0;
        status = "";
        use = "";
        vehicleInfo = null;

        System.out.println("Your Profile has been created, but please update: ");
        System.out.println("adminID");
        System.out.println("firstName");
        System.out.println("lastName");
        System.out.println("address");
        System.out.println("phone");
        System.out.println("income");
        System.out.println("status");
        System.out.println("use");
        System.out.println("vehicleInfo");

    }


    //Getters
    public String getAdminID() {
        return adminID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public float getIncome() {
        return income;
    }

    public String getStatus() {
        return status;
    }

    public String getUse() {
        return use;
    }
    public VehicleInfo getVehicleInfo() {
        return vehicleInfo;
    }

    //Setters/Updaters
    public void updateFirstName(String firstName) {
        this.firstName = firstName;
        System.out.println("Your first name has been updated successfully");
    }
    public void updateLastName(String lastName) {
        this.lastName = lastName;
        System.out.println("Your last name has been updated successfully");
    }

    public void updateAddress(String address) {
        this.address = address;
        System.out.println("Your address has been updated successfully");
    }

    public void updatePhone(String phone) {
        this.phone = phone;
        System.out.println("Your phone number has been updated successfully");
    }

    public void updateIncome(float income) {
        this.income = income;
        System.out.println("Your income has been updated successfully");
    }

    public void updateStatus(String status) {
        this.status = status;
        System.out.println("Your status has been updated successfully");
    }
    public void updateUse(String use) {
        this.use = use;
        System.out.println("Your use has been updated successfully");
    }

    public void updateVehicleInfo(VehicleInfo vehicleInfo){
        this.vehicleInfo = vehicleInfo;
        System.out.println("Your vehicle information has been updated successfully");
    }

    public static void main(String[] args) {
        VehicleInfo mycar = new VehicleInfo("Jeep Wrangler", "2002", "hatchback", "new");
        VehicleInfo mycar2 = new VehicleInfo("Toyota Hyundai", "1999", "luxury", "used");
        CustomerProf p = new CustomerProf("LMD123","Liam","Devlin","2 Belle Haven Drive", "406 434 3362", 90000, "Single", "None", mycar);
        System.out.println(p.getFirstName());
        System.out.println(p.getLastName());
        System.out.println(p.getAddress());
        System.out.println(p.getIncome());
        System.out.println(p.getPhone());
        System.out.println(p.getUse());
        System.out.println(p.getStatus());
        p.getVehicleInfo().show_vehicle();
        p.updateFirstName("John");
        p.updateLastName("Johnson");
        p.updateAddress("123 Generic Street");
        p.updateIncome(42000);
        p.updateStatus("Married");
        p.updateUse("business");
        p.updatePhone("860 867 5309");
        p.updateVehicleInfo(mycar2);
        System.out.println(p.getFirstName());
        System.out.println(p.getLastName());
        System.out.println(p.getAddress());
        System.out.println(p.getIncome());
        System.out.println(p.getPhone());
        System.out.println(p.getUse());
        System.out.println(p.getStatus());
        p.getVehicleInfo().show_vehicle();





    }
}