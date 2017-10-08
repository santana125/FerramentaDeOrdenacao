package modelo;

public class InsertionSort extends absSort
{

    public InsertionSort(String[] vetor)
    {
        super(vetor);
    }

    @Override
    public void executar()
    {
        sort();
    }

    private void sort()
    {
        this.trocas = 0;

        int i, j;
        String x;
        for (j = 1; j < vetor.length; j++)
        {
            x = vetor[j];
            i = j - 1;

            while (i >= 0)
            {
                if (x.compareTo(vetor[i]) > 0)
                {
                    break;
                }
                vetor[i + 1] = vetor[i];
                i--;
                this.trocas++;
            }
            vetor[i + 1] = x;

        }
        this.listaordenada = vetor;
    }

}
