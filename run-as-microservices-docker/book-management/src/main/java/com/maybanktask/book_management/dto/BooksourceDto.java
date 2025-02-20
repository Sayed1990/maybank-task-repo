<<<<<<<< HEAD:run-as-microservices-docker/book-management/src/main/java/com/maybanktask/book_management/dto/BooksourceDto.java
package com.maybanktask.book_management.dto;
========
<<<<<<< HEAD
package com.maybanktask.user_management.dto;
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/dto/BooksourceDto.java


public class BooksourceDto {
    private Long id;
    private String accountNumber;
    private double trxAmmount;
    private String description;
    private String trxDate;
    private String time;
    private CustomerDetails customerDetails;

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

    @Override
    public String toString() {
        return "BooksourceDto{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", trxAmmount=" + trxAmmount +
                ", description='" + description + '\'' +
                ", trxDate='" + trxDate + '\'' +
                ", time='" + time + '\'' +
                ", customerDetails=" + customerDetails +
                '}';
    }
}
<<<<<<<< HEAD:run-as-microservices-docker/book-management/src/main/java/com/maybanktask/book_management/dto/BooksourceDto.java
========
=======
package com.maybanktask.user_management.dto;


public class BooksourceDto {
    private Long id;
    private String accountNumber;
    private double trxAmmount;
    private String description;
    private String trxDate;
    private String time;
    private CustomerDetails customerDetails;

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

    @Override
    public String toString() {
        return "BooksourceDto{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", trxAmmount=" + trxAmmount +
                ", description='" + description + '\'' +
                ", trxDate='" + trxDate + '\'' +
                ", time='" + time + '\'' +
                ", customerDetails=" + customerDetails +
                '}';
    }
}
>>>>>>> origin/main
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/dto/BooksourceDto.java
