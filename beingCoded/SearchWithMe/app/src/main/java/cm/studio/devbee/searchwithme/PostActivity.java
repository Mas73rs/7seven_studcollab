package cm.studio.devbee.searchwithme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class PostActivity extends AppCompatActivity {
    Toolbar toolbarpost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        toolbarpost=findViewById ( R.id.posttoolbar );
        setSupportActionBar ( toolbarpost );
        getSupportActionBar ().setTitle ( "Que recherche vous ? " );
    }
}
