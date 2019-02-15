package cm.studio.devbee.searchwithme;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class RechercheActivity extends AppCompatActivity {
    private Toolbar toolbaracceuil;
    private FloatingActionButton floatingActionButton;
    private List<Slider> slideList;
    private ViewPager viewPagerSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);
        toolbaracceuil=findViewById ( R.id.sacceuilletoolbar );
        viewPagerSlider=findViewById(R.id.slider_pager);
        setSupportActionBar ( toolbaracceuil );
        getSupportActionBar ().setTitle ( "flux de recherche" );
        floatingActionButton=findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToPost = new Intent(RechercheActivity.this,PostActivity.class);
                startActivity(goToPost);
            }
        });

        slideList =new ArrayList<>();
        slideList.add(new Slider(R.drawable.slide1,"ne perdez plus jamais ce qui vous est precieux"));
        slideList.add(new Slider(R.drawable.slide2,"ne perdez plus jamais /nce qui vous est precieux"));
        slideList.add(new Slider(R.drawable.slide3,"ne perdez plus jamais ce qui vous est precieux"));
        slideList.add(new Slider(R.drawable.slide2,"ne perdez plus jamais /nce qui vous est precieux"));
        SliderPagerAdapter sliderAdapter =new SliderPagerAdapter(this,slideList);

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
