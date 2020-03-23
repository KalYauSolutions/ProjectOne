import java.util.ArrayList;
import java.util.Scanner;

public class TravProfDB {
    ArrayList<TravProf> travelerList;
    int numTravelers;
    int currentTraveler;
    String fileName;

    public TravProfDB(String fileAddress) {
        fileName = fileAddress;
    }

    public void insertNewProfile(TravProf profile){
        //add profile to ArrayList
        travelerList.add(profile);
    }

    public TravProf findProfile(String ID, String lastName){
        //return profile from DB by ID and lastName
        int conversion = Integer(ID);
        TravProf profile = travelerList.get(conversion);
        return profile;
    }

    public void writeAllTravProf(){
        //write all TravProf in travelerList to a file
        
    }

    public void initializeDatabase(){
        //read all Trav prof from file
    }
    public static void main(String[] args){
    }
}
