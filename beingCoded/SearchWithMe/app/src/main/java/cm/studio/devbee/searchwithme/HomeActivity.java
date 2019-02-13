package cm.studio.devbee.searchwithme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

public class HomeActivity extends AppCompatActivity {
    private android.support.v7.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_home );
        toolbar=findViewById ( R.id.setuptoolbar );
        setSupportActionBar ( toolbar );
       getSupportActionBar ().setTitle ( "parametre du ptofil" );
    }


}
