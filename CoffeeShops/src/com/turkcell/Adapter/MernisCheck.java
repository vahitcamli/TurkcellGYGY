package com.turkcell.Adapter;

import java.io.IOException;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.turkcell.Abstract.ICustomerCheck;
import com.turkcell.entities.Customer;

public class MernisCheck implements ICustomerCheck {

	@Override
	public boolean checkIfRealPerson(Customer customer) {
		
//		com.squareup.okhttp dependency yüklendi burada onu kullandım.
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/soap+xml; charset=utf-8");
		
//		Request body'si'ni Postman kullanarak doğru şekilde oluşturdum.
		String soapRequestBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n<soap12:Envelope xmlns:xsi=\""
				+ "http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\""
				+ " xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\r\n"
				+ "  <soap12:Body>\r\n    <TCKimlikNoDogrula xmlns=\"http://tckimlik.nvi.gov.tr/WS\">\r\n"
				+ "      <TCKimlikNo>" + customer.getIdentityNumber() + "</TCKimlikNo>\r\n   " + "   <Ad>"
				+ customer.getName() + "" + "</Ad>\r\n      <Soyad>" + customer.getSurname()
				+ "</Soyad>\r\n      <DogumYili>" + customer.getDateOfBirth().getYear()
				+ "</DogumYili>\r\n    </TCKimlikNoDogrula>\r\n  </soap12:Body>\r\n</soap12:Envelope>";
		RequestBody body = RequestBody.create(mediaType, soapRequestBody);
		Request request = new Request.Builder().url("https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx")
				.method("POST", body).addHeader("Content-Type", "application/soap+xml; charset=utf-8").build();
		
//		Yanıt Alıyoruz ve Mernisten dönen sonuca göre isRealPerson belirleniyor.
		try {
			Response response = client.newCall(request).execute();
			if (response.isSuccessful()) {
				String responseBody = response.body().string();
				boolean isRealPerson;
				if (responseBody.contains("<TCKimlikNoDogrulaResult>true</TCKimlikNoDogrulaResult>")) {
					isRealPerson = true;
				} else {
					isRealPerson = false;
				}
				return isRealPerson;
			} else {
				System.out.println("MERNIS Istegi başarısız!: " + response.code() + " " + response.message());
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
