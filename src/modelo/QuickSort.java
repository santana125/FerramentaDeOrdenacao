package modelo;

public class QuickSort extends absSort
{

    public QuickSort(String[] vetor)
    {
        super(vetor);
    }

    public void sort(int iniVet, int fimVet)
    {
        int i = iniVet;
        int j = fimVet;
        String pivo = vetor[iniVet + (fimVet - iniVet) / 2];

        while (i <= j)
        {
            while (this.vetor[i].compareToIgnoreCase(pivo) < 0)
            {
                i++;
            }

            while (this.vetor[j].compareToIgnoreCase(pivo) > 0)
            {
                j--;
            }

            if (i <= j)
            {
                troca(i, j);
                i++;
                j--;
            }
        }
        if (iniVet < j)
        {
            sort(iniVet, j);
        }
        if (i < fimVet)
        {
            sort(i, fimVet);
        }
    }

    void troca(int i, int j)
    {
        this.auxiliar = this.vetor[i];
        this.vetor[i] = this.vetor[j];
        this.vetor[j] = auxiliar;
        this.trocas++;
    }

    @Override
    public void executar()
    {
        sort(0, vetor.length - 1);
        this.listaordenada = vetor;
    }
}
