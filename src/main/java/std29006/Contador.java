package std29006;
import std29006.ContadorDistribuido;

import java.rmi.RemoteException;

/**
 * Classe que implementa a interface do objeto distribu´ıdo
 */
public class Contador implements ContadorDistribuido{
    private int valor = 0;
    @Override
    public void incrementa() throws RemoteException {
        this.valor++;
    }
    @Override

    public int obtemValorAtual() throws RemoteException {
        return this.valor;
    }
}