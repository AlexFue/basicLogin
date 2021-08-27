package com.example.basiclogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
//        print(users);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();


            }
        });
    }

//    public void isValidCredentials;

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

//    public void print(List<Map<String, String>> users){
//        for(Map m : users){
//            System.out.println(m.get("username"));
//            System.out.println(m.get("password"));
//            System.out.println(m.get("id"));
//        }
//    }
}