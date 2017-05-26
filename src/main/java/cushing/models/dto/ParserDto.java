package cushing.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @author Roman Nagibov
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParserDto {

    List<String> resource;

    String vacancy;

}
