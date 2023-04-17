import java.util.Scanner;

public class Passenger {
    private String username ;
    private String password ;
    private int wallet = 0 ;
    Flights [] flightBooked = new Flights[15];
    String [] ticketId =  new String[15];

    public Passenger(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }
    //this method is for print passenger menue and if enter 7 sign out 
    public void passengerMenue(){
        String command = "0";
        while (command.charAt(0) != '7'){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::\n\tWELCOME TO AIRLINE RESERVATION SYSTEM\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::\n.....................PASSENGER MENUE ......................\n<1>change password \n<2>search flight \n<3>booking ticket \n<4>ticket cancelation \n<5>booked \n<6>add charge \n<7>sign out ");
            Scanner input = new Scanner(System.in);
            System.out.println("please enter your command ");
            command = input.nextLine();
            if (command.equals("1")){
                changePassword();
            } else if (command.equals("2")) {
                flightSearch();
            } else if (command.equals("3")) {
                bookingTicket();
            } else if (command.equals("5")) {
                booked();
            } else if (command.equals("6")) {
                addCharge();
            }

        }

    }
    //this method is for changing password
    public void changePassword(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner input = new  Scanner(System.in);
        String password ;
        String command = null;
        System.out.println("please enter your new password ");
        password = input.nextLine();
        this.password = password ;
        System.out.println("the password changed successfully your new password is  " + password  + "please enter any command to back");
        command = input.nextLine();

    }

    public void flightSearch(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String command , searchparameter ;
        Flights [] temp_primitive = new Flights[10];
        Flights [] temp_final = Admin.flight;
        int count = 0 ;
        Scanner input = new Scanner(System.in);
        // this is for search by flightId
        System.out.println("Do you want to search by flightId ?(please enter Y for Yes and enter N for No)");
        command = input.next();
        if (command.equals("y")||command.equals("Y")){
            System.out.println("please enter your parameter");
            searchparameter = input.next();
            for (int i = 0; i < temp_final.length; i++) {
                if (temp_final[i] != null &&temp_final[i].getFlightid().equals(searchparameter)){
                    temp_primitive[count] = temp_final[i];
                    count ++ ;
                }
            }
            temp_final = temp_primitive;
            temp_primitive = new Flights[10];
            count = 0;
        }

        //this is  for search by orgin
        System.out.println("Do you want to search by orgin (first latter is capital) ?(please enter Y for Yes and enter N for No)");
        command = input.next();
        if (command.equals("y")||command.equals("Y")){
            System.out.println("please enter your parameter");
            searchparameter = input.next();
            for (int i = 0; i < temp_final.length; i++) {
                if (temp_final[i] !=null &&  temp_final[i].getOrigin().equals(searchparameter)){
                    temp_primitive[count] = temp_final[i];
                    count ++ ;
                }
            }
            temp_final = temp_primitive;
            temp_primitive = new Flights[10];
            count = 0;

        }

        //this is for search by destination
        System.out.println("Do you want to search by destination(first latter is capital) ?(please enter Y for Yes and enter N for No)");
        command = input.next();
        if (command.equals("y")||command.equals("Y")){
            System.out.println("please enter your parameter");
            searchparameter = input.next();
            for (int i = 0; i < temp_final.length; i++) {
                if (temp_final[i] !=null && temp_final[i].getDestination().equals(searchparameter)){
                    temp_primitive[count] = temp_final[i];
                    count ++ ;
                }
            }
            temp_final = temp_primitive;
            temp_primitive = new Flights[10];
            count = 0;

        }

        //this is for search by date
        System.out.println("Do you want to search by date ?(please enter Y for Yes and enter N for No)");
        command = input.next();
        if (command.equals("y")||command.equals("Y")){
            System.out.println("please enter your parameter");
            searchparameter = input.next();
            for (int i = 0; i < temp_final.length; i++) {
                if ( temp_final[i] != null&&temp_final[i].getDate().equals(searchparameter)){
                    temp_primitive[count] = temp_final[i];
                    count ++ ;
                }
            }
            temp_final = temp_primitive;
            temp_primitive = new Flights[10];
            count = 0;
        }

        //this is for search by time
        System.out.println("Do you want to search by time ?(please enter Y for Yes and enter N for No)");
        command = input.next();
        if (command.equals("y")||command.equals("Y")){
            System.out.println("please enter your parameter");
            searchparameter = input.next();
            for (int i = 0; i < temp_final.length; i++) {
                if (temp_final[i] != null &&temp_final[i].getTime().equals(searchparameter)){
                    temp_primitive[count] = temp_final[i];
                    count ++ ;
                }
            }
            temp_final = temp_primitive;
            temp_primitive = new Flights[10];
            count = 0;
        }

        //this is for search by price
        System.out.println("Do you want to search by price ?(please enter Y for Yes and enter N for No)");
        command = input.next();
        if (command.equals("y")||command.equals("Y")){
            System.out.println("please enter your parameter");
            searchparameter = input.next();
            for (int i = 0; i < temp_final.length; i++) {
                if ( temp_final[i] != null&& temp_final[i].getPrice() == Integer.parseInt(searchparameter)){
                    temp_primitive[count] = temp_final[i];
                    count ++ ;
                }
            }
            temp_final = temp_primitive;
            temp_primitive = new Flights[10];
            count = 0;
        }

        //this is for search by seat

        System.out.println("Do you want to search by seat ?(please enter Y for Yes and enter N for No)");
        command = input.next();
        if (command.equals("y")||command.equals("Y")){
            System.out.println("please enter your parameter");
            searchparameter = input.next();
            for (int i = 0; i < temp_final.length; i++) {
                if (temp_final[i] != null && temp_final[i].getSeat() == Integer.parseInt(searchparameter)){
                    temp_primitive[count] = temp_final[i];
                    count ++ ;
                }
            }
            temp_final = temp_primitive;
            temp_primitive = new Flights[10];
            count = 0;
        }

        // this is for show result
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n","FlightId","Orgin","Destination","Date","Time","Price","Seat|");
        System.out.println("........................................................................");
        for (int i = 0; i < temp_final.length; i++) {
            if (temp_final[i] != null){
                System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15d|%-15d\n",temp_final[i].getFlightid(),temp_final[i].getOrigin(),temp_final[i].getDestination(),temp_final[i].getDate(),temp_final[i].getTime(),temp_final[i].getPrice(),temp_final[i].getSeat());
                System.out.println("........................................................................");
            }

        }

        System.out.println("please enter any command to go back");
        command = input.next();




    }
    //this method is for booking ticket
    public void bookingTicket(){
        Main.admin.flightPrint();
        System.out.println("please enter your flightId that you want to book it :");
        Scanner input =  new Scanner(System.in);
        String flightId = input.next();
        int index;
        String command ;
        for (int i = 0; i < flightBooked.length; i++) {
            if (flightBooked[i] == null){
                index = Main.admin.searchFlight(flightId);
                if (index != -1){
                    flightBooked[i] = Admin.flight[index];
                    ticketId[i] = flightBooked[i].getFlightid() + flightBooked[i].getSeat() +flightBooked[i].getSeat() + flightBooked[i].getTime();
                    Admin.flight[index].setSeat(Admin.flight[index].getSeat()-1);
                    System.out.println("the flight booked successfully and your ticketId is " + ticketId[i]);
                    System.out.println("please enter any command to go back");
                    break;
                }else {
                    System.out.println("there isn't such flight please enter r to try again or any command to go back:");
                    break;
                }
            }
        }
        command = input.next();
        if (command.equalsIgnoreCase("r")){
            bookingTicket();
        }
    }
    //this method is for show flights that passenger booked
    public void booked(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String command ;
        Scanner input = new Scanner(System.in);
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n","FlightId","Orgin","Destination","Date","Time","Price","Seat|");
        System.out.println("........................................................................");
        for (int i = 0; i < flightBooked.length; i++) {
            if (flightBooked[i] != null ){
                System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15d|%-15d\n",flightBooked[i].getFlightid(),flightBooked[i].getOrigin(),flightBooked[i].getDestination(),flightBooked[i].getDate(),flightBooked[i].getTime(),flightBooked[i].getPrice(),flightBooked[i].getSeat());
                System.out.println("ticketId is : " + ticketId[i]);
                System.out.println("........................................................................");
            }
        }
        System.out.println("please enter any command to  go back ");
        command =  input.next();
    }
    //this method is for adding charge by passenger
    public void addCharge(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner input = new Scanner(System.in);
        int add ;
        System.out.println("Your charge amount:" +this.wallet);
        System.out.println("Please enter the amount of charge you want to add ...");
        add = input.nextInt();
        this.wallet = this.wallet + add;
        System.out.println("Your charge is now equal to " + this.wallet);
        System.out.println("please enter any command to back");
        input.next();

    }

    @Override
    public String toString() {
        return "Passenger{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", wallet=" + wallet +
                '}';
    }


}
