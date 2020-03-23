import java.util.ArrayList;
import java.util.Scanner;

public class TravProfDB {
    ArrayList<TravProf> travelerList;
    int numTravelers;
    int currentTraveler;
    String fileName;

    public TravProfDB(String fileAddress) {
    }

public void insertNewProfile(TravProf profile){
    travelerList.add(profile);
}

public TravProf findProfile(String ID, String lastName){
}

public void writeAllTravProf(){
    //write all TravProf in travelerList to a file
}

public void initializeDatabase(){

}
    public static void main(String[] args){

    }
}
