package ihm.kauffmann.com.tboth.Magasin;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ihm.kauffmann.com.tboth.Model.Magasin;
import ihm.kauffmann.com.tboth.R;

public class MagasinRecyclerAdapter extends RecyclerView.Adapter<MagasinViewHolder>{

    private List<Magasin> magasins;

    public MagasinRecyclerAdapter(List<Magasin> magasins) {
        this.magasins = magasins;
    }

    @Override
    public MagasinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.magasin_grid_item, parent, false);
        MagasinViewHolder vh = new MagasinViewHolder(v,
                (LinearLayout) v.findViewById(R.id.magasin_grid_element_background),
                (ImageView) v.findViewById(R.id.magasin_grid_element_image),
                (TextView) v.findViewById(R.id.magasin_grid_element_text));
        return vh;
    }

    @Override
    public void onBindViewHolder(MagasinViewHolder holder, int position) {
        Magasin m = magasins.get(position);
        holder.getImage().setImageResource(m.getImagePath());
        holder.getNom().setText(m.getName());
    }

    @Override
    public int getItemCount() {
        return magasins.size();
    }

}
