package cushing.models.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Roman Nagibov
 */
@Data
@EqualsAndHashCode(callSuper = true)

@MappedSuperclass
public class BaseDictionaryModel extends BaseModel {

    @Column(name = "name", nullable = false)
    private String name;

}
