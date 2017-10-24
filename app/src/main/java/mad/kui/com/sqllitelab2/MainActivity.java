package mad.kui.com.sqllitelab2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        // CRUD OPERATIONS
        // inserting Details

        Log.d("Insert: " , "Inserting...");
        db.addUser(new Users( "Pablo","Pirate"));
        db.addUser(new Users("Bruce","Vigilanti"));


        db.addUserFav(new UserFav("Green"));
        db.addUserFav(new UserFav("Black"));

        db.addUserFood(new UserFood("Potatoes"));
        db.addUserFood(new UserFood("Blackberries"));

        //Reading all UserDetails
        Log.d("Reading: ", "Reading all User Details..");
        List<Users> userses = db.getAllUsers();

        Log.d("Table 1:", "Table Users Details ");
        for (Users u :userses){
            String log = "Id: "+u.getId()+"  ,Name: " + u.getName() + "  ,Job: " + u.getJob();

            Log.d("Users: ", log);
        }

        // TABLE USERFAV
        List<UserFav> userFavs = db.getAllUserFav();
        Log.d("Table 2 :", "User Favorite Color ");
        for (UserFav uf :userFavs){
            String log = "Id: "+uf.getId()+"  ,Color: " + uf.getColor();

            Log.d("UserFav: ", log);
        }

        //TABLE USERFOOD
        List<UserFood> userFoods = db.getAllUserFood();
        Log.d("Table 3 :", "User Favorote Food ");
        for (UserFood ufo :userFoods){
            String log = "Id: "+ufo.getId()+"  ,Food: " + ufo.getFood();

            Log.d("UserFood: ", log);
        }




    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
