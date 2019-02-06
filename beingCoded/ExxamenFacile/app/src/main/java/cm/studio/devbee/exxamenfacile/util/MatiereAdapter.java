package cm.studio.devbee.exxamenfacile.util;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cm.studio.devbee.exxamenfacile.Second_Activity_for_choice.MatiereChoisie;
import cm.studio.devbee.exxamenfacile.R;

public class MatiereAdapter extends RecyclerView.Adapter<MatiereAdapter.ViewHolder> {

    List<SchoolMatiereModel> schoolMatiereModelList;

    public MatiereAdapter(List<SchoolMatiereModel> schoolMatiereModelList) {
        this.schoolMatiereModelList = schoolMatiereModelList;
    }


    @NonNull
    @Override
    public MatiereAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from ( viewGroup.getContext () ).inflate ( R.layout.troisieme_matiere_layout ,viewGroup,false);
        return new ViewHolder ( v );
    }

    @Override
    public void onBindViewHolder(@NonNull MatiereAdapter.ViewHolder viewHolder, int position) {
        String name =schoolMatiereModelList.get ( position ).getNomMatiere ();
        int image=schoolMatiereModelList.get ( position ).getImageMAtiere ();
        viewHolder.setNom ( name );
        viewHolder.setimage ( image );
    }

    @Override
    public int getItemCount() {
        return schoolMatiereModelList.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView nom;
        public ViewHolder(@NonNull View itemView) {
            super ( itemView );
            image=itemView.findViewById ( R.id.image_matiere );
            nom=itemView.findViewById ( R.id.titre_matiere );
        }
        public void setimage(int img){
            image.setImageResource ( img );

        }

        public void setNom(final String name){
            nom.setText ( name );
            itemView.setOnClickListener ( new View.OnClickListener () {
                @Override
                public void onClick(View v) {
                    Intent categoryIntent=new Intent ( itemView.getContext (),MatiereChoisie.class );
                    categoryIntent.putExtra ( "categoryName",name );
                    itemView.getContext ().startActivity ( categoryIntent );

                }
            } );

        }
    }

}
