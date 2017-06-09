package ihm.kauffmann.com.tboth;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;

import ihm.kauffmann.com.tboth.Model.Magasin;
import ihm.kauffmann.com.tboth.Model.Produit;

public class FicheMagasinActivity extends AppCompatActivity implements OnMapReadyCallback {

    private Magasin m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_magasin);
        m = Magasin.getData().get(Integer.parseInt(getIntent().getStringExtra("position")));

        TextView toolbar_text = (TextView) findViewById(R.id.fiche_magasin_toolbar_text);
        toolbar_text.setText(m.getName());
        toolbar_text.setTextSize(20);

        ImageButton favorite = (ImageButton) findViewById(R.id.fiche_magasin_button_favorite);
        favorite.setBackgroundResource(R.drawable.ic_stars_black_24dp);

        ImageView image = (ImageView) findViewById(R.id.fiche_magasin_image);
        image.setImageResource(m.getImagePath());

        TextView tel_text = (TextView) findViewById(R.id.fiche_magasin_telephone);
        tel_text.setText(m.getPhoneNumber());
        tel_text.setTextSize(24);

        ImageButton call = (ImageButton) findViewById(R.id.fiche_magasin_button_call);
        call.setBackgroundResource(R.drawable.ic_call_black_24dp);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + m.getPhoneNumber()));
                startActivity(intent);
            }
        });

        ImageButton message = (ImageButton) findViewById(R.id.fiche_magasin_button_message);
        message.setBackgroundResource(R.drawable.ic_message_black_24dp);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:" + m.getPhoneNumber());
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                Produit p = Produit.getData().get(0);
                intent.putExtra("sms_body", "Bonjour,\npourriez-vous me mettre de côté 1 " + p.getName() + " je vous prie ? Merci d'avance, et bonne journée !");
                startActivity(intent);
            }
        });

        ImageButton question = (ImageButton) findViewById(R.id.fiche_magasin_button_question);
        question.setBackgroundResource(R.drawable.ic_question_answer_black_24dp);
        question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:" + m.getPhoneNumber());
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                Produit p = Produit.getData().get(0);
                intent.putExtra("sms_body", "Bonjour,\nj'aimerais connaître la quantité de " + p.getName() + " qui est disponible. Merci d'avance, et bonne journée !");
                startActivity(intent);
            }
        });

        TextView adresse_text = (TextView) findViewById(R.id.fiche_magasin_adresse);
        adresse_text.setText(m.getAddress());
        adresse_text.setTextSize(24);

        TextView mail_text = (TextView) findViewById(R.id.fiche_magasin_mail);
        mail_text.setText(m.getEmail());
        mail_text.setTextSize(24);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.fiche_magasin_fragment_gmaps);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        for (Magasin mag : Magasin.getData()) {
            if (mag.equals(m))
                googleMap.addMarker(new MarkerOptions().position(mag.getPosition()).title(mag.getName()))
                        .setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
            else
                googleMap.addMarker(new MarkerOptions().position(mag.getPosition()).title(mag.getName()));
        }
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(m.getPosition(), 15.0f));
    }
}
