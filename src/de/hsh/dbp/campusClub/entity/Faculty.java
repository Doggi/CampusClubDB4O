package de.hsh.dbp.campusClub.entity;

import java.util.Date;
import java.util.List;

public class Faculty extends Person {

    private String rank;
    private List<CampusClub> advisorOf;
    private Department worksIn;

    public Faculty(int pId, Date dateOfBirth, String firstName, String lastName, String rank, Department worksIn, List<CampusClub> advisorOf) {
        super(pId, dateOfBirth, firstName, lastName);
        setRank(rank);
        setAdvisorOf(advisorOf);
        setWorksIn(worksIn);
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public List<CampusClub> getAdvisorOf() {
        return advisorOf;
    }

    public void setAdvisorOf(List<CampusClub> advisorOf) {
        this.advisorOf = advisorOf;
    }

    public void addAdvisorOf(CampusClub campusClub){
        advisorOf.add(campusClub);
    }

    public Department getWorksIn() {
        return worksIn;
    }

    public void setWorksIn(Department worksIn) {
        this.worksIn = worksIn;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "rank='" + rank + '\'' +
                ", advisorOf=" + advisorOf +
                '}';
    }
}
