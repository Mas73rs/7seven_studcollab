package cm.studio.devbee.searchwithme;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import cm.studio.devbee.searchwithme.fragment.AccountFragment;
import cm.studio.devbee.searchwithme.fragment.HomeFragment;
import cm.studio.devbee.searchwithme.fragment.NotificationFragment;
import cm.studio.devbee.searchwithme.utils.Slider;
import cm.studio.devbee.searchwithme.utils.SliderPagerAdapter;

public class RechercheActivity extends AppCompatActivity {
    private Toolbar toolbaracceuil;
    private FloatingActionButton floatingActionButton;
    private List<Slider> slideList;
    private ViewPager viewPagerSlider;
    private FirebaseAuth mfireAuth;
    private FirebaseFirestore mfirebasefirestore;
    private String user_id;
    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    private HomeFragment homeFragment;
    private NotificationFragment notification;
    private AccountFragment accountFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);
        toolbaracceuil=findViewById ( R.id.sacceuilletoolbar );
        viewPagerSlider=findViewById(R.id.slider_pager);
        setSupportActionBar ( toolbaracceuil );
        getSupportActionBar ().setTitle ( "flux de recherche" );
        floatingActionButton=findViewById(R.id.floatingActionButton);
        mfireAuth=FirebaseAuth.getInstance ();
        bottomNavigationView=findViewById(R.id.bottomNavigationView);


        frameLayout=findViewById(R.id.frameLayout);

        mfirebasefirestore=FirebaseFirestore.getInstance ();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToPost = new Intent(RechercheActivity.this,PostActivity.class);
                startActivity(goToPost);
            }
        });

        slideList =new ArrayList<>();
        slideList.add(new Slider(R.drawable.slide1,"ne perdez plus jamais " +
                "ce qui vous est precieux"));
        slideList.add(new Slider(R.drawable.slide2,"ne perdez plus jamais " +
                "ce qui vous est precieux"));
        slideList.add(new Slider(R.drawable.slide3,"ne perdez plus jamais " +
                "ce qui vous est precieux"));
        slideList.add(new Slider(R.drawable.slide2,"ne perdez plus jamais " +
                "ce qui vous est precieux"));
        SliderPagerAdapter adapter = new SliderPagerAdapter(RechercheActivity.this,slideList);
//        viewPagerSlider.setAdapter(adapter);

        homeFragment=new HomeFragment();
        notification = new NotificationFragment();
        accountFragment=new AccountFragment();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.ic_home:
                        replace(new HomeFragment());
                       return true;
                    case R.id.ic_notification:
                        replace(new NotificationFragment());
                        return true;
                    case R.id.ic_account:
                        replace(new AccountFragment());
                        return true;
                        default:
                            return false;
                }

            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new HomeFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.acceuil_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.ic_profil:{
                Intent gotoprofil = new Intent(RechercheActivity.this,ProfilActivity.class);
                startActivity(gotoprofil);
                break;
            }
            case R.id.ic_deconnexion:{
                Intent gotologin = new Intent(RechercheActivity.this,LoginActivity.class);
                startActivity(gotologin);
                break;
            }
            case R.id.ic_parametre_profil:{
                Intent gotoparametre= new Intent(RechercheActivity.this,HomeActivity.class);
                startActivity(gotoparametre);
                break;
            }


        }
        return super.onOptionsItemSelected(item);
    }

    public void replace(Fragment fragment){

        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();

    }
    /*
    @Override
    protected void onStart() {
        super.onStart ();
        FirebaseUser current_usr = FirebaseAuth.getInstance ().getCurrentUser ();
        if(current_usr==null){
            Intent gotologin = new Intent(RechercheActivity.this,LoginActivity.class);
            startActivity(gotologin);
           finish ();
        }else{
            user_id=mfireAuth.getCurrentUser ().getUid ();
            mfirebasefirestore.collection ( "User" ).document (user_id).get ().addOnCompleteListener ( new OnCompleteListener<DocumentSnapshot> () {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful ()){
                        if (!task.getResult ().exists ()){
                            Intent stupIntent = new Intent ( RechercheActivity.this,HomeActivity.class );
                            startActivity ( stupIntent );
                            finish ();
                        }
                    }else{
                        String error =task.getException ().getMessage ();
                        Toast.makeText ( RechercheActivity.this,error,Toast.LENGTH_LONG ).show ();
                    }
                }
            } );
        }
    }*/
}
