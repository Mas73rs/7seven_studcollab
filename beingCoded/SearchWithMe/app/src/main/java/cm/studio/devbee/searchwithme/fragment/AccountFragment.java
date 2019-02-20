package cm.studio.devbee.searchwithme.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import cm.studio.devbee.searchwithme.HomeActivity;
import cm.studio.devbee.searchwithme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {
    private Toolbar toolbar;
    private TextView name;
    private TextView domicile;
    private TextView phone;
    private ProgressBar progressAccount;
    //  private Button profil_button_message;
    //private Button profil_user_appel;
    private StorageReference storageReference;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth firebaseAuth;
    private String user_id;
    private ProgressBar progressBar;
    private View v;

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         v= inflater.inflate(R.layout.fragment_account, container, false);
//        goTomodification=v.findViewById(R.id.goTomodification);

        liaison ();
        return v;
    }

    private void liaison(){
        firebaseFirestore=FirebaseFirestore.getInstance ();
        // circleImageView=findViewById ( R.id.profil_mage );
        name=v.findViewById ( R.id.profil_user_name );
        phone=v.findViewById( R.id.user_profil_contact_enable );
        domicile=v.findViewById( R.id.profil_user_domicile_enable );
        // savebutton=findViewById ( R.id.setupButton );
        progressBar=v.findViewById ( R.id.setupprogressBar );
        firebaseAuth=FirebaseAuth.getInstance ();
        progressAccount=v.findViewById(R.id.progressBarAccount);
        storageReference=FirebaseStorage.getInstance ().getReference ();
        user_id=firebaseAuth.getCurrentUser ().getUid ();
        //savebutton.setEnabled ( false );

        firebaseFirestore.collection ("User").document (user_id).get ().addOnCompleteListener ( new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful ()){
                    if ( task.getResult ().exists ()){
                        Toast.makeText(getActivity(),"reception des donnes utilisateur termine",Toast.LENGTH_SHORT).show ();
                        String myname = task.getResult ().getString ("name");
                        String myphone = task.getResult ().getString ("phone");
                        String myresidence = task.getResult ().getString ("residence");
                        // String myimage = task.getResult ().getString ("image");
                        //mImageUri=Uri.parse (myimage);
                        name.setText ( myname );
                        phone.setText ( myphone );
                        domicile.setText ( myresidence );
                      /*  RequestOptions placeRquestHolder =new RequestOptions ();
                        placeRquestHolder.placeholder ( R.mipmap.user_prefere);
                        Glide.with (HomeActivity.this).setDefaultRequestOptions (  placeRquestHolder).load ( myimage ).into ( circleImageView );
*/                     // Picasso.get().load ( myimage ).into ( circleImageView );
                        // Picasso.with(ProfilActivity.this).load(myimage).into(circleImageView);
                        progressAccount.setVisibility(View.INVISIBLE);

                    }

                }else {
                    String error= task.getException().getMessage();
                    Toast.makeText(getActivity(),error,Toast.LENGTH_LONG).show ();

                }
//                progressBar.setVisibility ( View.INVISIBLE );
                // savebutton.setEnabled ( true );

            }
        } );




    }


}
