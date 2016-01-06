package de.hsh.dbp.campusClub.entity;

import java.util.ArrayList;
import java.util.Date;

public class Student extends Person {

    private String status;
    private Department major;
    private ArrayList<CampusClub> campusClubs;

    public Student(int pId, Date dateOfBirth, String firstName, String lastName,
                   String status,Department major, ArrayList<CampusClub> campusClubs) {
        super(pId, dateOfBirth, firstName, lastName);
        setStatus(status);
        setMajor(major);
        setCampusClubs(campusClubs);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Department getMajor() {
        return major;
    }

    public void setMajor(Department major) {
        this.major = major;
    }

    public ArrayList<CampusClub> getCampusClubs() {
        return campusClubs;
    }

    public void setCampusClubs(ArrayList<CampusClub> campusClubs) {
        this.campusClubs = campusClubs;
    }

    @Override
    public String toString() {
        return "Student{" +
                "status='" + status + '\'' +
                ", major=" + major +
                ", campusClubs=" + campusClubs +
                '}';
    }
}
