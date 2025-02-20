<<<<<<< HEAD
package com.maybanktask.user_management.dto;

public class Books {
    private Long id;
    private String accountNumber;
    private double trxAmmount;
    private String description;
    private String trxDate;
    private String time;
    private CustomerDetails customerDetails;
    public Books(Long id, String accountNumber, double trxAmmount, String description, String trxDate, String time, CustomerDetails customerDetails) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.trxAmmount = trxAmmount;
        this.description = description;
        this.trxDate = trxDate;
        this.time = time;
        this.customerDetails = customerDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getTrxAmmount() {
        return trxAmmount;
    }

    public void setTrxAmmount(double trxAmmount) {
        this.trxAmmount = trxAmmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(String trxDate) {
        this.trxDate = trxDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }
}
=======
package com.maybanktask.user_management.dto;

public class Books {
    private Long id;
    private String accountNumber;
    private double trxAmmount;
    private String description;
    private String trxDate;
    private String time;
    private CustomerDetails customerDetails;
    public Books(Long id, String accountNumber, double trxAmmount, String description, String trxDate, String time, CustomerDetails customerDetails) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.trxAmmount = trxAmmount;
        this.description = description;
        this.trxDate = trxDate;
        this.time = time;
        this.customerDetails = customerDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getTrxAmmount() {
        return trxAmmount;
    }

    public void setTrxAmmount(double trxAmmount) {
        this.trxAmmount = trxAmmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(String trxDate) {
        this.trxDate = trxDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }
}
>>>>>>> origin/main
