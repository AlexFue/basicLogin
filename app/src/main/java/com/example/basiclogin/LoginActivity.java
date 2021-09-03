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
    private static String id;
    private Bundle bun = new Bundle();

    private static List<Map<String, String>> users =  new ArrayList<Map<String, String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        intializeUsers();

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
    }

    public void nextActivity(View view) {
        String username = et_username.getText().toString();
        String password = et_password.getText().toString();
        String result = isValidCredentials(username, password);
        clearFocus();
        switch (result) {
            case "valid":
                bun.putString("username", username);
                bun.putString("password", password);
                bun.putString("id", id);
                break;
            case "wrong user":
                isWrongUser();
                return;
            case "wrong password":
                isWrongPassword();
                return;
        }

        Intent intent = MainActivity.getIntent(getApplicationContext(), bun);
        startActivity(intent);
    }

    public static String isValidCredentials(String username, String password) {
        for(Map obj: users){
            if(username.equals(obj.get("username"))){
                if(password.equals(obj.get("password"))){
                    id = obj.get("id").toString();
                    return "valid";
                }
                else{
                    return "wrong password";
                }
            }
        }
        return "wrong user";
    }

    public void clearFocus() {
        et_password.clearFocus();
        et_username.clearFocus();
        et_username.setSelectAllOnFocus(false);
        et_password.setSelectAllOnFocus(false);
    }

    public void isWrongPassword() {
        et_password.setSelectAllOnFocus(true);
        et_password.requestFocus();
        Toast.makeText(LoginActivity.this, "Incorrect Password!", Toast.LENGTH_SHORT).show();
    }

    public void isWrongUser() {
        et_username.setSelectAllOnFocus(true);
        et_username.requestFocus();
        Toast.makeText(LoginActivity.this, "Incorrect Username!", Toast.LENGTH_SHORT).show();
    }

    public static void intializeUsers() {
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