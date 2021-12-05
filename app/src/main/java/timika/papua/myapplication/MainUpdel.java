package timika.papua.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Stitle, Sgenre;
    private EditText Etitle, Egenre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Stitle = i.getStringExtra("Inama");
        Sgenre = i.getStringExtra("Ikelas");
        Etitle = (EditText) findViewById(R.id.updel_title);
        Egenre = (EditText) findViewById(R.id.updel_genre);
        Etitle.setText(Stitle);
        Egenre.setText(Sgenre);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stitle = String.valueOf(Etitle.getText());
                Sgenre  = String.valueOf(Egenre.getText());
                if (Stitle.equals("")){
                    Etitle.requestFocus();
                    Toast.makeText(MainUpdel.this, "Input Game Title",
                            Toast.LENGTH_SHORT).show();
                } else if (Sgenre.equals("")){
                    Egenre.requestFocus();
                    Toast.makeText(MainUpdel.this, "Input Game Genre",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateGameList(new GameList(Sid, Stitle,
                            Sgenre));
                    Toast.makeText(MainUpdel.this, "Data has been update",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteGameList(new GameList(Sid, Stitle,
                        Sgenre));
                Toast.makeText(MainUpdel.this, "Data has been deleted",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}