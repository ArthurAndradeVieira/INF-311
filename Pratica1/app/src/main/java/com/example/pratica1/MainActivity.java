package com.example.pratica1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText entrada1, entrada2;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entrada1 = findViewById(R.id.entrada1);
        entrada2 = findViewById(R.id.entrada2);
        resultado = findViewById(R.id.result);

        Button botaoSoma = findViewById(R.id.botaoSoma);
        Button botaoSubtracao = findViewById(R.id.botaoSubtracao);
        Button botaoMultiplicacao = findViewById(R.id.botaoMultiplicacao);
        Button botaoDivisao = findViewById(R.id.botaoDivisao);

        botaoSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacao("+");
            }
        });

        botaoSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacao("-");
            }
        });

        botaoMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacao("*");
            }
        });

        botaoDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacao("/");
            }
        });
    }

    private void realizarOperacao(String operacao) {
        String textoValor1 = entrada1.getText().toString();
        String textoValor2 = entrada2.getText().toString();

        if (!textoValor1.isEmpty() && !textoValor2.isEmpty()) {
            double valor1 = Double.parseDouble(textoValor1);
            double valor2 = Double.parseDouble(textoValor2);
            double resultadoFinal = 0;

            switch (operacao) {
                case "+":
                    resultadoFinal = valor1 + valor2;
                    break;
                case "-":
                    resultadoFinal = valor1 - valor2;
                    break;
                case "*":
                    resultadoFinal = valor1 * valor2;
                    break;
                case "/":
                    if (valor2 != 0) {
                        resultadoFinal = valor1 / valor2;
                    } else {
                        resultado.setText("Erro: Divisão por zero");
                        return;
                    }
                    break;
                default:
                    break;
            }

            resultado.setText("Resultado: " + resultadoFinal);
        } else {
            resultado.setText("Por favor, insira números válidos");
        }
    }
}