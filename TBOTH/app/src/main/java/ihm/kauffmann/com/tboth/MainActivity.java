package ihm.kauffmann.com.tboth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView logo;
    private Button promotions;
    private Button fidelite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = (ImageView) findViewById(R.id.logo);
        logo.setImageResource(R.drawable.logo);

        promotions = (Button) findViewById(R.id.promo_button);
        promotions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPromotions();
            }
        });

        fidelite = (Button) findViewById(R.id.fidelite_button);
        fidelite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFidelite();
            }
        });
    }

    private void openPromotions() {
        Intent intent = new Intent(this, ChoixMagasinActivity.class);
        startActivity(intent);
    }

    private void openFidelite() {
        Intent intent = new Intent(this, FideliteActivity.class);
        startActivity(intent);
    }
}
