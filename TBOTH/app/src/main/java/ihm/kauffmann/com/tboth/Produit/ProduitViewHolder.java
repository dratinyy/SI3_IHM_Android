package ihm.kauffmann.com.tboth.Produit;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProduitViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private LinearLayout background;
    private ImageView image;
    private ImageView type;
    private TextView nom;

    private boolean activeState;

    public ProduitViewHolder(View v, LinearLayout background, ImageView image, ImageView type, TextView nom) {
        super(v);
        this.background = background;
        this.image = image;
        this.type = type;
        this.nom = nom;
        this.activeState = false;

        itemView.setOnClickListener(this);
    }

    public ImageView getImage() {
        return image;
    }

    public TextView getNom() {
        return nom;
    }

    public ImageView getType() {
        return type;
    }


    @Override
    public void onClick(View v) {

        if (activeState) {
            background.setBackgroundColor(0);
        } else {
            background.setBackgroundColor(0x4000FF00);
        }
        activeState = !activeState;
    }
}
