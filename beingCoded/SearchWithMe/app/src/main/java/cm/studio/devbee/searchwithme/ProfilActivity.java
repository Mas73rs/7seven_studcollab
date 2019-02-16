package cm.studio.devbee.searchwithme;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class ProfilActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView name;
    private TextView domicile;
    private TextView phone;
  //  private Button profil_button_message;
    //private Button profil_user_appel;
    private StorageReference storageReference;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;
    private String user_id;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_profil );
       toolbar=findViewById ( R.id.profil_activity_toolbar );
        setSupportActionBar ( toolbar );
       // progressBar=findViewById ( R.id.progressBar2 );
        //progressBar.setVisibility ( View.VISIBLE );
       liaison ();


    }
    private void liaison(){
        firebaseFirestore=FirebaseFirestore.getInstance ();
       // circleImageView=findViewById ( R.id.profil_mage );
        name=findViewById ( R.id.profil_user_name );
        phone=findViewById ( R.id.user_profil_contact_enable );
        domicile=findViewById ( R.id.profil_user_domicile_enable );
       // savebutton=findViewById ( R.id.setupButton );
        progressBar=findViewById ( R.id.setupprogressBar );
        firebaseAuth=FirebaseAuth.getInstance ();
        storageReference=FirebaseStorage.getInstance ().getReference ();
        user_id=firebaseAuth.getCurrentUser ().getUid ();
        //savebutton.setEnabled ( false );

        firebaseFirestore.collection ("User").document (user_id).get ().addOnCompleteListener ( new OnCompleteListener<DocumentSnapshot> () {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful ()){
                    if ( task.getResult ().exists ()){
                        Toast.makeText(ProfilActivity.this,"reception des donnes utilisateur termine",Toast.LENGTH_SHORT).show ();
                        String myname = task.getResult ().getString ("name");
                        String myphone = task.getResult ().getString ("phone");
                        String myresidence = task.getResult ().getString ("residence");
                       // String myimage = task.getResult ().getString ("image");
                        //mImageUri=Uri.parse (myimage);
                        name.setText ( myname );
                        phone.setText ( myphone );
                        domicile.setText ( myresidence );
                        getSupportActionBar ().setTitle ( myname );
                      /*  RequestOptions placeRquestHolder =new RequestOptions ();
                        placeRquestHolder.placeholder ( R.mipmap.user_prefere);
                        Glide.with (HomeActivity.this).setDefaultRequestOptions (  placeRquestHolder).load ( myimage ).into ( circleImageView );
*/                     // Picasso.get().load ( myimage ).into ( circleImageView );
                       // Picasso.with(ProfilActivity.this).load(myimage).into(circleImageView);

                    }

                }else {
                    String error= task.getException().getMessage();
                    Toast.makeText(ProfilActivity.this,error,Toast.LENGTH_LONG).show ();

                }
//                progressBar.setVisibility ( View.INVISIBLE );
               // savebutton.setEnabled ( true );

            }
        } );




    }

    public void modifier(View view) {
        Intent gotoSetup =new Intent ( ProfilActivity.this,HomeActivity.class );
        startActivity ( gotoSetup );

    }
}
