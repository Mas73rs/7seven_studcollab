package cm.studio.devbee.pocketexxam;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private FrameLayout frameLayout;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener () {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId ()) {
                case R.id.ic_3eme:
                    setFragment ( new Troisieme () );
                    return true;
                case R.id.ic_premiere:
                    setFragment ( new Premiere() );
                    return true;
                case R.id.ic_terminal:
                    setFragment ( new Terminal () );
                    return true;
                case R.id.ic_a_propos:
                    setFragment ( new layout_a_propos () );
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_home );
        BottomNavigationView navigation = (BottomNavigationView) findViewById ( R.id.bottom_navigation );
        navigation.setOnNavigationItemSelectedListener ( mOnNavigationItemSelectedListener );
        frameLayout=(FrameLayout)findViewById ( R.id.frame_layout );
        getSupportFragmentManager ().beginTransaction ().replace ( R.id.frame_layout,new Troisieme () ).commit ();


    }
    public  void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager ().beginTransaction ();
        fragmentTransaction.replace ( frameLayout.getId (),fragment );
        fragmentTransaction.commit ();
    }


}
