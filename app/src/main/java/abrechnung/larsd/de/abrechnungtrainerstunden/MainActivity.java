package abrechnung.larsd.de.abrechnungtrainerstunden;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    //Variablen für Bedienelemente
    TextView tv_summe, tv_stunden;
    Button btn_neu, btn_liste, btn_settings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void initalisiere() {

        //Variablen IDs zuweisen
        tv_summe = (TextView) findViewById(R.id.tv_Summe);
        tv_stunden = (TextView) findViewById(R.id.tv_Stunden);
        btn_liste = (Button) findViewById(R.id.btn_liste);
        btn_neu = (Button) findViewById(R.id.btn_neu);
        btn_settings = (Button) findViewById(R.id.btn_settings);

        //OnClickListener hinzufuegen
        btn_liste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Liste.class);
                startActivity(intent);
            }
        });

        btn_neu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Neu.class);
                startActivity(intent);
            }
        });

        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Settings.class);
                startActivity(intent);
            }
        });

        //tvs initalisieren
        SharedPreferences pref = getSharedPreferences("Speicher", 0);
        tv_stunden.setText(pref.getString("Stunden", "0 Stunden"));
        tv_summe.setText(pref.getString("Summe", "0 Euro"));
    }
}
