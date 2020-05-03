package src.travelProfilePackage;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class TravProfInterfaceGUI {
    public static TravProf_DAO newDB = new TravProf_DAO("./profiles.json");

    public TravProfInterfaceGUI() {
        MedCond testmedinfo = new MedCond("Dr Phil", "911", "Peanuts", "None");
        TravProf testProfile = new TravProf("1337",
                "Austin",
                "Nolfi",
                "753 Sasco Hill Rd.",
                "2037338419",
                500,
                "Pleasure",
                "Cash",
                testmedinfo);
        TravProf testProfile2 = new TravProf("1337",
                "Schmaustin",
                "Molfi",
                "753 Sasco Hill Rd.",
                "2037338419",
                500,
                "Pleasure",
                "Cash",
                testmedinfo);
        newDB.insertNewProfile(testProfile);
        newDB.insertNewProfile(testProfile2);
        openMainMenuGUI("Greetings! Select an option to get started :)");
    }

    public static void openMainMenuGUI(String messageToDipslay) {
        JFrame mainFrame = new JFrame("Integrated Travel System: main menu");
        mainFrame.setSize(400, 500);
        mainFrame.setLayout(null);

        JLabel header = new JLabel("Integrated Travel System");
        header.setBounds(0, 20, 400, 30);
        header.setHorizontalAlignment(JLabel.CENTER);
        mainFrame.add(header);

        JRadioButton rbtnCreateProf = new JRadioButton("Create Profile");
        rbtnCreateProf.setBounds(30, 60, 200, 20);

        JRadioButton rbtnDelProf = new JRadioButton("Delete Profile");
        rbtnDelProf.setBounds(30, 90, 200, 20);

        JRadioButton rbtnUpdProf = new JRadioButton("Update Profile");
        rbtnUpdProf.setBounds(30, 120, 200, 20);

        JRadioButton rbtnFinProf = new JRadioButton("Find/Display Profiles");
        rbtnFinProf.setBounds(30, 150, 200, 20);

        JRadioButton rbtnDisAll = new JRadioButton("Display All Profiles");
        rbtnDisAll.setBounds(30, 180, 200, 20);

        ButtonGroup group = new ButtonGroup();
        group.add(rbtnCreateProf);
        group.add(rbtnDelProf);
        group.add(rbtnUpdProf);
        group.add(rbtnFinProf);
        group.add(rbtnDisAll);
        mainFrame.add(rbtnCreateProf);
        mainFrame.add(rbtnDelProf);
        mainFrame.add(rbtnUpdProf);
        mainFrame.add(rbtnFinProf);
        mainFrame.add(rbtnDisAll); //Radio buttons added to group

        JButton btnSelect = new JButton("Select");
        btnSelect.setBounds(150, 300, 100, 30);
        mainFrame.add(btnSelect);

        JLabel messageLbl = new JLabel(messageToDipslay);
        messageLbl.setBounds(0, 350, 400, 30);
        mainFrame.add(messageLbl);

        mainFrame.setVisible(true);

        btnSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                if (rbtnCreateProf.isSelected()) {
                    //launch Create frame
                    openCreateProfileGUI();
                } else if (rbtnDelProf.isSelected()) {
                    //launch Delete frame
                    openDeleteProfileGUI();
                } else if (rbtnUpdProf.isSelected()) {
                    //launch Update frame
                    openUpdateProfileMenuGUI();
                } else if (rbtnFinProf.isSelected()) {
                    //launch Find/Display frame
                    openFindProfileGUI();
                } else if (rbtnDisAll.isSelected()) {
                    //launch DisplayAll frame
                    openDisplayAllTravProfGUI();
                }
            }
        });
    }


//    public static void deleteTravProf(String userID) throws InterruptedException {
//        System.out.print("Are you sure? To confirm, enter the last name of the profile you wish to delete: ");
//        Scanner delInput = new Scanner(System.in);
//        String delName = delInput.nextLine();
//        boolean didWeDelete = false;
//        didWeDelete = newDB.deleteProfile(userID, delName);
//        while (!didWeDelete) {
//            System.out.println("Hm...I wasn't able to delete this profile. Please ensure your ID was the one used to create the profile in the first place, then try again.");
//            System.out.print("Once more, enter the last name of the profile you wish to delete: ");
//            didWeDelete = newDB.deleteProfile(userID, delName);
//        }
//        System.out.println("Deleting profile...");
//        Thread.sleep(1000);
//        System.out.println("Done!");
//
//    }

    public static void openDeleteProfileGUI() {
        JFrame deleteFrame = new JFrame("Integrated File System: Delete profile");
        deleteFrame.setSize(400, 500);
        deleteFrame.setLayout(null);

        JLabel deleteHeader = new JLabel("Delete Profile");
        deleteHeader.setBounds(0, 20, 400, 30);
        deleteHeader.setHorizontalAlignment(JLabel.CENTER);
        deleteFrame.add(deleteHeader);

        JLabel delIDLabel = new JLabel("Traveler ID: ");
        delIDLabel.setBounds(5, 50, 100, 30);
        deleteFrame.add(delIDLabel);

        JTextField delIDBox = new JTextField();
        delIDBox.setBounds(100, 50, 200, 30);
        deleteFrame.add(delIDBox);

        JLabel delNameLabel = new JLabel("Last Name: ");
        delNameLabel.setBounds(5, 80, 100, 30);
        deleteFrame.add(delNameLabel);

        JTextField delNameBox = new JTextField();
        delNameBox.setBounds(100, 80, 200, 30);
        deleteFrame.add(delNameBox);

        JButton btnDel = new JButton("Delete Profile");
        btnDel.setBounds(100, 300, 200, 30);
        deleteFrame.add(btnDel);

        deleteFrame.setVisible(true);

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String GUIdelID = delIDBox.getText();
                String GUIdelName = delNameBox.getText();

                boolean didGUIDelete = newDB.deleteProfile(GUIdelID, GUIdelName);
                deleteFrame.dispose();
                if (didGUIDelete) {
                    openMainMenuGUI("Profile successfully deleted!");
                } else {
                    openProfileNotFoundGUI();
                }
            }
        });
    }


    public static void openFindProfileGUI() {
        JFrame mainFrame = new JFrame("Integrated Travel System: Find profile");
        mainFrame.setSize(400, 500);
        mainFrame.setLayout(null);

        JLabel header = new JLabel("Find/Display Profile");
        header.setBounds(0, 20, 400, 30);
        header.setHorizontalAlignment(JLabel.CENTER);
        mainFrame.add(header);

        JLabel travLbl = new JLabel("Traveler ID: ");
        travLbl.setBounds(5, 50, 100, 30);
        mainFrame.add(travLbl);

        JLabel lastnameLbl = new JLabel("Last Name: ");
        lastnameLbl.setBounds(5, 80, 100, 30);
        mainFrame.add(lastnameLbl);

        JTextField travIDbox = new JTextField();
        travIDbox.setBounds(100, 50, 200, 30);
        mainFrame.add(travIDbox);

        JTextField lastNamebox = new JTextField();
        lastNamebox.setBounds(100, 80, 200, 30);
        mainFrame.add(lastNamebox);

        JButton btnFind = new JButton("Find profile");
        btnFind.setBounds(100, 300, 200, 30);
        mainFrame.add(btnFind);

        mainFrame.setVisible(true);

        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = travIDbox.getText();
                String lastName = lastNamebox.getText();

                TravProf profile_found = findTravProf(ID, lastName);
                if (profile_found == null) {
                    mainFrame.dispose();
                    openProfileNotFoundGUI();
                } else {
                    mainFrame.dispose();
                    opendisplayTravProfGUI(profile_found);
                }
            }
        });
    }

    public static TravProf findTravProf(String userID, String lastName) {
        TravProf profResult = newDB.findProfile(userID, lastName);
        if (profResult == null) {
            return null;
        }
        return profResult; //found
    }

    public static void openUpdateProfileMenuGUI() {
        JFrame mainFrame = new JFrame("Integrated Travel System: update profile");
        mainFrame.setSize(400, 500);
        mainFrame.setLayout(null);

        JLabel header = new JLabel("Update Profile");
        header.setBounds(0, 20, 400, 30);
        header.setHorizontalAlignment(JLabel.CENTER);
        mainFrame.add(header);

        JLabel travLbl = new JLabel("Traveler ID: ");
        travLbl.setBounds(5, 50, 100, 30);
        mainFrame.add(travLbl);

        JLabel lastnameLbl = new JLabel("Last Name: ");
        lastnameLbl.setBounds(5, 80, 100, 30);
        mainFrame.add(lastnameLbl);

        JTextField travIDbox = new JTextField();
        travIDbox.setBounds(100, 50, 200, 30);
        mainFrame.add(travIDbox);

        JTextField lastNamebox = new JTextField();
        lastNamebox.setBounds(100, 80, 200, 30);
        mainFrame.add(lastNamebox);

        JLabel fieldLbl = new JLabel("Update Field: ");
        fieldLbl.setBounds(5, 120, 100, 30);
        mainFrame.add(fieldLbl);

        String[] fieldsList = {"1. Address",
                "2. Phone",
                "3. Trip cost",
                "4. Travel type",
                "5. Payment type",
                "6. Medical contact",
                "7. Medical contact phone number",
                "8. Allergy type",
                "9. Illness type"};
        JComboBox selectField = new JComboBox(fieldsList);
        selectField.setBounds(100, 120, 300, 30);
        mainFrame.add(selectField);

        JButton btnFind = new JButton("Find Profile for Update");
        btnFind.setBounds(100, 300, 225, 30);
        mainFrame.add(btnFind);

        mainFrame.setVisible(true);

        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //find the profile in the database with the corresponding ID and lastName
                String ID = travIDbox.getText();
                String lastName = lastNamebox.getText();
                String comboOption = selectField.getSelectedItem().toString();
                String field = comboOption.substring(3);

                updateTravProf(ID, lastName, field);
                mainFrame.dispose();
            }
        });
    }

    public static void updateTravProf(String userID, String lastName, String field) {
        TravProf modProf = findTravProf(userID, lastName);
        if (modProf == null) {
            openProfileNotFoundGUI();
        } else {
            openUpdateGUI(lastName, userID, field, modProf);
        }
    }

    public static void opendisplayTravProfGUI(TravProf prof) {
        String name = prof.getFirstName();
        String lastName = prof.getLastName();
        String address = prof.getAddress();
        String phone = prof.getPhone();
        float cost = prof.getTripCost();
        String travType = prof.getTravelType();
        String payType = prof.getPaymentType();
        String medContact = prof.getMedCondInfo().getMdContact();
        String medPhone = prof.getMedCondInfo().getMdPhone();
        String algType = prof.getMedCondInfo().getAlgType();
        String illType = prof.getMedCondInfo().getIllType();

        JFrame displayFrame = new JFrame("Integrated Travel System: " + name + " " + lastName + " Profile");
        displayFrame.setSize(400, 500);
        displayFrame.setLayout(null);

        JLabel header = new JLabel("Displaying the profile of " + name + " " + lastName);
        header.setBounds(0, 20, 400, 30);
        header.setHorizontalAlignment(JLabel.CENTER);
        displayFrame.add(header);

        JLabel nameLbl = new JLabel("First name: " + name);
        nameLbl.setBounds(5, 50, 350, 30);
        displayFrame.add(nameLbl);

        JLabel lastNameLbl = new JLabel("Last name: " + lastName);
        lastNameLbl.setBounds(5, 80, 350, 30);
        displayFrame.add(lastNameLbl);

        JLabel addresLbl = new JLabel("Address: " + address);
        addresLbl.setBounds(5, 110, 350, 30);
        displayFrame.add(addresLbl);

        JLabel phoneLbl = new JLabel("Phone: " + phone);
        phoneLbl.setBounds(5, 140, 350, 30);
        displayFrame.add(phoneLbl);

        JLabel costLbl = new JLabel("Trip cost: " + cost);
        costLbl.setBounds(5, 170, 350, 30);
        displayFrame.add(costLbl);

        JLabel travTypeLbl = new JLabel("Travel type: " + travType);
        travTypeLbl.setBounds(5, 200, 350, 30);
        displayFrame.add(travTypeLbl);

        JLabel payTypeLbl = new JLabel("Payment type: " + payType);
        payTypeLbl.setBounds(5, 230, 350, 30);
        displayFrame.add(payTypeLbl);

        JLabel medContactLbl = new JLabel("Medical contact: " + medContact);
        medContactLbl.setBounds(5, 260, 350, 30);
        displayFrame.add(medContactLbl);

        JLabel medPhoneLbl = new JLabel("Medical contact phone: " + medPhone);
        medPhoneLbl.setBounds(5, 290, 350, 30);
        displayFrame.add(medPhoneLbl);

        JLabel algTypeLbl = new JLabel("Allergies: " + algType);
        algTypeLbl.setBounds(5, 320, 350, 30);
        displayFrame.add(algTypeLbl);

        JLabel illTypeLbl = new JLabel("Illnesses: " + illType);
        illTypeLbl.setBounds(5, 350, 350, 30);
        displayFrame.add(illTypeLbl);

        JButton returnBtn = new JButton("Return to Main Menu");
        returnBtn.setBounds(100, 400, 200, 30);
        displayFrame.add(returnBtn);

        displayFrame.setVisible(true);

        returnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFrame.dispose();
                openMainMenuGUI("");
            }
        });
    }

    public static int displayAllIndex = 0;

    public static void openDisplayAllTravProfGUI() {
        JFrame displayAllFrame = new JFrame("Displaying all profiles");
        displayAllFrame.setSize(400, 500);
        displayAllFrame.setLayout(null);

        JLabel header = new JLabel("Enter Travel ID: ");
        header.setBounds(0, 20, 400, 30);
        header.setHorizontalAlignment(JLabel.CENTER);
        displayAllFrame.add(header);

        //TravelerID
        JLabel travID = new JLabel("Traveler ID: ");
        travID.setBounds(5, 50, 300, 30);
        displayAllFrame.add(travID);

        JTextField travIDField = new JTextField();
        travIDField.setBounds(100, 50, 200, 30);
        displayAllFrame.add(travIDField);

        JButton createConfirm = new JButton("Submit");
        createConfirm.setBounds(100, 100, 100, 30);
        displayAllFrame.add(createConfirm);

        displayAllFrame.setVisible(true);

        createConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllFrame.dispose();
                for (int i = 0; i <= newDB.travelerList.length; i++) {
                    if (i == newDB.travelerList.length) {
                        openProfileNotFoundGUI();
                        break; //Went through list with no matches
                    } else if (newDB.travelerList[i] == null) {
                        continue; //no profile in current index
                    } else if (newDB.travelerList[i].travAgentID.equals(travIDField.getText())) {
                        displayAllIndex = i;
                        openDisplayNextTravProfGUI(newDB.travelerList[i], i, travIDField.getText()); //we have a match, display it!
                        break;
                    }
                }
            }
        });

    }

    public static JFrame openDisplayNextTravProfGUI(TravProf prof, int i, String ID) {
        String name = prof.getFirstName();
        String lastName = prof.getLastName();
        String address = prof.getAddress();
        String phone = prof.getPhone();
        float cost = prof.getTripCost();
        String travType = prof.getTravelType();
        String payType = prof.getPaymentType();
        String medContact = prof.getMedCondInfo().getMdContact();
        String medPhone = prof.getMedCondInfo().getMdPhone();
        String algType = prof.getMedCondInfo().getAlgType();
        String illType = prof.getMedCondInfo().getIllType();

        JFrame displayFrame = new JFrame("Integrated Travel System: " + name + " " + lastName + " Profile");
        displayFrame.setSize(600, 700);
        displayFrame.setLayout(null);

        JLabel header = new JLabel("Displaying the profile of " + name + " " + lastName);
        header.setBounds(0, 20, 400, 30);
        header.setHorizontalAlignment(JLabel.CENTER);
        displayFrame.add(header);

        JLabel nameLbl = new JLabel("First name: " + name);
        nameLbl.setBounds(5, 50, 350, 30);
        displayFrame.add(nameLbl);

        JLabel lastNameLbl = new JLabel("Last name: " + lastName);
        lastNameLbl.setBounds(5, 80, 350, 30);
        displayFrame.add(lastNameLbl);

        JLabel addresLbl = new JLabel("Address: " + address);
        addresLbl.setBounds(5, 110, 350, 30);
        displayFrame.add(addresLbl);

        JLabel phoneLbl = new JLabel("Phone: " + phone);
        phoneLbl.setBounds(5, 140, 350, 30);
        displayFrame.add(phoneLbl);

        JLabel costLbl = new JLabel("Trip cost: " + cost);
        costLbl.setBounds(5, 170, 350, 30);
        displayFrame.add(costLbl);

        JLabel travTypeLbl = new JLabel("Travel type: " + travType);
        travTypeLbl.setBounds(5, 200, 350, 30);
        displayFrame.add(travTypeLbl);

        JLabel payTypeLbl = new JLabel("Payment type: " + payType);
        payTypeLbl.setBounds(5, 230, 350, 30);
        displayFrame.add(payTypeLbl);

        JLabel medContactLbl = new JLabel("Medical contact: " + medContact);
        medContactLbl.setBounds(5, 260, 350, 30);
        displayFrame.add(medContactLbl);

        JLabel medPhoneLbl = new JLabel("Medical contact phone: " + medPhone);
        medPhoneLbl.setBounds(5, 290, 350, 30);
        displayFrame.add(medPhoneLbl);

        JLabel algTypeLbl = new JLabel("Allergies: " + algType);
        algTypeLbl.setBounds(5, 320, 350, 30);
        displayFrame.add(algTypeLbl);

        JLabel illTypeLbl = new JLabel("Illnesses: " + illType);
        illTypeLbl.setBounds(5, 350, 350, 30);
        displayFrame.add(illTypeLbl);

        JButton nextBtn = new JButton("Next");
        nextBtn.setBounds(100, 400, 200, 30);
        displayFrame.add(nextBtn);

        displayFrame.setVisible(true);

        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = displayAllIndex; i < newDB.travelerList.length; i++) {
                    if (displayAllIndex == newDB.travelerList.length) {
                        break;
                    } else if (newDB.travelerList[i] == null) {
                        continue;
                    } else if (newDB.travelerList[i].travAgentID.equals(ID)) {
                        displayAllIndex = i + 1;
                        if (displayAllIndex == newDB.travelerList.length) {
                            break;
                        }
                        displayFrame.dispose();
                        openDisplayNextTravProfGUI(newDB.travelerList[i + 1], displayAllIndex, ID);
                    }
                }
                displayFrame.dispose();
                openMainMenuGUI("Returning to Main Menu...");


            }
        });
        return displayFrame;
    }

    public static void displayAllTravProf(String userID) {
        System.out.println("Gotcha. Here are all the profiles created by your current ID:");
        for (int i = 0; i < newDB.numTravelers; i++) {
            if (newDB.travelerList[i] == null) {
                continue;
            } else if (newDB.travelerList[i].travAgentID.equals(userID)) {
                opendisplayTravProfGUI(newDB.travelerList[i]);
            }
        }
    }

    public static void writeToDB() {
        System.out.println("Writing to 'profiles.json'...");
        try {
            newDB.writeAllTravProf();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void initDB() {
        System.out.println("Loading profiles from 'profiles.json'...");
        try {
            newDB.initializeDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static TravProf createNewTravProf(String userID) throws InterruptedException {
//        System.out.print("To begin, please enter your (client's) first name: ");
//        Scanner userInput = new Scanner(System.in);
//        String newFirst = userInput.nextLine();
//        userInput.reset();
//        System.out.print("Next, please enter your last name: ");
//        String newLast = userInput.nextLine();
//        userInput.reset();
//        System.out.print("Next, please enter your address: ");
//        String newAddy = userInput.nextLine();
//        userInput.reset();
//        System.out.print("Next, please enter your home phone number: ");
//        String newPhone = userInput.nextLine();
//        userInput.reset();
//        System.out.print("Next, please enter your estimated trip cost. Floats are fine!: ");
//        float newCost = Float.parseFloat(userInput.nextLine());
//        userInput.reset();
//        System.out.print("Next, please choose your travel type, by typing 'Pleasure' or 'Business': ");
//        String newTravType = userInput.nextLine();
//        userInput.reset();
//        while (!newTravType.equals("Pleasure") & !newTravType.equals("pleasure") & !newTravType.equals("Business") & !newTravType.equals("business")) {
//            System.out.print("Apologies, but the string you entered is neither 'Business' and, quite frankly, nor is it 'Pleasure'. Try again :) : ");
//            newTravType = userInput.nextLine();
//            userInput.reset();
//        }
//        String newPaymentType = null;
//        while (newPaymentType == null) {
//            System.out.print("How will you be paying? Please choose by typing 'Credit', 'Check', 'Debit', or 'Invoice'. DINERS CLUB IS NO LONGER ACCEPTED: ");
//            String newPaymentChoice = userInput.nextLine();
//            switch (newPaymentChoice) {
//                case "Credit":
//                case "credit":
//                    newPaymentType = "Credit";
//                    break;
//                case "Check":
//                case "check":
//                    newPaymentType = "Check";
//                    break;
//                case "Debit":
//                case "debit":
//                    newPaymentType = "Debit";
//                    break;
//                case "Invoice":
//                case "invoice":
//                    newPaymentType = "Invoice";
//                    break;
//                default:
//                    newPaymentType = null;
//                    System.out.println("Invalid payment type entered.");
//            }
//        }
//        userInput.reset();
//        System.out.println("Analyzing user based off of entries...");
//        Thread.sleep(1000);
//        System.out.println("Interesting. I will now confirm your medical records with our human database.");
//        TimeUnit.SECONDS.sleep(1);
//        MedCond newMedCond = createNewMedCond();
//        TravProf newProfile = new TravProf(userID, newFirst, newLast, newAddy, newPhone, newCost, newTravType, newPaymentType, newMedCond);
//        return newProfile;
//    }

//    public static MedCond createNewMedCond() {
//        System.out.print("To confirm, please enter the name of your client's physician: ");
//        Scanner medInput = new Scanner(System.in);
//        String newMdContact = medInput.nextLine();
//        medInput.reset();
//        System.out.print("And what is this physician's phone number?");
//        String newMdPhone = medInput.nextLine();
//        medInput.reset();
//        System.out.println("Hmmm...that checks out with our data so far. Further questions:");
//        String newAlgType = null;
//        while (newAlgType == null) {
//            System.out.print("What is your client's most pertinent allergy? Please choose by typing 'none', 'food', 'medication', or 'other': ");
//            String newAlgChoice = medInput.nextLine();
//            switch (newAlgChoice) {
//                case "None":
//                case "none":
//                    newAlgType = "None";
//                    break;
//                case "Food":
//                case "food":
//                    newAlgType = "Food";
//                    break;
//                case "Medication":
//                case "medication":
//                    newAlgType = "Medication";
//                    break;
//                case "Other":
//                case "other":
//                    newAlgType = "Other";
//                    break;
//                default:
//                    newAlgType = null;
//                    System.out.println("Invalid allergy type entered.");
//            }
//        }
//        medInput.reset();
//
//        String newIllType = null;
//        while (newIllType == null) {
//            System.out.print("What is your client's most pertinent illness? Please choose by typing 'none', 'heart', 'diabetes', 'asthma', or 'other': ");
//            String newIllChoice = medInput.nextLine();
//            switch (newIllChoice) {
//                case "None":
//                case "none":
//                    newIllType = "None";
//                    break;
//                case "Heart":
//                case "heart":
//                    newIllType = "Heart";
//                    break;
//                case "Diabetes":
//                case "diabetes":
//                    newIllType = "Diabetes";
//                    break;
//                case "Asthma":
//                case "asthma":
//                    newIllType = "Asthma";
//                    break;
//                case "Other":
//                case "other":
//                    newIllType = "Other";
//                    break;
//                default:
//                    newIllType = null;
//                    System.out.println("Invalid allergy type entered.");
//            }
//        }
//        medInput.reset();
//
//        System.out.println("Confirming all medical info...");
//        System.out.println("Going back to main menu..." + "\n");
//        return new MedCond(newMdContact, newMdPhone, newAlgType, newIllType);
//    }//call this within createNewTravProf

    public static void openCreateProfileGUI() {
        JFrame createFrame = new JFrame("Create a new profile");
        createFrame.setSize(400, 500);
        createFrame.setLayout(null);

        JLabel header = new JLabel("Create your new Profile");
        header.setBounds(0, 20, 400, 30);
        header.setHorizontalAlignment(JLabel.CENTER);
        createFrame.add(header);

        //TravelerID
        JLabel travID = new JLabel("Traveler ID: ");
        travID.setBounds(5, 50, 200, 30);
        createFrame.add(travID);
        //First Name
        JLabel fName = new JLabel("First Name: ");
        fName.setBounds(5, 80, 200, 30);
        createFrame.add(fName);
        //Last Name
        JLabel lName = new JLabel("Last Name: ");
        lName.setBounds(5, 110, 200, 30);
        createFrame.add(lName);
        //Address
        JLabel address = new JLabel("Address: ");
        address.setBounds(5, 140, 200, 30);
        createFrame.add(address);
        //Phone
        JLabel phone = new JLabel("Phone Number: ");
        phone.setBounds(5, 170, 200, 30);
        createFrame.add(phone);
        //Trip Cost
        JLabel tripCost = new JLabel("Trip Cost: ");
        tripCost.setBounds(5, 200, 200, 30);
        createFrame.add(tripCost);
        //Travel Type
        JLabel travType = new JLabel("Travel Type: ");
        travType.setBounds(5, 230, 200, 30);
        createFrame.add(travType);
        //Payment Type
        JLabel payType = new JLabel("Payment Type: ");
        payType.setBounds(5, 260, 200, 30);
        createFrame.add(payType);
        //Mode of Travel
        JLabel mdContact = new JLabel("Medical Contact Name: ");
        mdContact.setBounds(5, 290, 200, 30);
        createFrame.add(mdContact);
        //Rewards Company
        JLabel mdPhone = new JLabel("Medical Phone Number: ");
        mdPhone.setBounds(5, 320, 200, 30);
        createFrame.add(mdPhone);
        //Rewards ID
        JLabel algType = new JLabel("Allergy Type: ");
        algType.setBounds(5, 350, 200, 30);
        createFrame.add(algType);
        //Rewards Balance
        JLabel illType = new JLabel("Illness Type: ");
        illType.setBounds(5, 380, 200, 30);
        createFrame.add(illType);

        // Corresponding text fields
        JTextField travIDField = new JTextField();
        travIDField.setBounds(100, 50, 200, 30);
        createFrame.add(travIDField);

        JTextField fNameField = new JTextField();
        fNameField.setBounds(100, 80, 200, 30);
        createFrame.add(fNameField);

        JTextField lNameField = new JTextField();
        lNameField.setBounds(100, 110, 200, 30);
        createFrame.add(lNameField);

        JTextField AddressField = new JTextField();
        AddressField.setBounds(100, 140, 200, 30);
        createFrame.add(AddressField);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(100, 170, 200, 30);
        createFrame.add(phoneField);

        JTextField tCostField = new JTextField();
        tCostField.setBounds(100, 200, 200, 30);
        createFrame.add(tCostField);

        String[] tTypeList = {"Business",
                "Pleasure"};
        JComboBox tTypeField = new JComboBox(tTypeList);
        tTypeField.setBounds(100, 230, 200, 30);
        createFrame.add(tTypeField);

        String[] pTypeList = {"Credit",
                "Check",
                "Debit",
                "Invoice"};
        JComboBox pTypeField = new JComboBox(pTypeList);
        pTypeField.setBounds(100, 260, 200, 30);
        createFrame.add(pTypeField);

        JTextField mdContactField = new JTextField();
        mdContactField.setBounds(160, 290, 200, 30);
        createFrame.add(mdContactField);

        JTextField mdPhoneField = new JTextField();
        mdPhoneField.setBounds(160, 320, 200, 30);
        createFrame.add(mdPhoneField);

        String[] algTypeList = {"None",
                "Food",
                "Medication",
                "Other"};
        JComboBox algTypeField = new JComboBox(algTypeList);
        algTypeField.setBounds(100, 350, 200, 30);
        createFrame.add(algTypeField);

        String[] illTypeList = {"None",
                "Heart",
                "Diabetes",
                "Asthma",
                "Other"};
        JComboBox illTypeField = new JComboBox(illTypeList);
        illTypeField.setBounds(100, 380, 200, 30);
        createFrame.add(illTypeField);

        JButton createConfirm = new JButton("Submit");
        createConfirm.setBounds(100, 410, 200, 30);
        createFrame.add(createConfirm);

        createFrame.setVisible(true);

        createConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newDB.insertNewProfile(new TravProf(travIDField.getText(), fNameField.getText(), lNameField.getText(), AddressField.getText(), phoneField.getText(), Float.parseFloat(tCostField.getText()), tTypeField.getSelectedItem().toString(), pTypeField.getSelectedItem().toString(), new MedCond(mdContactField.getText(), mdPhoneField.getText(), algTypeField.getSelectedItem().toString(), illTypeField.getSelectedItem().toString())));
                createFrame.dispose();
                openMainMenuGUI("Submission Successful! Wow!");
            }
        });

    }

    public static void openUpdateGUI(String passed_name, String passed_id, String field, TravProf passed_profile) {
        JFrame updateFrame = new JFrame("Update the Current Profile");
        updateFrame.setSize(400, 500);
        updateFrame.setLayout(null);
        JLabel header = new JLabel("Update " + field);
        header.setBounds(0, 20, 400, 30);
        header.setHorizontalAlignment(JLabel.CENTER);
        updateFrame.add(header);

        JLabel travLbl = new JLabel("Traveler ID: " + passed_id);
        travLbl.setBounds(5, 50, 300, 30);
        updateFrame.add(travLbl);

        JLabel lastnameLbl = new JLabel("Last Name: " + passed_name);
        lastnameLbl.setBounds(5, 80, 300, 30);
        updateFrame.add(lastnameLbl);

        JLabel fieldToUpdate = new JLabel("Enter " + field);
        fieldToUpdate.setBounds(5, 110, 300, 30);
        updateFrame.add(fieldToUpdate);

        JTextField fieldText = new JTextField();
        fieldText.setBounds(5, 145, 300, 30);
        updateFrame.add(fieldText);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(100, 300, 200, 30);
        updateFrame.add(btnUpdate);

        updateFrame.setVisible(true);

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String updateText = fieldText.getText();
                MedCond profile_med = passed_profile.getMedCondInfo();
                switch (field) {
                    case "Address":
                        //updateAddress
                        passed_profile.updateAddress(updateText);
                        break;
                    case "Phone":
                        //updatePhone
                        passed_profile.updatePhone(updateText);
                        break;
                    case "Trip cost":
                        float cost = Float.parseFloat(updateText);
                        passed_profile.updateTripCost(cost);
                        break;
                    case "Travel type":
                        passed_profile.updateTravelType(updateText);
                        break;
                    case "Payment type":
                        passed_profile.updatePaymentType(updateText);
                        break;
                    case "Medical contact":
                        profile_med.updateMdContact(updateText);
                        passed_profile.updateMedCondInfo(profile_med);
                        break;
                    case "Medical contact phone number":
                        profile_med.updateMdPhone(updateText);
                        passed_profile.updateMedCondInfo(profile_med);
                        break;
                    case "Allergy type":
                        profile_med.updateAlgType(updateText);
                        passed_profile.updateMedCondInfo(profile_med);
                        break;
                    case "Illness type":
                        profile_med.updateIllType(updateText);
                        passed_profile.updateMedCondInfo(profile_med);
                        break;
                }
                String messageToDisplay = "Profile successfully updated!";
                updateFrame.dispose();
                openMainMenuGUI(messageToDisplay);
            }
        });
    }

    public static void openProfileNotFoundGUI() {
        JFrame notFoundFrame = new JFrame("Profile Not Found");
        notFoundFrame.setSize(400, 500);
        notFoundFrame.setLayout(null);

        JLabel header = new JLabel("Profile not Found, please try again.");
        header.setBounds(0, 20, 400, 30);
        header.setHorizontalAlignment(JLabel.CENTER);
        notFoundFrame.add(header);

        JButton btnReturn = new JButton("Return");
        btnReturn.setBounds(100, 300, 200, 30);
        notFoundFrame.add(btnReturn);

        notFoundFrame.setVisible(true);

        btnReturn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notFoundFrame.dispose();
                openMainMenuGUI("");
            }
        });
    }

    public static void main(String[] args) {
        TravProfInterfaceGUI test = new TravProfInterfaceGUI();
    }
}
