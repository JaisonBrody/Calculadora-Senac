package br.senac.calculadora.calculadora;



import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;


public class Operador implements Serializable {
    //VARIAVEIS
    private double valor = 0;
    private String texto = "";
    private NumberFormat nf = NumberFormat.getNumberInstance();
    //VARIAVEIS

    //METODO PARA FORMATAR OS CARACTERES
    public void setCaracter(char caracter) throws ParseException {
        texto += caracter;
        valor = nf.parse(texto).doubleValue();

    }

    //FUNÇÕES PARA OBTER E FORMATAR VALORES
    public String getValorTexto() {
        return nf.format(this.valor);
    }
    public double getValor() {
        return this.valor;
    }


    //METODO QUE DA VIDA AO METODO DO BOTÃO DELETE
    public void removerUltimoCaracter() throws ParseException {
        if (texto.length() > 1) {
            texto = texto.substring(0, texto.length() - 1);
            valor = nf.parse(texto).doubleValue();
        } else {
            texto = "0";
            valor = 0;
        }
    }
}
