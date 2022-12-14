package com.appsdeveloperblog.app.ws.service.impl;

import com.appsdeveloperblog.app.ws.io.entity.AddressEntity;
import com.appsdeveloperblog.app.ws.io.entity.UserEntity;
import com.appsdeveloperblog.app.ws.io.repositories.AddressRepository;
import com.appsdeveloperblog.app.ws.io.repositories.UserRepository;
import com.appsdeveloperblog.app.ws.service.AddressService;
import com.appsdeveloperblog.app.ws.shared.dto.AddressDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<AddressDto> getAddresses(String id) {
        List<AddressDto> returnValue = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        UserEntity userEntity = userRepository.findByUserId(id);
        if (userEntity == null) return returnValue;

        Iterable<AddressEntity> addresses = addressRepository.findAllByUserDetails(userEntity);

        for (AddressEntity addressEntity : addresses) {
            returnValue.add(modelMapper.map(addressEntity, AddressDto.class));
        }
        return returnValue;
    }

    @Override
    public AddressDto getAddress(String addressId) {

        AddressDto returnValue= new AddressDto();

        AddressEntity addressEntity= addressRepository.findByAddressId(addressId);

        if(addressEntity !=null){
            returnValue= new ModelMapper().map(addressEntity, AddressDto.class);
        }

        return returnValue;
    }


}

