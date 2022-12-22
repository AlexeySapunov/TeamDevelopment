package ru.gb.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.gb.controler.dto.PublicationDto;
import ru.gb.service.PublicationService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/publication")
public class PublicationController {

    private static final Logger logger = LoggerFactory.getLogger(PublicationController.class);

    private final PublicationService publicationService;

    @Autowired
    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping
    public String listPage(Model model,
                           @RequestParam("authorName") Optional<String> authorName,
                           @RequestParam("menuItem") Optional<String> menuItem,
                           @RequestParam("titleFilter") Optional<String> titleFilter,
                           @RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size,
                           @RequestParam("sort") Optional<String> sort) {
        logger.info("Publication filter with name pattern {}", titleFilter.orElse(null));

        model.addAttribute("publications", publicationService.findAll(
                authorName,
                menuItem,
                titleFilter,
                page.orElse(1) - 1,
                size.orElse(5),
                sort.filter(s ->
                                !s.isBlank())
                        .orElse("id")));

        return "publication";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("activePage", "Publication");
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        logger.info("Edit publication page requested");

        model.addAttribute("publication", publicationService.findById(id)
                .orElseThrow(() -> new NotFoundException("Publication not found")));

        return "publication_form";
    }

    @GetMapping("/new")
    public String create(Model model) {
        logger.info("New publication page requested");

        model.addAttribute("publication", new PublicationDto());

        return "publication_form";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("publication") PublicationDto publication, BindingResult result) {
        logger.info("Saving publication");

        if (result.hasErrors()) {
            logger.error(result.getAllErrors().toString());

            return "publication_form";
        }

        publicationService.save(publication);

        return "redirect:/publication";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        logger.info("Deleting publication with id {}", id);

        publicationService.deleteById(id);

        return "redirect:/publication";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView notFoundExceptionHandler(NotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView("not_found");
        modelAndView.addObject("message", ex.getMessage());
        modelAndView.setStatus(HttpStatus.NOT_FOUND);

        return modelAndView;
    }
}
