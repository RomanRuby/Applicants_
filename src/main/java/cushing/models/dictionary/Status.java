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
@Table(name = "statuses")
public class Status extends BaseDictionaryModel {

    @Enumerated(EnumType.STRING)
    @Column(name = "code", nullable = false)
    private Code code;

    public enum Code {
        SUCCESSFUL,
        TREATMENT,
        REJECTED
    }

}
