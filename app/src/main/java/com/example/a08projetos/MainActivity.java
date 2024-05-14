package com.example.a08projetos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a08projetos.model.Ingresso;
import com.example.a08projetos.model.IngressoVIP;

public class MainActivity extends AppCompatActivity {
    private EditText editTextCodigo;
    private EditText editTextValor;
    private EditText editTextFuncao;
    private Button buttonComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCodigo = findViewById(R.id.editTextCodigo);
        editTextValor = findViewById(R.id.editTextValor);
        editTextFuncao = findViewById(R.id.editTextFuncao);
        buttonComprar = findViewById(R.id.buttonComprar);

        buttonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprarIngresso();
            }
        });
    }

    private void comprarIngresso() {
        String codigo = editTextCodigo.getText().toString();
        float valor = Float.parseFloat(editTextValor.getText().toString());
        String funcao = editTextFuncao.getText().toString();

        Ingresso ingresso;
        if (funcao.isEmpty()) {
            ingresso = new Ingresso(codigo, valor);
        } else {
            ingresso = new IngressoVIP(codigo, valor, funcao);
        }

        // Supondo uma taxa de conveniência fixa de R$ 5
        float taxaConveniencia = 5.0f;
        float valorFinal = ingresso.valorFinal(taxaConveniencia);

        Intent intent = new Intent(MainActivity.this, DetalhesCompraActivity.class);
        intent.putExtra("codigo", ingresso.getCodigoIdentificador());
        intent.putExtra("valorFinal", valorFinal);
        if (ingresso instanceof IngressoVIP) {
            intent.putExtra("funcao", ((IngressoVIP) ingresso).getFuncao());
        }
        startActivity(intent);
    }
}






