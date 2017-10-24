package mad.kui.com.sqllitelab2;

import android.provider.BaseColumns;

/**
 * Created by Kui on 10/23/2017.
 */

public class Contract {

// THIS CLASS CONTAINS ALL THE INITALIZED VARIABLES FOR THE TABLES IN THE DATABASE

    //COLUMN NAMES

    public static abstract class UserDetails implements BaseColumns{

        // COMMON COLUMN NAMES
        public static final String KEY_ID = "id";

        //TABLE USERS

        public static final String TABLE_USERS = "users";

        public static final String KEY_NAME = "name";
        public static final String KEY_JOB = "job";

        public static final String CREATE_TABLE_USERS = "CREATE TABLE "
                + TABLE_USERS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME
                + " TEXT," + KEY_JOB + " TEXT" + ")";




        // TABLE USERFAV
        public static final String TABLE_USER_FAV = "userFav";

        public static final String KEY_COLOR = "color";

        public static final String CREATE_TABLE_USER_FAV = "CREATE TABLE " + TABLE_USER_FAV
                + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_COLOR + " TEXT" + ")";


        // TABLE USERFOOD
        public static final String TABLE_USER_FOOD = "userFood";

        public static final String KEY_FOOD = "food";

        public static final String CREATE_TABLE_USER_FOOD = "CREATE TABLE " + TABLE_USER_FOOD
                + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_FOOD + " TEXT" + ")";

    }

    }
