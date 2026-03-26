package br.gov.sp.cps.projetoprovap1.joKenPo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

import br.gov.sp.cps.projetoprovap1.R;
import br.gov.sp.cps.projetoprovap1.joKenPo.ResultScreen;

public class JokenpoMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.jokenpo_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    int vPc = 0;
    int vYou = 0;
    //Selecionado Pedra:
    public void selecPedra(View view){
        this.opcaoSelecionada("pedra");
    }


    //Selecionado Papel:
    public void selecPapel(View view){
        this.opcaoSelecionada("papel");
    }


    //Selecionado Tesoura:
    public void selecTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }


    //Análise das opções selecionadas:
    public void opcaoSelecionada(String opcaoSelecionada){
        ImageView imgResultado = findViewById(R.id.imgResultado);
        TextView textResultado = findViewById(R.id.textResultado);

    // logica - Escolha do PC:
        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};

        String opcaoPC = opcoes[numero];

    switch (opcaoPC){
        case "pedra":
            imgResultado.setImageResource(R.drawable.pedra);
        break;

        case "papel":
            imgResultado.setImageResource(R.drawable.papel);
        break;
        case "tesoura":
            imgResultado.setImageResource(R.drawable.tesoura);
            break;
    }



    //logica do jogo - Analisa quem ganhou e quem perdeu
        TextView textPlacarPc = findViewById(R.id.textPlacarPc);
        TextView textPlacarVc = findViewById(R.id.textPlacarVc);
        if (
                (opcaoPC.equals("tesoura") && opcaoSelecionada.equals("papel")) ||
                        (opcaoPC.equals("papel") && opcaoSelecionada.equals("pedra")) ||
                        (opcaoPC.equals("pedra") && opcaoSelecionada.equals("tesoura"))
        ){
            textResultado.setText("PC WIN - Perdeu vacilão");
            vPc++;
            textPlacarPc.setText(String.valueOf(vPc));
        }else if (
                (opcaoSelecionada.equals("tesoura") && opcaoPC.equals("papel")) ||
                        (opcaoSelecionada.equals("papel") && opcaoPC.equals("pedra")) ||
                        (opcaoSelecionada.equals("pedra") && opcaoPC.equals("tesoura"))
        ) {
            textResultado.setText("YOU WIN - Parabéns otário");
            vYou++;
            textPlacarVc.setText(String.valueOf(vYou));
        }else {
            textResultado.setText("DRAW - BURRO KKKKK");
        }




        if (vPc >= 5 || vYou >= 5) {
            Intent intent = new Intent(JokenpoMain.this, ResultScreen.class);
            intent.putExtra("VPC", vPc);
            intent.putExtra("VYOU", vYou);
            startActivity(intent);
            finish();
        }
        }
    }
