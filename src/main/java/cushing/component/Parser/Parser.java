package cushing.component.Parser;

import cushing.models.entity.Applicant;
import cushing.models.entity.Vacancy;

import java.io.IOException;
import java.util.Set;

/**
 * @author Roman Nagibov
 */
public interface Parser {

    Set<Applicant> parse(Vacancy vacancy) throws IOException;

}
