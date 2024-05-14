package com.example.a08projetos;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalhesCompraActivity extends AppCompatActivity {
    private TextView textViewCodigo;
    private TextView textViewValorFinal;
    private TextView textViewFuncao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_compra);

        textViewCodigo = findViewById(R.id.textViewCodigo);
        textViewValorFinal = findViewById(R.id.textViewValorFinal);
        textViewFuncao = findViewById(R.id.textViewFuncao);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String codigo = extras.getString("codigo");
            float valorFinal = extras.getFloat("valorFinal");
            String funcao = extras.getString("funcao");

            textViewCodigo.setText("Código (opcional): " + codigo);
            textViewValorFinal.setText("Valor Final: R$" + valorFinal);
            if (funcao != null) {
                textViewFuncao.setText("Função: " + funcao);
            }
        }
    }
}





