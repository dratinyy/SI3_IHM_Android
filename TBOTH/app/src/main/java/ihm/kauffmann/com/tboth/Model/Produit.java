package ihm.kauffmann.com.tboth.Model;

import java.util.LinkedList;
import java.util.List;

import ihm.kauffmann.com.tboth.R;

public class Produit {

    private static List<Produit> data = null;

    public static List<Produit> getData() {
        if (data == null) {
            data = new LinkedList<>();
            data.add(new Produit(0, "Coffret Zen", R.drawable.p_c1, CategorieProduit.CD));
            data.add(new Produit(1, "Relaxation", R.drawable.p_c2, CategorieProduit.CD));
            data.add(new Produit(2, "Méditation", R.drawable.p_c3, CategorieProduit.CD));

            data.add(new Produit(3, "Le Yoga facile", R.drawable.p_d1, CategorieProduit.DVD));
            data.add(new Produit(4, "Massage Tradition", R.drawable.p_d2, CategorieProduit.DVD));
            data.add(new Produit(5, "Bien-être au réveil", R.drawable.p_d3, CategorieProduit.DVD));

            data.add(new Produit(6, "Vivez Mieux", R.drawable.p_l1, CategorieProduit.Livre));
            data.add(new Produit(7, "Yoga Méditation", R.drawable.p_l2, CategorieProduit.Livre));
            data.add(new Produit(8, "Massage Chinois", R.drawable.p_l3, CategorieProduit.Livre));

            data.add(new Produit(9, "Relaxation", R.drawable.p_s1, CategorieProduit.Stage));
            data.add(new Produit(10, "Bien-être", R.drawable.p_s2, CategorieProduit.Stage));
            data.add(new Produit(11, "Bien-être et Nature", R.drawable.p_s3, CategorieProduit.Stage));
        }
        return data;
    }

    private int id;
    private String name;
    private int imagePath;
    private CategorieProduit cat;

    public Produit(int id, String name, int imagePath, CategorieProduit cat) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.cat = cat;
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

    public int getCatPath() {
        return cat.getImagePath();
    }
}
