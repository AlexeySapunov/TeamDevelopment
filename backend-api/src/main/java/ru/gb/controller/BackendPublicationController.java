package ru.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.dto.BackendPublicationDto;
import ru.gb.service.BackendPublicationService;

import java.util.Optional;

@RequestMapping("v1/publication")
@RestController
public class BackendPublicationController {

    private final BackendPublicationService backendPublicationService;

    @Autowired
    public BackendPublicationController(BackendPublicationService backendPublicationService) {
        this.backendPublicationService = backendPublicationService;
    }

    @GetMapping("/all")
    public Page<BackendPublicationDto> findAll(@RequestParam("authorName") Optional<String> authorName,
                                               @RequestParam("menuItem") Optional<String> menuItem,
                                               @RequestParam("titleFilter") Optional<String> titleFilter,
                                               @RequestParam("page") Optional<Integer> page,
                                               @RequestParam("size") Optional<Integer> size,
                                               @RequestParam("sort") Optional<String> sort) {
        return backendPublicationService.findAll(
                authorName,
                menuItem,
                titleFilter,
                page.orElse(1) - 1,
                size.orElse(5),
                sort.filter(fld -> !fld.isBlank()).orElse("id"));
    }
}
