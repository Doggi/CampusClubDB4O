package de.hsh.dbp.campusClub.client;

/**
 * Created by Sören on 06.01.2016.
 */
import java.util.*;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import de.hsh.dbp.campusClub.entity.*;

public class Client {
    private static final String DB4O_FILENAME = "campusclub.db4o";
    private static ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),DB4O_FILENAME);

    public static void main(String[] args){
        storeCampusData();
        getCampusData();

        db.close();
    }

    private static void storeCampusData() {
        Map<String,Object> objs = new HashMap<>();

        //Person
        objs.put("1001", new Person(1001,new Date(1960,1,10),"Brad","Bredge"));
        objs.put("1002", new Person(1002,new Date(1965,5,20),"Jayne","Dissette"));
        //Department
        objs.put("D01", new Department("D01", "Computer Science", null));
        objs.put("D02", new Department("D02", "Electrical Engineering", null));
        objs.put("D03", new Department("D03", "Biology", null));
        //Faculty
        objs.put("2001", new Faculty(2001,new Date(1955,1,5),"Jamal", "Alsabbagh", "full", (Department) objs.get("D01"), new ArrayList<CampusClub>()));
        objs.put("2002", new Faculty(2002,new Date(1975,3,15),"Robert", "Adams", "associate", (Department) objs.get("D02"), new ArrayList<CampusClub>()));
        objs.put("2003", new Faculty(2003,new Date(1985,11,25),"Jie", "Du", "assistant", (Department) objs.get("D01"), new ArrayList<CampusClub>()));
        objs.put("2004", new Faculty(2004,new Date(1972,11,17),"Jonathan", "Leidig", "assistant", (Department) objs.get("D01"), new ArrayList<CampusClub>()));
        //Department set faculty
        ((Department)objs.get("D01")).setDeptChair((Faculty) objs.get("2001"));
        ((Department)objs.get("D02")).setDeptChair((Faculty) objs.get("2002"));
        ((Department)objs.get("D03")).setDeptChair((Faculty) objs.get("2004"));
        //Faculty set Department
        ((Faculty)objs.get("2004")).addAdvisorOf((CampusClub) objs.get("C101"));
        ((Faculty)objs.get("2004")).addAdvisorOf((CampusClub) objs.get("C102"));
        //CampusClub
        objs.put("C101", new CampusClub("C101", "Chess Club","Mackinac Hall A-103", "616-317-5234",(Faculty) objs.get("2004")));
        objs.put("C102", new CampusClub("C102", "Track&Field","Fieldhouse F-201", "616-331-5000",(Faculty) objs.get("2004")));
        objs.put("C103", new CampusClub("C103", "Wine Tasting","Manitou Hall B-302", "616-323-7890",null));
        //Student
        objs.put("3001", new Student(3001, new Date(1995,3,12), "Jonathan", "Engelsma", "sophomore", (Department) objs.get("D01"),
                new ArrayList<CampusClub>(Arrays.asList((CampusClub) objs.get("C101"), (CampusClub) objs.get("C102")))
        ));
        objs.put("3002", new Student(3002, new Date(1998,5,11), "Joseph", "Hornik", "senior", (Department) objs.get("D02"),
                new ArrayList<CampusClub>(Arrays.asList((CampusClub) objs.get("C101")))
        ));
        objs.put("3003", new Student(3003, new Date(1993,2,2), "Cheryl", "Kautz", "junior", (Department) objs.get("D01"),
                new ArrayList<CampusClub>(Arrays.asList((CampusClub) objs.get("C101"), (CampusClub) objs.get("C102")))
        ));
        objs.put("3004", new Student(3004, new Date(1999,10,31), "Tara", "Meeuwsen", "freshmen", (Department) objs.get("D01"),
                new ArrayList<CampusClub>()
        ));

        for(String key : objs.keySet()) {
            Object o = objs.get(key);
            db.store(o);
            System.out.println("[STORE]:" + o.toString());
        }
    }

    public static void getCampusData(){
        ObjectSet result = db.queryByExample(new Person(1001,new Date(1960,1,10),"Brad","Bredge"));
        Person p = (Person) result.next();
        System.out.println(p);
    }
}
