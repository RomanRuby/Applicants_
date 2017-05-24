package cushing.models.entity;

import cushing.models.base.BaseDictionaryModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Roman Nagibov
 */
@Data
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "resources")
public class Resource extends BaseDictionaryModel {

}
