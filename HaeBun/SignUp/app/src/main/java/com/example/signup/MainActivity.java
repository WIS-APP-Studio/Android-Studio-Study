package com.example.signup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout logoff_layout, logon_layout;
    Button btn_login, btn_register, btn_logout;
    TextView txt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("로그인,회원가입 테스트");

        logoff_layout = findViewById(R.id.logoff_layout);
        logon_layout = findViewById(R.id.logon_layout);

        btn_login = findViewById(R.id.btn_login);
        btn_logout = findViewById(R.id.btn_logout);
        btn_register = findViewById(R.id.btn_register);
        txt_login = findViewById(R.id.txt_login);

        Intent intent = getIntent();
        String user_id = intent.getStringExtra("user_id");
        if (user_id==null) {    // 로그아웃 상태
            logon_layout.setVisibility(View.INVISIBLE);
            logoff_layout.setVisibility(View.VISIBLE);
        } else {                // 로그인 상태
            logon_layout.setVisibility(View.VISIBLE);
            logoff_layout.setVisibility(View.INVISIBLE);

            txt_login.setText(user_id + " 회원님");
        }


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void login() {
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    private void logout() {
        new AlertDialog.Builder(this)
                .setTitle("로그아웃").setMessage("로그아웃 하시겠습니까?")
                .setPositiveButton("로그아웃", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 로그아웃 처리
                        txt_login.setText("");
                        logon_layout.setVisibility(View.INVISIBLE);
                        logoff_layout.setVisibility(View.VISIBLE);

                          Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                          intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                          startActivity(intent);
                    }
                })
                .setNegativeButton("취소", null)
                .show();
    }

    private void register() {
        Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

}
