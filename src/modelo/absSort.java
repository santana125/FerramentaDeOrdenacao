package modelo;

public abstract class absSort implements intSort
{

    protected int tamanhoVetor;
    protected long trocas;
    protected String auxiliar;
    protected String[] listaordenada;
    protected String[] vetor;
    protected long tAtual;
    protected long tApos;
    protected long tFinal;

    public absSort(String[] vetor) // CONSTRUTOR
    {
        trocas = 0;
        this.vetor = vetor; // Pega o vetor do contrutor
        tAtual = System.currentTimeMillis(); // Pega tempo atual para comparar com o tempo após o procedimento
        executar(); // Executa a função desejada
        tApos = System.currentTimeMillis(); // Pega o tempo atual após o procedimento
        tFinal = (tApos - tAtual); //
    }

    public String[] getListaordenada()
    {
        return listaordenada; // Retorna lista ordenada
    }

    public long gettFinal()
    {
        return tFinal; // Retorna o tempo de processamento
    }

    public long getTrocas()
    {
        return trocas; // retorna o numero de trocas
    }

}
