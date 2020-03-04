public class MedCond {
    String mdContact;
    String mdPhone;
    String algType;
    String illType;
    public MedCond(String physician, String medNum, String allergies, String illness){
        mdContact = physician;
        mdPhone = medNum;
        algType = allergies;
        illType = illness;
    }
    public String getMdContact(){
        return mdContact;
    }
    public String getMdPhone(){
        return mdPhone;
    }
    public String getAlgType(){
        return algType;
    }
    public String getIllType(){
        return illType;
    }
    public void updateMdContact(String newMdContact){
        mdContact = newMdContact;
    }
    public void updateMdPhone(String newMdPhone){
        mdPhone = newMdPhone;
    }
    public void updateAlgType(String newAlgType){
        algType = newAlgType;
    }
    public void updateIllType(String newIllType){
        illType = newIllType;
    }

}
