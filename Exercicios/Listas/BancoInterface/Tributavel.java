package Exercicios.Listas.BancoInterface;
/*
Crie uma interface Tributavel. Esta interface deve ter o seguinte método:
calcularTributo(BigDecimal taxaRendimento).
 */

import java.math.BigDecimal;

public interface Tributavel {

    public BigDecimal calcularTributo(BigDecimal taxaRendimento);
}
