package com.example.pratica2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class ResultadoActivity extends AppCompatActivity {

    private TextView textViewNome;
    private TextView textViewIdade;
    private TextView textViewPeso;
    private TextView textViewAltura;
    private TextView textViewIMC;
    private TextView textViewClassificacao;
    private Button buttonNovoCalculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        textViewNome = findViewById(R.id.textViewNome);
        textViewIdade = findViewById(R.id.textViewIdade);
        textViewPeso = findViewById(R.id.textViewPeso);
        textViewAltura = findViewById(R.id.textViewAltura);
        textViewIMC = findViewById(R.id.textViewIMC);
        textViewClassificacao = findViewById(R.id.textViewClassificacao);
        buttonNovoCalculo = findViewById(R.id.buttonNovoCalculo);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        int idade = intent.getIntExtra("idade", 0);
        double peso = intent.getDoubleExtra("peso", 0.0);
        double altura = intent.getDoubleExtra("altura", 0.0);

        textViewNome.setText("Nome: " + nome);
        textViewIdade.setText("Idade: " + idade);
        textViewPeso.setText("Peso: " + new DecimalFormat("#.##").format(peso) + " kg");
        textViewAltura.setText("Altura: " + new DecimalFormat("#.##").format(altura) + " m");

        double imc = calcularIMC(peso, altura);
        String classificacao = classificarIMC(imc);

        textViewIMC.setText("IMC: " + new DecimalFormat("#.##").format(imc));
        textViewClassificacao.setText("Classificação: " + classificacao);

        buttonNovoCalculo.setOnClickListener(v -> finish());
    }

    private double calcularIMC(double peso, double altura) {
        if (altura == 0.0) return 0.0;
        return peso / (altura * altura);
    }

    private String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do Peso";
        } else if (imc < 25) {
            return "Saudável";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else if (imc < 35) {
            return "Obesidade Grau I";
        } else if (imc < 40) {
            return "Obesidade Grau II (severa)";
        } else {
            return "Obesidade Grau III (mórbida)";
        }
    }
}