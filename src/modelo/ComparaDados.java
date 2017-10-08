package modelo;

import javax.swing.JOptionPane;

public class ComparaDados
{

    public void compararTempo(long Bubble, long Quick, long Insert)
    {
        if (Bubble < Quick && Bubble < Insert)
        {
            JOptionPane.showMessageDialog(null, "Melhor tempo: BubbleSort");
        } else
        {
            if (Quick < Insert)
            {
                JOptionPane.showMessageDialog(null, "Melhor tempo: QuickSort");
            } else
            {
                JOptionPane.showMessageDialog(null, "Melhor tempo: InsertionSort");
            }
        }

    }

}
