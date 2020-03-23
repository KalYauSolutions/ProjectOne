package src.travelProfilePackage;

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

    public TravProf(String ID, String first, String last, String address, String phone, float cost, String travType,
                    String payType, MedCond medInfo) {
        this.travAgentID = ID;
        this.firstName = first;
        this.lastName = last;
        this.address = address;
        this.phone = phone;
        this.tripCost = cost;
        this.travelType = travType;
        this.paymentType = payType;
        this.medCondInfo = medInfo;
    }

    public String gettravAgentID() {
        return travAgentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress(){
        return address;
    }

    public String getPhone(){
        return phone;
    }

    public float getTripCost(){
        return tripCost;
    }

    public String getTravelType(){
        return travelType;
    }

    public String getPaymentType(){
        return paymentType;
    }

    public MedCond getMedCondInfo(){
        return medCondInfo;
    }

    public void updateFirstName(String newFname){
        firstName = newFname;
    }

    public void updateLastName(String newLname){
        lastName = newLname;
    }

    public void updateAddress(String newAddress){
        address = newAddress;
    }

    public void updatePhone(String newPhone){
        phone = newPhone;
    }

    public void updateTripCost(float newCost){
        tripCost = newCost;
    }

    public void updateTravelType(String newTType){
        travelType = newTType;
    }

    public void updatePaymentType(String newPType){
        paymentType = newPType;
    }

    public void updateMedCondInfo(MedCond newMedInfo) {
        medCondInfo = newMedInfo;
    }
    public static void main(String[] args){
        MedCond traveler1med = new MedCond("cum", "fuck", "shit", "a$$");
        TravProf traveler1 = new TravProf("123", 
                                          "austin", 
                                          "nolfi", 
                                          "WoodHaven", 
                                          "911", 
                                          1.02f, 
                                          "Business", 
                                          "Cash", 
                                          traveler1med);
        System.out.println("FIRST:" + traveler1.getFirstName());
        System.out.println("LAST:" + traveler1.getLastName());
    }
}
