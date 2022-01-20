
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


public class DatabaseList implements Serializable {

    private HashMap<String, ArrayList<Database>> databaseList;

    private static final long serialVersionUID = 7L;

    public DatabaseList() {
        databaseList = new HashMap<String,ArrayList<Database>>();
    }

    public void addDatabase(String username, Database database) {
        
        if(databaseList.get(username)==null){
            databaseList.put(username, new ArrayList<Database>());
        }
        
        databaseList.get(username).add(database);

    }

    public Database getDatabase(String username, int ind) {
        return databaseList.get(username).get(ind);
    }

    public ArrayList<Database> getList(String username){
        return databaseList.get(username);

    }
    
    public Database getDatabase(String username){

        return databaseList.get(username).get(getListsize(username)-1);

    }

    public void DeletelastGame(String username){
        
        if(getListsize(username)==0)return;
        databaseList.get(username).remove(getListsize(username)-1);
    }

    public int getListsize(String username){

        if(databaseList.get(username)==null){
            return 0;
        }
        return databaseList.get(username).size();

    }

    public int getSize(){
        return databaseList.size();
    }

}
