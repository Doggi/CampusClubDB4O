package de.hsh.dbp.campusClub.client;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;
import com.db4o.query.Query;
import de.hsh.dbp.campusClub.entity.Department;
import de.hsh.dbp.campusClub.entity.Person;
import de.hsh.dbp.campusClub.entity.Student;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by hassannahle on 07.01.16.
 */
public class QueryClient {
    private static ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), ClientSetting.DB4O_FILENAME);

    public static void main(String[] args){
        queryByExample();
        sodaQuery();
        nativeQuery();
        db.close();
    }

    public static void queryByExample(){
        System.out.println("[query by example]");
        ObjectSet result = db.queryByExample(new Person(1001,new Date(1960,1,10),"Brad","Bredge"));
        Person p = (Person) result.next();
        System.out.println(p);
    }

    public static void sodaQuery(){
        System.out.println("[SODA query]");
        Query query = db.query();
        query.constrain(Student.class);
        query.descend("major").constrain(new Department(null, "Computer Science", null)).contains();
        query.sortBy(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if( o1 instanceof Student && o2 instanceof Student ){
                    return ((Student)o1).getFirstName().compareTo( ((Student) o2).getFirstName() );
                }
                return 0;
            }
        });
        ObjectSet<Student> students = query.execute();

        for (Student student: students){
            System.out.println(student);
        }
    }

    //Native-Anfrage in Java ohne DB-Wissen umsetzbar
    //Jedoch nicht so mächtig

    //Alle Studierenden, deren Nachnamen mit H anfangen und der Fakulät "Electrical Engineering" zugeordnet sind
    public static void nativeQuery(){
        System.out.println("[native query]");
        List<Student> studentList = db.query(new Predicate<Student>() {
            @Override
            public boolean match(Student student) {
                return student.getLastName().startsWith("H") && student.getMajor().getName().equals("Electrical Engineering");
            }
        });

        for (Student student: studentList){
            System.out.println(student);
        }
    }
}
