package modelo;

import javax.swing.JOptionPane;

public class Controle
{

    private String[] VetorBubble;
    private String[] VetorQuick;
    private String[] VetorInsert;
    private long TempoBubble;
    private long TempoQuick;
    private long TempoInsert;
    private long TrocaBubble;
    private long TrocaQuick;
    private long TrocaInsert;
    public String mensagem;
    public String diretorioInteiro;

    public boolean GerarLista(String tamanhoStr, String nome)
    {
        mensagem = "";
        Validacao val = new Validacao();

        if (val.Validar(tamanhoStr, nome))
        {
            GerenciadorDeLista lista = new GerenciadorDeLista();
            String[] ListaGerada = lista.Gerar(val.tamanhoInt);
            GerenciadorDeArquivos Garc = new GerenciadorDeArquivos();
            Garc.SalvarArquivo(ListaGerada, nome);

            if (Garc.diretorio == null)
            {
                JOptionPane.showMessageDialog(null, Garc.getMensagem());
                return false;
            } else
            {
                JOptionPane.showMessageDialog(null, "Arquivo salvo em:" + Garc.diretorio);
                this.diretorioInteiro = Garc.diretorio;
                return true;
            }

        } else
        {
            this.mensagem = val.mensagem;
            JOptionPane.showMessageDialog(null, this.mensagem);
            return false;
        }
    }

    public void ExeTestes(String local)
    {
        GerenciadorDeLista Glista = new GerenciadorDeLista();

        absSort SortBubble = new BubbleSort(Glista.Ler(local));
        VetorBubble = SortBubble.getListaordenada();
        TempoBubble = SortBubble.gettFinal();
        TrocaBubble = SortBubble.getTrocas();

        absSort SortQuick = new QuickSort(Glista.Ler(local));
        VetorQuick = SortQuick.getListaordenada();
        TempoQuick = SortQuick.gettFinal();
        TrocaQuick = SortQuick.getTrocas();

        absSort SortInsertion = new InsertionSort(Glista.Ler(local));
        VetorInsert = SortInsertion.getListaordenada();
        TempoInsert = SortInsertion.gettFinal();
        TrocaInsert = SortInsertion.getTrocas();
    }

    public void SalvarListas(String[] listaordenadaBubble, String[] listaordenadaQuick, String[] listaordenadaInsertion)
    {
        GerenciadorDeArquivos Garc = new GerenciadorDeArquivos();
        Garc.SalvarArquivo(listaordenadaBubble, "ListaOrdendaBubbleSort");
        Garc.SalvarArquivo(listaordenadaQuick, "ListaOrdendaQuickSort");
        Garc.SalvarArquivo(listaordenadaInsertion, "ListaOrdendaInsertionSort");
    }

    public void ExibirResultados()
    {
        ComparaDados compara = new ComparaDados();
        compara.compararTempo(TempoBubble, TempoQuick, TempoInsert);
    }

    public String[] getVetorBubble()
    {
        return VetorBubble;
    }

    public String[] getVetorQuick()
    {
        return VetorQuick;
    }

    public String[] getVetorInsert()
    {
        return VetorInsert;
    }

    public String getTempoBubble()
    {
        return String.valueOf(TempoBubble);
    }

    public String getTempoQuick()
    {
        return String.valueOf(TempoQuick);
    }

    public String getTempoInsert()
    {
        return String.valueOf(TempoInsert);
    }

    public String getTrocaBubble()
    {
        return String.valueOf(TrocaBubble);
    }

    public String getTrocaQuick()
    {
        return String.valueOf(TrocaQuick);
    }

    public String getTrocaInsert()
    {
        return String.valueOf(TrocaInsert);
    }

}
