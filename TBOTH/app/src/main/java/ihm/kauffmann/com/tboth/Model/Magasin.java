package ihm.kauffmann.com.tboth.Model;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import ihm.kauffmann.com.tboth.R;

public class Magasin {

    private static List<Magasin> data = null;

    public static List<Magasin> getData() {
        if (data == null) {
            data = new LinkedList<>();
            data.add(new Magasin(0, "ToBeOrToHave\nSophia-Antipolis", R.drawable.m_f0, "+33676128870", "24 rue Lorem Ipsum 06000 Sophia-Antipolis",
                    "contact@tboth-antibes.fr", 43.615735, 7.071853));
            data.add(new Magasin(1, "ToBeOrToHave\nCap 3000", R.drawable.m_f1, "+33676128870", "24 rue Lorem Ipsum 06000 Saint Laurent du Var",
                    "contact@tboth-stlaurent.fr", 43.659214, 7.197474));
            data.add(new Magasin(2, "ToBeOrToHave\nNice", R.drawable.m_f2, "+33676128870", "24 rue Lorem Ipsum 06000 Nice",
                    "contact@tboth-nice.fr", 43.7010818, 7.2668979));
            data.add(new Magasin(3, "ToBeOrToHave\nCagnes-sur-Mer", R.drawable.m_f3, "+33676128870", "24 rue Lorem Ipsum 06000 Cagnes-sur-Mer",
                    "contact@tboth-cannes.fr", 43.665287, 7.127654));
            data.add(new Magasin(4, "ToBeOrToHave\nParis", R.drawable.m_f4, "+33676128870", "24 rue Lorem Ipsum 75000 Paris",
                    "contact@tboth-paris.fr", 48.8416192, 2.3066351));
            data.add(new Magasin(5, "ToBeOrToHave\nLyon", R.drawable.m_f5, "+33676128870", "24 rue Lorem Ipsum 69000 Lyon",
                    "contact@tboth-lyon.fr", 45.761803, 4.855695));
        }
        return data;
    }

    private int id;
    private String name;
    private int imagePath;
    private String phoneNumber;
    private String address;
    private String email;
    private LatLng position;

    public Magasin(int id, String name, int imagePath, String phoneNumber, String address,
                   String email, double lat, double lng) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.position = new LatLng(lat, lng);
    }

    public static HashMap<Produit, HashMap<Integer, Magasin>> getPromotionData() {
        HashMap<Produit, HashMap<Integer, Magasin>> promotions = new HashMap<>();
        List<Magasin> mag = getData();
        List<Produit> prod = Produit.getData();

        HashMap<Integer, Magasin> hm1 = new HashMap<>();
        hm1.put(15, mag.get(0));
        hm1.put(20, mag.get(1));
        promotions.put(prod.get(0), hm1);

        HashMap<Integer, Magasin> hm2 = new HashMap<>();
        hm1.put(10, mag.get(2));
        hm1.put(25, mag.get(3));
        promotions.put(prod.get(1), hm2);

        return promotions;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImagePath() {
        return imagePath;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public LatLng getPosition() {
        return position;
    }
}
