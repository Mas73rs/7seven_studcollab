package cm.studio.devbee.searchwithme.utils;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cm.studio.devbee.searchwithme.R;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    public List<Model> search_list;

    public Adapter(List<Model> search_list) {
        this.search_list = search_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.support_simple_spinner_dropdown_item,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        String desc = search_list.get(position).getDesc();
        viewHolder.setDescText(desc);
    }

    @Override
    public int getItemCount() {
        return search_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private View mView;
        private TextView desc;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView=itemView;
        }
        public void setDescText(String descText){
            desc = mView.findViewById(R.id.main_text_user);
            desc.setText(descText);


        }
    }

}
