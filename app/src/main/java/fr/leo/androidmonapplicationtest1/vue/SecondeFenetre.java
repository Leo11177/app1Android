package fr.leo.androidmonapplicationtest1.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fr.leo.androidmonapplicationtest1.R;

public class SecondeFenetre extends AppCompatActivity {

    private EditText edtName ;
    private Button btnValider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconde_fenetre);

        edtName = (EditText) findViewById(R.id.edtName);
        btnValider = (Button) findViewById(R.id.btnValider);

        String inputData = this.getIntent().getExtras().getString("message");
        edtName.setText(inputData);

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               setResult(30);
               finish();
            }
        });

    }
}
