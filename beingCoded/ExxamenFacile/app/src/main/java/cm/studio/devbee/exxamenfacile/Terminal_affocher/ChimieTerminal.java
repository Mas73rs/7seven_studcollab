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
public class ChimieTerminal extends Fragment {
    ListView listView_ChimieTerminal;
    PDFView pdfListView;

    public ChimieTerminal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate ( R.layout.fragment_chimie_terminal, container, false );
        ///////////// creation d la lecture des liste de pdf
        listView_ChimieTerminal=v.findViewById ( R.id.listTerminachimie );
        String [] pdfFiles = {"bac_2014_terminal_c_d","bac_2015_terminal_c_d","bac_2016_terminal_c_d","bac_2008_serie_d_ti",
        "bac_2009_serie_d_ti","bac_2011_serie_d_ti","bac_2013_serie_d_ti"};
        ArrayAdapter<String> adapter =new ArrayAdapter<String> (getActivity (),android.R.layout.simple_list_item_1,pdfFiles ){


            @Override
            public View getView(int position, View convertView,ViewGroup parent) {
                View view=super.getView ( position,convertView,parent );
                TextView mytext=view.findViewById ( android.R.id.text1 );
                return super.getView ( position, convertView, parent );
            }
        };
        listView_ChimieTerminal.setAdapter ( adapter );
        listView_ChimieTerminal.setOnItemClickListener ( new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item =listView_ChimieTerminal.getItemAtPosition ( position ).toString ();
                Intent start = new Intent ( getActivity () ,ReadActivity.class );
                start.putExtra ( "NomDuPdf",item );
                startActivity ( start );

            }
        } );
        /////////////fin de la creation d la lecture des liste de pdf

        return v;
    }

}
