package cm.studio.devbee.searchwithme.utils;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cm.studio.devbee.searchwithme.R;

public class AdapterForList extends RecyclerView.Adapter<AdapterForList.ViewHolder> {
    List<ModelForlist> modelForlistList;

    public AdapterForList(List<ModelForlist> modelForlistList) {
        this.modelForlistList = modelForlistList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_du_model_de_publication,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String descript=modelForlistList.get(i).getUser_description();
        viewHolder.description(descript);
    }

    @Override
    public int getItemCount() {
        return modelForlistList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView description ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            description =itemView.findViewById(R.id.user_desc);
        }
        public void description(String desc){
            description.setText(desc);
        }
    }


}
