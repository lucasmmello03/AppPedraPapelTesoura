package com.lucasmello.apppedrapapeltesoura;

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

public class MainActivity extends AppCompatActivity {

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
    }

    //Métodos
    public void selecionarPedra(View view){
        verificarGanhador("pedra");
    }

    public void selecionarPapel(View view){
        verificarGanhador("papel");
    }

    public void selecionarTesoura(View view){
        verificarGanhador("tesoura");
    }

    //Método com retorno de string
    private String gerarEscolhaAleatóriaApp() {
        String[] opções = {"pedra", "papel", "tesoura"};

        int numAleatório = new Random().nextInt(3);

        ImageView imagemApp = findViewById(R.id.img_app);

        String escolhaApp = opções[numAleatório];

        switch (escolhaApp) {
            case "pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }
        return escolhaApp;
    }

    private void verificarGanhador( String escolhaUsuario){

        String escolhaApp = gerarEscolhaAleatóriaApp();
        TextView textoResultado = findViewById(R.id.text_resultado);

        if(
                (escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
                (escolhaApp == "papel" && escolhaUsuario== "pedra") ||
                (escolhaApp == "tesoura" && escolhaUsuario == "papel")
        ){//App é vencedor
            textoResultado.setText("Você perdeu :(");

        }else if(
                (escolhaUsuario == "pedra" && escolhaApp == "tesoura") ||
                (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                (escolhaUsuario == "tesoura" && escolhaApp == "papel")
        ){//Usuário é vencedor
            textoResultado.setText("Você ganhou :)");


        }else{//Empate
            textoResultado.setText("Empatamos!");

        }
    }
}