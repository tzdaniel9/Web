package API;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class DogBreed {
	
	@Test
	public void ListBreeds() {

		try {

			String url = "https://dog.ceo/api/breeds/list/all";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());
		} catch (Exception e) {
			System.out.println("Response not found");
		}
	}
	
	@Test
	public void breedRetriever() {
		try {

			String url = "https://dog.ceo/api/breed/retriever/list";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response.toString());
		} catch (Exception e) {
			System.out.println("Response not found");
		}
	}

	@Test
	public void retrieverGolden() {
		try {

			String url = "https://dog.ceo/api/breed/retriever/golden/images/random";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			System.out.println(response);
		} catch (Exception e) {
			System.out.println("Response not found");
		}
	}
}