package com.example.ecommercemono2.business.concretes;

import com.example.ecommercemono2.business.abstracts.AddressService;
import com.example.ecommercemono2.business.dto.request.address.CreateAddressRequest;
import com.example.ecommercemono2.business.dto.request.address.UpdateAddressRequest;
import com.example.ecommercemono2.business.dto.response.address.CreateAddressResponse;
import com.example.ecommercemono2.business.dto.response.address.GetAddressResponse;
import com.example.ecommercemono2.business.dto.response.address.GetAllAddressResponse;
import com.example.ecommercemono2.business.dto.response.address.UpdateAddressResponse;
import com.example.ecommercemono2.business.rules.AddressRules;
import com.example.ecommercemono2.common.mapper.ModelMapperService;
import com.example.ecommercemono2.entities.Address;
import com.example.ecommercemono2.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {
    private final ModelMapperService mapper;
    private final AddressRepository repository;
    private final AddressRules rules;
    @Override
    public CreateAddressResponse add(CreateAddressRequest request) {
        rules.existAddress(request);
        Address address=mapper.forRequest().map(request,Address.class);
        address.setId(null);
        repository.save(address);
        return mapper.forResponse().map(address,CreateAddressResponse.class);
    }

    @Override
    public List<GetAllAddressResponse> getAll() {
        return repository.findAll().stream().map(address -> mapper.forResponse().map(address, GetAllAddressResponse.class)).toList();
    }

    @Override
    public GetAddressResponse getById(UUID id) {
        rules.existById(id);
        return mapper.forResponse().map(repository.findById(id).orElseThrow(),GetAddressResponse.class);
    }

    @Override
    public UpdateAddressResponse update(UUID id, UpdateAddressRequest request) {
        rules.existById(id);
        CreateAddressRequest createAddressRequest=mapper.forRequest().map(request,CreateAddressRequest.class);
        rules.existAddress(createAddressRequest);
        Address address=mapper.forRequest().map(request,Address.class);
        address.setId(id);
        repository.save(address);
        return mapper.forResponse().map(address,UpdateAddressResponse.class);
    }

    @Override
    public void delete(UUID id) {
        rules.existById(id);
        repository.deleteById(id);
    }

    @Override
    public boolean existsTryCreateAddress(CreateAddressRequest request) {
        return repository.existsByCityAndCountryAndFlatsNumberAndStreetAndPostCodeAndNeighbourhoodAndFloorNumber
               (request.getCity(), request.getCountry(), request.getFlatsNumber(), request.getStreet(),
               request.getPostCode(), request.getNeighbourhood(), request.getFloorNumber());
    }
    public CreateAddressResponse findAddress(CreateAddressRequest request) {
        return mapper.forResponse().map(repository.findByCityAndCountryAndFlatsNumberAndStreetAndPostCodeAndNeighbourhoodAndFloorNumber
                (request.getCity(), request.getCountry(), request.getFlatsNumber(), request.getStreet(),
                request.getPostCode(), request.getNeighbourhood(), request.getFloorNumber()),CreateAddressResponse.class);

    }
}
