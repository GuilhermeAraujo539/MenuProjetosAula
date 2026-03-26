package br.gov.sp.cps.projetoprovap1.imc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.gov.sp.cps.projetoprovap1.R;

public class ImcResult1 extends AppCompatActivity {

    private Button btnChamaT1;
    private TextView textValores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Ciclo Vida", "T2-onCreate");

        EdgeToEdge.enable(this);
        setContentView(R.layout.imc_screen2);

        btnChamaT1 = findViewById(R.id.btnChamaT1);
        textValores = findViewById(R.id.textValores);

        // Recebe o IMC da MainActivity1
        double imc = getIntent().getDoubleExtra("imc", 0);

        // Mostra o valor do IMC
        textValores.setText("IMC: " + String.format("%.2f", imc));

        // Botão voltar
        btnChamaT1.setOnClickListener(view -> {
            Intent intent = new Intent(ImcResult1.this, MainImc.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ciclo Vida", "T2-onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Ciclo Vida", "T2-onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Ciclo Vida", "T2-onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo Vida", "T2-onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo Vida", "T2-onRestart");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo Vida", "T2-onDestroy");
    }
}