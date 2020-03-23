package src.travelProfilePackage;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class TravProfDB {
    TravProf[] travelerList = new TravProf[200]; //for now, just set to 20 entries
    int numTravelers = 0;
    int currentTravelerIndex = 0;
    String fileName;

    public TravProfDB(String fileAddress) {
        fileName = fileAddress;
    }

    public void insertNewProfile(TravProf profile) {
        // add profile to Array
        travelerList[currentTravelerIndex] = profile;
        this.currentTravelerIndex += 1;
    }

    public boolean deleteProfile(String ID, String lastName){
        //return true if profile successfully deleted
    }

    public TravProf findProfile(String ID, String lastName){
        //return profile from DB by ID and lastName
        int conversion = Integer(ID);
        TravProf profile = travelerList.get(conversion);
        return profile;
    }

    public void writeAllTravProf() throws FileNotFoundException{
        //write all TravProf in travelerList to a file
        if (currentTravelerIndex == -1){
            return null;
        }
        else{
            JSONObject jo = new JSONObject();
            PrintWriter pw = new PrintWriter(fileName);

            for(TravProf currProfile: travelerList){  
                jo.put("travAgentID", currProfile.gettravAgentID());//currentAgentID)
                jo.put("firstName", currProfile.getFirstName());//currentFirstName)
                jo.put("lastName", currProfile.getLastName());//currentLast)
                jo.put("address", currProfile.getAddress());//currentAddress)
                jo.put("phone", currProfile.getPhone());
                jo.put("tripCost", currProfile.getTripCost());
                jo.put("travelType", currProfile.getTravelType());
                jo.put("paymentType", currProfile.getPaymentType());
        
                med = currProfile.medCondInfo();
                Map map = new LinkedHashMap(4);
                map.put("mdContact", med.getMdContact());
                map.put("mdPhone", med.getMdPhone());
                map.put("algType", med.getAlgType());
                map.put("illType", med.getIllType());
                jo.put("medCondInfo", map);

                pw.write(jo.toJSONString());
                pw.flush();
            }
            pw.close();
        }
    }

    public void initializeDatabase() throws Exception{
        //read all Trav prof from file
        //NEED TO ITERATE THROUGH JSON DOC. NEED TO FIGURE HOW TO IMPLIMENT
        Object obj = new JSONParser().parse(new FileReader(fileName));
        JSONObject jo = (JSONObject) obj;
        
        String travAgentID = (String) jo.get("travAgentID");
        String firstName = (String) jo.get("firstName");
        String lastName = (String) jo.get("lastName");
        String address = (String) jo.get("address");
        String phone = (String) jo.get("phone");
        float tripCost = (float) jo.get("tripCost");
        String travelType = (String) jo.get("travelType");
        String paymentType = (String) jo.get("paymentType");

        medCond medCondInfo = new medCond();
        TravProf profileToAdd = new TravProf(travAgentID, firstName, lastName, address, phone, tripCost, travelType, paymentType, null);
        insertNewProfile(profileToAdd);
    }
    public static void main(String[] args){
    }
}
