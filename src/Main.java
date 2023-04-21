import java.util.*;
public class Main {
    static Passenger[] passenger = new Passenger[10];
    static Admin admin = new Admin();

    public static void main(String[] args) {
        //call this method to set 3 begin flight
        admin.beginSetFlight();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner input = new Scanner(System.in);
        int command;
        while (true){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::\n\tWELCOME TO AIRLINE RESERVATION SYSTEM\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::\n.....................MENUE OPTION......................\n<1>sign in \n<2>sign up");
            command = input.nextInt();
            switch (command) {
                case 1:
                    signin();
                    break;
                case 2 :
                    signUp();
                    break;
            }

        }

    }
    //this method is for signup users (by search method search for null object and signup user )
    public static void signUp(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String username = null, password = null;
        String command = null;
        Scanner input = new Scanner(System.in);
        for(int i = 0 ; i < Main.passenger.length ; i++){
            if (Main.passenger[i] == null){
                System.out.println("please enter your username :");
                username = input.nextLine();
                while (searchPassenger(username) == true){
                    System.out.println("this username is exists please enter another username :");
                    username = input.nextLine();
                }
                System.out.println("please enter your password :");
                password = input.next();
                Main.passenger[i] = new Passenger(username,password);
                System.out.println("sign up was successful");
                break;
            }
        }
        System.out.println("please enter any command to back");
        command =input.next();
    }
    //this method is for sign in user
    public static void signin (){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String username = null;
        String password = null;
        String command = null;
        //this boolean is for check user is there or no
        boolean checkIsUser = false;
        Scanner input = new Scanner(System.in);
        System.out.println("please enter your username ");
        username = input.nextLine();
        System.out.println("please enter your password ");
        password = input.nextLine();
        if(username.equals(admin.username) ){
            if (password.equals(admin.password) ){
                admin.adminMenue();
                checkIsUser =true ;
            }else {
                System.out.println("the password of admin is not correct please enter any command back ");
                command = input.nextLine();
                checkIsUser = true;
            }
        }

        for (int i = 0; i < passenger.length; i++) {
            if (passenger[i] != null && passenger[i].getUsername().equals(username)  ){
                if (passenger[i].getPassword().equals(password) ){
                    //System.out.println("user sign in successfully ");
                    passenger[i].passengerMenue();
                    checkIsUser = true;
                }else {
                    System.out.println("the password of user is not correct please enter your command ");
                    command = input.nextLine();
                    checkIsUser =true;
                }
            }

        }

        if (checkIsUser == false){
            System.out.println("there is not such user please enter any key for back");
            command = input.nextLine();

        }
    }

    //this method is for searching users by username
    public static boolean searchPassenger(String username){
        for (int i = 0; i < Main.passenger.length; i++) {
            if (Main.passenger[i] != null && Main.passenger[i].getUsername() == username )
                return true ;

        }
        return false ;
    }


}