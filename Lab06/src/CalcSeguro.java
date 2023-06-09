// Enum para identificação de fatores para calculo de valores.

public enum CalcSeguro {
    VALOR_BASE(10.0),
    FATOR_MENOR_30(1.25),
    FATOR_30_60(1.0),
    FATOR_MAIOR_60(1.5);

    public final double fator;

    CalcSeguro(double fator){
        this.fator = fator;
    }

    public double getCalcSeguro(){
        return this.fator;
    }
}