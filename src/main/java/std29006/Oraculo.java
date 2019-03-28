package std29006;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface que deve ser compartilhada por servidor e clientes
 */
public interface Oraculo extends Remote {
    public int gerarSenha(String nome) throws RemoteException;

    public String gerarResultado() throws RemoteException;
}

