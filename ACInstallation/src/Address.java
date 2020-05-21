/*
 Made by Student Names : Tajinder Pal Singh & Mohit Redhu
                Student ID -12095732 & 12100962
 */

//address class extending Dates class
public class Address extends Dates{
    String address; //String variable for address variable
    String hp; //String variable for hp variable
    String zone; //String variable for zone variable
    String outlet; //String variable for outlet variable
    
    //parameterized constructor
    public Address(String address, String hp, String zone, String outlet, String start, String end) {
        super(start, end);
        this.address = address;
        this.hp = hp;
        this.zone = zone;
        this.outlet = outlet;
    }

    //get method for address variable
    public String getAddress() {
        return address;
    }

    //set method for addrss varibale
    public void setAddress(String address) {
        this.address = address;
    }
  
    //get method for Zone variable
    public String getZone() {
        return zone;
    }

    //get method for outlet variable
    public String getOutlet() {
        return outlet;
    }

    //get method for Hp variable
    public String getHp() {
        return hp;
    }

    
    //set method for Zone variable
    public void setZone(String zone) {
        this.zone = zone;
    }

    //set method for outlet variable
    public void setOutlet(String outlet) {
        this.outlet = outlet;
    }

    //set method for hp variable
    public void setHp(String hp) {
        this.hp = hp;
    }
    
    //to string method
    @Override
    public String toString() {
        return "\nAddress Details\nAddress = "+getAddress()+"\nHp = "+getHp()+"\tZone = "+getZone()+"\tOutlet = "+getOutlet()+super.toString();
    }
}