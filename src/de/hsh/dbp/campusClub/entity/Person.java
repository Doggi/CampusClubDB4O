package de.hsh.dbp.campusClub.entity;

import java.util.Date;

public class Person {

    private int pId;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;

    public Person(int pId, Date dateOfBirth, String firstName, String lastName){
        setpId(pId);
        setDateOfBirth(dateOfBirth);
        setFirstName(firstName);
        setLastName(lastName);
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pId=" + pId +
                ", dateOfBirth=" + dateOfBirth +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
