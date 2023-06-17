import java.util.HashMap;
import java.util.Scanner;

public class Login {
    static HashMap<String,User> users = new HashMap<>();

    public Login() {
        users.put("oliver",new User("Oliver Cornell","oliver","1234",35,"5468796758","olivercornell@gmail.com","BMW","520d","2021","35SE35","Diesel"));
    }

    public void Authorization(){
        String tempUserName;
        String tempPassword;
        Scanner scanner = new Scanner(System.in);

        System.out.println("------------Login-------------");
        System.out.println("UserName");
        tempUserName = scanner.next();

        System.out.println("Password");
        tempPassword = scanner.next();

        for (String userName : users.keySet()){
            if (userName.equals(tempUserName) && users.get(userName).getPassword().equals(tempPassword)){
                Menu(users.get(tempUserName));
            }
        }
    }
    public void Menu(User user){

        Scanner scanner = new Scanner(System.in);
        int tempInput;
        boolean exit = true;
        user.displayInformation();
        System.out.println("---------------------------------------------");
        Park park = new Park();
        while (exit){
            System.out.println("\n1- Empty Parking Lots\n2-Shop/Place Name\n3-Entrance\n4-Reservation\n-1 for Exit");
            tempInput = scanner.nextInt();
            scanner.nextLine();
            switch (tempInput) {
                case 1:
                    park.DisplaySlots();
                    park.SelectSlot(user);
                    break;
                case 2:
                    boolean unvalid = true;
                    while (unvalid){
                        System.out.print("\nEnter shop you want to go: ");
                        String userShop = scanner.next();
                        unvalid = park.displayByEntrance(userShop);
                        break;
                    }
                    break;


                case 3:
                    park.selectEntrance();
                    break;
                case 4:
                    user.getBooks();
                    break;
                case -1:
                    System.out.println("Exiting...");
                    exit = false;
                    break;
                default:
                    System.out.println("Wrong Input");
            }
        }
    }
}
