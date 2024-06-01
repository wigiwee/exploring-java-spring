package org.example;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.Scanner;

public class CurrencyConverter {
    public void convert() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type currency to convert from: ");
        String convertFrom = scanner.nextLine();
        System.out.println("Type currency to convert to: ");
        String convertTo = scanner.nextLine();

        System.out.println("Type quantity to convert : ");
        BigDecimal quantity = scanner.nextBigDecimal();

        String urlString = "https://api.freecurrencyapi.com/v1/latest?apikey=fca_live_3kbUJPWhFBDbWNshcVd6beDbKQCYS3Sav6qdPyj2" ;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(urlString)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        String stringResponse = response.body().string();
        JSONObject jsonObject = new JSONObject(stringResponse);
        JSONObject ratesObject = jsonObject.getJSONObject("data");
        BigDecimal rate = ratesObject.getBigDecimal(convertFrom.toUpperCase().strip());
        BigDecimal result = rate.multiply(quantity);
        System.out.println(result +" "+ convertTo.toUpperCase().strip());
        scanner.close();
    }
}
