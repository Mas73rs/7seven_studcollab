package cm.studio.devbee.exxamenfacile.terminal;


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
public class TerminalFragment extends Fragment {
    RecyclerView matiereRecyclerView;

    public TerminalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate ( R.layout.fragment_terminal, container, false );
        matiereRecyclerView=v.findViewById ( R.id.recyclerView_terminal );
        //////////list matiere trisieme
        ///////debut de la liste de troisieme
        List<SchoolMatiereModel> schoolMatiereModelList = new ArrayList<> (  );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( "Baccaleaureat","Chimie terminal" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( "Baccaleaureat","Mathematiques terminal" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( "Baccaleaureat","Physique terminal" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( "Baccaleaureat","SVT terminal" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( "Baccaleaureat","Langue terminal" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( "Baccaleaureat","Philo terminal" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( "Baccaleaureat","litterature terminal" ) );

       /* schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.sept,"Anglais terminal" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.sept,"Chimie terminal" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.sept,"Mathematiques terminal" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.sept,"Physique terminal" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.sept,"SVT terminal" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.sept,"Langue terminal" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.sept,"Philo terminal" ) );
        schoolMatiereModelList.add ( new SchoolMatiereModel ( R.mipmap.sept,"litterature terminal" ) );*/

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
