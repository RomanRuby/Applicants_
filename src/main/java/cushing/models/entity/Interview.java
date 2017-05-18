package cushing.models.entity;

import cushing.models.base.ExcludeFieldModel;
import cushing.models.dictionary.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Roman Nagibov
 */
@Data
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "interviews")
public class Interview extends ExcludeFieldModel {

    @NotNull(message = "Введите дату  и время")
    @Column(name = "event_date", nullable = false)
    private Date eventDate = new Date();

    @Column(name = "creation_date")
    private Date creationDate = new Date();

    @Column(name = "description")
    private String description;

    @Min(value = 0, message = " не может быть меньше 0")
    @Max(value = 10, message = " не может быть больше 10")
    @Column(name = "preference")
    private Long preference;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

}