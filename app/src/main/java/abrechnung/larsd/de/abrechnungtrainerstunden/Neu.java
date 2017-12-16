package abrechnung.larsd.de.abrechnungtrainerstunden;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Neu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neu);
    }

    public void speichern(String pDatum, double pZeit, double pLohn){
        SharedPreferences pref = getSharedPreferences("Speicher", 0);
        String speicher = Integer.toString(pref.getInt("Speicher", 0));

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child(speicher);
        ref.setValue(new Einheit(pDatum, pZeit, pLohn));
    }
}
