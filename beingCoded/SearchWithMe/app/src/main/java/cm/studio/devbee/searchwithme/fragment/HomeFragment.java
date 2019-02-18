package cm.studio.devbee.searchwithme.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import cm.studio.devbee.searchwithme.R;



import cm.studio.devbee.searchwithme.R;
import cm.studio.devbee.searchwithme.utils.Adapter;
import cm.studio.devbee.searchwithme.utils.Model;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView homeRecyclerView;
    private List<Model> search_list;
    private FirebaseFirestore firebaseFirestore;
    private Adapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);
        homeRecyclerView=v.findViewById(R.id.RecyclerView_home_fragment);
        search_list=new ArrayList<>();
        adapter=new Adapter(search_list);
        homeRecyclerView.setAdapter(adapter);
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        firebaseFirestore=FirebaseFirestore.getInstance();
        firebaseFirestore.collection("posts").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                for (DocumentChange doc : queryDocumentSnapshots.getDocumentChanges()){
                    if (doc.getType()==DocumentChange.Type.ADDED){

                        Model model =doc.getDocument().toObject(Model.class);
                        search_list.add(model);
                        adapter.notifyDataSetChanged();
                    }

                }
            }
        });
        return v;
    }




}
