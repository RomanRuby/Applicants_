package cushing.models.dictionary;

import cushing.models.base.BaseDictionaryModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author Roman Nagibov
 */
@Data
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "offices")
public class Office extends BaseDictionaryModel {
}
