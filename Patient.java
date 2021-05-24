import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Patient{
     
    private String name;
    private int age;
    private String address;
    private Date date_of_visit;
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }    
    
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
       
    public Date getDate_of_visit() {
        return date_of_visit;
    }
    public void setDate_of_visit(String strdate) throws ParseException {
           SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
        
            Date actual = f1.parse(strdate);
            this.date_of_visit = actual;
            
      
        
    }

}