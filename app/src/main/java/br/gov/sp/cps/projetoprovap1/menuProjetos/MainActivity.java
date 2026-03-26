package br.gov.sp.cps.projetoprovap1.menuProjetos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.gov.sp.cps.projetoprovap1.R;
import br.gov.sp.cps.projetoprovap1.imc.MainImc;
import br.gov.sp.cps.projetoprovap1.joKenPo.JokenpoMain;

public class MainActivity extends AppCompatActivity {

    private Button btnImc, btnJoKenPo, btnQuestionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnQuestionario = findViewById(R.id.btnQuestionario);
        btnImc = findViewById(R.id.btnImc);
        btnJoKenPo = findViewById(R.id.btnJoKenPo);

        btnQuestionario.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, QuestionaryScreen.class);
            startActivity(intent);
            finish();
        });

        btnImc.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, MainImc.class);
            startActivity(intent);
            finish();
        });

        btnJoKenPo.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, JokenpoMain.class);
            startActivity(intent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}