package com.starzec.allegro.service;

import com.starzec.allegro.entity.WareHouse;
import com.starzec.allegro.mapper.WareHouseMapper;
import com.starzec.allegro.model.WareHouseDto;
import com.starzec.allegro.repository.WareHouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WareHouseService {
    private final WareHouseRepository wareHouseRepository;
    private final WareHouseMapper wareHouseMapper;

    public List<WareHouseDto> findAllWareHouses() {
        List<WareHouse> wareHouses = wareHouseRepository.findAll();
        return wareHouses.stream()
                .map(wareHouseMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<WareHouse> findIdWareHouse(Long id) {
        return wareHouseRepository.findById(id);
    }

    public void createNewWareHouse(WareHouseDto wareHouseDto) {
        WareHouse wareHouse = wareHouseMapper.toEntity(wareHouseDto);
        wareHouseRepository.save(wareHouse);
    }

    public void updateWareHouse(Long id, String name, String address) {
        WareHouse wareHouse = wareHouseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(" NOT found item with this id"));
        wareHouse.setName(name);
        wareHouse.setAddress(address);
        wareHouseRepository.save(wareHouse);
    }

    public boolean existById(Long id) {
        List<WareHouse> wareHouses = wareHouseRepository.findAll();
        return wareHouses.stream()
                .anyMatch(wereHouse -> wereHouse.getId().equals(id));
    }

    public void deleteWareHouse(Long id) {
        wareHouseRepository.deleteById(id);
    }
}
