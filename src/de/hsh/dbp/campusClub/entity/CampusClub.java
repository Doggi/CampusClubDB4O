package de.hsh.dbp.campusClub.entity;

public class CampusClub {

    private String cId;
    private String name;
    private String location;
    private String phone;
    private Faculty advisor;

    public CampusClub(String cId, String name, String location, String phone, Faculty advisor){
        setcId(cId);
        setName(name);
        setLocation(location);
        setPhone(phone);
        setAdvisor(advisor);
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Faculty getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Faculty advisor) {
        this.advisor = advisor;
    }

    @Override
    public String toString() {
        return "CampusClub{" +
                "cId='" + cId + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", advisor=" + advisor +
                '}';
    }
}
