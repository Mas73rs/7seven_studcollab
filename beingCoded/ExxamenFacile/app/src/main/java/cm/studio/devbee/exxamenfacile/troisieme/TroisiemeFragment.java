package cm.studio.devbee.exxamenfacile.troisieme;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cm.studio.devbee.exxamenfacile.R;
import cm.studio.devbee.exxamenfacile.util.MatiereAdapter;
import cm.studio.devbee.exxamenfacile.util.SchoolMatiereModel;


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
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.three,"Geographie Troisieme" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.three,"ECM troisieme" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.three,"PCT troisieme" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.three,"Espagnol troisieme" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.three,"Mathematique Troisieme" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.three,"Etude de texte troisieme" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.three,"svt troisieme" ) );
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
