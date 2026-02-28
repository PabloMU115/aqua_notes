package project.aqua_notes.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "anons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnonUserEntity {

    @Id
    private Long AnonUserId;

    @Column(nullable = false, length = 100)
    private String name = "Usuario Anonimo";

}
