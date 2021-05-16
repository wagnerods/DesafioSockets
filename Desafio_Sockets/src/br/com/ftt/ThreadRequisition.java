package br.com.ftt;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static br.com.ftt.DesafioSockets.Pega_Requisicao;

public class ThreadRequisition extends Thread {

	private boolean ActiveServer;
	private static ServerSocket server;
	private static int port = 9879;
	private List<Client> connectedClients = Collections.synchronizedList(new ArrayList<Client>());

	@Override
	public void run() {

		try {
			ActiveServer = true;
			server = new ServerSocket(port);
			while (ActiveServer) {
				Socket socket = server.accept();
				addClient(socket);
				Thread.sleep(10);
			}
		} catch (IOException | InterruptedException ex) {
			if (ex.getMessage().equals("socket closed")) {
				System.out.println("Conexão server encerrada...");
			} else {
				Logger.getLogger(ThreadRequisition.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

	}


	private void addClient(Socket socket) {
		Client manager = new Client();
		manager.setClientSocket(socket);
		connectedClients.add(manager);
		Thread threadSocket = new Thread(manager);
		threadSocket.start();
	}

	public void listClients() {
		for (Client cliente : connectedClients) {
			cliente.identifiqueSe();
		}
	}

	public void encerra() throws IOException {
		connectedClients.forEach((cliente) -> {
			try {
				cliente.encerra();
			} catch (IOException ex) {
				Logger.getLogger(ThreadRequisition.class.getName()).log(Level.SEVERE, null, ex);
			}
		});
		ActiveServer = false;
		server.close();
	}
}
