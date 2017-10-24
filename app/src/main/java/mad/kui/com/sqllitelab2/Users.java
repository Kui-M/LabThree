package mad.kui.com.sqllitelab2;

/**
 * Created by Kui on 10/22/2017.
 */

public class Users {
    String name,job;
    int id;

    public Users () {}

    public Users (int id , String name,String job){
        this.id = id;
        this.name = name;
        this.job = job;
    }

    public Users (String name,String job){
        this.name = name;
        this.job = job;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() { return this.job; }

    public void setJob(String job) {
        this.job = job;
    }




}
