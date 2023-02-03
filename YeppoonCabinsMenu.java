// TODO -- create header comments

import java.util.Scanner;

// TODO -- copy the Booking2 class from assignment one part A and rename the class to Booking and rename the file to Booking.java
// TODO -- implement the toString method in the Booking class

public class YeppoonCabinsMenu
{
	final int ENTER_BOOKING = 1;
	final int DISPLAY_BOOKINGS = 2;
	final int DISPLAY_STATISTICS = 3;
	final int SEARCH_BOOKINGS = 4;
	final int EXIT = 5;
       int currentBookingCount=0;

	// TODO -- declare any further constants
// TODO -- declare array of Booking objects
	// TODO -- declare variable for the current booking entered (integer)



Booking currentBooking = new Booking();
String allBookingName[] = new String[10];
int allBookingStay[] = new int[10];
double allCalculateCharge[] = new double[10]; 
	private int getMenuItem()
	{
		System.out.println("\nPlease select from the following");
		System.out.println(ENTER_BOOKING + ". Enter booking name and number of nights");
		System.out.println(DISPLAY_BOOKINGS + ". Display all booking names, number of nights and charges");
		System.out.println(DISPLAY_STATISTICS + ". Display Statistics");
		System.out.println(SEARCH_BOOKINGS + ". Search for booking");
		System.out.println(EXIT + ". Exit the application");
		System.out.print("Enter choice==> ");
            Scanner inputMenuChoice = new Scanner(System.in);
		String choice = inputMenuChoice.nextLine();
		while (choice.equals("") || !isStringNumeric(choice))
		{
			System.out.println("Error - Menu selection name cannot be blank and must be numeric");

			System.out.print("Enter choice==> ");

			choice = inputMenuChoice.nextLine();
		}

		return Integer.parseInt(choice);
	}


	private boolean isStringNumeric(String str)
	{
		for (int i = 0; i < str.length(); i++)
		{
			if (!Character.isDigit(str.charAt(i)))
				return false;
		}

		return true;
	}


	private void processOrders()
	{
		int choice = getMenuItem();
		while (choice != EXIT)
		{
			switch (choice)
			{
				case ENTER_BOOKING:
					enterBooking();
					break;
				case DISPLAY_BOOKINGS:
					displayAllBookings();
					break;
				case DISPLAY_STATISTICS:
					displayStatistics();
					break;
				case SEARCH_BOOKINGS:
					searchBookings();
					break;
				default:
					System.out.println("ERROR choice not recognised");
			}
			choice = getMenuItem();
		}
	}


	private void enterBooking()
	{
            if(currentBookingCount<10){
        // TODO -- check if maximum bookings has been reached (do this after getting the other functionality working)

	Scanner userInput = new Scanner(System.in);	// TODO -- read in the booking name (as a string)
        System.out.print("Enter the Booking Person Name ===> ");
        String name = userInput.nextLine();
	// TODO -- create validation loop (do this after getting the other functionality working)
               while (name.equals("")|| isStringWord(name))
		{
	                System.out.println("Error - name cannot be blank and must be Alphabetics");
			System.out.print("Enter the Booking Person Name ===> ");
			name = userInput.nextLine();
		}
   	
       // TODO -- read in the number of nights
     System.out.print("Enter the Number of nights to stay in Hotel ===> ");
     String number = userInput.nextLine();
		// TODO -- create validation loop (do this after getting the other functionality working)
               while (number.equals("") || !isStringNumeric(number))
		{
	                System.out.println("number of nights must greater then or equal to 1 ! ");
			System.out.print(" Enter the Number of nights to stay in Hotel ===> ");
			number= userInput.nextLine();
		}
     
       currentBooking.setBookingName(name);
       currentBooking.setNightsOfStay(Integer.parseInt(number));
		// TODO -- add the data to the array (use the new keyword and the parameterised constructor in Booking class)
     Booking newBooking = new Booking (name , Integer.parseInt(number));
     allBookingName[currentBookingCount]=newBooking.getBookingName();
     allBookingStay[currentBookingCount]=newBooking.getNightsOfStay();
     allCalculateCharge[currentBookingCount]= newBooking.calculateCharge();
		displayHeading();// TODO -- display the booking name, number of nights and the charge

		currentBookingCount++;// TODO -- increment the current booking variable for the next entry
         
            }
            else{
            System.out.println("maximum bookings has been reached");
            }
            
            }
    private boolean isStringWord(String str)
	{
		for (int i = 0; i < str.length(); i++)
		{
			if (!Character.isLetter(str.charAt(i)) && Character.isWhitespace(str.charAt(i)))
				return false;
		}

		return true;
	}
   
	private void displayHeading()
	{
		System.out.printf("%-30s%-11s%6s\n", "Booking Name", "Nights", "Charge");
                System.out.println(currentBooking.toString());    
        }


	private void displayAllBookings()
	{
                // TODO -- check if there has been an booking entered (do this after getting the other functionality working)
            if(currentBookingCount>0){
		System.out.printf("%-30s%-11s%-6s\n", "Booking Name", "Nights", "Charge");
                for(int i=0; i<=(currentBookingCount-1);i++){
                System.out.printf( "%-30s%-11s$%-6s\n", allBookingName[i], allBookingStay[i],allCalculateCharge[i]+"\n");
                }
            }
            else {
                System.out.println("No records to display ________________________________________________________________________");
                        }
             

		// TODO -- display all of the entries entered so far (just display the current entries not the whole array, use the current booking variable as the termination condition)
	}


	private void displayStatistics()
	{
		// TODO -- check if there has been an booking entered (do this after getting the other functionality working)      
            if(currentBookingCount>0){
		// TODO -- loop though the current entries in the array and calculate and display the statistics
		maxNights();
                minNights();
                totalCharges();
                
            }else {
                System.out.println("No records to display ____statistics_______");
}
            
	}
        private void totalCharges(){
         double totalCharge=0;
                for(int i=0;i<currentBookingCount;i++){
                 totalCharge = (totalCharge + allCalculateCharge[i]);
                }
                 System.out.println("The total charges collected:  $"+totalCharge); 
        }

        private void maxNights(){
                int i;
                int max =allBookingStay[0];
                for(i=0;i<currentBookingCount;i++){
                if (allBookingStay[i]>max){
                    max=allBookingStay[i];
                }
                }
                boolean found = false;
                 i = 0;
                while(!found && i<currentBookingCount){
                    if(max==allBookingStay[i]){
                        found=true;
                         }
                    else{i++;}
                }
                if (found==true){
                System.out.println(allBookingName[i]+" has the maximum number of "+allBookingStay[i]+" nights .");
                }
        }
 private void minNights(){
     int i;
                int min =allBookingStay[0];
                for( i=0;i<currentBookingCount;++i){
                if (min>allBookingStay[i]){
                    min=allBookingStay[i];
                }
                }
                boolean found = false;
                 i = 0;
                while(!found && i<currentBookingCount){
                    if(min==allBookingStay[i]){
                        found=true;
                         }
                    else{i++;}
                }
                
                if (found==true){
                System.out.println(allBookingName[i]+" has the minimum number of "+allBookingStay[i]+" nights .");
                }
        }
	private void searchBookings()
	{
		// TODO -- check if there has been an booking entered (do this after getting the other functionality working)

            if(currentBookingCount>0){
                Scanner userInput = new Scanner(System.in);
                System.out.println("Please Enter a name to search for ==");
		String search = userInput.nextLine();
                boolean found = false;
                int i = 0;
                while(!found && i<currentBookingCount){
                    if(search.equals(allBookingName[i])){
                        found=true;
                         }
                    else{i++;}
                
                }
                if (found==true){
                System.out.println("Following Booking has Found with "+search);
                System.out.printf("%-30s%-11s%-6s\n", "Booking Name", "Nights", "Charge");
                System.out.printf("%-30s%-11s%-6s\n", allBookingName[i], allBookingStay[i], allCalculateCharge[i]);
                    }
                else{
                    System.out.println("there is no booking with this name ");
                }
		// TODO -- read the search key
		// TODO -- loop though the current entries in the array to search for the search key
		// TODO -- display the found item or report it has not been found
            }
            else {
                System.out.println("No records to display ____search_______");
                        }
            

	}



	public static void main(String [] args)
	{
		YeppoonCabinsMenu app = new YeppoonCabinsMenu();

		app.processOrders();
	}
}