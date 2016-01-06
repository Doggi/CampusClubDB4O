package de.hsh.dbp.campusClub.client;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 * Created by hassannahle on 07.01.16.
 */
public class QueryClient {
    private static final String DB4O_FILENAME = "campusclub.db4o";
    private static ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), DB4O_FILENAME);

    public static void main(String[] args){
        queryByExample();
        sodaQuery();
        nativeQuery();
    }

    public static void queryByExample(){

    }

    public static void sodaQuery(){

    }

    public static void nativeQuery(){

    }
}
