package fr.leo.androidmonapplicationtest1.vue;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import fr.leo.androidmonapplicationtest1.R;
import fr.leo.androidmonapplicationtest1.controleur.Controleur;

public class MainActivity extends AppCompatActivity {

    private RadioButton rBtnHomme ;
    private RadioButton rBtnFemme ;
    private EditText  edtNom ;
    private EditText edtPrenom ;
    private TextView mlTxtRes;
    private Button btnTraiter;
    private Button btnPageSuivante ;
    private ImageView idPicture;
    private Controleur monControleur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        this.monControleur = Controleur.getMonInstance();
    }

    private void init(){
        rBtnHomme = findViewById(R.id.rBtnHomme);
        rBtnFemme = (RadioButton) findViewById(R.id.rBtnFemme);
        edtNom = (EditText) findViewById(R.id.edtNom);
        edtPrenom = (EditText) findViewById(R.id.edtPrenom);
        mlTxtRes = (TextView) findViewById(R.id.mlTxtRes);
        idPicture = (ImageView) findViewById(R.id.idPicture);
        btnPageSuivante = (Button) findViewById(R.id.btnPageSuivante);

        btnPageSuivante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                  MainActivity.this, SecondeFenetre.class
                );
                intent.putExtra("message", "voila le message parvenu de la fenetre 1");
                startActivityForResult(intent , 1234);
            }
        });
        ecouterEnvoyer();
    }
    public void testClick (View v){
        String maChaine = edtNom.getText().toString();
        Toast.makeText(this, maChaine, Toast.LENGTH_SHORT).show();
    }

    private void ecouterEnvoyer(){
        Button clickButton = (Button) findViewById(R.id.btnTraiter);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String lenom = edtNom.getText().toString();
                    String lePrenom = edtPrenom.getText().toString();
                    String sexe = "";
                    if (rBtnHomme.isChecked()){
                        sexe = "homme";
                    }else{
                        sexe = "femme";
                    }                        ;
                    affichage(sexe,lenom,lePrenom);
            };
        });
    }

    public void affichage(String strSexe, String strNom, String strPrenom){
        this.monControleur.creerPersonne(strSexe,strNom,strPrenom);
        if (strSexe.equals("homme")){
            mlTxtRes.setText("Bonjour Monsieur " + strNom);
            idPicture.setImageResource(R.drawable.homme);
        }else {
            mlTxtRes.setText("Bonjour Madame " + strNom);
            idPicture.setImageResource(R.drawable.femme);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1234){
            mlTxtRes.setText("Résultat : " + resultCode);
        }
    }
}
