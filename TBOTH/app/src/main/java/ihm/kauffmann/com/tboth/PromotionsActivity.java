package ihm.kauffmann.com.tboth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import ihm.kauffmann.com.tboth.Magasin.MagasinRecyclerAdapter;
import ihm.kauffmann.com.tboth.Model.Magasin;
import ihm.kauffmann.com.tboth.Promotion.PromotionRecyclerAdapter;

public class PromotionsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private PromotionRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix);

        Toolbar toolbar = (Toolbar) findViewById(R.id.choix_toolbar);
        setSupportActionBar(toolbar);

        TextView toolbar_text = (TextView) findViewById(R.id.choix_toolbar_text);
        toolbar_text.setText("Choisir des magasins");
        toolbar_text.setTextSize(15);

        ImageButton favorite = (ImageButton) findViewById(R.id.choix_button_favorite);
        favorite.setBackgroundResource(R.drawable.ic_stars_black_24dp);
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ImageButton save_favorite = (ImageButton) findViewById(R.id.choix_button_save);
        save_favorite.setBackgroundResource(R.drawable.ic_save_black_24dp);

        ImageButton ok = (ImageButton) findViewById(R.id.choix_button_ok);
        ok.setBackgroundResource(R.drawable.ic_arrow_forward_black_24dp);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChoixProduits();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.choix_recyclerView);
        mLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new PromotionRecyclerAdapter(Magasin.getPromotionData());
        mRecyclerView.setAdapter(mAdapter);

    }

    private void openChoixProduits() {
        Intent intent = new Intent(this, ChoixProduitActivity.class);
        startActivity(intent);
    }
}
