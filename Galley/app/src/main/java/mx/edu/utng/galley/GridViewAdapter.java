package mx.edu.utng.galley;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Toshiba on 27/02/2017.
 */
public class GridViewAdapter extends ArrayAdapter<ImageItem> {
    private Context context;
    private int resource;
    private ArrayList<ImageItem> data = new ArrayList<ImageItem>();


    public GridViewAdapter(Context context, int resource, ArrayList<ImageItem> data) {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

     @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)  {

         View rowView = convertView;
         ViewHolder holder;

        if (rowView == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            rowView = inflater.inflate(resource, parent, false);
            holder = new ViewHolder();
            holder.tvTitle = (TextView)rowView.findViewById(R.id.tv_title);
            holder.ivPhoto = (ImageView)rowView.findViewById(R.id.iv_photo);
            rowView.setTag(holder);
        }else{
            holder = (ViewHolder) rowView.getTag();
        }
         ImageItem item = data.get(position);
         holder.ivPhoto.setImageBitmap(item.getImage());
         holder.tvTitle.setText(item.getTitle());

         return rowView;
     }

    static class ViewHolder{
        TextView tvTitle;
        ImageView ivPhoto;

    }
}
