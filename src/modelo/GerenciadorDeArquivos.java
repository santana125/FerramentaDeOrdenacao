package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GerenciadorDeArquivos
{

    JFileChooser arquivo = new JFileChooser();
    FileNameExtensionFilter filtrar;
    public String diretorio;
    private String mensagem;

    public String CarregarArquivo() throws FileNotFoundException
    {
        filtrar = new FileNameExtensionFilter("Arquivos de texto", "txt");
        arquivo.setFileFilter(filtrar);

        int carrega = arquivo.showOpenDialog(null);

        if (carrega == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                Scanner LerArquivo = new Scanner(new File(arquivo.getSelectedFile().toString()));
            } catch (Exception exp)
            {
                JOptionPane.showMessageDialog(null, "Arquivo não encontrado!");
                return null;
            }

            return arquivo.getSelectedFile().toString();
        } else
        {
            return null;
        }

    }

    public void SalvarArquivo(String[] vetoraleatorio, String nome)
    {
        arquivo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        this.diretorio = "";
        int carrega = arquivo.showSaveDialog(null);

        if (carrega == JFileChooser.APPROVE_OPTION)
        {
            this.diretorio = arquivo.getSelectedFile().toString() + File.separator + nome + ".txt";

            try
            {
                PrintWriter escrever = new PrintWriter(this.diretorio);

                for (String vetoraleatorio1 : vetoraleatorio)
                {
                    escrever.println(vetoraleatorio1);
                }
                escrever.close();

            } catch (FileNotFoundException ex)
            {
                this.diretorio = null;
                this.mensagem = "Não foi possivel salvar o arquivo!";
            }
        } else
        {
            this.diretorio = null;
            this.mensagem = "Ação cancelada!";
        }

    }

    public String getMensagem()
    {
        return mensagem;
    }

}
