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

        //as duas linhas a seguir estão instanciando os 2 visores
        this.visor = (TextView) findViewById(R.id.visor);
        this.visorPrincipal = (TextView) findViewById(R.id.visorPrincipal);

        //essa linha serve para atualizar os 2 visores
        atualizarVisor();
    }

    //METODO PARA ATUALIZAR A TELA
    private void atualizarVisor(){
        //caso algum numero seja precionado, esse if ira jogar-lo na tela
        if (this.calculadora != null) {
            //as proximas 2 linhas irão definir o texto dos 2 visores
            visor.setText(calculadora.getValorTexto());
            visorPrincipal.setText(calculadora.getValorTextoPrincipal());
        //esse else seja caso nenhum numero seja pressionado ou algo seja limpado
        }else{
            //as proximas 2 linhas irão definir o texto dos 2 visores
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
        //o try ira tentar executar as 2 ações
        try {
            //essa linha serve para deletar o ultimo caracter inserido
            calculadora.removerUltimoCaracter();
            //essa linha ira atualizar os visores
            atualizarVisor();
        //caso alguma falhe retornara um exception e uma mensagem de erro
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        }
    }

    //METODO PARA DEFINIR OS CARACTERES
    private void setCaracter(char caracter){
        //com o try ira tentar executar as 2 ações
        try {
            //essa linha ira inserir os caracteres chamando um outro metodo
            calculadora.setCaracter(caracter);
            //essa linha ira atualizar os visores
            atualizarVisor();
            //caso alguma falhe retornara um exception e uma mensagem de erro
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getBaseContext(), "Ocorreu um erro!", Toast.LENGTH_SHORT).show();
        }
    }

    //METODO PARA DEFINIR O CALCULO(OPERAÇÃO)
    private void setOperacao(Operacao operation){
        //essa linha ira chamar um utro metodo para inserir a operação
        calculadora.setOperacao(operation);
        //essa linha ira atualizar o visor
        atualizarVisor();
    }

    //METODO DO BOTÃO RESULTADO
    public void handleButtonResultado(View view){
        //essa linha ira chamar o metodo responsavel por gerenciar os calculos
        calculadora.calcular();
        //essa linha ira atualizar os visores
        atualizarVisor();
    }

    //METODO PARA LIMPAR O VISOR
    public void handleButtonLimpar(View view){
        //essa linha ira simplesmente instanciar um novo objeto que é responsavel pelos visores e os numeros armazenados
        calculadora = new Calculadora();
        //essa linha ira atualizar o visor
        atualizarVisor();
    }




    //METODOS DOS BOTÕES
        //set character é para definir um numero
        //set operação é pra definir o tipo de calculo
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
