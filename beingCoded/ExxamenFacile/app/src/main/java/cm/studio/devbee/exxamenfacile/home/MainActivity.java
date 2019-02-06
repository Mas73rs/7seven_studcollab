package cm.studio.devbee.exxamenfacile.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import cm.studio.devbee.exxamenfacile.R;
import cm.studio.devbee.exxamenfacile.terminal.TerminalFragment;
import cm.studio.devbee.exxamenfacile.troisieme.TroisiemeFragment;
import cm.studio.devbee.exxamenfacile.a_propos.AproposFragment;
import cm.studio.devbee.exxamenfacile.premiere.PremiereFragment;

public class MainActivity extends AppCompatActivity {
    private FrameLayout frameLayout;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener () {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId ()) {
                case R.id.troisieme_butto:
                    setFragment ( new TroisiemeFragment () );
                    return true;
                case R.id.premiere_button:
                    setFragment ( new PremiereFragment () );
                    return true;
                case R.id.termial_button:
                    setFragment ( new TerminalFragment () );
                    return true;
                case R.id.a_propos:
                    setFragment ( new AproposFragment () );
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        BottomNavigationView navigation = (BottomNavigationView) findViewById ( R.id.bottomnavigation );
        navigation.setOnNavigationItemSelectedListener ( mOnNavigationItemSelectedListener );
        frameLayout=(FrameLayout)findViewById ( R.id.matiereFRameLayout );
        getSupportFragmentManager ().beginTransaction ().replace ( R.id.matiereFRameLayout,new TroisiemeFragment () ).commit ();

    }
    public  void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager ().beginTransaction ();
        fragmentTransaction.replace ( frameLayout.getId (),fragment );
        fragmentTransaction.commit ();
    }

}
