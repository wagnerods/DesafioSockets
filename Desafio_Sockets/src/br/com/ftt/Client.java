package br.com.ftt;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static br.com.ftt.DesafioSockets.Pega_Requisicao;

public class Client implements Runnable {
	private Socket clientSocket;

	@Override
	public void run() {

		try {
			InputStream stream = clientSocket.getInputStream();

			try {
				boolean ativo = true;
				do {

					if (stream.available() != 0) {
						byte[] data = new byte[stream.available()];
						stream.read(data);
						String readData = new String(data);
						Pega_Requisicao(readData);						
					}                

				}while(ativo);

			}finally {
				if (stream != null) {
					stream.close();
				}
				if (clientSocket.isConnected()) {
					clientSocket.close();
				}
			}
		} catch (IOException ex) {
			if (ex.getMessage().equals("Socket closed")) {
				System.out.println(clientSocket.hashCode() + ": Conexão cliente encerrada");
			}
			if (ex.getMessage().equals("Stream closed.")) {
				System.out.println("Stream fechado");
			} else {
				Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public void encerra() throws IOException {
		if (clientSocket.isConnected()) {
			clientSocket.close();
		}
	}

	void identifiqueSe() {
		if ((clientSocket.isConnected()) && (!clientSocket.isClosed())) {
			System.out.println(clientSocket.hashCode() + ": Conexão cliente estabelecida.");
		} else {
			System.out.println(clientSocket.hashCode() + ": Conexão cliente encerrada.");
		}
	}

	public Socket getClientSocket() {
		return clientSocket;
	}

}
