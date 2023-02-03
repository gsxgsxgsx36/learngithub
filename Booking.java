
public class Booking {
private String bookingName;
private int nightsOfStay;
//Discount rates are declared as constant dis10 and dis15
final double STAY_10_DAYS = 10;
final double STAY_7_DAYS = 7;
final double DISCOUNT_10_PERCENTAGE= 10;
final double DISCOUNT_15_PERCENTAGE= 15;
final double NIGHTLY_CHARGES = 89.95;
final double CLEANING_CHARGES = 20.00;
	public Booking()
        {
            bookingName = null;
            nightsOfStay = 0;
            
        }
       public Booking(String name, int stay)
        {
            
            bookingName = name;
            nightsOfStay = stay;
        }      
        
 public String getBookingName(){
     return bookingName;
 }
  public void setBookingName(String b){
             bookingName=b;
                }
 public int getNightsOfStay(){
     return nightsOfStay;
 }
  public void setNightsOfStay(int a){
      nightsOfStay = a;
 }
public double calculateCharge(){
    if (nightsOfStay<=STAY_7_DAYS)
        return (NIGHTLY_CHARGES*nightsOfStay)+CLEANING_CHARGES ;
    
         else if (nightsOfStay > STAY_7_DAYS && nightsOfStay <=STAY_10_DAYS)
               return ((NIGHTLY_CHARGES*nightsOfStay)-((NIGHTLY_CHARGES*nightsOfStay)*DISCOUNT_10_PERCENTAGE/100)+CLEANING_CHARGES);
                    
    else 
       return ((NIGHTLY_CHARGES*nightsOfStay)-((NIGHTLY_CHARGES*nightsOfStay)*DISCOUNT_15_PERCENTAGE/100)+CLEANING_CHARGES);
} 
@Override
public String toString(){
   String abc = String.format("%-30s%-11d$%5.2f\n", bookingName, nightsOfStay, calculateCharge());
                 return abc;                }
}

