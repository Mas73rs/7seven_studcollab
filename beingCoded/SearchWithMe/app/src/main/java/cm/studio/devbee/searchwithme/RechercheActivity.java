package cm.studio.devbee.searchwithme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class RechercheActivity extends AppCompatActivity {
    private Toolbar toolbaracceuil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);
        toolbaracceuil=findViewById ( R.id.sacceuilletoolbar );
        setSupportActionBar ( toolbaracceuil );
        getSupportActionBar ().setTitle ( "flux de recherche" );
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
                Intent gotoprofil = new Intent(RechercheActivity.this,HomeActivity.class);
                startActivity(gotoprofil);
                break;
            }
            case R.id.ic_deconnexion:{
                Intent gotologin = new Intent(RechercheActivity.this,LoginActivity.class);
                startActivity(gotologin);
                break;
            }


        }
        return super.onOptionsItemSelected(item);
    }
}
