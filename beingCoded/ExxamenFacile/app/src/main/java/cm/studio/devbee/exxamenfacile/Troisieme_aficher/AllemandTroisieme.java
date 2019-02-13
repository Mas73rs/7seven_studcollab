package cm.studio.devbee.exxamenfacile.Troisieme_aficher;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

import cm.studio.devbee.exxamenfacile.R;

import cm.studio.devbee.exxamenfacile.ReadActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllemandTroisieme extends Fragment {
    ListView listView_AllemandTroisieme;
    PDFView pdfListView;

    public AllemandTroisieme() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate ( R.layout.fragment_allemand_troisieme, container, false );
        ///////////// creation d la lecture des liste de pdf
        listView_AllemandTroisieme=v.findViewById ( R.id.listTroisiemeAllemand );
        String [] pdfFiles = {"allemand_college_henrie_2011_2012"};
        ArrayAdapter<String> adapter =new ArrayAdapter<String> (getActivity (),android.R.layout.simple_list_item_1,pdfFiles ){


            @Override
            public View getView(int position, View convertView,ViewGroup parent) {
                View view=super.getView ( position,convertView,parent );
                TextView mytext=view.findViewById ( android.R.id.text1 );
                return super.getView ( position, convertView, parent );
            }
        };
        listView_AllemandTroisieme.setAdapter ( adapter );
        listView_AllemandTroisieme.setOnItemClickListener ( new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item =listView_AllemandTroisieme.getItemAtPosition ( position ).toString ();
                Intent start = new Intent ( getActivity () ,ReadActivity.class );
                start.putExtra ( "NomDuPdf",item );
                startActivity ( start );

            }
        } );
        /////////////fin de la creation d la lecture des liste de pdf

        return v;
    }

}
