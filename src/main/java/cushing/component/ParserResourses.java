package cushing.component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Roman Nagibov
 */
public class ParserResourses {

    public Map<String, String> getInformation(List<String> command) {
        Map<String,String> sites = new HashMap<>();

        for(Specialization site : Specialization.values()){
        sites.put("sites",site.name());
    }

        return sites;
    }

    public enum Specialization {
        PRACABY,
        TUTBY
    }

}
