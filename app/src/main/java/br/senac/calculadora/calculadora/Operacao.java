package br.senac.calculadora.calculadora;



//classe enum responsavel pelas operações
public enum Operacao {
    //caso os botões de operações sejam pressionados, ira ser chamado o item referente a eles
    ADICAO(" + "),
    SUBTRACAO(" - "),
    MULTIPLICACAO(" x "),
    DIVISAO(" ÷ "),
    PORCENTAGEM(" % ");

    //variavel comum
    private String texto = "";

    // esse metodo ira jogar os itens enum acima para a string texto
    private Operacao(String texto) {
        //a linha aseguir ira retornar esse texto
        this.texto = texto;
    }
    //mais um metodo para retornar o texto em caso do ultimo não funcionar
    @Override
    public String toString() {
        //a linha aseguir ira retornar esse texto
        return this.texto;
    }
}
