package cushing.models.dictionary;


import lombok.Data;

import javax.persistence.*;

/**
 * @author Roman Nagibov
 */
@Data

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

}
