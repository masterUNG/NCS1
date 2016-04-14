package rmutr.boonsathain.wanwisa.ncs1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 4/14/16 AD.
 */
public class MyManage {

    //Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public static final String user_table = "userTABLE";
    public static final String column_id = "_id";
    public static final String column_User = "User";
    public static final String column_Pass = "Password";
    public static final String column_Status = "Status";
    public static final String column_Name = "Name";
    public static final String column_Surname = "Surname";

    public MyManage(Context context) {

        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();

    }   //Constructor

    public long addNewUser(String strUser,
                           String strPassword,
                           String strStatus,
                           String strName,
                           String strSurname) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_User, strUser);
        contentValues.put(column_Pass, strPassword);
        contentValues.put(column_Status, strStatus);
        contentValues.put(column_Name, strName);
        contentValues.put(column_Surname, strSurname);

        return sqLiteDatabase.insert(user_table, null, contentValues);
    }


}   // Main Class
