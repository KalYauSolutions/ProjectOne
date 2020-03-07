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
                    String payType, medConInfo medInfo) {
        travAgentID = ID;
        firstName = first;
        lastName = last;
        address = address;
        phone = phone;
        tripCost = cost;
        travelType = travType;
        paymentType = payType;
        medCondInfo = medInfo;
    }

    public String gettravAgentID() {
        return travAgentId;
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
        MedCond t1med = new MedCond();
        TravProf t1 = new TravProf("123", "austin", "nolfi", "WoodHaven", "911",
                "$1", "business", "cash", t1med);

        System.out.print(gettravAgentID());
    }
}
