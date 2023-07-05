package com.example.frenchforeignlegion.supporting;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.frenchforeignlegion.R;
import java.util.List;

/**
 * @author Belitski Marat
 * @date 04.07.2023
 */
public class SpinnerAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<Languages> list;

    public SpinnerAdapter(Context context, int layout, List<Languages> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    public Context getContext() {
        return context;
    }

    public int getLayout() {
        return layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Languages newList = list.get(position);
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();

        @SuppressLint("ViewHolder")
        View spinner_layout = inflater.inflate(R.layout.layout_spinner, parent, false);

        TextView text = spinner_layout.findViewById(R.id.spinner_text);
        text.setText(newList.getNameLanguage());

        ImageView image  = spinner_layout.findViewById(R.id.spinner_image);
        image.setImageResource(newList.getImageLanguage());

        return spinner_layout;
    }
}
