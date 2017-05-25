package cushing.controllers;


import cushing.models.dto.ParserDto;
import cushing.services.ResourceService;
import cushing.services.VacancyService;
import cushing.services.impl.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @author Roman Nagibov
 */
@RestController
@RequestMapping(value = "/parsing")
public class ParsingController {

    @Autowired private ParserService parserService;
    @Autowired private VacancyService vacancyService;
    @Autowired private ResourceService resourceService;


    @RequestMapping(value = "/applicants", method = RequestMethod.POST)
    public Boolean parsing(@RequestBody ParserDto parserDto) {
        Resource resource = resourceService.get(parserDto.getResource().get(0).getId()); // Нельзя get(0)
        return parserService.parseInformation(Collections.singletonList(resource),
                vacancyService.get(parserDto.getVacancy().getId()));
    }

    @RequestMapping(value = "/resources")
    public List<Resource> parsing() {
        return resourceService.getAll();
    }
}
