/*
 Made by Student Names : Tajinder Pal Singh & Mohit Redhu
                Student ID -12095732 & 12100962
 */

//components class
public class components {
    String hp, zone, outlet; //String data type for hp, zone and outlet  variable
    
    //parametrized constructor
    public components(String hp, String zone, String outlet){
        this.hp = hp;
        this.zone = zone;
        this.outlet = outlet;
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

    //set method for zone variable
    public String getZone() {
        return zone;
    }

    //get method for outlet variable
    public String getOutlet() {
        return outlet;
    }

    //get method for hp variable
    public String getHp() {
        return hp;
    }
}
