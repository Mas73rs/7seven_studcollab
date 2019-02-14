package cm.studio.devbee.searchwithme;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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

public class RegisterActivity extends AppCompatActivity {
    private EditText registerEmail;
    private EditText registerPassword;
    private EditText regirsterConfirmPassword;
    private Button buttonRegister;
    private TextView goToLoginActivity;
    private ProgressBar registerProgressBar;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_register );
        liaison ();
        gotologin ();
        register ();
        registerProgressBar.setVisibility ( View.INVISIBLE );
    }

    private void liaison(){
        registerEmail=findViewById ( R.id.email_register );
        registerPassword=findViewById ( R.id.password_register );
        regirsterConfirmPassword =findViewById ( R.id.password_login_confirm );
        goToLoginActivity=findViewById ( R.id.login_back );
        registerProgressBar=findViewById ( R.id.progressBarRegister );
        buttonRegister=findViewById ( R.id.register_button );
        firebaseAuth=FirebaseAuth.getInstance ();
    }
    public void gotologin(){
        goToLoginActivity.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent gotologin=new Intent ( RegisterActivity.this,LoginActivity.class );
                startActivity ( gotologin );
                finish ();
            }
        } );
    }
    public void register(){
            buttonRegister.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                     registerProgressBar.setVisibility ( View.VISIBLE );
                     String email=registerEmail.getText ().toString ();
                     String password =registerPassword.getText ().toString ();
                     String confirm=regirsterConfirmPassword.getText ().toString ();
                     if (!TextUtils.isEmpty ( email )&&!TextUtils.isEmpty ( password )&&!TextUtils.isEmpty ( confirm )){
                         if (!password.equals ( confirm )){
                             Toast.makeText ( RegisterActivity.this,"les mots de passe ne correspondent pas !",Toast.LENGTH_LONG ).show ();
                             registerProgressBar.setVisibility ( View.INVISIBLE );
                         }else{firebaseAuth.createUserWithEmailAndPassword ( email ,password).addOnCompleteListener ( new OnCompleteListener<AuthResult> () {
                             @Override
                             public void onComplete(@NonNull Task<AuthResult> task) {
                                 registerProgressBar.setVisibility ( View.VISIBLE );
                                 if (task.isSuccessful ()){
                                     goToHome();
                                 }else{
                                     String error=task.getException ().getMessage ();
                                     Toast.makeText ( RegisterActivity.this,error,Toast.LENGTH_LONG ).show ();
                                     registerProgressBar.setVisibility ( View.INVISIBLE );
                                 }
                             }
                         } );}
                     }
                }
            } );
    }
   public void goToHome(){
        Intent gotoHomeIntent=new Intent ( RegisterActivity.this,HomeActivity.class );
        startActivity ( gotoHomeIntent );
        startActivity ( gotoHomeIntent );
        finish ();
    }
}
