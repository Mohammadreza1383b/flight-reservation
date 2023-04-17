import java.util.*;
public class Admin {
    String username = "admin";
    String password = "admin";
    static Flights [] flight = new Flights[10];

    //this method is for printing admin menue
    public  void adminMenue() {
        String command = "0";
        Scanner input = new Scanner(System.in);
        while (command.charAt(0) != '5'){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::\n\tWELCOME TO AIRLINE RESERVATION SYSTEM\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::\n.....................ADMIN MENUE ......................\n<1>add \n<2>update \n<3>remove \n<4>flight schedules \n<5>sign out ");
            command = input.next();
            if (command.equals("4")){
                flightSchedules();
            } else if (command.equals("3")) {
               flightRemove();
            } else if (command.equals("2")) {
                flightUpdate();
            } else if (command.equals("1")) {
                flightAdd();
            }
        }

    }

    //this method is for adding a flight
    public void  flightAdd(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String flightid , orgin , destination , date , time ,command ;
        int price , seat;
        Scanner input = new Scanner(System.in);
        System.out.println("please enter wanted item :");
        System.out.print("FlightId ==>");
        flightid = input.next();
        System.out.println("\norgin ==>");
        orgin = input.next();
        System.out.println("\nDestination ==>");
        destination = input.next();
        System.out.println("\nDate ==>");
        date = input.next();
        System.out.println("\nTime ==>");
        time = input.next();
        System.out.println("\nPrice ==>");
        price = Integer.parseInt(input.next());
        System.out.println("\nSeat ==>");
        seat = Integer.parseInt(input.next());
        for (int i = 0; i < flight.length; i++) {
            if (flight[i] == null){
                setFlight(i,flightid,orgin,destination,date,time,price,seat);
                System.out.println("the flight added successfully please enter any key to go back");
                command = input.next();
                break;
            }
        }
    }

    //this method is for update flights by flightId
    public void flightUpdate(){
        Scanner input = new Scanner(System.in);
        //command is for user command and flightId for search and find flight that want to update and update is for get parameters
        String command , update , flightid;
        flightPrint();
        System.out.println("please enter flightId that you want to update :");
        flightid = input.next();
        if(searchFlight(flightid) != -1){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("do you want change FlightId ?(enter Y for Yes enter N for No)");
            command = input.next();
            if (command.equals("Y") || command.equals("y")){
                System.out.println("please enter the new FlightId");
                update = input.next();
                while (searchFlight(update) != -1){
                    System.out.println("this FlightId is repeated  please enter another flight id ");
                    update = input.next();
                }
                flight[searchFlight(flightid)].setFlightid(update);
            }
            System.out.println("do you want change Orgin? (enter Y for Yes enter N for No)");
            command =input.next();
            if (command.equals("Y") || command.equals("y")){
                System.out.println("please enter the new Orgin");
                update =input.next();
                flight[searchFlight(flightid)].setOrigin(update);
            }
            System.out.println("do you want change Destination? (enter Y for Yes enter N for No)");
            command = input.next();
            if (command.equals("Y") || command.equals("y")){
                System.out.println("please enter the new Destination");
                update = input.next();
                flight[searchFlight(flightid)].setDestination(update);
            }
            System.out.println("do you want change Date? (enter Y for Yes enter N for No)");
            command = input.next();
            if (command.equals("Y") || command.equals("y")){
                System.out.println("please enter the new Date");
                update = input.next();
                flight[searchFlight(flightid)].setDate(update);
            }
            System.out.println("do you want change Time? (enter Y for Yes enter N for No)");
            command = input.next();
            if (command.equals("Y") || command.equals("y")){
                System.out.println("please enter the new Time");
                update = input.next();
                flight[searchFlight(flightid)].setTime(update);
            }
            System.out.println("do you want change Price? (enter Y for Yes enter N for No)");
            command = input.next();
            if (command.equals("Y") || command.equals("y")){
                System.out.println("please enter the new Price");
                update = input.next();
                flight[searchFlight(flightid)].setPrice(Integer.parseInt(update));
            }
            System.out.println("do you want change Seat? (enter Y for Yes enter N for No)");
            command = input.next();
            if (command.equals("Y") || command.equals("y")){
                System.out.println("please enter the new Seat");
                update = input.next();
                flight[searchFlight(flightid)].setSeat(Integer.parseInt(update));
            }
            System.out.println("the flight updated successfully please enter any command to go back");
            command = input.next();

        }else {
            System.out.println("there is not such flightId please enter any command to go back :");
            command =input.next();
        }

    }

    public void flightRemove(){
        String remove;
        Flights [] temp = new Flights[10];
        Scanner input = new Scanner(System.in);
        boolean checkremove = false;
        String command;
        flightPrint();
        System.out.println("please enter the flightId for remove the flight");
        remove = input.next();
        for (int i = 0; i < flight.length; i++) {
            if (flight[i] != null && flight[i].getFlightid().equals(remove) ){
                flight[i] =null;
                int count =0;
                for (int j = 0; j < flight.length; j++) {
                    if (flight[j] != null){
                        temp[count] = flight[j];
                        count++;
                    }
                }
                flight = temp;
                checkremove =true;
                break;
            }
        }

        if (checkremove == false){
            System.out.println("there is not such flightId enter any command to go back..");
            command = input.next();
        }else {
            System.out.println("the flight removed successfully please enter any command to go back");
            command = input.next();
        }
    }


    //this method is for showing table of flights by using flightPrint method
    public void flightSchedules(){
        String command ;
        Scanner input = new Scanner(System.in);
        flightPrint();
        System.out.println("please enter any command to go back");
        command = input.next();
    }
    //this method is for init 3 flight at begin
    public void beginSetFlight(){
        //set first flight
        setFlight(0,"wx-12","Yazd","Tehran","1401-12-10","12:30",700,51);
        //set second  flight
        setFlight(1,"wz-15","Mashhad","Ahvaz","1401-12-11","8:30",900,245);
        //set third flight
        setFlight(2,"bg-22","Shiraz","Tabriz","1401-12-12","22:30",1100000,12);
    }

    //this method is for setting a fight by index
    public void setFlight(int index , String flightid , String orgin , String destination , String date , String time , int price , int seat){
        flight[index] =new Flights();
        flight[index].setFlightid(flightid);
        flight[index].setOrigin(orgin);
        flight[index].setDestination(destination);
        flight[index].setDate(date);
        flight[index].setTime(time);
        flight[index].setPrice(price);
        flight[index].setSeat(seat);
    }

    //this method is for printing flights
    public void flightPrint(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n","FlightId","Orgin","Destination","Date","Time","Price","Seat|");
        System.out.println("........................................................................");
        for (int i = 0; i < flight.length; i++) {
            if (flight[i] != null){
                System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-15s|%-15d|%-15d\n",flight[i].getFlightid(),flight[i].getOrigin(),flight[i].getDestination(),flight[i].getDate(),flight[i].getTime(),flight[i].getPrice(),flight[i].getSeat());
                System.out.println("........................................................................");
            }

        }
    }

    public int searchFlight (String flightid){
        for (int i = 0; i < flight.length; i++) {
            if (flight[i].getFlightid().equals(flightid)){
                return i;
            }
        }
        return -1;
    }




}
