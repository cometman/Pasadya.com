package com.pasadya.paypal;

import java.util.List;

import paypal.payflow.ClientInfo;
import paypal.payflow.Context;
import paypal.payflow.FraudResponse;
import paypal.payflow.PayflowConnectionData;
import paypal.payflow.PayflowUtility;
import paypal.payflow.Response;
import paypal.payflow.SDKProperties;
import paypal.payflow.SaleTransaction;
import paypal.payflow.TransactionResponse;
import paypal.payflow.UserInfo;

import com.pasadya.data.ItemVO;
import com.pasadya.data.MemberVO;
import com.pasadya.shop.UserSession;

public class PayPalTransaction {

	private static PayPalTransaction instance = new PayPalTransaction();
	private static UserInfo userInfo;
	private static PayflowConnectionData conn;
	private PayPalObjectBuilder ppob;

	/*
	 * Singleton instance of paypal transaction. This instance will handle all
	 * of the transactions
	 */
	private PayPalTransaction() {

		SDKProperties.setHostAddress("pilot-payflowpro.paypal.com");
		SDKProperties.setHostPort(443);
		SDKProperties.setTimeOut(20);
		userInfo = PayPalConstants.USER_INFO;
		conn = new PayflowConnectionData();
	}

	public void processTransaction(MemberVO member, String ccNum, String ccExp,
			String cvv2) {
		ppob = new PayPalObjectBuilder(member);
		ppob.createTender(ccNum, ccExp, cvv2);
		SaleTransaction transaction = prepareTransaction(member);
		Response response = submitTransaction(transaction);
		if (response != null) {
			TransactionResponse trxnResponse = response
					.getTransactionResponse();

			ClientInfo client = new ClientInfo();
			transaction.setClientInfo(client);

			if (trxnResponse != null) {
				System.out.println("RESULT = " + trxnResponse.getResult());
				System.out.println("PNREF = " + trxnResponse.getPnref());
				System.out.println("RESPMSG = " + trxnResponse.getRespMsg());
				System.out.println("AUTHCODE = " + trxnResponse.getAuthCode());
				System.out.println("AVSADDR = " + trxnResponse.getAvsAddr());
				System.out.println("AVSZIP = " + trxnResponse.getAvsZip());
				System.out.println("IAVS = " + trxnResponse.getIavs());
				System.out
						.println("CVV2MATCH = " + trxnResponse.getCvv2Match());
				System.out.println("PROCCVV2 = " + trxnResponse.getProcCVV2());
				// If value is true, then the Request ID has not been changed
				// and the original response
				// of the original transction is returned.
				System.out
						.println("DUPLICATE = " + trxnResponse.getDuplicate());
			}

			// Get the Fraud Response parameters.
			FraudResponse fraudResp = response.getFraudResponse();
			if (fraudResp != null) {
				System.out.println("PREFPSMSG = " + fraudResp.getPreFpsMsg());
				System.out.println("POSTFPSMSG = " + fraudResp.getPostFpsMsg());
			}

			// Display the response.
			System.out.println("\n" + PayflowUtility.getStatus(response));

			// Get the Transaction Context and check for any contained SDK
			// specific errors (optional code).
			Context transCtx = response.getContext();
			if (transCtx != null && transCtx.getErrorCount() > 0) {
				System.out.println("\nTransaction Errors = "
						+ transCtx.toString());
			}
		}
	}

	/*
	 * Submit transaction to paypal servers
	 */
	public Response submitTransaction(SaleTransaction transaction) {
		return transaction.submitTransaction();
	}

	/*
	 * Prepare the transaction object for paypal
	 * 
	 * The transaction object must have the following information:   UserInfo  
	 * * PayflowConnectionData  Invoice   * BillTo   * CreditCard   * CardTender
	 *   * ClientInfo TransactionResponse and FraudResponse contain the response
	 * parameters.
	 */

	public SaleTransaction prepareTransaction(MemberVO member) {
		SaleTransaction saleTransaction = null;
		saleTransaction = new SaleTransaction(userInfo, conn,
				ppob.createInvoice(), ppob.getCardTender(),
				PayflowUtility.getRequestId());
		return saleTransaction;
	}

	public static PayPalTransaction getInstance() {
		return instance;
	}

}
