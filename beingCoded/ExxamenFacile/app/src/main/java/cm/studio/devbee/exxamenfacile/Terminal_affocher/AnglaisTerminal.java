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
public class AnglaisTerminal extends Fragment {
    ListView listView_AnglaisTerminal;
    PDFView pdfListView;

    public AnglaisTerminal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate ( R.layout.fragment_anglais_terminal, container, false );
        ///////////// creation d la lecture des liste de pdf
        listView_AnglaisTerminal=v.findViewById ( R.id.listTerminalanglais );
        String [] pdfFiles = {"bac_2009_anglais_terminal_a","bac_2009_anglais_terminal_b",
                "bac_2009_anglais_terminal_t_c_d","bac_2014_anglais_terminal_a",
                "bac_2015_anglais_terminal_a","bac_2016_anglais_terminal_a","bac_2017_anglais_terminal_a_c_d",
                "bac_ 2017_serie_a","bac_blanc_henri_2012_terminal_a4",
        "bac_blanc_henri_2012_terminal_c_d"};
        ArrayAdapter<String> adapter =new ArrayAdapter<String> (getActivity (),android.R.layout.simple_list_item_1,pdfFiles ){


            @Override
            public View getView(int position, View convertView,ViewGroup parent) {
                View view=super.getView ( position,convertView,parent );
                TextView mytext=view.findViewById ( android.R.id.text1 );
                return super.getView ( position, convertView, parent );
            }
        };
        listView_AnglaisTerminal.setAdapter ( adapter );
        listView_AnglaisTerminal.setOnItemClickListener ( new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item =listView_AnglaisTerminal.getItemAtPosition ( position ).toString ();
                Intent start = new Intent ( getActivity () ,ReadActivity.class );
                start.putExtra ( "NomDuPdf",item );
                startActivity ( start );

            }
        } );
        /////////////fin de la creation d la lecture des liste de pdf

        return v;
    }

}
