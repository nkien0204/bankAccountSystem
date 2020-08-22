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
public class Bank {
    private String bankID;
    private String bankName;
    private String bankLocation;
    
    public Bank(String bankID, String bankName, String bankLocation) {
        this.bankID = bankID;
        this.bankName = bankName;
        this.bankLocation = bankLocation;
    }
    
    public String getBankID() {
        return bankID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankLocation() {
        return bankLocation;
    }

    public void setBankLocation(String bankLocation) {
        this.bankLocation = bankLocation;
    }
}
