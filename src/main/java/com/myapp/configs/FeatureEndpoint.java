package com.myapp.configs;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Endpoint(id = "features")
public class FeatureEndpoint {

	private final Map<String, Feature> featureMap = new ConcurrentHashMap<>();

	public FeatureEndpoint() {
		featureMap.put("Department", new Feature(Boolean.TRUE));
		featureMap.put("User", new Feature(Boolean.FALSE));
		featureMap.put("Authentication", new Feature(Boolean.FALSE));
	}

	@ReadOperation
	public Map<String, Feature> features() {
		return featureMap;
	}

	@ReadOperation
	public Feature feature(@Selector String feature) {
		return featureMap.get(feature);
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	private static class Feature {
		private boolean isEnabled;
	}

}
