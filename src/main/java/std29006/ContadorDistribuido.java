package std29006;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface que deve ser compartilhada por servidor e clientes
 */
public interface ContadorDistribuido extends Remote {
    public void incrementa() throws RemoteException;

    public int obtemValorAtual() throws RemoteException;
}

