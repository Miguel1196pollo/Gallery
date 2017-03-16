package mx.edu.utng.galley;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by Toshiba on 27/02/2017.
 */
public class GalleryFragment extends Fragment {
    private GridView gvPhotos;
    private GridViewAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.gallery_fragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        gvPhotos = (GridView) getView().findViewById(R.id.gv_photos);
        adapter = new GridViewAdapter(getActivity(),R.layout.item_layout, getData());
        gvPhotos.setAdapter(adapter);

        gvPhotos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageItem item = (ImageItem) parent.getItemAtPosition(position);

                Intent intent = new Intent(getActivity(),ShowImageActivity.class );
                intent.putExtra("title", item.getTitle());
                intent.putExtra("image", item.getImage());
                startActivity(intent);
            }
        });
    }

    private ArrayList<ImageItem> getData(){
     final ArrayList<ImageItem> images = new ArrayList<>();
        TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);

        for (int i = 0;i < imgs.length(); i++){
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imgs.getResourceId(i, -1));
            images.add(new ImageItem(bitmap, "Photo "+i));

        }
        return images;

    }
}
