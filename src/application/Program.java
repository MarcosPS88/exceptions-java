package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Número do Quarto: ");
		int numero = scan.nextInt();
		System.out.println("Data CheckIn(dd/MM/yyyy): ");
		Date checkIn = sdf.parse(scan.next());
		System.out.println("Data CheckOut(dd/MM/yyyy): ");
		Date checkOut = sdf.parse(scan.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na Reserva: A data de check-out deve ser posterior à data de check-in.");
		}else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			
			System.out.println("Entre com a data de atualização da reserva: ");
			System.out.println("Data CheckIn(dd/MM/yyyy): ");
			checkIn = sdf.parse(scan.next());
			System.out.println("Data CheckOut(dd/MM/yyyy): ");
			checkOut = sdf.parse(scan.next());
			
			Date agora = new Date();
			if(checkIn.before(agora) || checkOut.before(agora)) {
				System.err.println("Erro na Reserva: Datas para reserva devem ser posteriores à data atual! ");
			}else if(!checkOut.after(checkIn)) {
				System.out.println("Erro na Reserva: A data de check-out deve ser posterior à data de check-in.");
			 }else {
			
				 reserva.atualizarData(checkIn, checkOut);
				 System.out.println(reserva);
			 }
		}
		
		
		
		
		scan.close();

	}

}
