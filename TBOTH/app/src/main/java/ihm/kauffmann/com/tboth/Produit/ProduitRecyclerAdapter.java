package ihm.kauffmann.com.tboth.Produit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ihm.kauffmann.com.tboth.Model.Produit;
import ihm.kauffmann.com.tboth.R;

public class ProduitRecyclerAdapter extends RecyclerView.Adapter<ProduitViewHolder>{

    private List<Produit> produits;

    public ProduitRecyclerAdapter(List<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public ProduitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.produit_grid_item, parent, false);
        ProduitViewHolder vh = new ProduitViewHolder(v,
                (LinearLayout) v.findViewById(R.id.produit_grid_element_background),
                (ImageView) v.findViewById(R.id.produit_grid_element_image),
                (ImageView) v.findViewById(R.id.produit_grid_element_type),
                (TextView) v.findViewById(R.id.produit_grid_element_text));
        return vh;
    }

    @Override
    public void onBindViewHolder(ProduitViewHolder holder, int position) {
        Produit p = produits.get(position);
        holder.getImage().setImageResource(p.getImagePath());
        holder.getType().setImageResource(p.getCatPath());
        holder.getNom().setText(p.getName());
    }

    @Override
    public int getItemCount() {
        return produits.size();
    }
}
