package timika.papua.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<GameList> ListGameList = new ArrayList<GameList>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListGameList
        );
        mListView = (ListView) findViewById(R.id.list_game);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListGameList.clear();
        List<GameList> gamelist = db.ReadGameList();
        for (GameList game : gamelist) {
            GameList daftar = new GameList();
            daftar.set_id(game.get_id());
            daftar.set_title(game.get_title());
            daftar.set_genre(game.get_genre());
            ListGameList.add(daftar);
            if ((ListGameList.isEmpty()))
                Toast.makeText(MainRead.this, "Data not found",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        GameList detailGame = (GameList) o;
        String Sid = detailGame.get_id();
        String Stitle = detailGame.get_title();
        String Sgenre = detailGame.get_genre();
        Intent goUpdel = new Intent(MainRead.this,
                MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Ititle", Stitle);
        goUpdel.putExtra("Igenre", Sgenre);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListGameList.clear();
        mListView.setAdapter(adapter_off);
        List<GameList> gamelist = db.ReadGameList();
        for (GameList game : gamelist) {
            GameList daftar = new GameList();
            daftar.set_id(game.get_id());
            daftar.set_title(game.get_title());
            daftar.set_genre(game.get_genre());
            ListGameList.add(daftar);
            if ((ListGameList.isEmpty()))
                Toast.makeText(MainRead.this, "Data Not Found",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
