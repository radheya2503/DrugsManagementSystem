package DrugsManagement;

import java.util.ArrayList;
import java.util.Scanner;

// Drug class to represent each drug
class Drug {
    private String drugID;
    private String name;
    private String type;
    private int quantity;
    private double price;

    public Drug(String drugID, String name, String type, int quantity, double price) {
        this.drugID = drugID;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getDrugID() {
        return drugID;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // toString method to display drug details
    @Override
    public String toString() {
        return "Drug ID: " + drugID + ", Name: " + name + ", Type: " + type +
                ", Quantity: " + quantity + ", Price: $" + price;
    }
}

// DrugManagementSystem class to manage the drug list
class DrugManagementSystem {
    private ArrayList<Drug> drugList;

    public DrugManagementSystem() {
        drugList = new ArrayList<>();
    }

    // Add a new drug
    public void addDrug(Drug drug) {
        drugList.add(drug);
        System.out.println("Drug added successfully.");
    }

    // View all drugs
    public void viewDrugs() {
        if (drugList.isEmpty()) {
            System.out.println("No drugs available.");
            return;
        }
        for (Drug drug : drugList) {
            System.out.println(drug);
        }
    }

    // Search for a drug by ID
    public Drug searchDrugByID(String drugID) {
        for (Drug drug : drugList) {
            if (drug.getDrugID().equalsIgnoreCase(drugID)) {
                return drug;
            }
        }
        return null;
    }

    // Delete a drug by ID
    public boolean deleteDrugByID(String drugID) {
        Drug drug = searchDrugByID(drugID);
        if (drug != null) {
            drugList.remove(drug);
            System.out.println("Drug deleted successfully.");
            return true;
        }
        System.out.println("Drug not found.");
        return false;
    }
}

// Main class to run the program
public class DrugManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DrugManagementSystem dms = new DrugManagementSystem();

        while (true) {
            System.out.println("\n--- Drug Management System ---");
            System.out.println("1. Add Drug");
            System.out.println("2. View Drugs");
            System.out.println("3. Search Drug by ID");
            System.out.println("4. Delete Drug by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Drug ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Drug Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Drug Type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();

                    Drug drug = new Drug(id, name, type, quantity, price);
                    dms.addDrug(drug);
                    break;

                case 2:
                    System.out.println("\n--- List of Drugs ---");
                    dms.viewDrugs();
                    break;

                case 3:
                    System.out.print("Enter Drug ID to search: ");
                    String searchID = scanner.nextLine();
                    Drug foundDrug = dms.searchDrugByID(searchID);
                    if (foundDrug != null) {
                        System.out.println("Drug Found: " + foundDrug);
                    } else {
                        System.out.println("Drug not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Drug ID to delete: ");
                    String deleteID = scanner.nextLine();
                    dms.deleteDrugByID(deleteID);
                    break;

                case 5:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}