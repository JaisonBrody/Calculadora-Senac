package br.senac.calculadora.calculadora;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;

public class Calculadora implements Serializable {
    //VARIAVEIS
    private Operador operador1 = new Operador();
    private Operador operador2 = new Operador();
    private Operacao operacao = null;
    private boolean finalizado = false;
    private NumberFormat nf = NumberFormat.getNumberInstance();
    //VARIAVEIS

    //METODO PARA INSERIR OS CARACTERES EM SEUS LUGARES
    public void setCaracter(char caracter) throws ParseException{
        //esse if ira sempre ser executado no inicio do programa assim instanciando os operadores
        if(finalizado){
            //operador dos primeiros digitos
            operador1 = new Operador();
            //operador dos segundos digitos
            operador2 = new Operador();
            //operador da operação
            operacao = null;
            //boolean para não ser executado mais esse if
            finalizado = false;
        }
        //segundo if a ser executado
        if (operacao == null){
            //esse if ira definir os primeiros caracteres
            operador1.setCaracter(caracter);
        //terceiro if a ser executado
        } else if (!finalizado) {
            //esse if ira definir os segundos caracteres
            operador2.setCaracter(caracter);
        }
    }

    //METODO PARA INSERIR A OPERAÇÃO
    public void setOperacao(Operacao operacao){
        //a proxima inserir a operação escolhida
        this.operacao = operacao;
    }

    //METODO PARA RECEBER AS ENTRADAS DOS BOTÕES
    public String getValorTexto(){
        //string que recebera o primeiro operador
        String op1 = operador1.getValorTexto();
        //string que recebera o segundo operador
        String op2 = operador2.getValorTexto();
        //string que recebera o tipo de calculo
        String texto = "";

        //caso não exista nenhuma operação inserida quando precionada a mesma, caira nesse if
        if (operacao == null) {
            //definindo a operação
            texto += "";
        //caso exista um operador inserido, caira nesse if
        } else if (!finalizado){
            //isso ira definir o operador1 + a operação em uma string
            texto += op1 + operacao;
        //em ultimo caso esse else serve para definir o layout completo de Operador1 + operação + operador2
        } else {
            //isso ira definir o operador1 + operação + o operador2 em uma string
            texto += op1 + operacao + op2;
        }
        //return do texto definido anteriormente
        return texto;
    }

    //METODO PARA RECEBER AS ENTRADAS DOS BOTÕES A SEREM JOGADOS NO VISOR PRINCIPAL
    public String getValorTextoPrincipal() {
        //string q ira receber o operador1
        String op1 = operador1.getValorTexto();
        //string que ira obter o operador2
        String op2 = operador2.getValorTexto();
        //string que ira receber a operação
        String texto = "";

        //caso haja uma string inserida ao apertar uma operação, essa string seja jogada no visor principal
        if (operacao == null){
            //definindo o texto do visor principal
            texto += op1;
            //caso haja uma string inserida ao visor e uma segunda inserida no visor inferior, sera jogado ambos o operador2 e a operação no visor principal
        }else if(!finalizado){
            texto += op2;
        //else para retornar o resultado
        }else{
            //definindo o texto do visor com o resultado da conta
            texto += getResultado();
        }
        return texto;
    }

    //METODO PARA OBTER O RESULTADO
    public String getResultado(){
        //double q ira receber o operador1
        double op1 = operador1.getValor();
        //double q ira receber o operador2
        double op2 = operador2.getValor();
        //double q ira receber o resultado
        double resultado = 0;
        //if caso a operação seja a adição
        if(operacao == Operacao.ADICAO){
            resultado = op1 + op2;
        //if caso a operação seja a subtração
        }else if (operacao == Operacao.SUBTRACAO){
            resultado = op1 - op2;
        //if caso a operação seja a multiplicação
        }else if (operacao == Operacao.MULTIPLICACAO){
            resultado = op1 * op2;
        //if caso a operação seja a divisão
        }else if (operacao == Operacao.DIVISAO){
            resultado = op1 / op2;
        //if caso a operação seja a porcentagem
        }else if (operacao == Operacao.PORCENTAGEM) {
            resultado = op1 * op2 / 100;
        //else caso a operação seja inserida uma operação não presente na classe enum
        }else{
            //a proxima linha ira uma exception com um texto
            throw new UnsupportedOperationException("Operação não implementada.");
        }
        //return ira retornar o resultado
        return nf.format(resultado);
    }

    //METODO PARA CALCULAR
    public void calcular() {
        //isso ira dizer a calculadora que o botão de resultado foi pressionado
        this.finalizado = true;
    }

    //METODO DA FUNÇÃO DO BOTÃO DELETE
    public void removerUltimoCaracter() throws ParseException {
        //if caso a operação não seja inserida
        if (operacao == null) {
            //esse metodo ira utilizar outro metodo para deletar o ultimo caracter do operador1
            operador1.removerUltimoCaracter();
            //if caso a operação seja inserida
        } else if (!finalizado) {
            //esse metodo ira utilizar outro metodo para deletar o ultimo caracter do operador2
            operador2.removerUltimoCaracter();
        }
    }
    //metodo string para retornar o texto caso necessario
    @Override
    public String toString() {
        //definindo o valor do texto
        String texto = getValorTexto();
        //esse if ira retornar o texto do visor principal formatado
        if (getValorTextoPrincipal().trim().length() > 0) {
            texto += " = " + getValorTextoPrincipal();
        }
        //return do texto
        return texto;
    }
}
