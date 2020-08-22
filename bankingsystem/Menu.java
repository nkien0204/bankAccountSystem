/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

import java.util.Scanner;

/**
 *
 * @author kn
 */
public class Menu {
    private String choice;
    private Customers customer;
    private String customerID, customerName, customerAddr;
    
    public void start() {
        Scanner input = new Scanner(System.in);
        logIn();
        while (true) {
            System.out.println("*****************************************");
            System.out.println("Welome to Bank Account Managament System");
            System.out.println("1. Open Bank account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View a specific account");
            System.out.println("5. View all account");
            System.out.println("6. Close Bank account");
            System.out.println("7. Quit");
            
            System.out.print("Your choice: ");
            choice = input.nextLine();
            switch(choice) {
                case "1":
                    openAccount();
                    break;
                case "2":
                    depositMoney();
                    break;
                case "3":
                    withdrawMoney();
                    break;
                case "4":
                    viewOneAccount();
                    break;
                case "5":
                    viewAllAccount();
                    break;
                case "6":
                    closeAccount();
                    break;
                case "7":
                    quit();
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    
    private void logIn() {
        Scanner input = new Scanner(System.in);
        System.out.println("**********************");
        System.out.println("LOG IN");
        System.out.print("Enter your customer ID: ");
        customerID = input.nextLine();
        System.out.print("Enter your name: ");
        customerName = input.nextLine();
        System.out.print("Enter your address: ");
        customerAddr = input.nextLine();
        
        customer = new Customers(customerID, customerName, customerAddr);
    }
    
    private void openAccount() {
        System.out.println("**********************");
        System.out.println("OPEN ACCOUNT");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your new account number: ");
        String accountNr = input.nextLine();
        
        customer.openAccount(customerID, accountNr);
        System.out.println("**********************");
        System.out.println("NEW ACCOUNT INFO");
        customer.querySpecificAccount(accountNr);
        
        while (true) {
            System.out.print("Press \'0\' to go back: ");
            String back = input.nextLine();
            if (back.equals("0")) {
                return;
            }
        }
    }
    
    private void depositMoney() {
        System.out.println("**********************");
        System.out.println("DEPOSIT MONEY");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your account number: ");
        String accountNr = input.nextLine();
        System.out.print("Enter your deposit money: ");
        int amount = input.nextInt();
        
        customer.depositMoney(accountNr, amount);
        
        if (customer.getAccounts()[0] != null) {
            System.out.println("ACCOUNT INFO");
            customer.querySpecificAccount(accountNr);
        }
        input.nextLine();
        while (true) {
            System.out.print("Press \'0\' to go back: ");
            String back = input.nextLine();
            if (back.equals("0")) {
                return;
            }
        }
    }
    
    private void withdrawMoney() {
        System.out.println("**********************");
        System.out.println("WITHDRAW MONEY");

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your account number: ");
        String accountNr = input.nextLine();
        System.out.print("Enter your withdraw money: ");
        int amount = input.nextInt();
        
        customer.withdrawMoney(accountNr, amount);
        
        if (customer.getAccounts()[0] != null) {
            System.out.println("ACCOUNT INFO");
            customer.querySpecificAccount(accountNr);
        }
        
        input.nextLine();
        while (true) {
            System.out.print("Press \'0\' to go back: ");
            String back = input.nextLine();
            if (back.equals("0")) {
                return;
            }
        }
    }
    
    private void viewOneAccount() {
        System.out.println("**********************");
        System.out.println("ACCOUNT INFO");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your account number: ");
        String accountNr = input.nextLine();
        
        customer.querySpecificAccount(accountNr);
        
        while (true) {
            System.out.print("Press \'0\' to go back: ");
            String back = input.nextLine();
            if (back.equals("0")) {
                return;
            }
        }
    }
    
    private void viewAllAccount() {
        System.out.println("**********************");
        System.out.println("ACCOUNT INFO");
        Scanner input = new Scanner(System.in);
        customer.queryAllAccount();
        
        while (true) {
            System.out.print("Press \'0\' to go back: ");
            String back = input.nextLine();
            if (back.equals("0")) {
                return;
            }
        }
    }
    
    private void closeAccount() {
        System.out.println("**********************");
        System.out.println("CLOSE ACCOUNT");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your account number: ");
        String accountNr = input.nextLine();
        
        customer.closeAccount(accountNr);
        
        while (true) {
            System.out.print("Press \'0\' to go back: ");
            String back = input.nextLine();
            if (back.equals("0")) {
                return;
            }
        }
    }
    
    private void quit() {
        System.exit(0);
    }
}
