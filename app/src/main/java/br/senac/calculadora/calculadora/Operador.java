package br.senac.calculadora.calculadora;



import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;


public class Operador implements Serializable {
    //VARIAVEIS
    private double valor = 0;
    private String texto = "";
    //metodo de formatação
    private NumberFormat nf = NumberFormat.getNumberInstance();
    //VARIAVEIS

    //METODO PARA FORMATAR OS CARACTERES
    public void setCaracter(char caracter) throws ParseException {
        //variavel responsavel por armazenar os caracteres
        texto += caracter;
        //essa variavel ira receber e formatar o texto
        valor = nf.parse(texto).doubleValue();

    }

    //FUNÇÕES PARA OBTER A STRING COMPLETA DO VISOR
    //ese metodo ira retornar para quem o chamar, os numeros e simbolos formatados
    public String getValorTexto(){
        return nf.format(this.valor);
    }
    //metodo responsavel por retornar somente valores
    public double getValor() {
        return this.valor;
    }


    //METODO QUE DA VIDA AO METODO DO BOTÃO DELETE
    public void removerUltimoCaracter() throws ParseException{
        //caso hája mais de 1 item no visor, sera usado esse if
        if (texto.length() > 1){
            //a proxima linha ira pegar o numero de caracteres da string e ira diminuir um numero dele;
            texto = texto.substring(0, texto.length() - 1);
            //a proxima linha ira formatar novamente a string
            valor = nf.parse(texto).doubleValue();
        //caso caia nesse else, le simplesmente ira setar o texto dos visores para 0
        } else {
            texto = "0";
            valor = 0;
        }
    }
}
