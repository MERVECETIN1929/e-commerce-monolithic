package com.example.ecommercemono2.business.rules;

import com.example.ecommercemono2.business.dto.request.address.CreateAddressRequest;
import com.example.ecommercemono2.common.constants.Message;
import com.example.ecommercemono2.common.exception.BusinessException;
import com.example.ecommercemono2.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AddressRules {
    private AddressRepository repository;

    public void existById(UUID id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Message.Address.NotExistId);
        }
    }

    public void existAddress(CreateAddressRequest request) {
        if (repository.existsAddressByCityAndCountryAndFlatsNumberAndStreetAndPostCodeAndNeighbourhoodAndFloorNumber
                (request.getCity(), request.getCountry(), request.getFlatsNumber(), request.getStreet(), request.getPostCode(), request.getNeighbourhood(), request.getFloorNumber())) {
            throw new BusinessException(Message.Address.ExistAddress);
        }
    }
}
