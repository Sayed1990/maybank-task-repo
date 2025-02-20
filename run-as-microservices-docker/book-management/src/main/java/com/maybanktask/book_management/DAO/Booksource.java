<<<<<<<< HEAD:run-as-microservices-docker/book-management/src/main/java/com/maybanktask/book_management/DAO/Booksource.java
package com.maybanktask.book_management.DAO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
========
<<<<<<< HEAD
package com.maybanktask.user_management.dao;

>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/dao/Booksource.java
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "book_table")
public class Booksource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber;
    private double trxAmmount;
    private String description;
    private String trxDate;
    private String time;
    private String customerId;
<<<<<<<< HEAD:run-as-microservices-docker/book-management/src/main/java/com/maybanktask/book_management/DAO/Booksource.java
    @JsonManagedReference
========
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/dao/Booksource.java
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "booksource_id")
    CustomerDetailsEntity customerDetailsEntity;

    public Booksource() {

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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Booksource(String accountNumber, double trxAmmount, String description, String trxDate, String time, String customerId, CustomerDetailsEntity customerDetailsEntity) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.trxAmmount = trxAmmount;
        this.description = description;
        this.trxDate = trxDate;
        this.time = time;
        this.customerId = customerId;
        this.customerDetailsEntity = customerDetailsEntity;
    }

    public CustomerDetailsEntity getCustomerDetailsEntity() {
        return customerDetailsEntity;
    }

    public void setCustomerDetailsEntity(CustomerDetailsEntity customerDetailsEntity) {
        this.customerDetailsEntity = customerDetailsEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booksource that = (Booksource) o;
        return Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(trxAmmount, that.trxAmmount) &&
                Objects.equals(description, that.description) &&
                Objects.equals(trxDate, that.trxDate) &&
                Objects.equals(time, that.time) &&
                Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, trxAmmount,description,trxDate,time,customerId);
    }
}
<<<<<<<< HEAD:run-as-microservices-docker/book-management/src/main/java/com/maybanktask/book_management/DAO/Booksource.java
========
=======
package com.maybanktask.user_management.dao;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "book_table")
public class Booksource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber;
    private double trxAmmount;
    private String description;
    private String trxDate;
    private String time;
    private String customerId;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "booksource_id")
    CustomerDetailsEntity customerDetailsEntity;

    public Booksource() {

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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Booksource(String accountNumber, double trxAmmount, String description, String trxDate, String time, String customerId, CustomerDetailsEntity customerDetailsEntity) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.trxAmmount = trxAmmount;
        this.description = description;
        this.trxDate = trxDate;
        this.time = time;
        this.customerId = customerId;
        this.customerDetailsEntity = customerDetailsEntity;
    }

    public CustomerDetailsEntity getCustomerDetailsEntity() {
        return customerDetailsEntity;
    }

    public void setCustomerDetailsEntity(CustomerDetailsEntity customerDetailsEntity) {
        this.customerDetailsEntity = customerDetailsEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booksource that = (Booksource) o;
        return Objects.equals(accountNumber, that.accountNumber) &&
                Objects.equals(trxAmmount, that.trxAmmount) &&
                Objects.equals(description, that.description) &&
                Objects.equals(trxDate, that.trxDate) &&
                Objects.equals(time, that.time) &&
                Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, trxAmmount,description,trxDate,time,customerId);
    }
}
>>>>>>> origin/main
>>>>>>>> 52d73478a67759e0764ce4ef59022f89f1aa7923:src/main/java/com/maybanktask/user_management/dao/Booksource.java
