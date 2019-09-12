package br.senac.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import br.senac.calculadora.calculadora.Operacao;

import br.senac.calculadora.calculadora.Calculadora;

public class MainActivity extends Activity {

    //VARIAVEIS
    private Calculadora calculadora = new Calculadora();
    private TextView visor;
    private TextView visorPrincipal;
    private boolean virgu = false;
    //VARIAVEIS

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.visor = (TextView) findViewById(R.id.visor);
        this.visorPrincipal = (TextView) findViewById(R.id.visorPrincipal);

        atualizarVisor();
    }

    //METODO PARA ATUALIZAR A TELA
    private void atualizarVisor(){
            if (this.calculadora != null) {
                visor.setText(calculadora.getValorTexto());
                visorPrincipal.setText(calculadora.getValorTextoPrincipal());
            } else {
                visor.setText("");
                visorPrincipal.setText("0");
            }
    }



    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.getSerializable("calculadora") != null) {
            this.calculadora = (Calculadora) savedInstanceState.getSerializable("calculadora");
            atualizarVisor();
        }
    }



    //METODO DO BOTÃO DELETE
    public void handleButtonDesfazer(View view){
        try {
            calculadora.removerUltimoCaracter();
            atualizarVisor();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        }
    }

    //METODO PARA DEFINIR OS CARACTERES
    private void setCaracter(char caracter){
        try {
            calculadora.setCaracter(caracter);
            atualizarVisor();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        }
    }

    //METODO PARA DEFINIR O CALCULO(OPERAÇÃO)
    private void setOperacao(Operacao operation){
        calculadora.setOperacao(operation);
        atualizarVisor();
    }

    //METODO DO BOTÃO RESULTADO
    public void handleButtonResultado(View view){
        calculadora.calcular();
        atualizarVisor();
    }

    //METODO PARA LIMPAR O VISOR
    public void handleButtonLimpar(View view){
        calculadora = new Calculadora();
        atualizarVisor();
    }




    //METODOS DOS BOTÕES
    public void handleButtonUm(View view){
        setCaracter('1');
    }
    public void handleButtonDois(View view){
        setCaracter('2');
    }
    public void handleButtonTres(View view){
        setCaracter('3');
    }
    public void handleButtonQuatro(View view){
        setCaracter('4');
    }
    public void handleButtonCinco(View view){
        setCaracter('5');
    }
    public void handleButtonSeis(View view){
        setCaracter('6');
    }
    public void handleButtonSete(View view){
        setCaracter('7');
    }
    public void handleButtonOito(View view){
        setCaracter('8');
    }
    public void handleButtonNove(View view){
        setCaracter('9');
    }
    public void handleButtonZero(View view){
        setCaracter('0');
    }



    //METODO DOS BOTÕES ESPECIAIS(OPERAÇÕES)
    public void handleButtonSoma(View view){
        setOperacao(Operacao.ADICAO);
    }
    public void handleButtonSubtrai(View view){
        setOperacao(Operacao.SUBTRACAO);
    }
    public void handleButtonMultiplica(View view){
        setOperacao(Operacao.MULTIPLICACAO);
    }
    public void handleButtonDivide(View view){
        setOperacao(Operacao.DIVISAO);
    }
    public void handleButtonPorcentagem(View view){
        setOperacao(Operacao.PORCENTAGEM);
    }

    //METODOS PARA VIRGULA
    public void handleButtonVirgula(View view){
        virgu= true;
        setCaracter('.');
    }
    public void handleButtonPonto(View view){

        setCaracter('.');
    }
}
