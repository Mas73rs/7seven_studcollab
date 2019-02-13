package cm.studio.devbee.exxamenfacile.Terminal_affocher;


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
public class LangueTerminal extends Fragment {
    ListView listView_LangueTerminal;
    PDFView pdfListView;

    public LangueTerminal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate ( R.layout.fragment_langue_terminal, container, false );
        ///////////// creation d la lecture des liste de pdf
        listView_LangueTerminal=v.findViewById ( R.id.listTerminallangue );
        String [] pdfFiles = {"bac_2014_serie_a4","bac_2014_serie_c_d_e_ti","bac_2015_serie_a4",
        "bac_2015_serie_c_e_ti","bac_2016_serie_d_ti","bac_2017_serie_a4","bac_2017_serie_c_e",
        "bac_blanc_henrie_2012"};
        ArrayAdapter<String> adapter =new ArrayAdapter<String> (getActivity (),android.R.layout.simple_list_item_1,pdfFiles ){


            @Override
            public View getView(int position, View convertView,ViewGroup parent) {
                View view=super.getView ( position,convertView,parent );
                TextView mytext=view.findViewById ( android.R.id.text1 );
                return super.getView ( position, convertView, parent );
            }
        };
        listView_LangueTerminal.setAdapter ( adapter );
        listView_LangueTerminal.setOnItemClickListener ( new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item =listView_LangueTerminal.getItemAtPosition ( position ).toString ();
                Intent start = new Intent ( getActivity () ,ReadActivity.class );
                start.putExtra ( "NomDuPdf",item );
                startActivity ( start );

            }
        } );
        /////////////fin de la creation d la lecture des liste de pdf

        return v;
    }

}
