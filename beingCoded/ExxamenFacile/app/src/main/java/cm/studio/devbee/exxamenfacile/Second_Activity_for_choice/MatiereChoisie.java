package cm.studio.devbee.exxamenfacile.Second_Activity_for_choice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import cm.studio.devbee.exxamenfacile.Troisieme_aficher.ECMTroisieme;
import cm.studio.devbee.exxamenfacile.Troisieme_aficher.EspagnolTroisieme;
import cm.studio.devbee.exxamenfacile.Troisieme_aficher.GeographieTroisieme;
import cm.studio.devbee.exxamenfacile.R;
import cm.studio.devbee.exxamenfacile.Troisieme_aficher.MathematiqueTroisieme;
import cm.studio.devbee.exxamenfacile.Troisieme_aficher.PCTTroisieme;

public class MatiereChoisie extends AppCompatActivity {

    FrameLayout frameLayout;
    public String title;
    public String geographie="GeographieTroisieme";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_matiere_choisie );
        frameLayout=findViewById ( R.id.matiere_framelayout_container );
        ActionBar ab=getSupportActionBar ();
        ab.setDisplayHomeAsUpEnabled ( true );
        title =getIntent ().getStringExtra ( "categoryName" );
        getSupportActionBar ().setTitle ( title );
        setMatiereTroisieme ( title );




    }
    public void setFragent(Fragment fragment){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager ().beginTransaction ();
        fragmentTransaction.replace ( frameLayout.getId (),fragment );
        fragmentTransaction.commit ();
    }
    public void setMatiereTroisieme(String titre){
        if (title.equals ( "Geographie Troisieme")){
            setFragent ( new GeographieTroisieme () );
        }
        if (title.equals ( "Mathematique Troisieme" )){
            setFragent ( new MathematiqueTroisieme () );
        }
        /////////////////////
        if (title.equals ( "ECM troisieme")){
            setFragent ( new ECMTroisieme () );
        }
        if (title.equals ( "PCT troisieme" )){
            setFragent ( new PCTTroisieme () );
        } if (title.equals ( "Espagnol troisieme")){
            setFragent ( new EspagnolTroisieme () );
        }
        if (title.equals ( "Etude de texte troisieme" )){
            setFragent ( new MathematiqueTroisieme () );
        } if (title.equals ( "svt troisieme")){
            setFragent ( new GeographieTroisieme () );
        }

    }


}
