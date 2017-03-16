package mx.edu.utng.galley;

import android.graphics.Bitmap;

/**
 * Created by Toshiba on 27/02/2017.
 */
public class ImageItem {
    private Bitmap image;
    private String title;


    public ImageItem(Bitmap image, String title) {
        this.image = image;
        this.title = title;
    }

    public ImageItem(){
        this(null, "");
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
