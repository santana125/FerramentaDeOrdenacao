package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GerenciadorDeLista
{

    String localDoArquivo = "";
    Random aleatorio = new Random();

    public String[] Gerar(int tamanho)
    {

        String[] vetoraleatorio = new String[tamanho];

        for (int count = 0; count < tamanho; count++)
        {
            if (aleatorio.nextInt(2) + 1 == 2)
            {
                vetoraleatorio[count] = GeraPalavra();
            } else
            {
                vetoraleatorio[count] = String.valueOf(aleatorio.nextInt(1000000));
            }
        }

        return vetoraleatorio;

    }

    private String GeraPalavra()
    {
        String palavra = "";

        for (int i = 0; i < aleatorio.nextInt(9) + 3; i++)
        {
            palavra += String.valueOf(Character.toChars(aleatorio.nextInt(26) + 97));
        }
        return palavra;
    }

    public String[] Ler(String local)
    {
        String linha = "";

        List<String> StringTemporaria = new ArrayList<>();

        try
        {
            Scanner LerArquivo = new Scanner(new File(local)).useDelimiter("\n");

            while (LerArquivo.hasNext())
            {
                linha = LerArquivo.next();
                if (!linha.trim().equals(""))
                {
                    StringTemporaria.add(linha);
                }
            }
            LerArquivo.close();

            return StringTemporaria.toArray(new String[0]);

        } catch (FileNotFoundException exp)
        {
            return null;
        }
    }

}
