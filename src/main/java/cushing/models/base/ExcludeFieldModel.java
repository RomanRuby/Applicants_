package cushing.models.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Roman Nagibov
 */
@Data
@EqualsAndHashCode(callSuper = true)

@MappedSuperclass
public class ExcludeFieldModel extends BaseModel {

    @Column(name = "is_enable")
    private Boolean isEnabled ;

}
