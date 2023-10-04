package edu.njust.newpet2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static boolean isLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences shared = getSharedPreferences("share",MODE_PRIVATE);
        String phonenumber = shared.getString("phonenumber","nostring");
        String password = shared.getString("password","nostring");
        if (!phonenumber.equals("nostring")){
            isLogin = true;
        }
        if (!isLogin){
            Intent intent = new Intent(this, Login0Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

        if (isLogin){
            Intent intent = new Intent(this , HomePageActivity.class);
            startActivity(intent);
        }


    }
}