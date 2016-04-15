package rmutr.boonsathain.wanwisa.ncs1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HubService extends AppCompatActivity {

    //Explicit
    private ImageView hub4ImageView;
    private TextView hub4TextView;
    private String nameString, surnameString, statusString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub_service);

        //Bind Widget
        hub4ImageView = (ImageView) findViewById(R.id.imageView5);
        hub4TextView = (TextView) findViewById(R.id.textView8);

        //Check Status
        checkStatus();

    }   // Main Method

    public void clickAddBoat(View view) {
        Intent intent = new Intent(HubService.this, AddBoat.class);
        startActivity(intent);
    }



    private void checkStatus() {

        statusString = getIntent().getStringExtra("Status");
        if (statusString.equals("0")) {

            hub4ImageView.setVisibility(View.INVISIBLE);
            hub4TextView.setVisibility(View.INVISIBLE);

        }   // if

    }   // checkStatus


}   // Main Class
