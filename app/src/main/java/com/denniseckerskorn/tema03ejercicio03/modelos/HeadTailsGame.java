package com.denniseckerskorn.tema03ejercicio03.modelos;

import java.util.Random;

public class HeadTailsGame {

    /**
     * Enumerado HEAD o TAILS
     */
    public enum CoinSide {
        HEAD,
        TAILS
    }

    private static final Random rnd = new Random();

    /**
     * Lanza la moneda y devuelve HEAD or TAILS:
     *
     * @return enum HEAD o TAILS
     */
    public static CoinSide throwCoin() {
        return rnd.nextInt(2) == 0 ? CoinSide.HEAD : CoinSide.TAILS;
    }
}
