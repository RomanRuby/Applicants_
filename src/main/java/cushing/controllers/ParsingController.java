package cushing.controllers;


import cushing.models.dto.ParserDto;
import cushing.services.impl.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Roman Nagibov
 */
@RestController
@RequestMapping(value = "/parsing")
public class ParsingController {

    @Autowired private ParserService parserService;


    @RequestMapping(value = "/applicants", method = RequestMethod.POST)
    public Boolean applicantsParse(@RequestBody ParserDto parserDto) {
        return parserService.parseInformation(parserDto.getResource(), parserDto.getVacancy());
    }

    @RequestMapping(value = "/resources")
    public List<String> parsing() {
        return parserService.getResource();
    }

}
