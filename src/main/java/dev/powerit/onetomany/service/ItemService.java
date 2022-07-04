package dev.powerit.onetomany.service;

import dev.powerit.onetomany.model.Item;
import dev.powerit.onetomany.model.Person;
import dev.powerit.onetomany.repository.ItemRepository;
import dev.powerit.onetomany.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final PersonRepository personRepository;

    private final ItemRepository itemRepository;

    public ItemService(PersonRepository personRepository, ItemRepository itemRepository) {
        this.personRepository = personRepository;
        this.itemRepository = itemRepository;
    }

    public Item saveItem(Long id, Item item){
        Person person = personRepository.findById(id).orElseThrow(null);
        item.setOwner(person);
        return itemRepository.save(item);
    }
}
