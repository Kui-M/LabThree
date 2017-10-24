package mad.kui.com.sqllitelab2;

/**
 * Created by Kui on 10/22/2017.
 */

public class UserFav {

    String color;
    int id;

    public UserFav (){}

    public UserFav ( int id, String color){
        this.id = id;
        this.color = color;
    }

    public  UserFav (String color){
        this.color = color;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
