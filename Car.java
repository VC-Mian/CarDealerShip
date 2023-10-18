package carDealerShip
/**
 *Car.java: contains cars attributes and returns them to menu 
 * @author V. Miranda-Calleja
 */
public class Car {
    private String vin;
    private String make;
    private String model;
    private int year;
    private double mileage;
    private double price;
    
    //constructors
    public Car(String v, String m, String mo, int yr, double mi, double pr){
        this.vin = v;
        this.make = m;
        this.model = mo;
        this.year = yr;
        this.mileage = mi;
        this.price = pr;
    }

    
    //setters getters
    
    //vin
    public void setVin(String vin){
        this.vin = vin;
    }
    
    public String getVin(){
        return vin;
    }
    
    //make
    public void setMake(String m){
        this.make = m;
    }
    
    public String getMake(){
        return make;
    }
    
    //model
    public void setModel(String mo){
        this.model = mo;
    }
    
    public String getModel(){
        return model;
    }
    
    //year
    public void setYear(int yr){
        if (yr > 1970){
            this.year = yr;
        }else{
            System.out.println("Invalid year, Enter a value greater than 1970 ");
        }
    }
    
    public int getYear(){
        return year;
    }
    
    //mileage
    public void setMileage(double mi){
        if(mi > 0){
            this.mileage = mi; 
        }else{
            System.out.println("Invaild mileage, Enter a value greater than 0");
        }
    }
    
    public double getMileage(){
        return mileage;
    }
    
    public void setPrice(double pr){
        if (pr > 1000){
           this.price = pr; 
        }else{
            System.out.println("Invalid Price, Enter a price greater than 1000");
        }
    }
    
    public double getPrice(){
        return price;
    }
    
    @Override
    public String toString(){
        return "Vin: " + this.vin + "\nMake: " + this.make + "\nModel: " + this.model + "\nYear:  " + this.year + "\nMileage: " + this.mileage + "\nPrice: $" + this.price + "\n"; 
    }
}
