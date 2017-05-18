package cushing.models.entity;

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
@Table(name = "vacancies")
public class Vacancy extends BaseDictionaryModel {

    @Column(name = "salary", nullable = false)
    private Double salary;

    @Column(name = "description")
    private String description;

}
