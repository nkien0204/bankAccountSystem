/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

/**
 *
 * @author kn
 */
public class Customers {
    private Account[] accounts = new Account[10];
    private String customerID;
    private String customerName;
    private String customerAddr;
    
    public Customers(String customerID, String customerName, String customerAddr) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddr = customerAddr;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddr(String customerAddr) {
        this.customerAddr = customerAddr;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddr() {
        return customerAddr;
    }
    
    public void openAccount(String customerID, String accountNo) {
        int i = 0;
        int balance = 0;
        while (accounts[i] != null) {
            i++;
        }
        
        accounts[i] = new Account(accountNo, customerID, balance);
        System.out.println("Open account successfully");
    }
    
    public void closeAccount(String accountNo) {
        int i = 0;
        boolean flag = false;
        while (accounts[i] != null) {
            if (accounts[i].getAccountNo().equals(accountNo)) {
                accounts[i] = accounts[i+1];
                accounts[i+1] = null;
                flag = true;
            }
            i++;
        }
        if (flag == true) System.out.println("Close account successfully");
        else System.out.println("Account number does not exist");
    }
    
    public void depositMoney(String accountNo, int amount) {
        int i = 0;
        while (accounts[i] != null) {
            if (accounts[i].getAccountNo().equals(accountNo)) {
                accounts[i].setBalance(accounts[i].getBalance() + amount);
                System.out.println("Transaction successfully!");
                break;
            }
            i++;
        }
        if (accounts[i] == null) {
            System.out.println("Account number does not exist!");
        }
    }
    
    public void withdrawMoney(String accountNo, int amount) {
        int i = 0;
        while (accounts[i] != null) {
            if (accounts[i].getAccountNo().equals(accountNo)) {
                if (accounts[i].getBalance() >= amount) {
                    accounts[i].setBalance(accounts[i].getBalance() - amount);
                    System.out.println("Transaction successfully!");
                } else {
                    System.out.println("Your balance is not enough!");
                }
                break;
            }
            i++;
        }
        if (accounts[i] == null) {
            System.out.println("Account number does not exist!");
        }
    }
    
    public void querySpecificAccount(String accountNo) {
        int i = 0;
        while (accounts[i] != null) {
            if (accounts[i].getAccountNo().equals(accountNo)) {
                System.out.println("Customer name: " + getCustomerName());
                System.out.println("Account number: " + accounts[i].getAccountNo());
                System.out.println("Customer ID: " + accounts[i].getCustomerID());
                System.out.println("Balance: " + accounts[i].getBalance());
                break;
            } else {
                i++;
            }
        }
        if (accounts[i] == null) {
            System.out.println("Account number does not exist!");
        }
    }
    
    public void queryAllAccount() {
        int i = 0;
        if (accounts[0] == null) {
            System.out.println("You dont have any account");
            return;
        }
        while (accounts[i] != null) {
            System.out.println("Customer name: " + getCustomerName());
            System.out.println("Account number: " + accounts[i].getAccountNo());
            System.out.println("Customer ID: " + accounts[i].getCustomerID());
            System.out.println("Balance: " + accounts[i].getBalance());
            System.out.println("************************************");
            i++;
        }
    }
}
