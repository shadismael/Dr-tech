package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginactivity extends AppCompatActivity {
    EditText User;
    EditText Password;
    Button Login;
    TextView Register;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        User=(EditText)findViewById(R.id.etEmail);
        Password=(EditText) findViewById(R.id.etSecondName);
        Login=(Button) findViewById(R.id.btLogin);
        Register=(TextView) findViewById(R.id.tvRegister);
        mAuth = FirebaseAuth.getInstance();

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(User.getText().toString().isEmpty()||Password.getText().toString().isEmpty()){
                    Toast.makeText(loginactivity.this, "empty field",
                            Toast.LENGTH_SHORT).show();
                }else{
                    enter();
                }
            }
        });

        RegisterPage();





    }
    /////////////////////////////////move to register page//////////////////////////////////////////
    public void RegisterPage(){
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), com.example.loginactivity.Register.class);
                startActivity(intent);

            }
        });
    }
    ////////////////////////////////////////////sign in to firebase function////////////////////////
    public void enter(){
        mAuth.signInWithEmailAndPassword(User.getText().toString(), Password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(loginactivity.this, "Welcome",
                                    Toast.LENGTH_SHORT).show();
                            Intent s=new Intent(getApplicationContext(), com.example.loginactivity.Home.class);
                            startActivity(s);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(loginactivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }
    ///////////////////////////////////sign in to firebase function end ////////////////////////////

}