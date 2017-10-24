package mad.kui.com.sqllitelab2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static mad.kui.com.sqllitelab2.Contract.UserDetails.CREATE_TABLE_USERS;
import static mad.kui.com.sqllitelab2.Contract.UserDetails.CREATE_TABLE_USER_FAV;
import static mad.kui.com.sqllitelab2.Contract.UserDetails.CREATE_TABLE_USER_FOOD;
import static mad.kui.com.sqllitelab2.Contract.UserDetails.KEY_COLOR;
import static mad.kui.com.sqllitelab2.Contract.UserDetails.KEY_FOOD;
import static mad.kui.com.sqllitelab2.Contract.UserDetails.KEY_ID;
import static mad.kui.com.sqllitelab2.Contract.UserDetails.KEY_JOB;
import static mad.kui.com.sqllitelab2.Contract.UserDetails.KEY_NAME;
import static mad.kui.com.sqllitelab2.Contract.UserDetails.TABLE_USERS;
import static mad.kui.com.sqllitelab2.Contract.UserDetails.TABLE_USER_FAV;
import static mad.kui.com.sqllitelab2.Contract.UserDetails.TABLE_USER_FOOD;


/**
 * Created by Kui on 10/22/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "userDetails";


    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_USER_FAV);
        db.execSQL(CREATE_TABLE_USER_FOOD);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_FAV);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_FOOD);

        onCreate(db);

    }

 /**
  * CRUD METHODS FOR THE DATABASE USERDETALS TABLES
  *
  * **/

    /************ TABLE USER MEHTODS*******************/

    public void addUser (Users users){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME,users.getName());
        values.put(KEY_JOB,users.getJob());

        db.insert(TABLE_USERS,null,values);
        db.close();
    }

    public Users getUsers(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USERS,new String[]{ KEY_ID, KEY_NAME, KEY_JOB},
                KEY_ID + "=?", new String[]{ String.valueOf(id)},null,null,null,null);
        if (cursor != null)
            cursor.moveToFirst();

        Users users = new Users (Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2));
        //return users
        return  users;
    }
    public List<Users> getAllUsers (){
        List<Users> usersList = new ArrayList<Users>();

        //select All query
        String selectQuery = "SELECT * FROM " + TABLE_USERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        //looping through all rows and adding to list

        if (cursor.moveToFirst()){
            do{
                Users users = new Users();
                users.setId(Integer.parseInt(cursor.getString(0)));
                users.setName(cursor.getString(1));
                users.setJob(cursor.getString(2));

                //adding user details to list
                usersList.add(users);

            }while(cursor.moveToNext());
        }
        return  usersList;
    }
    //getting Users count
    public int getUsersCount(){
        String countQuery = "SELECT * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.close();;

        //return count
        return  cursor.getCount();
    }

    //updating single User
    public int updateUser (Users users){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME,users.getName());
        values.put(KEY_JOB,users.getJob());

        //updating row
        return  db.update(TABLE_USERS,values,KEY_ID + " = ? ",
                new String[]{ String.valueOf(users.getId())}
        );
    }

    //deleting single User
    public void deleteUsers (Users users){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS,KEY_ID + " = ? ",
                new String[]{ String.valueOf(users.getId())}
        );
        db.close();
    }




    /************ TABLE USERFAV METHODS *******************/



    public void addUserFav (UserFav userFav){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_COLOR,userFav.getColor());


        db.insert(TABLE_USER_FAV,null,values);
        db.close();
    }

    public UserFav getUserFav(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER_FAV,new String[]{ KEY_ID, KEY_COLOR},
                KEY_ID + "=?", new String[]{ String.valueOf(id)},null,null,null,null);
        if (cursor != null)
            cursor.moveToFirst();

        UserFav userFav = new UserFav (Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));
        //return userFav
        return  userFav;
    }
    public List<UserFav> getAllUserFav (){
        List<UserFav> userFavsList = new ArrayList<UserFav>();

        //select All query
        String selectQuery = "SELECT * FROM " + TABLE_USER_FAV;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        //looping through all rows and adding to list

        if (cursor.moveToFirst()){
            do{
                UserFav userFav = new UserFav();
                userFav.setId(Integer.parseInt(cursor.getString(0)));
                userFav.setColor(cursor.getString(1));


                //adding cuserFav to list
                userFavsList.add(userFav);

            }while(cursor.moveToNext());
        }
        return  userFavsList;
    }
    //getting Userfav count
    public int getUserFavCount(){
        String countQuery = "SELECT * FROM " + TABLE_USER_FAV;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.close();;

        //return count
        return  cursor.getCount();
    }

    //updating single contact
    public int updateUserFav (UserFav userFav){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_COLOR,userFav.getColor());


        //updating row
        return  db.update(TABLE_USER_FAV,values,KEY_ID + " = ? ",
                new String[]{ String.valueOf(userFav.getId())}
        );
    }

    //deleting single contact
    public void deleteUserFav (UserFav userFav){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER_FAV,KEY_ID + " = ? ",
                new String[]{ String.valueOf(userFav.getId())}
        );
        db.close();
    }





    /************ TABLE USERFOOD METHODS *******************/

    public void addUserFood (UserFood userFood){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FOOD,userFood.getFood());


        db.insert(TABLE_USER_FOOD,null,values);
        db.close();
    }

    public UserFood getUserFood(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER_FOOD,new String[]{ KEY_ID, KEY_FOOD},
                KEY_ID + "=?", new String[]{ String.valueOf(id)},null,null,null,null);
        if (cursor != null)
            cursor.moveToFirst();

        UserFood userFood = new UserFood (Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));
        //return users
        return  userFood;
    }
    public List<UserFood> getAllUserFood (){
        List<UserFood> userFoodsList = new ArrayList<UserFood>();

        //select All query
        String selectQuery = "SELECT * FROM " + TABLE_USER_FOOD;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        //looping through all rows and adding to list

        if (cursor.moveToFirst()){
            do{
                UserFood userFood = new UserFood();
                userFood.setId(Integer.parseInt(cursor.getString(0)));
                userFood.setFood(cursor.getString(1));


                //adding contact to list
                userFoodsList.add(userFood);

            }while(cursor.moveToNext());
        }
        return  userFoodsList;
    }
    //getting UserFood count
    public int getUserFoodCount(){
        String countQuery = "SELECT * FROM " + TABLE_USER_FOOD;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        cursor.close();;

        //return count
        return  cursor.getCount();
    }

    //updating single UserFood
    public int updateUserFood (UserFood userFood){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FOOD,userFood.getFood());


        //updating row
        return  db.update(TABLE_USER_FOOD,values,KEY_ID + " = ? ",
                new String[]{ String.valueOf(userFood.getId())}
        );
    }

    //deleting single UserFood
    public void deleteUserFood (UserFood userFood){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER_FOOD,KEY_ID + " = ? ",
                new String[]{ String.valueOf(userFood.getId())}
        );
        db.close();
    }


}
