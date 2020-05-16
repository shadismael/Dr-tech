package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    EditText Email;
    EditText Password;
    EditText ConfirmPassword;
    Button btnRegister;
    private FirebaseAuth mAuth;
    public String email;
    public String password;
    TextView r;
    ImageButton back;
    ///////////////////////////////////////////////////////////////////////////////
    MediaPlayer RegisterSound , error;
    ///////////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Email=(EditText) findViewById(R.id.etEmail);
        Password=(EditText) findViewById(R.id.etNewPassword);
        ConfirmPassword=(EditText) findViewById(R.id.etSecondNewPassword);
        btnRegister=(Button) findViewById(R.id.btRegister);
        mAuth = FirebaseAuth.getInstance();
        RegisterSound=MediaPlayer.create(this,R.raw.register);
        error=MediaPlayer.create(this,R.raw.error);
        r=findViewById(R.id.textView11);
        back=findViewById(R.id.imagebuttonBR);
        ///////////////////////////////////////////////////////////////////////register begin///////
        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String email=Email.getText().toString();
                String password=Password.getText().toString();
                newUser();
                Intent intent=new Intent(getApplicationContext(), com.example.loginactivity.loginactivity.class);
                startActivity(intent);




            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Register.this, "Log in",
                        Toast.LENGTH_SHORT).show();
                Intent PL=new Intent(getApplicationContext(), com.example.loginactivity.loginactivity.class);
                startActivity(PL);
            }
        });

    }

       ////////////////////////////////////////////////////////////////////////register end////////


    ////////////////////////////Register function beginning ////////////////////////////////////////
    public void newUser(){
        mAuth.createUserWithEmailAndPassword(Email.getText().toString(), Password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                          Toast.makeText(Register.this,"success",Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            RegisterSound.start();

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Register.this,"fail",Toast.LENGTH_SHORT).show();
                            Toast.makeText(Register.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            error.start();

                        }

                        // ...
                    }
                });
    }
    ///////////////////////////////////////////////////register function end ///////////////////////


}
