import java.util.ArrayList;

public class  User {
    private String name;
    private String userName;
    private String password;
    private int age;
    private String phoneNumber;
    private String email;
    private String car;
    private String model;
    private String year;
    private String carPlate;
    private String fuelType;
    private ArrayList<ParkingSlots> books;



    public User(String name, String userName,String password, int age, String phoneNumber, String email, String car, String model, String year, String carPlate, String fuelType) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.car = car;
        this.model = model;
        this.year = year;
        this.carPlate = carPlate;
        this.fuelType = fuelType;
        books = new ArrayList<>();
    }
    public void displayInformation(){
        System.out.println("---------------------------------------------");
        System.out.println("Name : " + getName());
        System.out.println("Car : " + getCar());
        System.out.println("Model : " + getModel());
        System.out.println("Plate Number : " + getCarPlate());
        System.out.println("Fuel Type : " + getFuelType());
        System.out.println("Car Type : " + "Disabled");
    }
    public void Booking(ParkingSlots parkingSlots){
        books.add(parkingSlots);
        parkingSlots.setOccupy(true);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String carPlate) {
        this.carPlate = carPlate;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    public void getBooks() {
        System.out.println("--------RESERVATIONS--------");
        for (ParkingSlots p : books){
            System.out.println(p.getName());
        }

    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

