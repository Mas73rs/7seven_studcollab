package cm.studio.devbee.exxamenfacile.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import cm.studio.devbee.exxamenfacile.R;
import cm.studio.devbee.exxamenfacile.terminal.TerminalFragment;
import cm.studio.devbee.exxamenfacile.a_propos.AproposFragment;

public class MainActivity extends AppCompatActivity {
    private FrameLayout frameLayout;
    private AdView mAdView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener () {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId ()) {
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
        getSupportFragmentManager ().beginTransaction ().replace ( R.id.matiereFRameLayout,new TerminalFragment () ).commit ();

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setTitle ( "Clique sur Banniere publicitaire" );
        builder.setMessage("Si la banniere publicitaire s'affiche,n'oubliez pas de cliquer dessus histoire de financer et encourager le devellopement de l'application. Merci d'avance");
        builder.setCancelable(false);
        builder.setPositiveButton ( "Oki,jai compris", new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel ();
            }
        } );
        AlertDialog alert=builder.create();
        alert.show();
    }
    public  void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager ().beginTransaction ();
        fragmentTransaction.replace ( frameLayout.getId (),fragment );
        fragmentTransaction.commit ();
    }

}
