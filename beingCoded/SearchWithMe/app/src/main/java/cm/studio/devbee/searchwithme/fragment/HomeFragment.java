package cm.studio.devbee.searchwithme.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cm.studio.devbee.searchwithme.R;



import cm.studio.devbee.searchwithme.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView homeRecyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);
        homeRecyclerView=v.findViewById(R.id.RecyclerView_home_fragment);
        return v;
    }

    public void replace(Fragment fragment){


        }


}
