package timika.papua.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<GameList> GameList;
    public CustomListAdapter(Activity activity, List<GameList> GameList) {
        this.activity = activity;
        this.GameList = GameList;
    }
    @Override
    public int getCount() {
        return GameList.size();
    }
    @Override
    public Object getItem(int location) {
        return GameList.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView title = (TextView)
                convertView.findViewById(R.id.text_title);
        TextView genre = (TextView)
                convertView.findViewById(R.id.text_genre);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        GameList m = GameList.get(position);
        title.setText("Title : "+ m.get_title());
        genre.setText("Genre : "+ m.get_genre());
        return convertView;
    }
}