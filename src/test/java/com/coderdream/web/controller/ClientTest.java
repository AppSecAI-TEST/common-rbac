package com.coderdream.web.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.coderdream.util.Constants;

/**
 */
public class ClientTest {
	private RestTemplate restTemplate = new RestTemplate();

	@SuppressWarnings("rawtypes")
	@Test
	public void testServiceHelloSuccess() {
		String username = "zhang";
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("username", username);

		String url = UriComponentsBuilder
				.fromHttpUrl(Constants.BASE_URL + "getPermission").queryParams(params)
				.build().toUriString();

		ResponseEntity responseEntity = restTemplate.getForEntity(url,
				String.class);
		assertEquals("permissions", responseEntity.getBody());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testServiceHelloSuccess_00() {
		String username = "admin";
		String url = UriComponentsBuilder
				.fromHttpUrl(Constants.BASE_URL + "getPermissions/" + username).build()
				.toUriString();

		ResponseEntity responseEntity = restTemplate.getForEntity(url,
				String.class);
		// assertEquals("[\"user:create\",\"user:update\",\"menu:create\"]",
		// responseEntity.getBody());
		assertEquals(
				"[\"user:*\",\"role:*\",\"resource:*\",\"session:*\",\"organization:*\"]",
				responseEntity.getBody());

	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testServiceHelloSuccess_01() {
		String username = "admin";
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("username", username);

		String url = UriComponentsBuilder
				.fromHttpUrl(Constants.BASE_URL + "getPermission").build().toUriString();

		ResponseEntity responseEntity = restTemplate.getForEntity(url,
				String.class);
		assertEquals("permissions", responseEntity.getBody());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testServiceHelloSuccess_02() {
		String username = "admin";
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("username", username);

		String url = UriComponentsBuilder.fromHttpUrl(Constants.BASE_URL + "hello")
				.build().toUriString();

		ResponseEntity responseEntity = restTemplate.getForEntity(url,
				String.class);
		assertEquals("你好！hello", responseEntity.getBody());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testServiceHelloSuccess_03() {
		String username = "admin";
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("username", username);

		String url = UriComponentsBuilder
				.fromHttpUrl(Constants.BASE_URL + "say/" + username).build()
				.toUriString();

		ResponseEntity responseEntity = restTemplate.getForEntity(url,
				String.class);
		assertEquals("{\"msg\":\"you say:'admin'\"}", responseEntity.getBody());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testGetPermissions_01_Normal() {
		String username = "B-28709";
		String url = UriComponentsBuilder
				.fromHttpUrl(Constants.BASE_URL + "getPermissions/" + username).build()
				.toUriString();

		ResponseEntity responseEntity = restTemplate.getForEntity(url,
				String.class);
		String expected = "[\"projecteval:view\",\"profileeval:view\",\"profile:*\",\"profile:view\",\"profile:update\"]";
		assertEquals(expected, responseEntity.getBody());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testGetPermissions_02_PM() {
		String username = "B-26050";
		String url = UriComponentsBuilder
				.fromHttpUrl(Constants.BASE_URL + "getPermissions/" + username).build()
				.toUriString();

		ResponseEntity responseEntity = restTemplate.getForEntity(url,
				String.class);
		String expected = "[\"projecteval:*\",\"profileeval:view\",\"task:*\",\"profile:*\",\"profile:view\"]";
		assertEquals(expected, responseEntity.getBody());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testGetPermissions_03_TM() {
		String username = "B-22341";
		String url = UriComponentsBuilder
				.fromHttpUrl(Constants.BASE_URL + "getPermissions/" + username).build()
				.toUriString();

		ResponseEntity responseEntity = restTemplate.getForEntity(url,
				String.class);
		String expected = "[\"projecteval:view\",\"profileeval:*\",\"task:view\",\"profile:*\",\"profile:view\"]";
		assertEquals(expected, responseEntity.getBody());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testGetPermissions_04_RM() {
		String username = "B-26026";
		String url = UriComponentsBuilder
				.fromHttpUrl(Constants.BASE_URL + "getPermissions/" + username).build()
				.toUriString();

		ResponseEntity responseEntity = restTemplate.getForEntity(url,
				String.class);
		String expected = "[\"projecteval:view\",\"profileeval:*\",\"task:view\",\"profile:*\",\"profile:view\"]";
		assertEquals(expected, responseEntity.getBody());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testFindResourceIds_01_Normal() {
		String username = "B-28709";
		String url = UriComponentsBuilder
				.fromHttpUrl(Constants.BASE_URL + "findResourceIds/" + username).build()
				.toUriString();

		ResponseEntity responseEntity = restTemplate.getForEntity(url,
				String.class);
		String expected = "[66,68,70,75,80]";
		assertEquals(expected, responseEntity.getBody());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testFindResourceIds_02_PM() {
		String username = "B-26050";
		String url = UriComponentsBuilder
				.fromHttpUrl(Constants.BASE_URL + "findResourceIds/" + username).build()
				.toUriString();

		ResponseEntity responseEntity = restTemplate.getForEntity(url,
				String.class);
		String expected = "[61,66,70,71,80]";
		assertEquals(expected, responseEntity.getBody());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testFindResourceIds_03_TM() {
		String username = "B-22341";
		String url = UriComponentsBuilder
				.fromHttpUrl(Constants.BASE_URL + "findResourceIds/" + username).build()
				.toUriString();

		ResponseEntity responseEntity = restTemplate.getForEntity(url,
				String.class);
		String expected = "[65,66,70,75,76]";
		assertEquals(expected, responseEntity.getBody());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testFindResourceIds_04_RM() {
		String username = "B-26026";
		String url = UriComponentsBuilder
				.fromHttpUrl(Constants.BASE_URL + "findResourceIds/" + username).build()
				.toUriString();

		ResponseEntity responseEntity = restTemplate.getForEntity(url,
				String.class);
		String expected = "[65,66,70,75,76]";
		assertEquals(expected, responseEntity.getBody());
	}
}
