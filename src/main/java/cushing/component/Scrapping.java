package cushing.component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Roman Nagibov
 */
public interface Scrapping {
    public Map<String,String> getInformation(List<String>  command) throws IOException;

}
