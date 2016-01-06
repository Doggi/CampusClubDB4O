package de.hsh.dbp.campusClub.client;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import de.hsh.dbp.campusClub.entity.Person;

import java.util.Date;

/**
 * Created by hassannahle on 07.01.16.
 */
public class QueryClient {
    private static ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), ClientSetting.DB4O_FILENAME);

    public static void main(String[] args){
        queryByExample();
        sodaQuery();
        nativeQuery();
    }

    public static void queryByExample(){
        System.out.println("[query by example]");
        ObjectSet result = db.queryByExample(new Person(1001,new Date(1960,1,10),"Brad","Bredge"));
        Person p = (Person) result.next();
        System.out.println(p);
    }

    public static void sodaQuery(){
        System.out.println("[SODA query]");
    }

    public static void nativeQuery(){
        System.out.println("[native query]");
    }
}
