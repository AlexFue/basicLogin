package com.example.basiclogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText et_username;
    private EditText et_password;
    private Button btn_login;

    private List<Map<String, String>> users =  new ArrayList<Map<String, String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        intializeUsers(users);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                isValidCredentials(username, password);

            }
        });
    }

    public void isValidCredentials(String username, String password){
        et_password.clearFocus();
        et_username.clearFocus();
        et_username.setSelectAllOnFocus(false);
        et_password.setSelectAllOnFocus(false);
        for(Map obj: users){
            if(username.equals(obj.get("username"))){
                if(password.equals(obj.get("password"))){
                    Intent i = new Intent(this, MainActivity.class);
                    Bundle bun = new Bundle();
                    bun.putString("username", username);
                    bun.putString("password", password);
                    bun.putString("id", obj.get("id").toString());
                    i.putExtras(bun);
                    startActivity(i);
                    finish();
                    return;
                }
                else{
                    System.out.println("wrong password");
                    et_password.setSelectAllOnFocus(true);
                    et_password.requestFocus();
                    Toast.makeText(LoginActivity.this, "Incorrect Password!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        }
        System.out.println("wrong username");
        et_username.setSelectAllOnFocus(true);
        et_username.requestFocus();
        Toast.makeText(LoginActivity.this, "Incorrect Username!", Toast.LENGTH_SHORT).show();
    }

    public void intializeUsers(List<Map<String, String>> users){
        String[] usernames = {"alex", "andy", "michael", "eric", "prince", "aundre", "steven", "edward", "nick", "chris"};
        String[] passwords = {"123", "espi", "hay", "chav", "ri", "lab", "sch", "clus", "floor", "her"};

        for(int i = 1; i <= 10; i++){
            Map<String, String> obj = new HashMap<String, String>();
            obj.put("username", usernames[i-1]);
            obj.put("password", passwords[i-1]);
            obj.put("id", Integer.toString(i));
            users.add(obj);
        }
    }
}