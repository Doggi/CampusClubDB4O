package de.hsh.dbp.campusClub.entity;


public class Department {

    private String code;
    private String name;
    private Faculty deptChair = null;

    public Department(String code, String name, Faculty deptChair){
        setCode(code);
        setName(name);
        setDeptChair(deptChair);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Faculty getDeptChair() {
        return deptChair;
    }

    public void setDeptChair(Faculty deptChair) {
        this.deptChair = deptChair;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
