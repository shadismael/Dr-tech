package com.example.loginactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
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

import java.text.DateFormat;
import java.util.Calendar;

public class loginactivity extends AppCompatActivity {
    EditText User;
    EditText Password;
    Button Login;
    TextView Register;
    private FirebaseAuth mAuth;
    MediaPlayer welcome , error ;
    Calendar calendar;
    String currentDate;
    TextView tvDate;
    TextView dt;
    TextView FP;
    private static final int PERMISSION_REQUEST_CODE=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        User=(EditText)findViewById(R.id.etEmail);
        Password=(EditText) findViewById(R.id.etSecondName);
        Login=(Button) findViewById(R.id.btLogin);
        dt=findViewById(R.id.textView12);
        FP=findViewById(R.id.textView13);
        ///////////////////////////////////////////////////////////////////////////////////
        welcome=MediaPlayer.create(this,R.raw.welcome);
        error=MediaPlayer.create(this,R.raw.error);
        //////////////////////////////////////////////////////////////////////////////////////
        calendar=Calendar.getInstance();
        currentDate= DateFormat.getDateInstance().format(calendar.getTime());
        tvDate=findViewById(R.id.date);
        tvDate.setText(currentDate);
        /////////////////////////////////////////////////////////////////////////////////////
        Register=(TextView) findViewById(R.id.tvRegister);
        mAuth = FirebaseAuth.getInstance();
        ///////////////////////////////////////////////////////////////////////////////////////////

        if(ContextCompat.checkSelfPermission(loginactivity.this, Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.SEND_SMS)){

            }
            Toast.makeText(loginactivity.this,"You have already granted this permission",Toast.LENGTH_SHORT).show();
        }else{
            ActivityCompat.requestPermissions(loginactivity.this,new String[]{Manifest.permission.SEND_SMS},PERMISSION_REQUEST_CODE);

        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(User.getText().toString().isEmpty()||Password.getText().toString().isEmpty()){
                    Toast.makeText(loginactivity.this, "empty field",
                            Toast.LENGTH_SHORT).show();
                    error.start();
                }else{
                    enter();

                }
            }
        });

        RegisterPage();
        ///////////////////////////////////////////////////////////////////////////
        FP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });

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
    //////////////////////////////foget password////////////////////////////////////////////////////
    public void reset() {
        String mail = User.getText().toString().trim();

        if (TextUtils.isEmpty(mail)) {
            Toast.makeText(getApplication(), "Enter your registered email id", Toast.LENGTH_SHORT).show();
            return;
        }


        mAuth.sendPasswordResetEmail(mail)

                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(loginactivity.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(loginactivity.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                        }


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
                            welcome.start();
                            Intent s=new Intent(getApplicationContext(), com.example.loginactivity.Home.class);
                            startActivity(s);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(loginactivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            error.start();

                        }

                        // ...
                    }
                });
    }
    ///////////////////////////////////sign in to firebase function end ////////////////////////////

}
