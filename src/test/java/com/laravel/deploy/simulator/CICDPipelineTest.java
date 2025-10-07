package com.laravel.deploy.simulator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CICDPipelineTest {

	@Test
	public void testFullPipelineExecution() {
		
		CICDPipeline pipeline = new CICDPipeline();
		assertTrue(pipeline.build(), "Build step should succeed");
		assertTrue(pipeline.test(), "Test step should succeed");
		assertTrue(pipeline.deploy(), "Deploy step should succeed");
	}
}