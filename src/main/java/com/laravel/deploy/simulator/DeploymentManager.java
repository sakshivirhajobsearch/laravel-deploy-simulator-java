package com.laravel.deploy.simulator;

public class DeploymentManager {
	
    public static void main(String[] args) {
    	
        System.out.println("=== Laravel Forge/Envoyer Java Simulator ===");
        CICDPipeline pipeline = new CICDPipeline();
        pipeline.runPipeline();
    }
}