import java.math.BigDecimal;

public abstract class Tributavel extends ContaBancaria{

    public abstract BigDecimal calcularTributo(BigDecimal taxaRendimento);
}
