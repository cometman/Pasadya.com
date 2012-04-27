package com.pasadya.paypal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import paypal.payflow.BillTo;
import paypal.payflow.CardTender;
import paypal.payflow.ClientInfo;
import paypal.payflow.CreditCard;
import paypal.payflow.Currency;
import paypal.payflow.Invoice;

import com.pasadya.data.MemberVO;

public class PayPalObjectBuilder {

	// PayPal objects needed in order to instantiate a transaction
	private MemberVO member;
	private Date date = new Date();
	private SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
	private Random randomNumber = new Random();
	private String ccNum;
	private String ccExp;
	private String cvv2;
	private CardTender cardTender;

	public PayPalObjectBuilder(MemberVO member) {
		if (member != null) {
			this.member = member;
		} else {
			// TODO handle null exception
		}

	}

	/**
	 * Build the invoice for the member
	 * 
	 * @param member
	 * @return
	 */
	public Invoice createInvoice() {
		Invoice invoice = null;
		invoice = new Invoice();
		Currency amount = new Currency(new Double(member.getCart().getTotal()),
				"USD");

		return invoice;
	}

	public void setPONumber(Invoice invoice) {
		int trailingIDNum = randomNumber.nextInt(1000000);
		invoice.setPoNum("PO" + member.getUsername().substring(0, 4)
				+ sdf.format(date) + trailingIDNum);
	}

	public void setInvoiceNumber(Invoice invoice) {
		int trailingIDNum = randomNumber.nextInt(1000000);
		invoice.setPoNum("INV" + member.getUsername().substring(0, 4)
				+ sdf.format(date) + trailingIDNum);
	}

	/**
	 * Bill too information
	 * 
	 * @return Bill to data
	 */
	public BillTo createBillTo() {
		BillTo billTo = null;
		billTo = new BillTo();
		billTo.setCity(member.getCity());
		billTo.setFirstName(member.getFname());
		billTo.setLastName(member.getLname());
		billTo.setStreet(member.getAddress());
		billTo.setZip(member.getZip());
		billTo.setEmail(member.getEmail());
		return billTo;
	}

	/**
	 * Create the tender (credit card) for transaction
	 * 
	 * @param ccNum
	 * @param expiry
	 * @param cvv2
	 * @return Card tender created from credit card
	 */
	public void createTender(String ccNum, String ccExp, String cvv2) {
		CreditCard creditCard = null;
		creditCard = new CreditCard(ccNum, ccExp);
		if (cvv2 != null) {
			creditCard.setCvv2(cvv2);
		}
		cardTender = new CardTender(creditCard);

	}

	public CardTender getCardTender() {
		return cardTender;
	}

	public ClientInfo buildClientInfo() {
		ClientInfo clientInfo = null;
		return clientInfo;
	}
}
