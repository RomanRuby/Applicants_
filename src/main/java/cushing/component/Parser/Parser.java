package cushing.component.Parser;

import cushing.models.entity.Applicant;
import cushing.models.entity.Vacancy;

import java.io.IOException;
import java.util.Map;

/**
 * @author Roman Nagibov
 */
public interface Parser {
    Map<String,Applicant> parse(Vacancy vacancy) throws IOException;

}