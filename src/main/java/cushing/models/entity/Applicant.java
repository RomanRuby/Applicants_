package cushing.models.entity;

import cushing.models.base.ExcludeFieldModel;
import cushing.models.dictionary.Office;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Roman Nagibov
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Entity
@Table(name = "applicants")
public class Applicant extends ExcludeFieldModel {

    @NotNull(message = "Введите имя")
    @Size(min = 2, message = "Имя должно быть минимум из 2-х букв")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull(message = "Введите фамилию")
    @Size(min = 2, message = "Фамилия должна быть минимум из 2-х букв")
    @Column(name = "second_name", nullable = false)
    private String secondName;

    @NotNull(message = "Введите дату рождения")
    @Column(name = "birth_date", nullable = false)
    private Date birthDate = new Date();

    @Column(name = "reference_resume")
    private String referenceResume;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

    public int getColumnCount() {
        return 7;
    }

}
