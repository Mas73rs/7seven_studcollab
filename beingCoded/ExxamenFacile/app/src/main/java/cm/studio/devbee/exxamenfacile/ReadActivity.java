package cm.studio.devbee.exxamenfacile;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ReadActivity extends AppCompatActivity {
    PDFView mypdfListView;
    String getItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_read );
        mypdfListView=findViewById ( R.id.mypdfReader );
        getItem =getIntent ().getStringExtra ( "NomDuPdf" );
        getSupportActionBar ().setTitle ( getItem );
        lancerTroisieme ();

    }
    public void geographieTroisieme(){

        if (getItem.equals ( "Geographie_2010")){
            mypdfListView.fromAsset ( "Bepc2011.pdf" ).load ();
        }

    }

    public void mathmatiqueTroisieme(){

        if (getItem.equals ( "Bepc_mathmatique_2010" )){
            mypdfListView.fromAsset (  "Bepc2011.pdf").load ();
        }

    }

    public void ECMTroisieme(){

        if (getItem.equals ( "Bepc_kiko_2010" )){
            mypdfListView.fromAsset (  "bepc_2010.pdf").load ();
        }

    }
    public void PCTTroisieme(){

        if (getItem.equals ( "Bepc_koko_2010" )){
            mypdfListView.fromAsset (  "bepc_2010.pdf").load ();
        }

    }
    public void EspagonlTroisieme(){

        if (getItem.equals ( "Bepc_kilko_2010" )){
            mypdfListView.fromAsset (  "bepc_2010.pdf").load ();
        }

    }
    public void EtudeDeTzxtTroisieme(){

        if (getItem.equals ( "Bepc_killkmo_2010" )){
            mypdfListView.fromAsset (  "bepc_2010.pdf").load ();
        }

    }
    public void SvtTroisieme(){

        if (getItem.equals ( "Bepc_killko_2010" )){
            mypdfListView.fromAsset (  "bepc_2010.pdf").load ();
        }

    }
    public void lancerTroisieme(){
        geographieTroisieme ();
        mathmatiqueTroisieme ();
        ECMTroisieme ();
        PCTTroisieme ();
        EspagonlTroisieme ();
        EtudeDeTzxtTroisieme ();
        SvtTroisieme ();
    }
}
