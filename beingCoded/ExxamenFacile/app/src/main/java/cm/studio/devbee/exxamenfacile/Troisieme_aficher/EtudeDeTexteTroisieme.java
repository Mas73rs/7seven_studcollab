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
public class EtudeDeTexteTroisieme extends Fragment {
    ListView listView_EtudeDeTexteTroisieme;
    PDFView pdfListView;

    public EtudeDeTexteTroisieme() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate ( R.layout.fragment_etude_de_texte_troisieme, container, false );
        ///////////// creation d la lecture des liste de pdf
        listView_EtudeDeTexteTroisieme =v.findViewById ( R.id.list_etude_de_texte );
        pdfListView=v.findViewById ( R.id.mypdfReader );
        String [] pdfFiles = {"etude_de_texte_college_henrie_no8_2012","etude_de_texte_2014",
        "etude_de_texte_2015","etude_de_texte_2016","etude_de_texte_2017",
        "etude_de_texte_college_henri"};
        ArrayAdapter<String> adapter =new ArrayAdapter<String> (getActivity (),android.R.layout.simple_list_item_1,pdfFiles ){


            @Override
            public View getView(int position, View convertView,ViewGroup parent) {
                View view=super.getView ( position,convertView,parent );
                TextView mytext=view.findViewById ( android.R.id.text1 );
                return super.getView ( position, convertView, parent );
            }
        };
        listView_EtudeDeTexteTroisieme.setAdapter ( adapter );
        listView_EtudeDeTexteTroisieme.setOnItemClickListener ( new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item =listView_EtudeDeTexteTroisieme.getItemAtPosition ( position ).toString ();
                Intent start = new Intent ( getActivity () ,ReadActivity.class );
                start.putExtra ( "NomDuPdf",item );
                startActivity ( start );

            }
        } );
        /////////////fin de la creation d la lecture des liste de pdf

        return v;
    }

}
