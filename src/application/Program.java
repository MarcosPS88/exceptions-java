package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Número do Quarto: ");
			int numero = scan.nextInt();
			System.out.println("Data CheckIn(dd/MM/yyyy): ");
			Date checkIn = sdf.parse(scan.next());
			System.out.println("Data CheckOut(dd/MM/yyyy): ");
			Date checkOut = sdf.parse(scan.next());
			
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println(reserva);
			
			System.out.println("Entre com a data de atualização da reserva: ");
			System.out.println("Data CheckIn(dd/MM/yyyy): ");
			checkIn = sdf.parse(scan.next());
			System.out.println("Data CheckOut(dd/MM/yyyy): ");
			checkOut = sdf.parse(scan.next());
	
			reserva.atualizarData(checkIn, checkOut);
			System.out.println(reserva);
		}catch(ParseException e){
			System.err.println("Formato de data inválida!");
		}catch(DomainException e) {
			System.err.println("Erro na Reserva: " + e.getMessage());
		}catch(RuntimeException e) {
			System.err.println("Erro inesperado!");
		}
		scan.close();
	}

}
