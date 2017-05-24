package cushing.component;

import cushing.models.entity.Applicant;
import cushing.models.entity.Vacancy;

import java.io.IOException;
import java.util.Map;

/**
 * @author Roman Nagibov
 */
public interface Scrapping {
    Map<String,Applicant> parse(Vacancy vacancy) throws IOException;

}
