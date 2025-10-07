package com.laravel.deploy.simulator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SSHDeployer {

	public static void deployViaSSH() throws Exception {
		
		String command = "ssh forge@your-ip-address 'cd /home/forge/yourdomain.com && git pull origin main && php artisan migrate --force'";

		Process process = Runtime.getRuntime().exec(command);
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		int exitCode = process.waitFor();
		System.out.println("🚀 SSH deployment finished with exit code: " + exitCode);
	}
}
