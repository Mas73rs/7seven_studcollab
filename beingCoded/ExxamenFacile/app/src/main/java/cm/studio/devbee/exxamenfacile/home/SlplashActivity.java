package cm.studio.devbee.exxamenfacile.home;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cm.studio.devbee.exxamenfacile.R;

public class SlplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_slplash );
        SystemClock.sleep ( 250 );
        Intent goToPresent = new Intent ( SlplashActivity.this ,PresentActivity.class);
        startActivity ( goToPresent );
        finish ();
    }


}
