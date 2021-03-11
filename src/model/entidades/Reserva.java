package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;


public class Reserva {
	private Integer NumeroDeQuarto;
	private Date CheckIn;
	private Date CheckOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroDeQuarto, Date checkIn, Date checkOut)  {
		if (!CheckOut.after(CheckIn)) {
			throw new DomainException("Data de saida tem que ser maior que entrada!!");
		}
		
		NumeroDeQuarto = numeroDeQuarto;
		CheckIn = checkIn;
		CheckOut = checkOut;
	}

	public Integer getNumeroDeQuarto() {
		return NumeroDeQuarto;
	}

	public void setNumeroDeQuarto(Integer numeroDeQuarto) {
		NumeroDeQuarto = numeroDeQuarto;
	}

	public Date getCheckIn() {
		return CheckIn;
	}

	public Date getCheckOut() {
		return CheckOut;
	}

	public long duracao() { //"long" é o inteiro mais longo
		 long diff = CheckOut.getTime() - CheckIn.getTime();//Calculando dias de duracao
		 return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);//Esse metodo transforma o diff que estava em milisegundos para dias
	}
	public void DataAtualizadas(Date Checkin, Date Checkout) {
		
		Date now = new Date();//ESSE METODO CRIA UMA DATA DO MOMENTO ATUAL	
		if (CheckIn.before(now) || CheckOut.before(now)) {//.before PARA SABER SE ChackIn É ANTERIOR AO ChackOut
			throw new DomainException("Erro. Atualizacao deve ser com datas futuras!!");
		}
	
		this.CheckIn = Checkin;
		this.CheckIn = Checkout;
		
	}
	@Override
	public String toString() {
		return "Quarto "+ NumeroDeQuarto +", Check-in: "
				+sdf.format(CheckIn)
				+", Check-out: "
				+sdf.format(CheckOut)
				+", " 
				+duracao()
				+" noites";
	}
	
	
	
	
	
	
	
}
