package com.denniseckerskorn.tema03ejercicio03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.denniseckerskorn.tema03ejercicio03.modelos.HeadTailsGame;
import com.denniseckerskorn.tema03ejercicio03.modelos.HeadTailsGame.CoinSide;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlazar elementos de la interfaz de usuario:
        ImageView ivCoin = findViewById(R.id.ivCoin);
        Button bHead = findViewById(R.id.bHead);
        Button bTails = findViewById(R.id.bTails);
        TextView tvResult = findViewById(R.id.tvResult);

        //Listener común para ambos botones:
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Llamada al método que lanza la moneda:
                CoinSide coinResult = HeadTailsGame.throwCoin();

                //Determinar la apuesta del usuario en funcion del click en el boton:
                CoinSide bet = view.getId() == R.id.bHead ? CoinSide.HEAD : CoinSide.TAILS;

                //Se actualiza la imagen de la moneda:
                updateCoinImage(ivCoin, coinResult);

                //Se actualiza el resultado (Ganador / Perdedor):
                updateResultMessage(tvResult, coinResult, bet);
            }
        };

        //Asignación del listener al botón:
        bHead.setOnClickListener(listener);
        bTails.setOnClickListener(listener);
    }

    /**
     * Actualiza la imagen de la moneda en función del resultado
     *
     * @param ivCoin     ImageView donde se muestra la imagen
     * @param coinResult Resultado del lanzamiento de la moneda (HEAD o TAILS)
     */
    private void updateCoinImage(ImageView ivCoin, CoinSide coinResult) {
        if (coinResult == CoinSide.HEAD) {
            ivCoin.setImageResource(R.drawable.euro_cara); //Establece la imagen
            ivCoin.setContentDescription(getString(R.string.coin_head)); //Establece la descripción para accesibilidad
        } else {
            ivCoin.setImageResource(R.drawable.euro_cruz); //Establece la imagen
            ivCoin.setContentDescription(getString(R.string.coin_tails)); //Establece la descripción para accesibilidad
        }
    }

    /**
     * Actualiza el mensaje del TextView en función del resultado de la apuesta.
     *
     * @param tvResult   TextView donde se muestra el mensaje
     * @param coinResult Resultado del lanzamiento de la moneda
     * @param bet        Apuesta del usuario (HEAD o TAILS)
     */
    private void updateResultMessage(TextView tvResult, CoinSide coinResult, CoinSide bet) {
        if (coinResult == bet) {
            tvResult.setText(R.string.winnerMessage);
        } else {
            tvResult.setText(R.string.loserMessage);
        }
    }
}