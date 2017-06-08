package ihm.kauffmann.com.tboth.Model;

import android.util.SparseArray;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import ihm.kauffmann.com.tboth.R;

public class Magasin {

    private static List<Magasin> data = null;

    public static List<Magasin> getData() {
        if (data == null) {
            data = new LinkedList<>();
            data.add(new Magasin(0, "ToBeOrToHave\nAntibes", R.drawable.m_f0, "+33 6 58 89 18 58", "24 rue Lorem Ipsum 06000 Antibes",
                    "contact@tboth-antibes.fr", new HashMap<Integer, Produit>()));
            data.add(new Magasin(1, "ToBeOrToHave\nCAP3000", R.drawable.m_f1, "+33 6 58 89 18 58", "24 rue Lorem Ipsum 06000 Saint Laurent du Var",
                    "contact@tboth-stlaurent.fr", new HashMap<Integer, Produit>()));
            data.add(new Magasin(2, "ToBeOrToHave\nNice", R.drawable.m_f2, "+33 6 58 89 18 58", "24 rue Lorem Ipsum 06000 Nice",
                    "contact@tboth-nice.fr", new HashMap<Integer, Produit>()));
            data.add(new Magasin(3, "ToBeOrToHave\nCannes", R.drawable.m_f3, "+33 6 58 89 18 58", "24 rue Lorem Ipsum 06000 Cannes",
                    "contact@tboth-cannes.fr", new HashMap<Integer, Produit>()));
            data.add(new Magasin(4, "ToBeOrToHave\nParis", R.drawable.m_f4, "+33 6 58 89 18 58", "24 rue Lorem Ipsum 75000 Paris",
                    "contact@tboth-paris.fr", new HashMap<Integer, Produit>()));
            data.add(new Magasin(5, "ToBeOrToHave\nLyon", R.drawable.m_f5, "+33 6 58 89 18 58", "24 rue Lorem Ipsum 69000 Lyon",
                    "contact@tboth-lyon.fr", new HashMap<Integer, Produit>()));
        }
        return data;
    }

    private int id;
    private String name;
    private int imagePath;
    private String phoneNumber;
    private String address;
    private String email;
    //private HashMap<Integer, Produit> promotions;

    private boolean Favorite = false;


    public Magasin(int id, String name, int imagePath, String phoneNumber, String address,
                   String email, HashMap<Integer, Produit> promotions) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        //this.promotions = promotions;
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

    public void setFavorite(boolean favorite) {
        Favorite = favorite;
    }
}
