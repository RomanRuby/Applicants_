package cushing.controllers;


import cushing.models.dto.ParserDto;
import cushing.models.entity.Resource;
import cushing.services.ResourceService;
import cushing.services.VacancyService;
import cushing.services.impl.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Roman Nagibov
 */
@RestController
@RequestMapping(value = "/parsing")
public class ParsingController {

    @Autowired ParserService parserService;
    @Autowired private VacancyService vacancyService;
    @Autowired private ResourceService resourceService;

//        @RequestMapping(value = "/applicants", method = RequestMethod.POST)
//    public Boolean parsing1(RequestBody ParserDto parserDto) {
//    }

    @RequestMapping(value = "/applicants", method = RequestMethod.POST)
    public Boolean parsing(@RequestBody ParserDto parserDto) {
       Resource resource = resourceService.get(parserDto.getResource().get(0).getId());
        List<Resource > resourceList = new LinkedList<>();
        resourceList.add(resource);
        return parserService.parceInformation(resourceList, vacancyService.get(parserDto.getVacancy().getId()));
    }

}
