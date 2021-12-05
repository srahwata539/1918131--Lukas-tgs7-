package timika.papua.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Etitle, Egenre;
    private String Stitle, Sgenre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Etitle = (EditText) findViewById(R.id.create_title);
        Egenre = (EditText) findViewById(R.id.create_genre);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Stitle = String.valueOf(Etitle.getText());
                Sgenre = String.valueOf(Egenre.getText());
                if (Stitle.equals("")){
                    Etitle.requestFocus();
                    Toast.makeText(MainCreate.this, "Insert Game Title",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sgenre.equals("")) {
                    Egenre.requestFocus();
                    Toast.makeText(MainCreate.this, "Inser Game Genre",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Etitle.setText("");
                    Egenre.setText("");
                    Toast.makeText(MainCreate.this, "Data has been added",
                            Toast.LENGTH_SHORT).show();
                    db.CreateGameList(new GameList(null, Stitle,
                            Sgenre));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}