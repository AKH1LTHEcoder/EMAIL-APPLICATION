// BACKEND STUFF

package emailapp;

import java.util.Scanner;

public class Email {
    private String FirstName;
    private String LastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "company.com";

    // Constructor to receive the first name and last name
    public Email(String FirstName, String LastName) {
        this.FirstName = FirstName;
        this.LastName = LastName;

        // Call a method asking for the department - return the department
        this.department = setDepartment();
    
        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your Password is : " + this.password);

        // Combine elements to generate the email
        email = FirstName.toLowerCase() + "." + LastName.toLowerCase() + "@" + department + "." + companySuffix;
    
    }

    // Ask for the department
    private String setDepartment() {
        System.out.println("New worker: " + FirstName + ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "development";
        } else if (depChoice == 3) {
            return "acctounting";
        } else {
            return "";
        }
    }

    // Generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * password.length);
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail () { return alternateEmail; }
    public String getPassword () { return password; }

    public String showInfo() {
        return "DISPLAY NAME: " + FirstName + " " + LastName +
                "\nCOMPANY NAME: " + email + 
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb"; 
    }
}
