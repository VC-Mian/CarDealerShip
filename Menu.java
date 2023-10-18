package finalProject;

/**
 *Menu.java: user can add cars, modify a car, view a certain car, view all info of all cars, display average mileage of cars, displays lowest car price, and user can make an offer to the customer.
 * @author V. Miranda-Calleja
 */
import java.util.Scanner;
public class Menu {
    //cars counter
    public static int carCounter = 0;
    
    //array contains all cars
    public static Car[] cars = new Car[20];
    
    //main
    public static void main(String[] args) {
        menu();
    }
    
    //menu method for user to navigate to need
    public static void menu(){
        
        Scanner input = new Scanner(System.in);
        
        //menu options
        System.out.println("1 to add a vehicle.");
        System.out.println("2 to modify a vehicle.");
        System.out.println("3 to view a specific vehicle.");
        System.out.println("4 to view all vehicles info.");
        System.out.println("5 to get average miles.");
        System.out.println("6 to get lowest vehicle price.");
        System.out.println("7 to make an offer to customer.");
        System.out.println("--------------------");
    
        int choice = input.nextInt();
        
        ///goes to method user choose
        switch(choice) {
            case 1: 
                addCar();
                break;
            case 2:
                modCar();
                break;
            case 3:
                displayCar();
                break;
            case 4:
                displayAllCarInfo();
                break;
            case 5:
                getAvgMileage();
                break;
            case 6:
                getLowestPrice();
                break;
            case 7:
                MakeAnOffer();
                break;
            default:
                System.out.println("Invaild number ");
        }
    }
        
    //method to add car
    public static void addCar(){
        Scanner input = new Scanner(System.in);
       
        System.out.println("Enter car tag: ");
        String vin = input.nextLine();
        
        System.out.println("Enter car model: ");
        String model = input.nextLine();
        
        System.out.println("Enter car make: ");
        String make = input.nextLine();
        
        System.out.println("Enter car year: ");
        int year = input.nextInt();
        
        System.out.println("Enter car mileage: ");
        double mileage = input.nextDouble();
        
        System.out.println("Enter car price: ");
        double price = input.nextDouble();
        
        //adds new car object to array
        cars[carCounter] = new Car(vin, model, make, year, mileage, price);
        
        //incrementation
        carCounter++;
       
        System.out.println("1 to return to menu, otherwise 2 to add another car.");
        int choice = input.nextInt();
        switch (choice){
            case 1:
               menu();
               break;
               
            case 2:
                addCar();
                break;
                
            default:
                System.out.println("Invalid Number.");
           
       }
    }

    //method to modifiy a car
    public static void modCar(){
        Scanner input = new Scanner(System.in);
        
        //pick a car to modify
        System.out.println("Enter the car number you would like to modify.");
        int carNumber = input.nextInt();
        
        --carNumber;
        
        //display car info
        System.out.println("Car Number " + (carNumber + 1));
        System.out.println(cars[carNumber]);
        
        //display options to modify
        System.out.println("1 to modify vin.");
        System.out.println("2 to modify year.");
        System.out.println("3 to modify mileage.");
        System.out.println("4 to modify price.");
        

        int modnum = input.nextInt();
        
        //modification change
        switch (modnum){
            case 1:
                System.out.println("Enter new vin: ");
                String vin = input.next();
                //changes made
                cars[carNumber].setVin(vin);
                break;
                
            case 2:
                System.out.println("Enter new year: ");
                int year = input.nextInt();
                cars[carNumber].setYear(year);
                break;
                
            case 3:
                System.out.println("Enter new mileage:");
                double mileage = input.nextDouble();
                cars[carNumber].setMileage(mileage);
                break;
                
            case 4:
                System.out.println("Enter new price: ");
                double price = input.nextDouble();
                cars[carNumber].setPrice(price);
                break;
                
            default:
                System.out.println("Invalid Number");
        }
        
        //To verify change
        System.out.println(cars[carNumber]);
        
        //go back to menu or modify another car
        System.out.println("1 to return to menu, otherwise 2 to modify another car.");
        int choice = input.nextInt();
        switch (choice){
            case 1:
               menu();
               break;
            case 2:
                modCar();
                break;
            default:
                System.out.println("Invalid Number.");
       }
    }
        
    //method for user to view certain car
    public static void displayCar(){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter which car number you would like to view");
        int carNumber = input.nextInt();

        System.out.println("car Number " + carNumber);
        System.out.println(cars[carNumber - 1]);
        
        System.out.println("1 to return to menu, otherwise 2 to view another car.");
        int choice = input.nextInt();
        switch (choice){
            case 1:
               menu();
               break;
            case 2:
                displayCar();
                break;
            default:
                System.out.println("Invalid Number.");
       }
    }
    
    //Method to display info of all cars in array
    public static void displayAllCarInfo(){
        Scanner input = new Scanner(System.in);
        
        int counter = 0;
        
        for(Car c: cars){
            
            counter++;
            
            if (c != null) {
                System.out.println("Car Number: " + counter);
                System.out.println(c);
                System.out.println();
            }
        }
        //returns to menu
        System.out.println("Enter 1 to return to menu");
        int choice = input.nextInt();
        if(choice == 1){
            menu();
        }
    }
    
    //method to average mileage of cars
    public static void getAvgMileage(){
        Scanner input = new Scanner(System.in);
        
        double avgMileage;
        double sumMileage = 0;
        
        for (Car car : cars) {
            if (car != null) {
                //adds all mileages
                sumMileage += car.getMileage();
            }
        }
        
        //display results
        System.out.println("Number of Cars: " + carCounter);
        avgMileage = sumMileage/ carCounter;
        System.out.printf("Total Mileage: %.2f \n", sumMileage);
        System.out.printf("Average Mileage: %.2f \n", avgMileage);
        
        //returns to menu
        System.out.println("Enter 1 to return to menu");
        int choice = input.nextInt();
        if(choice == 1){
            menu();
        }
    }
    
    //method to present the lowest car price to seller
    public static void getLowestPrice(){
        Scanner input = new Scanner(System.in);
        
        //sets lowest to first car's price in array
        double lowest = cars[0].getPrice();
        for (Car c : cars) {
            //discards nulls
            if (c != null) {
                //evaluates which price is lowest
                Math.min(lowest, c.getPrice());
                if(lowest > c.getPrice()){
                    double newlow = c.getPrice();
                    lowest = newlow;
                }else{}
            }
        }
        System.out.printf("Lowest car Price: $%.2f \n", lowest);
        
        //returns to menu
        System.out.println("Enter 1 to return to menu");
        int choice = input.nextInt();
        if(choice == 1){
            menu();
        }
    }
    
    
    //method to discount for car depending on customer mood about car
    public static void MakeAnOffer(){
        Scanner input = new Scanner(System.in);
        
        double currentPrice;
        double newPrice;
        
        //choose car to discount
        System.out.println("Choose the car for discount: ");
        int carNumber = input.nextInt();
        
        --carNumber;
        
        //display car info before discount
        System.out.println("Vehicle Number " + (carNumber + 1));
        System.out.printf("Current Price: $%.2f \n", cars[carNumber]. getPrice());
        
        //customer mood options
        System.out.println("Enter a number from the following options:\n1.) Likes car, Discount: $100\n2.) Somewhat Likes car, Discount: $200\n3.) Dislikes car, Discount: $500");
        double discount = input.nextDouble();
        
        //discount is applied to current price of car
        if (discount == 1){
            currentPrice = cars[carNumber].getPrice();
            newPrice = currentPrice - 100;
            cars[carNumber].setPrice(newPrice);
            
        }else if (discount == 2){
            currentPrice = cars[carNumber].getPrice();
            newPrice = currentPrice - 200;
            cars[carNumber].setPrice(newPrice);
            
        }else if(discount == 3){
            currentPrice = cars[carNumber].getPrice();
            newPrice = currentPrice - 500;
            cars[carNumber].setPrice(newPrice);
            
        }else{
            System.out.println("Invalid amount");
        }
        
        //verify discount applied
        System.out.println("--------------------");
        System.out.println("Discount Applied.");
        System.out.printf("Discounted Price: $%.2f \n", cars[carNumber].getPrice());
        
        //return to menu or other
        System.out.println("1 to return to menu, otherwise 2 to apply a discount to another car.");
        int choice = input.nextInt();
        switch (choice){
            case 1:
               menu();
               break;
            case 2:
                MakeAnOffer();
                break;
            default:
                System.out.println("Invalid Number.");
       }
        
    }  
}