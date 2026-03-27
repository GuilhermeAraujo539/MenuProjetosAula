package br.gov.sp.cps.projetoprovap1.menuProjetos;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.gov.sp.cps.projetoprovap1.R;

public class QuestionaryScreen extends AppCompatActivity {

    private CheckBox cbTrabalho, cbEstudo, cbFolga;
    private RadioButton rbSono1, rbSono2, rbSono3, rbStress1, rbStress2, rbStress3;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.questionary_screen);

        cbTrabalho = findViewById(R.id.cbTrabalho);
        cbEstudo = findViewById(R.id.cbEstudo);
        cbFolga = findViewById(R.id.cbFolga);

        rbSono1 = findViewById(R.id.rbSono1);
        rbSono2 = findViewById(R.id.rbSono2);
        rbSono3 = findViewById(R.id.rbSono3);

        rbStress1 = findViewById(R.id.rbStress1);
        rbStress2 = findViewById(R.id.rbStress2);
        rbStress3 = findViewById(R.id.rbStress3);

        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(v -> {
            calcularFelicidade();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.questionary), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void calcularFelicidade() {
        int pesoSono = 0;
        if (rbSono1.isChecked()) {
            pesoSono = 1;
        } else if (rbSono2.isChecked()) {
            pesoSono = 2;
        } else if (rbSono3.isChecked()) {
            pesoSono = 3;
        } else {
            Toast.makeText(this, "Selecione as horas de sono", Toast.LENGTH_SHORT).show();
            return;
        }

        int pesoEstresse = 0;
        if (rbStress1.isChecked()) {
            pesoEstresse = 3;
        } else if (rbStress2.isChecked()) {
            pesoEstresse = 2;
        } else if (rbStress3.isChecked()) {
            pesoEstresse = 1;
        } else {
            Toast.makeText(this, "Selecione o nível de estresse", Toast.LENGTH_SHORT).show();
            return;
        }

        double felicidade = ((pesoSono + pesoEstresse) / 6.0) * 10;

        String classificacao = "";
        if (felicidade >= 0.0 && felicidade <= 2.0) {
            classificacao = "Muito Baixa (Alerta crítico)";
        } else if (felicidade > 2.1 && felicidade <= 4.0) {
            classificacao = "Baixa (Equilíbrio precário)";
        } else if (felicidade > 4.1 && felicidade <= 6.0) {
            classificacao = "Moderada (Estado neutro)";
        } else if (felicidade > 6.1 && felicidade <= 8.0) {
            classificacao = "Alta (Bom equilíbrio)";
        } else if (felicidade > 8.1 && felicidade <= 10.0) {
            classificacao = "Plena (Estado ideal)";
        } else {
            classificacao = "Valor inválido";
        }

        String mensagem = String.format("Classificação: %s", classificacao);

        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}