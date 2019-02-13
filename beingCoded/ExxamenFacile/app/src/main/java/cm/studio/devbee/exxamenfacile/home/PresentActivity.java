package cm.studio.devbee.exxamenfacile.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cm.studio.devbee.exxamenfacile.R;

public class PresentActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_present );
        btn= (Button)findViewById ( R.id.goButton );
        //dialog ();


    }
    public void goToactivity(View view) {
        Intent gointend= new Intent ( PresentActivity.this,MainActivity.class );
        startActivity ( gointend );
        finish ();
    }
   /* public void dialog(){
       btn.setOnClickListener ( new View.OnClickListener () {
           @Override
           public void onClick(View v) {
               AlertDialog.Builder builder= new AlertDialog.Builder(PresentActivity.this);
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
       } );
    }*/
}
