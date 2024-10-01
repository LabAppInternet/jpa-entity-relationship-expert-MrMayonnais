package cat.tecnocampus.notes2425.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record Tag(
        @Id String name) {
}
