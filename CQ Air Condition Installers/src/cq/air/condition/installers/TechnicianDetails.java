package cq.air.condition.installers;

/**
 *
 *@author Mohit Redhu
 *#Student ID: S12100962
 */
public class TechnicianDetails {
    String name;
    long contact;
    
    public TechnicianDetails(String techName, long contactNo){
        name = techName;
        contact = contactNo;
    }
    
    public String getName(){
        return this.name;
    }
}
