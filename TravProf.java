public class TravProf {
    String travAgentID;
    String firstName;
    String lastName;
    String address;
    String phone;
    float tripCost;
    String travelType;
    String paymentType;
    MedCond medCondInfo;

    public TravProf(String a, String b, String c, String d, String e, float f, String g, String h, medConInfo i) {
        travAgentID = a;
        firstName = b;
        lastName = c;
        address = d;
        phone = e;
        tripCost = f;
        travelType = g;
        paymentType = h;
        medCondInfo = i;
    }

    static String gettravAgentID() {
        return travAgentId;
    }

    static String getFirstName() {
        return firstName;
    }

    static String getLastName() {
        return lastName;
    }

    static String getAddress(){
        return address;
    }

    static String getPhone(){
        return phone;
    }

    static float getTripCost(){
        return tripCost;
    }

    static String getTravelType(){
        return travelType;
    }

    static String getPaymentType(){
        return paymentType;
    }

    static MedCond getMedCondInfo(){
        return medCondInfo;
    }

    static void updateFirstName(String newFname){
        firstName = newFname;
    }

    static void updateLastName(String newLname){
        lastName = newLname;
    }

    static void updateAddress(String newAddress){
        address = newAddress;
    }

    static void updatePhone(String newPhone){
        phone = newPhone;
    }

    static void updateTripCost(float newCost){
        tripCost = newCost;
    }

    static void updateTravelType(String newTType){
        travelType = newTType;
    }

    static void updatePaymentType(String newPType){
        paymentType = newPType;
    }

    static void updateMedCondInfo(MedCond newMedInfo) {
        medCondInfo = newMedInfo;
    }
}
