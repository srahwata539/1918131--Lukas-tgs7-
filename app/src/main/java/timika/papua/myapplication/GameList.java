package timika.papua.myapplication;

public class GameList {
    private String _id, _title, _genre;
    public GameList(String id, String title, String genre ) {
        this._id = id;
        this._title = title;
        this._genre = genre;
    }
    public GameList() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_title() {
        return _title;
    }
    public void set_title(String _title) {
        this._title = _title;
    }
    public String get_genre() {
        return _genre;
    }
    public void set_genre(String _genre) {
        this._genre = _genre;
    }
}