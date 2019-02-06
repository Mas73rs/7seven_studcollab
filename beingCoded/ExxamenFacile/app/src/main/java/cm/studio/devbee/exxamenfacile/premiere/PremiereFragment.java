package cm.studio.devbee.exxamenfacile.premiere;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cm.studio.devbee.exxamenfacile.util.MatiereAdapter;
import cm.studio.devbee.exxamenfacile.R;
import cm.studio.devbee.exxamenfacile.util.SchoolMatiereModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class PremiereFragment extends Fragment {
    RecyclerView matiereRecyclerView;


    public PremiereFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate ( R.layout.fragment_premiere, container, false );
        matiereRecyclerView=v.findViewById ( R.id.recyclerView_premiere );
        //////////list matiere trisieme
        ///////debut de la liste de troisieme
        List<SchoolMatiereModel> schoolMatiereModelList = new ArrayList<> (  );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.one,"Allemand" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.one,"Anglais" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.one,"Chimie" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.one,"ECM" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.one,"Espagnol" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.one,"Francais" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.one,"Histoire" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.one,"GeographieTroisieme" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.one,"Informatique" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.one,"Mathematiques" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.one,"Physique" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.one,"SVT" ) );
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
