package ihm.kauffmann.com.tboth.Model;

import ihm.kauffmann.com.tboth.R;

enum CategorieProduit {

    CD(R.drawable.ic_album_black_24dp),
    DVD(R.drawable.ic_play_circle_filled_black_24dp),
    Livre(R.drawable.ic_library_books_black_24dp),
    Stage(R.drawable.ic_group_black_24dp);

    private int imagePath;

    private CategorieProduit(int imagePath) {
        this.imagePath = imagePath;
    }

    public int getImagePath() {
        return imagePath;
    }

    public String getName() {
        return name();
    }
}
