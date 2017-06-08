package ihm.kauffmann.com.tboth.Promotion;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

import ihm.kauffmann.com.tboth.Model.Magasin;
import ihm.kauffmann.com.tboth.Model.Produit;
import ihm.kauffmann.com.tboth.R;

public class PromotionRecyclerAdapter extends RecyclerView.Adapter<PromotionViewHolder>{

    private final HashMap<Produit, HashMap<Integer, Magasin>> promotions;

    public PromotionRecyclerAdapter(HashMap<Produit, HashMap<Integer, Magasin>> promotions) {
        this.promotions = promotions;
    }

    @Override
    public PromotionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.promotion_list_item, parent, false);
        PromotionViewHolder vh = new PromotionViewHolder(v,
                (ImageView) v.findViewById(R.id.produit_grid_element_image),
                (ImageView) v.findViewById(R.id.produit_grid_element_type),
                (TextView) v.findViewById(R.id.produit_grid_element_text));
        return vh;
    }

    @Override
    public void onBindViewHolder(PromotionViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return promotions.size();
    }
}
