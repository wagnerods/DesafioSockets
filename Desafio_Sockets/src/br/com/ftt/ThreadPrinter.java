package br.com.ftt;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadPrinter extends Thread {

	@Override
	public void run() {        

		boolean status_printer_1 = true;
		boolean status_printer_2 = true;
		boolean status_printer_3 = true;
		boolean status_printer_4 = true;
		boolean queue;

		while (true) {
			queue = RequisitionQueueManager.getInstancia().RequestQueue1.isEmpty();
			if (!queue && status_printer_1) {
				try {
					status_printer_1 = false;
					Thread.sleep(2000);
					System.out.println(RequisitionQueueManager.getInstancia().RequestQueue1.poll() + " Impressora 1");
					status_printer_1 = true;
				} catch (InterruptedException ex) {
					Logger.getLogger(ThreadPrinter.class.getName()).log(Level.SEVERE, null, ex);
				}

			}
			queue = RequisitionQueueManager.getInstancia().RequestQueue1.isEmpty();

			if (!queue && status_printer_2) {
				try {
					status_printer_2 = false;
					Thread.sleep(2000);
					System.out.println(RequisitionQueueManager.getInstancia().RequestQueue1.poll() + " Impressora 2");
					status_printer_2 = true;
				} catch (InterruptedException ex) {
					Logger.getLogger(ThreadPrinter.class.getName()).log(Level.SEVERE, null, ex);
				}

			}
			queue = RequisitionQueueManager.getInstancia().RequestQueue1.isEmpty();

			if (!queue && status_printer_3) {
				try {
					status_printer_3 = false;
					Thread.sleep(2000);
					System.out.println(RequisitionQueueManager.getInstancia().RequestQueue1.poll() + " Impressora 3");
					status_printer_3 = true;
				} catch (InterruptedException ex) {
					Logger.getLogger(ThreadPrinter.class.getName()).log(Level.SEVERE, null, ex);
				}

			}
			queue = RequisitionQueueManager.getInstancia().RequestQueue1.isEmpty();

			if (!queue && status_printer_4) {
				try {
					status_printer_4 = false;
					Thread.sleep(2000);
					System.out.println(RequisitionQueueManager.getInstancia().RequestQueue1.poll() + " Impressora 4");
					status_printer_4 = true;
				} catch (InterruptedException ex) {
					Logger.getLogger(ThreadPrinter.class.getName()).log(Level.SEVERE, null, ex);
				}

			}

		}

	}
}