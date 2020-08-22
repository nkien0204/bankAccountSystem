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
public class Account {
    private String accountNo;
    private int balance = 0;
    private String customerID;
    
    public Account(String accountNo, String customerID, int balance) {
        this.accountNo = accountNo;
        this.customerID = customerID;
        this.balance = balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public int getBalance() {
        return balance;
    }

    public String getCustomerID() {
        return customerID;
    }
}
