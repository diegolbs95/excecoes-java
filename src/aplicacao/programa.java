package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;



import model.entidades.Reserva;
import model.exceptions.DomainException;

public class programa {

	public static void main(String[] args)  {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Numero do Quarto: ");
			int quarto = sc.nextInt();
			System.out.print("Check-in data (dd/MM/yyyy): ");
			Date ChackIn = sdf.parse(sc.next());// PARA ESCREVER UMA DATA. O SDF VAI TRANSFORMAR EM DATA
			System.out.print("Check-out data (dd/MM/yyyy): ");
			Date ChackOut = sdf.parse(sc.next());
			
			
			Reserva reserva = new Reserva(quarto, ChackIn, ChackOut);
			System.out.println("Reservado: "+ reserva);
			
			System.out.println();
			System.out.println("Digite dados para atualizar a reserva: ");
			System.out.print("Check-in data (dd/MM/yyyy): ");
			ChackIn = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/MM/yyyy): ");
			ChackOut = sdf.parse(sc.next());
			
			
			reserva.DataAtualizadas(ChackIn, ChackOut);//ESSE STRING VAI DIZER SE ACONTECEU ERRO OU NAO
			System.out.println("Reservado: "+ reserva);
		}
		catch(ParseException e) {
			System.out.println("Data invalida!");	
		}
		catch (DomainException e) {
			System.out.println("Erro em reserva!!"+ e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		sc.close();
	}
		
	
}



