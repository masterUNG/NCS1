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

    public static final String boat_table = "boatTABLE";
    public static final String column_data2 = "data2";
    public static final String column_data3 = "data3";
    public static final String column_data4 = "data4";
    public static final String column_data5 = "data5";
    public static final String column_data6 = "data6";
    public static final String column_data7 = "data7";
    public static final String column_data8 = "data8";
    public static final String column_data9 = "data9";
    public static final String column_data10 = "data10";
    public static final String column_data11 = "data11";
    public static final String column_data12 = "data12";
    public static final String column_data13 = "data13";
    public static final String column_data14 = "data14";
    public static final String column_data15 = "data15";
    public static final String column_data16 = "data16";

    public MyManage(Context context) {

        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();

    }   //Constructor

    public long addNewBoat(String strdata2,
                           String strdata3,
                           String strdata4,
                           String strdata5,
                           String strdata6,
                           String strdata7,
                           String strdata8,
                           String strdata9,
                           String strdata10,
                           String strdata11,
                           String strdata12,
                           String strdata13,
                           String strdata14,
                           String strdata15) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(column_data2, strdata2);
        contentValues.put(column_data3, strdata3);
        contentValues.put(column_data4, strdata4);
        contentValues.put(column_data5, strdata5);
        contentValues.put(column_data6, strdata6);
        contentValues.put(column_data7, strdata7);
        contentValues.put(column_data8, strdata8);
        contentValues.put(column_data9, strdata9);
        contentValues.put(column_data10, strdata10);
        contentValues.put(column_data11, strdata11);
        contentValues.put(column_data12, strdata12);
        contentValues.put(column_data13, strdata13);
        contentValues.put(column_data14, strdata14);
        contentValues.put(column_data15, strdata15);


        return sqLiteDatabase.insert(boat_table, null, contentValues);
    }

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
