package main;

import apresentacao.frmPrincipal;
import java.io.IOException;

public class Main

{

    public static void main(String[] args) throws IOException
    {
        frmPrincipal frm = new frmPrincipal(null, true);
        frm.setVisible(true);
    }
}
