package rmutr.boonsathain.wanwisa.ncs1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class AddBoat extends AppCompatActivity {

    //Explicit
    private EditText data2EditText, data3EditText, data4EditText,
            data5EditText, data6EditText, data7EditText, data8EditText,
            data9EditText, data10EditText, data11EditText, data12EditText,
            data13EditText, data14EditText, data15EditText;
    private String data2String, data3String, data4String, data5String, data6String,
            data7String, data8String, data9String, data10String, data11String, data12String,
            data13String, data14String, data15String, data16String;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_boat);

        //Bind Widget
        bindWidget();

        //Create Spinner
        createSpinner();

    }   // Main Method

    private void createSpinner() {

        final String[] typeBoatStrings = getResources().getStringArray(R.array.typeboat);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, typeBoatStrings);
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                data16String = typeBoatStrings[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                data16String = typeBoatStrings[0];
            }
        });

    }   // createSpinner

    private void bindWidget() {

        data2EditText = (EditText) findViewById(R.id.editText3);
        data3EditText = (EditText) findViewById(R.id.editText4);
        data4EditText = (EditText) findViewById(R.id.editText5);
        data5EditText = (EditText) findViewById(R.id.editText6);
        data6EditText = (EditText) findViewById(R.id.editText7);
        data7EditText = (EditText) findViewById(R.id.editText8);
        data8EditText = (EditText) findViewById(R.id.editText9);
        data9EditText = (EditText) findViewById(R.id.editText10);
        data10EditText = (EditText) findViewById(R.id.editText11);
        data11EditText = (EditText) findViewById(R.id.editText12);
        data12EditText = (EditText) findViewById(R.id.editText13);
        data13EditText = (EditText) findViewById(R.id.editText14);
        data14EditText = (EditText) findViewById(R.id.editText15);
        data15EditText = (EditText) findViewById(R.id.editText16);
        spinner = (Spinner) findViewById(R.id.spinner);

    }   // bindWidget

    public void clickSaveAddBoat(View view) {

        data2String = data2EditText.getText().toString().trim();
        data3String = data3EditText.getText().toString().trim();
        data4String = data4EditText.getText().toString().trim();
        data5String = data5EditText.getText().toString().trim();
        data6String = data6EditText.getText().toString().trim();
        data7String = data7EditText.getText().toString().trim();
        data8String = data8EditText.getText().toString().trim();
        data9String = data9EditText.getText().toString().trim();
        data10String = data10EditText.getText().toString().trim();
        data11String = data11EditText.getText().toString().trim();
        data12String = data12EditText.getText().toString().trim();
        data13String = data13EditText.getText().toString().trim();
        data14String = data14EditText.getText().toString().trim();
        data15String = data15EditText.getText().toString().trim();

        //Check Space
        if (checkSpace()) {
            //Have Space
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "มีช่องว่าง", "กรุณากรอกให้ครบ ทุกช่องคะ");
        } else {
            //No Space
            updateDataToServer();

        }

    }   // clickSave

    private void updateDataToServer() {

        String strUrl = "http://swiftcodingthai.com/num/php_add_boat_master.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd", "true")
                .add("data2", data2String)
                .add("data3", data3String)
                .add("data4", data4String)
                .add("data5", data5String)
                .add("data6", data6String)
                .add("data7", data7String)
                .add("data8", data8String)
                .add("data9", data9String)
                .add("data10", data10String)
                .add("data11", data11String)
                .add("data12", data12String)
                .add("data13", data13String)
                .add("data14", data14String)
                .add("data15", data15String)
                .add("data16", data16String)
                .build();
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(strUrl).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                try {

                   // Toast.makeText(AddBoat.this, "บันทึกข้อมูลสำเร็จแล้ว", Toast.LENGTH_SHORT).show();
                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }   // updateToServer

    private boolean checkSpace() {

        boolean bolStatus = true;

        bolStatus = data2String.equals("") ||
                data3String.equals("") ||
                data4String.equals("") ||
                data5String.equals("") ||
                data6String.equals("") ||
                data7String.equals("") ||
                data8String.equals("") ||
                data9String.equals("") ||
                data10String.equals("") ||
                data11String.equals("") ||
                data12String.equals("") ||
                data13String.equals("") ||
                data14String.equals("") ||
                data15String.equals("");

        return bolStatus;
    }

    public void clickEditAddBoat(View view) {

    }

    public void clickDeleteAddBoat(View view) {

    }

}   // Main Class
