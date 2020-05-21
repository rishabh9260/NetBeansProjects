/*
 Made by Student Names : Tajinder Pal Singh & Mohit Redhu
                Student ID -12095732 & 12100962
 */

//details class extending Address class
public class Details extends Address{
    String name; //String data type for name variavble
    String phone; //String data type for phone variable
    
    //parameterized constructor
    public Details(String name, String phone, String address, String hp, String zone, String outlet, String start, String end) {
        super(address, hp, zone, outlet, start, end);
        this.name = name;
        this.phone = phone;
    }

    //set method for phone variable
    public void setPhone(String phone) {
        this.phone = phone;
    }

    //set method for name variable
    public void setName(String name) {
        this.name = name;
    }

    //get method for phone variable
    public String getPhone() {
        return phone; //returning value
    }

    //get method for name variable
    public String getName() {
        return name;
    }
    
    //to string method
    @Override
    public String toString() {
        return "Technicain Details|"+getName()+"|\nName = "+getName()+"\tPhone No = "+getPhone()+super.toString()+"\n-------------------------------------------------------\n";
    }
}