package br.com.ftt;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;


public class RequisitionQueueManager {

	private static Object objeto = new Object();
	public static RequisitionQueueManager _instance;    


	public static RequisitionQueueManager getInstancia() {
		if (_instance == null) {
			_instance = new RequisitionQueueManager();
		}
		return _instance;
	}

	public static ConcurrentLinkedQueue<String> RequestQueue1 = new ConcurrentLinkedQueue<String>();    

	public void Adiciona_Requisicao_1(String mensagem) {
		RequestQueue1.add(mensagem);
	}

	public void Retira_Requisicao_1() {
		if (!RequestQueue1.isEmpty()) {
			RequestQueue1.remove();
		}
	} 
}