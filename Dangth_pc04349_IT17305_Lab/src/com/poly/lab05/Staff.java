package com.poly.lab05;

import java.io.Serializable;

/**
 *
 * @author MSI
 */
public class Staff implements Serializable {

    private String fullName;
    private double salary;

    public Staff(String fullName, double salary) {
        this.fullName = fullName;
        this.salary = salary;
    }

    public Staff() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
