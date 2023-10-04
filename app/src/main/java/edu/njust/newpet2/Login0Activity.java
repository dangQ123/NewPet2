package edu.njust.newpet2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Login0Activity extends AppCompatActivity {


    private Button phonelogin , acountloginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login0);

        phonelogin = findViewById(R.id.phonelogin);
        phonelogin.setOnClickListener(view -> {
            Intent intent = new Intent(this , Login2Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        acountloginbutton = findViewById(R.id.acountloginbutton);
        acountloginbutton.setOnClickListener(view -> {
            Intent intent = new Intent(this , Login1Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });


    }
}