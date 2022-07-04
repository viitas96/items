package dev.powerit.onetomany.controller;

import dev.powerit.onetomany.model.Item;
import dev.powerit.onetomany.service.ItemService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("{id}")
    public ResponseEntity<Item> addItem(@RequestBody @NotNull Item item, @PathVariable Long id){
        return new ResponseEntity<>(itemService.saveItem(id, item), HttpStatus.CREATED);
    }
}
