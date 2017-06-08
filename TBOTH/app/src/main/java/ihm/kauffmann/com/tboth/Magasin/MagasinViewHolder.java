package ihm.kauffmann.com.tboth.Magasin;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MagasinViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private LinearLayout background;
    private ImageView image;
    private TextView nom;

    private boolean activeState;

    public MagasinViewHolder(View v, LinearLayout background, ImageView image, TextView nom) {
        super(v);
        this.background = background;
        this.image = image;
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
