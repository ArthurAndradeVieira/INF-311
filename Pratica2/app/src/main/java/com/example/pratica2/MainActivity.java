package com.example.pratica2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextIdade;
    private EditText editTextPeso;
    private EditText editTextAltura;
    private Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        editTextIdade = findViewById(R.id.editTextIdade);
        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);
        buttonCalcular = findViewById(R.id.buttonCalcular);

        buttonCalcular.setOnClickListener(v -> {
            String nome = editTextNome.getText().toString();
            int idade;
            double peso;
            double altura;

            try {
                idade = Integer.parseInt(editTextIdade.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Idade inválida", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                peso = Double.parseDouble(editTextPeso.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Peso inválido", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                altura = Double.parseDouble(editTextAltura.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Altura inválida", Toast.LENGTH_SHORT).show();
                return;
            }

            if (altura == 0.0) {
                Toast.makeText(this, "Altura não pode ser zero", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, ResultadoActivity.class);
            intent.putExtra("nome", nome);
            intent.putExtra("idade", idade);
            intent.putExtra("peso", peso);
            intent.putExtra("altura", altura);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        limparCampos();
    }

    private void limparCampos() {
        editTextNome.setText("");
        editTextIdade.setText("");
        editTextPeso.setText("");
        editTextAltura.setText("");
    }
}