package ee.mainor.WebAppHM.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("game") // Specify the table name if it differs from the class name
public class Game {
    @Id
    private Long id;

    @Column("answer") // Map the field to the "answer" column in the database
    private Integer answer;
}
