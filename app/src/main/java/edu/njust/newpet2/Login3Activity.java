package edu.njust.newpet2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class Login3Activity extends AppCompatActivity {

    private EditText editText;
    private Button button, backicon;

    private boolean isAllRightToVerify = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);


        editText = findViewById(R.id.verify_code);
        button = findViewById(R.id.verify_button);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 输入字符的数目
                int length = s.length();
                if (length == 6){
                    isAllRightToVerify = true;
                    if (isAllRightToVerify ){
                        Drawable drawable = getResources().getDrawable(R.drawable.login0buttonbackground);
                        button.setTextColor(Color.WHITE);
                        button.setBackground(drawable);
                        button.setEnabled(true);
                    }
                }
                else {
                    isAllRightToVerify = false;
                    Drawable drawable = getResources().getDrawable(R.drawable.accountloginretangle);
                    button.setBackground(drawable);
                    button.setEnabled(false);
                    button.setTextColor(getApplication().getResources().getColor(R.color.grey_login));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        backicon = findViewById(R.id.backicon);
        backicon.setOnClickListener(view -> {
            Intent intent = new Intent(this , Login2Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_from_left,R.anim.slide_out_from_right);
        });

    }
}