package cm.studio.devbee.searchwithme;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
        private EditText login_email;
        private EditText login_password;
        private Button login_button;
        private TextView gotoregister;
        private FirebaseAuth firebaseAuth;
        private ProgressBar progressBar;
        private Button buttonSetup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );
        liaison ();
        goToRegisterActivity ();
        firebaseAuth=FirebaseAuth.getInstance ();
        buttonSetup=findViewById ( R.id.button );
        buttonSetup.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent into=new Intent ( LoginActivity.this,HomeActivity.class );
                startActivity ( into );
                finish ();
            }
        } );
    }

    private void liaison(){
        login_email =findViewById ( R.id.login_name );
        login_password=findViewById ( R.id.login_password );
        login_button =findViewById ( R.id.login_button );
        gotoregister =findViewById ( R.id.goToRegisterActivity );
        progressBar=findViewById ( R.id.setupprogressBar );
        login ();
    }

    private void goToRegisterActivity(){
        gotoregister.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent registrInten  = new Intent ( LoginActivity.this,RegisterActivity.class );
                startActivity ( registrInten );
                finish ();
            }
        } );
    }


    public void login(){
        login_button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
            progressBar.setVisibility ( View.VISIBLE );

            String user_email=login_email.getText ().toString ();
            String user_password=login_password.getText ().toString ();

            if (!TextUtils.isEmpty ( user_email )&&!TextUtils.isEmpty ( user_password )){
                progressBar.setVisibility ( View.VISIBLE );
                firebaseAuth.signInWithEmailAndPassword ( user_email,user_password ).addOnCompleteListener ( LoginActivity.this, new OnCompleteListener<AuthResult> () {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful ()){
                            goTomain();
                        }else{
                            progressBar.setVisibility ( View.INVISIBLE );
                            String error =task.getException ().getMessage ();
                            Toast.makeText ( LoginActivity.this, error, Toast.LENGTH_SHORT ).show ();
                        }
                    }
                } );

            }

            }
        } );
    }

    /*@Override
    protected void onStart() {
        super.onStart ();
        FirebaseUser firebaseUser= firebaseAuth.getCurrentUser ();
        if (firebaseUser==null){
            Intent goToHomeActivity = new Intent ( LoginActivity.this,LoginActivity.class );
            startActivity ( goToHomeActivity );
            finish ();
        }else{
            Intent goToHomeActivity = new Intent ( LoginActivity.this,HomeActivity.class );
            startActivity ( goToHomeActivity );
            finish ();
        }
    }*/

    private void goTomain() {
        Intent goToHome=new Intent ( LoginActivity.this,AcceuilleActivity.class );
        startActivity ( goToHome );
        finish ();
    }
}
