package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next()); // Converte a entrada do usuário para Date
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: "+ reservation);
				
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			// Atualizar as datas da reserva
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: "+ reservation);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format"); // Tratamento de erro para formato de data inválido
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage()); // Tratamento de erro de regra de negócio
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error"); // Capturar erros inesperados
		}
		
		sc.close();
	}
	
}
