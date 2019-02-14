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
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private CircleImageView circleImageView;
    private EditText name;
    private EditText phone;
    private EditText domicile;
    private Button savebutton;
    private Uri mImageUri;
    private ProgressBar progressBar;
    private StorageReference storageReference;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_home );
        toolbar=findViewById ( R.id.setuptoolbar );
        setSupportActionBar ( toolbar );
       getSupportActionBar ().setTitle ( "parametre du profil" );
        liaison();
        CheckAndroidVersion ();
        progressBar.setVisibility ( View.INVISIBLE );
    }

    private void liaison(){
        circleImageView=findViewById ( R.id.setupImage );
        name=findViewById ( R.id.setupName );
        phone=findViewById ( R.id.setupPhoneNumber );
        domicile=findViewById ( R.id.setupQuartier );
        savebutton=findViewById ( R.id.setupButton );
        progressBar=findViewById ( R.id.setupprogressBar );
        firebaseAuth=FirebaseAuth.getInstance ();
        storageReference=FirebaseStorage.getInstance ().getReference ();
        circleImageView.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                CheckAndroidVersion ();
            }
        } );

        lancerEnregistrement();
    }


    //REQUEST PERMISSION
    public void CheckAndroidVersion(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            try {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 555);
            }catch (Exception e){
                e.printStackTrace ();
            }
        }
        else {
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
            mImageUri= CropImage.getPickImageResultUri(HomeActivity.this, data);
            croprequest(mImageUri);
        }

        //RESULT FROM CROPING ACTIVITY
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), result.getUri());
                    ((CircleImageView)findViewById(R.id.setupImage)).setImageBitmap(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void lancerEnregistrement(){
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = name.getText().toString();
                String user_Phone_number=phone.getText().toString();
                String user_Domicile=domicile.getText().toString();
                if (!TextUtils.isEmpty(user_name)&&!TextUtils.isEmpty(user_Phone_number)&&!TextUtils.isEmpty(user_Domicile)&&circleImageView!=null){
                    String user_id =firebaseAuth.getCurrentUser().getUid();
                    StorageReference image_path= storageReference.child("Image_de_profile").child(user_id + ".jpg");
                    image_path.putFile(mImageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot> () {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if (task.isSuccessful()){

                                Uri download=task.getResult().getUploadSessionUri ();
                                progressBar.setVisibility ( View.INVISIBLE );
                                Toast.makeText(HomeActivity.this," profil enregistre ",Toast.LENGTH_LONG).show ();
                                Intent goToAcceuille = new Intent ( HomeActivity.this,AcceuilleActivity.class );
                                startActivity ( goToAcceuille );
                                finish ();

                            }else{
                                String error= task.getException().getMessage();
                                Toast.makeText(HomeActivity.this,error,Toast.LENGTH_LONG);

                            }
                            progressBar.setVisibility(View.INVISIBLE);
                        }
                    });
                }
            }
        });

    }


}
