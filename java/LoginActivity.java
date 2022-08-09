package com.rlaehgnss.sage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sage.R;

public class LoginActivity extends AppCompatActivity {

    private EditText login_id, login_password;
    private Button login_button, join_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

        login_id = findViewById( R.id.login_id );
        login_password = findViewById( R.id.login_password );

        join_button = findViewById( R.id.join_button );
        //회원가입 버튼 클릭시 이동
        join_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( LoginActivity.this, RegisterActivity.class );
                startActivity( intent );
            }
        });


        login_button = findViewById( R.id.login_button );
        login_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserID = login_id.getText().toString();
                String UserPassword = login_password.getText().toString();

                Toast.makeText(getApplicationContext(), "로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("UserID", UserID);
                intent.putExtra("userPassword", UserPassword);
                startActivity(intent);
            }
        });
    }
}
