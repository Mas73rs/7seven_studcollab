package cm.studio.devbee.exxamenfacile;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TroisiemeFragment extends Fragment {
    RecyclerView matiereRecyclerView;



    public TroisiemeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate ( R.layout.fragment_troisieme, container, false );
        matiereRecyclerView=v.findViewById ( R.id.recyclerView_troisieme );
        //////////list matiere trisieme
        ///////debut de la liste de troisieme
        List<SchoolMatiereModel> schoolMatiereModelList = new ArrayList<> (  );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.three,"Geographie" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.three,"ECM" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.three,"PCT" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.three,"Espagnol" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.three,"Mathematique" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.three,"Etude de texte" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.three,"Science e la vie et de la terre" ) );
        //////:fin de la liste
        MatiereAdapter matiereAdapter=new MatiereAdapter ( schoolMatiereModelList );
        matiereRecyclerView.setAdapter ( matiereAdapter );
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager ( getContext () );
        linearLayoutManager.setOrientation ( LinearLayoutManager.VERTICAL );
        matiereRecyclerView.setLayoutManager ( linearLayoutManager );

        matiereAdapter.notifyDataSetChanged ();
        return v;
    }

}
