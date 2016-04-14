package rmutr.boonsathain.wanwisa.ncs1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by masterUNG on 4/14/16 AD.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    //Explicit
    public static final String database_name = "Ncs.db";
    private static final int database_version = 1;
    private static final String create_user_table = "create table userTABLE (" +
            "_id integer primary key, " +
            "User text," +
            "Password text, " +
            "Status text," +
            "Name text," +
            "Surname text);";

    public MyOpenHelper(Context context) {
        super(context, database_name, null, database_version);
    }   // Constructor

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_user_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
} // Main Class
