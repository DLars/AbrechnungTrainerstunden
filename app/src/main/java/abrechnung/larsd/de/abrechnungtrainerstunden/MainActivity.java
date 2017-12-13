package abrechnung.larsd.de.abrechnungtrainerstunden;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase md = FirebaseDatabase.getInstance();
        DatabaseReference myRef = md.getReference();

        DatabaseReference auch = myRef.child("Test");
        auch.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Toast t = Toast.makeText(getApplicationContext(), dataSnapshot.getValue(String.class), Toast.LENGTH_LONG);
                t.show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
