package rmutr.boonsathain.wanwisa.ncs1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by masterUNG on 4/14/16 AD.
 */
public class MyManage {

    //Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public MyManage(Context context) {

        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();

    }   //Constructor

}   // Main Class
