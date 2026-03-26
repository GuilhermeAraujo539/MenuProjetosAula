package br.gov.sp.cps.projetoprovap1.imc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import br.gov.sp.cps.projetoprovap1.R;

public class MainImc extends AppCompatActivity {

    private EditText textPeso;
    private EditText textAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.imc_screen1);

        textPeso = findViewById(R.id.textPeso);
        textAltura = findViewById(R.id.textAltura);

        Log.i("DEBUG", "MainImc loaded");
        Log.i("DEBUG", "textPeso: " + textPeso);
        Log.i("DEBUG", "textAltura: " + textAltura);
    }

    public void calcular(View view) {

        String sPeso = textPeso.getText().toString().trim();
        String sAltura = textAltura.getText().toString().trim();

        if (sPeso.isEmpty() || sAltura.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            return;
        }

        double peso, altura;

        try {
            peso = Double.parseDouble(sPeso);
            altura = Double.parseDouble(sAltura);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Valores inválidos!", Toast.LENGTH_SHORT).show();
            return;
        }

        double imc = calcularIMC(peso, altura);

        Log.i("DEBUG", "Peso: " + peso + " Altura: " + altura + " IMC: " + imc);

        Intent intent;
        if (imc < 18.5) {
            intent = new Intent(this, ImcResult1.class);
        } else if (imc < 25) {
            intent = new Intent(this, ImcResult2.class);
        } else {
            intent = new Intent(this, ImcResult3.class);
        }

        intent.putExtra("imc", imc);

        startActivity(intent);
    }

    private double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }
}