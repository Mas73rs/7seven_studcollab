package cm.studio.devbee.searchwithme;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {
    private android.support.v7.widget.Toolbar toolbar;
    private CircleImageView circleImageView;
    private Uri mImageUri;
    private EditText setupName;
    private EditText setupPhoneNumber;
    private EditText setupHouse;
    private Button setupButton;
    private StorageReference storageReference;
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_home );
        toolbar=findViewById ( R.id.setuptoolbar );
        setSupportActionBar ( toolbar );
       getSupportActionBar ().setTitle ( "parametre du profil" );
       circleImageView=findViewById(R.id.setupImage);
       liaison();
       circleImageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){

                   if (ContextCompat.checkSelfPermission(HomeActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

                       ActivityCompat.requestPermissions(HomeActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);


                   }else{


                       CropImage.activity()
                               .setGuidelines(CropImageView.Guidelines.ON)
                               .setAspectRatio(1,1)
                               .start(HomeActivity.this);

                   }

               }


           }
       });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                mImageUri = result.getUri();
                circleImageView.setImageURI(mImageUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
    public void liaison(){
        setupName=findViewById(R.id.namesetup);
        setupPhoneNumber=findViewById(R.id.setupPhone);
        setupHouse=findViewById(R.id.setupQuartier);
        setupButton=findViewById(R.id.setupButton);
        firebaseAuth=FirebaseAuth.getInstance();
        storageReference=FirebaseStorage.getInstance().getReference();
        progressBar=findViewById(R.id.setupprogressBar);

    }

    public void lancerEnregistrement(){
       setupButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                String user_name = setupName.getText().toString();
                String user_Phone_number=setupPhoneNumber.getText().toString();
                String user_Domicile=setupHouse.getText().toString();
                if (!TextUtils.isEmpty(user_name)&&!TextUtils.isEmpty(user_Phone_number)&&!TextUtils.isEmpty(user_Domicile)&&circleImageView!=null){

                    String user_id =firebaseAuth.getCurrentUser().getUid();
                    StorageReference image_path= storageReference.child("Image_de_profile").child(user_id + ".jpg");
                    image_path.putFile(mImageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {


                            if (task.isSuccessful()){

                                Uri download=task.getResult().getUploadSessionUri();
                                Toast.makeText(HomeActivity.this," profil enregistre ",Toast.LENGTH_LONG);


                            }else{
                                String error= task.getException().getMessage();
                                Toast.makeText(HomeActivity.this,error,Toast.LENGTH_LONG);


                            }
                            progressBar.setVisibility(View.VISIBLE);



                        }
                    });
                }
           }
       });

    }

}
