package com.scaler.productService.thirdPartyClients.fakestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.scaler.productService.dtos.FakeStoreProductDto;
import com.scaler.productService.dtos.GenericProductDto;
import com.scaler.productService.exceptions.NotFoundException;

@Component
public class FakeStoreProductClient {
	
	@Value("${fakestore.api.baseurl}")
	private String fakeStoreBaseUrl;
	
	private final String fakeStoreProductPath = "/products";
	
    private RestTemplateBuilder restTemplateBuilder;
	
	private String productRequestUrl = fakeStoreBaseUrl + fakeStoreProductPath;
	
	@Autowired
	public FakeStoreProductClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplateBuilder = restTemplateBuilder;
	}

	public FakeStoreProductDto getProductById(Long id) throws NotFoundException {
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(productRequestUrl + "/{id}", FakeStoreProductDto.class, id);
		FakeStoreProductDto fakeStoreProductDto = response.getBody();
		
		if(fakeStoreProductDto == null) {
			throw new NotFoundException("Product with id - " + id + " not found");
		}
		
		return fakeStoreProductDto;
	}

	public FakeStoreProductDto createProduct(FakeStoreProductDto fakeStoreProductDtoRequest) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(productRequestUrl, fakeStoreProductDtoRequest, FakeStoreProductDto.class);
		FakeStoreProductDto fakeStoreProductDto = response.getBody();
		return fakeStoreProductDto;
	}

	public List<FakeStoreProductDto> getAllProducts() {
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeStoreProductDto[]> response =  restTemplate.getForEntity(productRequestUrl, FakeStoreProductDto[].class);
		FakeStoreProductDto[] fakeStoreProductDtos = response.getBody();
		
		return Arrays.asList(fakeStoreProductDtos);
	}

	public FakeStoreProductDto deleteProduct(Long id) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FakeStoreProductDto> response = 
				restTemplate.exchange(productRequestUrl + "/{id}", HttpMethod.DELETE, null, FakeStoreProductDto.class, id);
		FakeStoreProductDto fakeStoreProductDto = response.getBody();

		return fakeStoreProductDto;
	}

	public FakeStoreProductDto updateProductById(Long id, FakeStoreProductDto fakeStoreProductDtoRequest) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		HttpEntity<FakeStoreProductDto> requestEntity = new HttpEntity<FakeStoreProductDto>(fakeStoreProductDtoRequest);
		ResponseEntity<FakeStoreProductDto> response = 
				restTemplate.exchange(productRequestUrl + "/{id}", HttpMethod.PUT, requestEntity, FakeStoreProductDto.class, id);
		
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
		
		return fakeStoreProductDto;
	}


}
