package com.starzec.allegro.web;

import com.starzec.allegro.entity.WareHouse;
import com.starzec.allegro.model.WareHouseDto;
import com.starzec.allegro.service.WareHouseService;
import com.starzec.allegro.web.request.CreateAndUpdateWareHouseRequest;
import com.starzec.allegro.web.responce.GetWareHouseDetails;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/warehouse")
@AllArgsConstructor
public class WareHouseController {
    private final WareHouseService wareHouseService;

    @GetMapping
    public List<WareHouseDto> findAllWareHouses() {
        return wareHouseService.findAllWareHouses();
    }

    @GetMapping("/{id}")
    public GetWareHouseDetails wareHouseDetails (@PathVariable Long id){
        final Optional<WareHouse> wareHouse = wareHouseService.findIdWareHouse(id);
        return wareHouse.map(wH -> new GetWareHouseDetails(wH.getId(), wH.getName(), wH.getAddress()))
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "WareHouse with id "+ id+" doesnt exist"));
    }

    @PostMapping
    public void addItem(@RequestBody CreateAndUpdateWareHouseRequest request){
        WareHouseDto wareHouseDto = new WareHouseDto(request.getName(), request.getAddress());
        wareHouseService.createNewWareHouse(wareHouseDto);
    }

    @PutMapping("/{id}")
    public void updateItem(@PathVariable Long id, @RequestBody CreateAndUpdateWareHouseRequest request){
        wareHouseService.updateWareHouse(id, request.getName(), request.getAddress());
    }

    @DeleteMapping("/{id}")
    public void deleteWareHouse(@PathVariable Long id){
        if (wareHouseService.existById(id)){
            wareHouseService.deleteWareHouse(id);
        } else {
            throw new ResponseStatusException(NOT_FOUND, "WareHouse with given id "+ id +"not found");
        }
    }
}
