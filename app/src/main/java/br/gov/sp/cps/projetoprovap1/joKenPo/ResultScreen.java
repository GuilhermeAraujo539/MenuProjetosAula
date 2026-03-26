package br.gov.sp.cps.projetoprovap1.joKenPo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import br.gov.sp.cps.projetoprovap1.joKenPo.JokenpoMain;

import androidx.appcompat.app.AppCompatActivity;

import br.gov.sp.cps.projetoprovap1.R;

public class ResultScreen extends AppCompatActivity {

    int vPc;
    int vYou;
    ImageView imgResultado;
    TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_screen);

        vPc = getIntent().getIntExtra("VPC", 0);
        vYou = getIntent().getIntExtra("VYOU", 0);

        imgResultado = findViewById(R.id.imgRFinal);
        textResultado = findViewById(R.id.textRfinal);

        mostrarResultado();
    }

    public void mostrarResultado() {

        if (vPc >= 5) {
            textResultado.setText("Um COMPUTADOR tem mais sorte que vc HAHAHA");
            textResultado.setTextColor(Color.parseColor("#f00000"));
            imgResultado.setImageResource(R.drawable.simptons);

        } else if (vYou >= 5) {
            textResultado.setText("Você ganhou, eu admito ;-;");
            textResultado.setTextColor(Color.parseColor("#008000"));
            imgResultado.setImageResource(R.drawable.choro);
        }
    }

    public void reset(View view){
        Intent intent = new Intent(ResultScreen.this, JokenpoMain.class);
        startActivity(intent);
        finish();
    }
}