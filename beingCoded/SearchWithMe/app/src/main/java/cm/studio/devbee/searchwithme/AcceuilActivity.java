package cm.studio.devbee.searchwithme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class AcceuilActivity extends AppCompatActivity {
        private android.support.v7.widget.Toolbar acceuilToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_acceuil );
        acceuilToolbar=findViewById ( R.id.acceuille );
        setSupportActionBar ( acceuilToolbar );
        getSupportActionBar ().setTitle ( "flux de recherche" );
        Button button=findViewById ( R.id.button2 );
        button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent into = new Intent ( AcceuilActivity.this,HomeActivity.class );
                startActivity ( into );

            }
        } );

    }
}
