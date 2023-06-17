import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Park {
    HashMap <String,ParkingSlots> parkingSlotsHashMap;

    ArrayList <String> shops = new ArrayList<String>();
    private String entrance;

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public Park() {
        parkingSlotsHashMap = new HashMap<>();
        AddParkingSlotsIntoHashmap();
    }
    public void AddParkingSlotsIntoHashmap(){
        for (int i = 1;i <= 10;i++ ){
            ParkingSlots p = new ParkingSlots("P" + i);
            if (i % 3 == 0){
                p.setOccupy(true);
            }
            if (i >= 8){
                p.setDisabledElectric(true);
            }

            parkingSlotsHashMap.put(p.getName(),p);
        }
    }
    public void DisplaySlots(){
        String[] keys = new String[16];
        int i = 1;
        for (String name : parkingSlotsHashMap.keySet()){
            keys[i] = name;
            i++;
        }
        for (int j = 1; j <= 5; j++) {
            System.out.printf("%s\t%s",parkingSlotsHashMap.get(keys[j]).getAppearance(),parkingSlotsHashMap.get(keys[j + 5]).getAppearance());
            System.out.println();
        }
    }

    public boolean displayByEntrance(String shop){

        shops.add("Mango");
        shops.add("Koton");
        shops.add("Pull&Beer");
        shops.add("H&M");
        shops.add("Boyner");
        shops.add("Zara");
        shops.add("Bershka");
        shops.add("KFC");
        shops.add("Konyalım");
        shops.add("Rossmann");


        int shopIndex = shops.indexOf(shop);
        shops.indexOf(shop);

        if (shopIndex == -1){
            return false;
        }

        else if (shopIndex <= 1){
            System.out.printf("%s\n%s", parkingSlotsHashMap.get("P1").getAppearance(), parkingSlotsHashMap.get("P2").getAppearance());
        }
        else if (shopIndex <= 3){
            System.out.printf("%s\n%s\n%s", parkingSlotsHashMap.get("P3").getAppearance(), parkingSlotsHashMap.get("P4").getAppearance(),
                    parkingSlotsHashMap.get("P5").getAppearance());
        }
        else if(shopIndex <= 5){
            System.out.printf("%s\n%s", parkingSlotsHashMap.get("P6").getAppearance(), parkingSlotsHashMap.get("P7").getAppearance());
        }
        else{
            System.out.printf("%s\n%s\n%s", parkingSlotsHashMap.get("P8").getAppearance(), parkingSlotsHashMap.get("P9").getAppearance(),
                    parkingSlotsHashMap.get("P10").getAppearance());
        }
        return true;
    }


    public void selectEntrance() {
        System.out.println("Select the entrance (north/south): ");
        Scanner scanner = new Scanner(System.in);
        String entrance = scanner.nextLine().toLowerCase();

        if (entrance.equals("north")) {
            System.out.printf("%s\n%s\n%s\n%s", parkingSlotsHashMap.get("P1").getAppearance(),
                    parkingSlotsHashMap.get("P2").getAppearance(), parkingSlotsHashMap.get("P6").getAppearance(),
                    parkingSlotsHashMap.get("P7").getAppearance());
        } else if (entrance.equals("south")) {
            System.out.printf("%s\n%s\n%s\n%s\n%s\n%s", parkingSlotsHashMap.get("P3").getAppearance(),
                    parkingSlotsHashMap.get("P4").getAppearance(), parkingSlotsHashMap.get("P5").getAppearance(),
                    parkingSlotsHashMap.get("P8").getAppearance(), parkingSlotsHashMap.get("P9").getAppearance(),
                    parkingSlotsHashMap.get("P10").getAppearance());
        } else {
            System.out.println("Invalid entrance selection!");
        }
    }



    public void SelectSlot(User user){
        Scanner scanner = new Scanner(System.in);
        while (true){
            String temp,choice;
            System.out.println("Please Enter the slot name / -1 to exit");
            temp = scanner.nextLine();
            temp = temp.toUpperCase();
            if (parkingSlotsHashMap.containsKey(temp)) {
                parkingSlotsHashMap.get(temp).setSelected(true);
                DisplaySlots();
                if (parkingSlotsHashMap.get(temp).isSelected()){
                    System.out.println(temp + " is selected Do you want to book?");
                    System.out.println("y/n");
                    choice = scanner.nextLine();
                    if (choice.equals("y")){
                        parkingSlotsHashMap.get(temp).setSelected(false);
                        user.Booking(parkingSlotsHashMap.get(temp));
                        DisplaySlots();
                        System.out.println(parkingSlotsHashMap.get(temp).getName() + " Booked");
                        break;
                    }
                    else{
                        parkingSlotsHashMap.get(temp).setSelected(false);
                        DisplaySlots();
                    }
                }
            } else if (temp.equals("-1"))
                break;
        }
    }
}
