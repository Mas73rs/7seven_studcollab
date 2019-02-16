package cm.studio.devbee.searchwithme;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostActivity extends AppCompatActivity {
    private Toolbar toolbarpost;
    private ImageView imagePost;
    private Button postButton;
    private Uri postUri;
    private ProgressBar progressBar;
    private StorageReference storageReference;
    private FirebaseAuth firebaseAuth;
    private FirebaseStorage firebaseStorage;
    private String current_user_id;
    private Uri postImageUri;
    private EditText description_text;
    private EditText whre_text;
    private FirebaseFirestore firebaseFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        toolbarpost=findViewById ( R.id.posttoolbar );
        setSupportActionBar ( toolbarpost );
        getSupportActionBar ().setTitle ( "Que recherche vous ? " );
        storageReference=FirebaseStorage.getInstance ().getReference ();
        firebaseStorage=FirebaseStorage.getInstance ();
        firebaseAuth=FirebaseAuth.getInstance ();
        firebaseFirestore=FirebaseFirestore.getInstance ();
        imagePost=findViewById ( R.id.imageView );
        postButton=findViewById ( R.id.post_button );
        progressBar=findViewById ( R.id.postprogess );
        description_text=findViewById ( R.id.description_text );
        whre_text=findViewById ( R.id.lost_lieu );
        progressBar.setVisibility ( View.INVISIBLE );

        imagePost.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                CheckAndroidVersion();
            }
        } );
        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                final String user_description = description_text.getText().toString();
                final String lieu=whre_text.getText().toString();
                if (!TextUtils.isEmpty(user_description)&&!TextUtils.isEmpty(lieu)&&imagePost!=null){
                    current_user_id =firebaseAuth.getCurrentUser().getUid();
                    final String random =FieldValue.serverTimestamp ().toString ();
                    StorageReference image_path= storageReference.child("Image_de_profile").child(random + " .jpg ");
                    image_path.putFile(postImageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot> () {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if (task.isSuccessful()){
                                Uri download=task.getResult().getUploadSessionUri ();
                                //mImageUri=download;
                                Map <String,Object> user_post = new HashMap (  );
                                user_post.put ( "image",download.toString () );
                                user_post.put ( "desc",user_description );
                                user_post.put ( "lieu",lieu );
                                user_post.put ( "temp",FieldValue.serverTimestamp () );
                                firebaseFirestore.collection ( "pots" ).document ( current_user_id ).set ( user_post ).addOnCompleteListener ( new OnCompleteListener<Void> () {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful ()){
                                            Toast.makeText ( PostActivity.this ,"recherche envoyer aux utilisateur",Toast.LENGTH_LONG).show ();
                                            Intent goToAcceuille = new Intent ( PostActivity.this,RechercheActivity.class );
                                            startActivity ( goToAcceuille );
                                            finish ();
                                        }else {

                                            String error=task.getException ().getMessage ();
                                            Toast.makeText ( PostActivity.this ,error,Toast.LENGTH_LONG).show ();
                                        }
                                        progressBar.setVisibility(View.INVISIBLE);
                                    }
                                } );
                                Toast.makeText(PostActivity.this,"enregistre ",Toast.LENGTH_LONG).show ();
                              /*  Intent gotoacceuille = new Intent(HomeActivity.this,RechercheActivity.class);
                                startActivity ( gotoacceuille );
                                finish ();*/

                            }else{
                                String error= task.getException().getMessage();
                                Toast.makeText(PostActivity.this,error,Toast.LENGTH_LONG).show ();
                                progressBar.setVisibility(View.INVISIBLE);
                            }

                        }
                    });
                }
            }
        });

    }


    ////////////imageCrop
    //REQUEST PERMISSION
    public void CheckAndroidVersion(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            try {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 555);
            }catch (Exception e){
                e.printStackTrace ();
            }
            //new picimage()
            pickImage();
        }
        else {
            //pickImage();
            pickImage();

        }
    }

    //PICK IMAGE METHOD
    public void pickImage() {
        CropImage.startPickImageActivity(this);
    }

    //FOR ACTIVITY RESULT PERMISSION
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 555 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            pickImage();
        } else{
            CheckAndroidVersion();
        }
    }


    //CROP REQUEST JAVA
    private void croprequest(Uri imageUri) {
        CropImage.activity(imageUri)
                .setGuidelines(CropImageView.Guidelines.ON)
                .setMultiTouchEnabled(true)
                .start(this);
    }

    //FOR ACTIVITY RESULT
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //RESULT FROM SELECTED IMAGE
        if (requestCode == CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            postImageUri= CropImage.getPickImageResultUri(PostActivity.this, data);
            croprequest(postImageUri);
        }

        //RESULT FROM CROPING ACTIVITY
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), result.getUri());
                    ((ImageView)findViewById(R.id.imageView )).setImageBitmap(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
