package ru.home.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.home.shop.service.query.present.PresentQuery;
import ru.home.shop.service.query.present.PresentQueryRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/api/presents")
@RequiredArgsConstructor
public class PresentQueryController {

    private final PresentQueryRepository repository;

    @GetMapping(value = "/{id}")
    public PresentQuery findPresent(@PathVariable("id") UUID id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @GetMapping
    public Collection<PresentQuery> listPresent() {
        return repository.list();
    }
}
