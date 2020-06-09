package com.example.fastfish;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Authentication extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    EditText username1;
    EditText password1;
    Button signup;

    DBHelper db;
//    DBConnection con = new DBConnection();




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);



        db = new DBHelper(this);



        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);


        username1 = (EditText) findViewById(R.id.username1);
        password1 = (EditText) findViewById(R.id.password1);
        signup = (Button) findViewById(R.id.signup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Boolean aBoolean = db.updateData("hello", "fly", "-1" );



                String unInput = username.getText().toString();
                String pwInput = password.getText().toString();
                Boolean login = db.signIn(unInput, pwInput);
                if(login) {
                    Toast.makeText(Authentication.this, "Logged In", Toast.LENGTH_LONG).show();
                    Intent mainIntent = new Intent(Authentication.this, MainActivity.class);
                    startActivity(mainIntent);
                } else {
                    Toast.makeText(Authentication.this, "Try Again", Toast.LENGTH_LONG).show();

                }




//                Cursor res = db.getData();
//                if(res.getCount() == 0) {
//                    // show message
//                    showMessage("Error","Nothing found");
//                    return;
//                }
//
//                StringBuffer buffer = new StringBuffer();
//                while (res.moveToNext()) {
//                    buffer.append("username :"+ res.getString(0)+"\n");
//                    buffer.append("password :"+ res.getString(1)+"\n");
//                    buffer.append("highscore :"+ res.getString(2)+"\n");
//                }
//
//                // Show all data
//                showMessage("Data",buffer.toString());

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("worksssssssssssssssssssssssssssss");
                boolean res = db.insertData(username1.getText().toString(), password1.getText().toString(), "0");
                if(res == true) {
                    setData(username1.getText().toString(),password1.getText().toString(), 0 );
                    Toast.makeText(Authentication.this, "New User Created", Toast.LENGTH_LONG).show();
                    Intent mainIntent = new Intent(Authentication.this, MainActivity.class);
                    startActivity(mainIntent);
                } else {
                    Toast.makeText(Authentication.this, "Username Taken", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    public void setData(String un, String pw, int score) {
        User.setUsername(un);
        User.setPassword(pw);
        User.setHighScore(score);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
