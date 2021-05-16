package br.com.ftt;

import java.io.IOException;
import java.util.Scanner;


public class DesafioSockets {


	public static void main(String[] args) throws IOException, InterruptedException {

		RequisitionQueueManager.getInstancia();        
		ThreadPrinter thread = new ThreadPrinter();
		thread.start();         
		System.out.println("Waiting for the client request");
		ThreadRequisition thread_requisition = new ThreadRequisition();
		thread_requisition.start();    


		Scanner scan = new Scanner(System.in);
		try {
			boolean sair = false;
			do {
				System.out.println("Welcome");
				System.out.println("Choose one option:");
				System.out.println("1 - Show clients");
				System.out.println("2 - Get out");
				int opcao = scan.nextInt();
				switch (opcao) {
				case 1:
					thread_requisition.listClients();
					break;
				case 2:
					sair = true;
					break;
				}
			} while (!sair);
		} finally {
			scan.close();
			thread_requisition.encerra();       
		}






	}    
	public static void Pega_Requisicao(String mensagem) {

		RequisitionQueueManager.getInstancia().Adiciona_Requisicao_1(mensagem);

	}



}
