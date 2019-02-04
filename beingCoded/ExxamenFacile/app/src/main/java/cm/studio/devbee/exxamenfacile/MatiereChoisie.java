package cm.studio.devbee.exxamenfacile;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MatiereChoisie extends AppCompatActivity {
    FrameLayout frameLayout;
    public String title;
    public String geographie="Geographie";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_matiere_choisie );
        frameLayout=findViewById ( R.id.matiere_framelayout_container );
        ActionBar ab=getSupportActionBar ();
        ab.setDisplayHomeAsUpEnabled ( true );
        title =getIntent ().getStringExtra ( "categoryName" );
        getSupportActionBar ().setTitle ( title );
        if (title==geographie){
            setFragent ( new Geographie () );
        }

    }
    public void setFragent(Fragment fragment){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager ().beginTransaction ();
        fragmentTransaction.replace ( frameLayout.getId (),fragment );
        fragmentTransaction.commit ();
    }


}
