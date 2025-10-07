package com.laravel.deploy.simulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LaravelForgeDeployer {

	private static final String API_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiYmMxZjE5ZGJkM2QzOWZmMWU2OTcyMjBmYzlmNjZjZDAxOWFmOWI1M2RkMzlkYTQ3MTdkYTM0Mzk2MDc1OGU5YzQ0OWYxY2UwM2Q5ZjY5OGUiLCJpYXQiOjE3NTQwNzY2MzEuNTk1Mzk4LCJuYmYiOjE3NTQwNzY2MzEuNTk1NDAxLCJleHAiOjIwNjk2MDk0MzEuNTkyOTkyLCJzdWIiOiIyNzE2OTgiLCJzY29wZXMiOlsiKiJdfQ.bupaJLshPcgi5t7gH55-yZ6a7jrgOhNpKDG_9Ri9j4Q13MMsLbeLKyaz3Ol5ARjlRQm2oKbumMc13eXDeirkDnFHk8wwqT1Ek8_7dArkacGF3fZvfpA6UHH5Rf3lkJriitzo_Ftptx1fo468rL1wt4fchYPDJJ03oDqvWnKiEZfdZMn6R4y6wkjwLgrqs4FiM5kxcz1Qp8B4nN5AaDIOwETs_O8wAWKzFkbZxU3DgmkO1eT6MfTglGqXpKENSKEqdOdbdqhvIeJH8CFF8GZ3MMLkZ_KM6Vb1FDkaCuN3014fcoMK5mtjJMraivrphILNyV1WYyG6nGfZU2yThawAfz41NCYonWgXmr4SfrhEbmqPgVGKkCGPG2pg3nQuycKauwyPd0bt7OxMju0CwIeGHUVq_cM2sFwnPnPM4lRv-ezw8sVj-8OPsuhjQoRXQVeA3kWsjR4-lwr5bznO6SWpgm48gPQlBVY8aWV-2h4BN2wgivIBalQWx2YMFmHVjQagqSsbFd3YuNPVEQ6jrvdKi1EcAYkq7LEHF3j1pVMfMiOFCi0yXbacXrUgZD4BJ6EnFAUaohE-TNMbhcZt5dzDbqEHFpUpSVwc1c902bVi7hYM1vyv9YWtZASMwdJHc_DCxa67X_oXGkVH1nU8dAKUG-4ys9PHHt28qx3FFTgyfcw";
	private static final String SITE_ID = "789012";

	public static void deploySite() throws IOException {
		
		String endpoint = "https://forge.laravel.com/api/v1/sites/" + SITE_ID + "/deployment/deploy";

		HttpURLConnection conn = (HttpURLConnection) new URL(endpoint).openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "Bearer " + API_TOKEN);
		conn.setRequestProperty("Accept", "application/json");
		conn.setDoOutput(true);

		int responseCode = conn.getResponseCode();
		if (responseCode == 200 || responseCode == 201) {
			System.out.println("🚀 Laravel site deployed successfully via Forge API.");
		} else {
			System.out.println("❌ Failed to deploy. HTTP code: " + responseCode);
			try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getErrorStream()))) {
				String line;
				while ((line = in.readLine()) != null) {
					System.out.println(line);
				}
			}
		}
	}
}
