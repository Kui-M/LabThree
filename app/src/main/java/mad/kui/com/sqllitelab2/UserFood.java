package mad.kui.com.sqllitelab2;

/**
 * Created by Kui on 10/22/2017.
 */

public class UserFood {

    int id;
    String food;

    public UserFood(){}

    public UserFood (int id, String food){
        this.id = id;
        this.food = food;
    }

    public  UserFood (String food){
        this.food=food;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFood() {
        return this.food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
