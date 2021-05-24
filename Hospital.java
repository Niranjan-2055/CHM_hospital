import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Hospital {
    public static void main (String args[]) throws ParseException, InterruptedException
    {
        Scanner in = new Scanner(System.in);
        ArrayList <Patient> P_list = new ArrayList<>();
        Boolean flag = true;
        
        //While loop to provide option to choose operation 
        while(flag)
        {   
            System.out.println("\nChoose a operation :\n 1 - To Enter Patient Records \n 2 - To Predict \n 3 - Exit\n");
            System.out.print("Your choice : ");

            int choice = in.nextInt();

            if(choice == 1)
            {
            
                System.out.print("Enter the number of records that you want to add : ");

                int n = in.nextInt();
                in.nextLine();
                //For loop to record n- number of patient details and add it to ArrayList
                for(int i=0;i<n;i++)
                {
                    Patient p = new Patient();
                    System.out.print("\nEnter the Patient Name = ");
                    String name = in.nextLine();
                    p.setName(name);
                    System.out.print("Age = ");
                    int age = in.nextInt();
                    p.setAge(age);
                    in.nextLine();
                    System.out.print("Hospital Branch = ");
                    String address = in.nextLine();
                    p.setAddress(address); 
                    System.out.print("Visited Date(dd/MM/yyyy) = ");
                    String string_date = in.nextLine();
                    p.setDate_of_visit(string_date);
                    P_list.add(p);
                    System.out.println("Record has been added sucessfully\n");
                }
            }
            
            else if(choice == 2)
        N: {
                int ct_patient=0;
                int out_patient=0;
                String start_date;
                String end_date;
                in.nextLine();
                ArrayList <Patient> newList = new ArrayList<>(); //New List for storing the patient record that falls within our input date range
                
                System.out.println("\nThere are "+ P_list.size()+ " records stored in program.");
                
                if(P_list.size()==0) //Checks if there are any records in the main ArrayList , and breaks choice 2 loop if no records are found
                {
                    System.out.println("Please enter few records before predicting.");
                    break N;
                    
                }

                //User Input for date range and convverting string input to date format
                System.out.print("Enter the starting date (dd/MM/yyyy)  = ");
                start_date = in.nextLine();
                System.out.print("Enter the ending date (dd/MM/yyyy) = ");
                end_date = in.nextLine();
                SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                Date sdate = f.parse(start_date);
                Date edate = f.parse(end_date);     
                Patient pointer = new Patient();

                 for(int i=0;i<P_list.size();i++)
                
                 {
                
                    pointer = P_list.get(i);

                    if(pointer.getDate_of_visit().compareTo(sdate)>=0 && pointer.getDate_of_visit().compareTo(edate)<=0) //Checks and add all the records to new ArrayList if it falls withing given range of input dates.
                    {
                        newList.add(pointer);
                        
                    }
                                  
                    
                
                             
                 }
                 System.out.println("\nNO record found for the given range .");

                 if(newList.size()>0)
                    {
                        for(int i=0;i<newList.size();i++)
                        {   
                            pointer = newList.get(i);
                            if( (pointer.getAddress().compareTo("bangalore") == 0 || pointer.getAddress().compareTo("BANGALORE") == 0 ) || (pointer.getAddress().compareTo("BLR") ==0 ||pointer.getAddress().compareTo("Bangalore")==0 )) //Checking if the locaton of patient is within banglore
                            {
                                ct_patient = ct_patient+1;
                            }
                            else
                            {
                                out_patient = out_patient+1;
                            }

                                                  

                        }
                        
                        double city_percentage = Double.valueOf(ct_patient*100/newList.size());
                        double out_percentage = Double.valueOf(out_patient*100/newList.size());
                                           
                        System.out.println("\nThere are records of  "+newList.size()+" patient registration that took place between "+start_date+ " to "+end_date);
                        System.out.println("Among which " + String.format("%.2f", city_percentage) +"% were from Bangalore and "+String.format("%.2f", out_percentage)+"% were from OutStation");
                        System.out.println("\nBased on the records ");
                        if(ct_patient>out_patient)
                        {
                            System.out.println("Opening Hospital in Banglore will be more helpful ");
                            TimeUnit.SECONDS.sleep(5);//for 5 sec delay before running complete loop again
                        }
                        else{
                            System.out.println("It Should be fesible to open hospital outside Banglore ");
                            TimeUnit.SECONDS.sleep(5);
                        }


                        


                    }
            } 
            
            else
            {
                flag = false;
                System.out.println("The program is ending now");

            }
                
      
        }

    

        in.close(); //closing scanner in
        


    }
    
}




//Name : Niranjan Yadav
//College : New Horizon College of Engineering
