package cq.air.condition.installers;

/**
 *
 *@author Mohit Redhu
 *#Student ID: S12100962
 */
public class InstallationDetails{
    String address;
    String HP;
    String zones;
    String outlets;
    String start;
    String end;
    String techName;
    
    public InstallationDetails(String add, String hp, String zone, String outlet, String s, String e, String tech)
    {
        address = add;
        HP = hp;
        zones = zone;
        outlets = outlet;
        start = s;
        end = e;
        techName = tech;
    }
}
