package timika.papua.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_1918122";
    private static final String tb_gamelist = "tb_gamelist";
    private static final String tb_gamelist_id = "id";
    private static final String tb_gamelist_title = "title";
    private static final String tb_gamelist_genre = "genre";
    private static final String CREATE_TABLE_GAMELIST = "CREATE TABLE " +
            tb_gamelist +"("
            + tb_gamelist_id + " INTEGER PRIMARY KEY ,"
            + tb_gamelist_title + " TEXT ,"
            + tb_gamelist_genre + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_GAMELIST);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateGameList (GameList data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_gamelist_id, data.get_id());
        values.put(tb_gamelist_title, data.get_title());
        values.put(tb_gamelist_genre, data.get_genre());
        db.insert(tb_gamelist, null, values);
        db.close();
    }
    public List<GameList> ReadGameList() {
        List<GameList> listGame = new ArrayList<GameList>();
        String selectQuery = "SELECT * FROM " + tb_gamelist;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                GameList data = new GameList();
                data.set_id(cursor.getString(0));
                data.set_title(cursor.getString(1));
                data.set_genre(cursor.getString(2));
                listGame.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listGame;
    }
    public int UpdateGameList (GameList data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_gamelist_title, data.get_title());
        values.put(tb_gamelist_genre, data.get_genre());
        return db.update(tb_gamelist, values, tb_gamelist_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteGameList(GameList data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_gamelist,tb_gamelist_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}