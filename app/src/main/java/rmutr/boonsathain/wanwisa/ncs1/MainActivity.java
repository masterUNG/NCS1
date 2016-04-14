package rmutr.boonsathain.wanwisa.ncs1;

import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText, passwordEditText;
    private String userString, passwordString;
    private MyManage myManage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        userEditText = (EditText) findViewById(R.id.editText);
        passwordEditText = (EditText) findViewById(R.id.editText2);

        //Request SQLite
        myManage = new MyManage(this);

        //Test Add User
        //myManage.addNewUser("user", "pass", "status", "name", "surname");

        //Delete All SQLite
        deleteAllSQLite();

        //Syn JSON to SQLite
        synJSON();


    }   // Main Method

    private void synJSON() {
        MyConnectedMain myConnectedMain = new MyConnectedMain();
        myConnectedMain.execute();
    }

    //Create Inner Class
    public class MyConnectedMain extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url("http://swiftcodingthai.com/num/php_get_user_master.php").build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                Log.d("14April", "doIn error ==> " + e.toString());
                return null;
            }   // try

        }   // doInBack

        @Override
        protected void onPostExecute(String strJSON) {
            super.onPostExecute(strJSON);

            Log.d("14April", "strJSON ==> " + strJSON);

            try {

                JSONArray jsonArray = new JSONArray(strJSON);
                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String strUser = jsonObject.getString(MyManage.column_User);
                    String strPassword = jsonObject.getString(MyManage.column_Pass);
                    String strStatus = jsonObject.getString(MyManage.column_Status);
                    String strName = jsonObject.getString(MyManage.column_Name);
                    String strSurname = jsonObject.getString(MyManage.column_Surname);

                    myManage.addNewUser(strUser, strPassword, strStatus,
                            strName, strSurname);

                }   // for

            } catch (Exception e) {
                Log.d("14April", "onPost Error ==> " + e.toString());
            }

        }   // onPost

    }   // MyConnected Class

    private void deleteAllSQLite() {
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);
        sqLiteDatabase.delete(MyManage.user_table, null, null);
    }

    public void clickLogin(View view) {

        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //Check Space
        if (userString.equals("") || passwordString.equals("")) {
            //Have Space
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "มีช่องว่าง", "กรุณากรอกทุกช่อง คะ");

        } else {
            //No Space

        }

    }   // clickLogin

}   // Main Class
