package cm.studio.devbee.exxamenfacile.a_propos;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cm.studio.devbee.exxamenfacile.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AproposFragment extends Fragment {
    Button call;

    public AproposFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate ( R.layout.fragment_apropos, container, false );
        call=v.findViewById ( R.id.call );
        call.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String uri = "tel:+237656209008" ;
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        } );
        return v;
    }


}
