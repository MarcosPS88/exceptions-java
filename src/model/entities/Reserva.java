package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numeroQuarto;
	private Date checkin;
	private Date checkout;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
		
	}

	public Reserva(Integer numeroQuarto, Date checkin, Date checkout) {
		this.numeroQuarto = numeroQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	public long duracao() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String atualizarData(Date checkin, Date checkout) {
		Date agora = new Date();
		if(checkin.before(agora) || checkout.before(agora)) {
			return "Datas para reserva devem ser posteriores à data atual! ";
		}
		if(!checkout.after(checkin)) {
			return "A data de check-out deve ser posterior à data de check-in!";
		 }
		this.checkin = checkin;
		this.checkout = checkout;
		return null; 
		
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}
	
	@Override
	public String toString() {
		return "Reserva: Quarto " 
				+ numeroQuarto 
				+ ", CheckIn: " 
				+ sdf.format(checkin) 
				+ ", CheckOut: " 
				+ sdf.format(checkout)
				+ ", "
				+ duracao()
				+ " noites"; 
	}
	
}
