package com.example.fashionapp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {
    EditText username, psw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username = findViewById(R.id.username);
        psw = findViewById(R.id.edit_password);

    }
    public void onClick(View view){
        if(username.getText().toString().equals(username.getText().toString()) &&
                psw.getText().toString().equals(psw.getText().toString())){
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    SignUpActivity.this
            );
            builder.setIcon(R.drawable.ic_baseline_check_circle_24);
            builder.setTitle("Sign up Successfully");
            builder.setMessage("Welcome to Quiz App, Brain Freeze");

            builder.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //dialogInterface.cancel();
                    String input = username.getText().toString();
                    Intent intent = new Intent(SignUpActivity.this, Home.class);
                    intent.putExtra("input", input);
                    startActivity(intent);
                    /*FragmentManager fragmentManager =getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Bundle bundle = new Bundle();
                    bundle.putString("input",username.getText().toString());
                    HomeFragment homeFragment = new HomeFragment();
                    homeFragment.setArguments(bundle);
                    Intent intent = new Intent(SignUpActivity.this, Home.class);
                    startActivity(intent);*/
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }
    }
}