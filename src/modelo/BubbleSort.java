package modelo;

public class BubbleSort extends absSort
{

    public BubbleSort(String[] vetor)
    {
        super(vetor);
    }

    @Override
    public void executar()
    {
        tamanhoVetor = vetor.length;
        for (int i = 0; i < tamanhoVetor; i++)
        {
            for (int j = 0; j < tamanhoVetor - 1 - i; j++)
            {
                if (vetor[j].compareTo(vetor[j + 1]) > 0)
                {
                    auxiliar = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = auxiliar;
                    trocas++;
                }
            }
        }
        this.listaordenada = vetor;
    }
}
