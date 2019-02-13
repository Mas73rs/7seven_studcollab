package cm.studio.devbee.exxamenfacile.Second_Activity_for_choice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import cm.studio.devbee.exxamenfacile.Terminal_affocher.AnglaisTerminal;
import cm.studio.devbee.exxamenfacile.Terminal_affocher.ChimieTerminal;
import cm.studio.devbee.exxamenfacile.Terminal_affocher.LangueTerminal;
import cm.studio.devbee.exxamenfacile.Terminal_affocher.LitteratureTerminal;
import cm.studio.devbee.exxamenfacile.Terminal_affocher.MathTerminal;
import cm.studio.devbee.exxamenfacile.Terminal_affocher.PhyloTerminal;
import cm.studio.devbee.exxamenfacile.Terminal_affocher.PhysiqueTerminal;
import cm.studio.devbee.exxamenfacile.Terminal_affocher.SvtTerminal;
import cm.studio.devbee.exxamenfacile.R;

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

        //////terminal
        if (title.equals ( "allemand terminal" )){
        }if (title.equals ( "Anglais terminal" )){
            setFragent ( new AnglaisTerminal () );
        }
        if (title.equals ( "Chimie terminal" )){
            setFragent ( new ChimieTerminal () );
        }
        if (title.equals ( "Espagnol terminal" )){
        }
        if (title.equals ( "Geographie terminal" )){
        }
        if (title.equals ( "Histoire terminal" )){
        }
        if (title.equals ( "Informatique terminal" )){
        }
        if (title.equals ( "Langue terminal" )){
            setFragent ( new LangueTerminal () );
        }
        if (title.equals ( "Mathematiques terminal" )){
            setFragent ( new MathTerminal () );
        }if (title.equals ( "Philo terminal" )){
            setFragent ( new PhyloTerminal () );
        }if (title.equals ( "Physique terminal" )){
            setFragent ( new PhysiqueTerminal () );
        }if (title.equals ( "SVT terminal" )){
            setFragent ( new SvtTerminal () );
        }if (title.equals ( "litterature terminal" )){
            setFragent ( new LitteratureTerminal () );
        }
        //////litterature terminal


    }


}
