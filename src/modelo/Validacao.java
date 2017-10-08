package modelo;

import javax.swing.JOptionPane;

public class Validacao
{

    int tamanhoInt;
    String mensagem;

    public boolean Validar(String tamanhoStr, String nome)
    {
        mensagem = "";
        try
        {
            if (nome.trim().equals(""))
            {
                mensagem = "Nome Invalido!";
                return false;
            }

            tamanhoInt = Integer.parseInt(tamanhoStr);

            if (tamanhoInt > 1000000)
            {
                int opcao = JOptionPane.showConfirmDialog(null, "Tamanho muito alto, tem certeza que deseja continuar?(Inseguro!)");
                if (opcao == JOptionPane.OK_OPTION)
                {
                    return true;
                } else
                {
                    mensagem = "Ação Cancelada!";
                    return false;
                }

            }

            return true;
        } catch (NumberFormatException nfe)
        {
            mensagem = "Erro de Conversão!\nVerifique sua entrada.";
            return false;
        }
    }

}
