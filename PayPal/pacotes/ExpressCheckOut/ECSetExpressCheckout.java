/*
 * Copyright 2005, 2008 PayPal, Inc. All Rights Reserved.
 *
 * SetExpressCheckout SOAP example; last modified 08MAY23. 
 *
 * Initiate an Express Checkout transaction.  
 */
package ExpressCheckOut;

import com.paypal.sdk.profiles.APIProfile;
import com.paypal.sdk.profiles.ProfileFactory;
import com.paypal.sdk.services.CallerServices;
import com.paypal.soap.api.BasicAmountType;
import com.paypal.soap.api.CurrencyCodeType;
import com.paypal.soap.api.PaymentActionCodeType;
import com.paypal.soap.api.SetExpressCheckoutRequestDetailsType;
import com.paypal.soap.api.SetExpressCheckoutRequestType;
import com.paypal.soap.api.SetExpressCheckoutResponseType;
/**
 * PayPal Java SDK sample code
 */
public class ECSetExpressCheckout 
{

	
	


	public String ECSetExpressCheckoutCode(String paymentAmount, String returnURL, String cancelURL, 
										PaymentActionCodeType paymentAction, CurrencyCodeType currencyCodeType)
	{
		String responseValue = null;
		String token = null;
		String resposta = null;
		CallerServices caller = new CallerServices();
		
		try
		{
			APIProfile profile = ProfileFactory.createSignatureAPIProfile();
			/*
			 WARNING: Do not embed plaintext credentials in your application code.
			 Doing so is insecure and against best practices.
			 Your API credentials must be handled securely. Please consider
			 encrypting them for use in any production environment, and ensure
			 that only authorized individuals may view or modify them.
			 */

		// Set up your API credentials, PayPal end point, and API version.
			profile.setAPIUsername("sdk-three_api1.sdk.com");
			profile.setAPIPassword("QFZCWN5HZM8VBG7Q");
			profile.setSignature("AVGidzoSQiGWu.lGj3z15HLczXaaAcK6imHawrjefqgclVwBe8imgCHZ");
			profile.setEnvironment("sandbox");
			caller.setAPIProfile(profile);
			
			SetExpressCheckoutRequestType pprequest = new SetExpressCheckoutRequestType();
			pprequest.setVersion("51.0");

		// Add request-specific fields to the request.
			SetExpressCheckoutRequestDetailsType details = new SetExpressCheckoutRequestDetailsType();
			details.setReturnURL(returnURL);
			details.setCancelURL(cancelURL);
			BasicAmountType orderTotal = new BasicAmountType();
			orderTotal.set_value(paymentAmount);
			orderTotal.setCurrencyID(currencyCodeType);
			details.setOrderTotal(orderTotal);
			details.setPaymentAction(paymentAction);
			pprequest.setSetExpressCheckoutRequestDetails(details);

		// Execute the API operation and obtain the response.
			SetExpressCheckoutResponseType ppresponse = (SetExpressCheckoutResponseType) caller.call("SetExpressCheckout", pprequest);
			responseValue = ppresponse.getAck().toString();
			token=ppresponse.getToken().toString();
			resposta=responseValue+"&"+token;
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return resposta;
		
	}
}
