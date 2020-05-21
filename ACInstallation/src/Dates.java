/*
 Made by Student Names : Tajinder Pal Singh & Mohit Redhu
                Student ID -12095732 & 12100962
 */

//dates class
class Dates {
    String start; //String data type for start variable
    String end; //String data type for end variable
    
    //parameterized constructor
    public Dates(String start, String end) {
        this.start = start;
        this.end = end;
    }

    //set method for End variable
    public void setEnd(String end) {
        this.end = end;
    }

    //get method for end variable
    public String getEnd() {
        return end;
    }

    //set method for start variable
    public void setStart(String start) {
        this.start = start;
    }

    //get method for start variable
    public String getStart() {
        return start;
    }

    //to string method
    @Override
    public String toString() {
        return "\nInstallation Dates\nStart Date = " + getStart()+ "\tEnd Date = "+ getEnd();
    }
}
