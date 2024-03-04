package com.scaler.productService.services;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.scaler.productService.dtos.FakeStoreProductDto;
import com.scaler.productService.dtos.GenericProductDto;
import com.scaler.productService.exceptions.NotFoundException;
import com.scaler.productService.thirdPartyClients.fakestore.FakeStoreProductClient;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
	
	private FakeStoreProductClient fakeStoreProductClient;
	
	@Autowired
	public FakeStoreProductService(FakeStoreProductClient fakeStoreProductClient) {
		this.fakeStoreProductClient = fakeStoreProductClient;
	}
	
	public GenericProductDto convertFakeStoreDtoToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());

        return genericProductDto;
    }
	
	public FakeStoreProductDto convertGenericProductDtoToFakeSToreProductDto(GenericProductDto genericProductDto) {
		FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
		fakeStoreProductDto.setId(genericProductDto.getId());
		fakeStoreProductDto.setImage(genericProductDto.getImage());
		fakeStoreProductDto.setTitle(genericProductDto.getTitle());
		fakeStoreProductDto.setPrice(genericProductDto.getPrice());
		fakeStoreProductDto.setDescription(genericProductDto.getDescription());;
		fakeStoreProductDto.setCategory(genericProductDto.getCategory());
		
		return fakeStoreProductDto;
	}

	@Override
	public GenericProductDto getProductById(Long id) throws NotFoundException {
		FakeStoreProductDto fakeStoreProductDto = fakeStoreProductClient.getProductById(id);
		
		if(fakeStoreProductDto == null) {
			throw new NotFoundException("Product with id - " + id + " not found");
		}
		
		return convertFakeStoreDtoToGenericProductDto(fakeStoreProductDto);
	}

	@Override
	public GenericProductDto createProduct(GenericProductDto genericProductDto) {
		FakeStoreProductDto fakeStoreProductDto = fakeStoreProductClient.createProduct(convertGenericProductDtoToFakeSToreProductDto(genericProductDto));
		return convertFakeStoreDtoToGenericProductDto(fakeStoreProductDto);
	}

	@Override
	public List<GenericProductDto> getAllProducts() {
		List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreProductClient.getAllProducts();
		List<GenericProductDto> genericProductDtos = new ArrayList<>();
		for(FakeStoreProductDto fakeStoreProductDto: fakeStoreProductDtos) {
			GenericProductDto genericProductDto = convertFakeStoreDtoToGenericProductDto(fakeStoreProductDto);
			genericProductDtos.add(genericProductDto);
		}
		return genericProductDtos;
	}

	@Override
	public GenericProductDto deleteProduct(Long id) {

		FakeStoreProductDto fakeStoreProductDto = fakeStoreProductClient.deleteProduct(id);
		
		GenericProductDto genericProductDto = convertFakeStoreDtoToGenericProductDto(fakeStoreProductDto);

		return genericProductDto;
	}

	@Override
	public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDtoRequest) {
		
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductClient.updateProductById(id, convertGenericProductDtoToFakeSToreProductDto(genericProductDtoRequest));
		
		GenericProductDto genericProductDto = convertFakeStoreDtoToGenericProductDto(fakeStoreProductDto);
		return genericProductDto;
	}

}
