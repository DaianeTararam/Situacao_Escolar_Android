package com.example.calcularmedia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText etNota1;
    private EditText etNota2;
    private TextView tvResposta;
    private TextView tvTitulo;
    private TextView tvMedia;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNota1 = findViewById(R.id.etNota1);
        etNota1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etNota2 = findViewById(R.id.etNota2);
        etNota2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        tvResposta = findViewById(R.id.tvResposta);
        tvResposta.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvTitulo = findViewById(R.id.tvTitulo);
        tvTitulo.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tvMedia = findViewById(R.id.tvMedia);
        tvMedia.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnCalcular.setOnClickListener(op -> calcularMedia());
    }
    private void calcularMedia(){
        double n1 = Double.parseDouble(etNota1.getText().toString());
        double n2 = Double.parseDouble(etNota2.getText().toString());
        double media = (n1 + n2) / 2;
        String situacao = "";
        if (media >= 6){
            situacao = "APROVADO";
        } else{
            situacao = "REPROVADO";
        }
        String resMedia = getString(R.string.tvMedia) + " " + media;
        tvMedia.setText(resMedia);
        String resSituacao = getString(R.string.tvResposta) + " " + situacao;
        tvResposta.setText(resSituacao);
    }
}