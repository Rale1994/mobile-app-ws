package com.appsdeveloperblog.app.ws.service;

import com.appsdeveloperblog.app.ws.shared.dto.AddressDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AddressService {
    List<AddressDto> getAddresses(String id);

    AddressDto getAddress(String addressId);
}
