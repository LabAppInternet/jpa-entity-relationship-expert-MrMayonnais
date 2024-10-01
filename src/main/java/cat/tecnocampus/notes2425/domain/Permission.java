package cat.tecnocampus.notes2425.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public record Permission(
        @Id
        @ManyToOne
        @JoinColumn(name = "user_id")
        UserLab owner,

        @Id
        @ManyToOne
        @JoinColumn(name = "note_id")
        Note note,
        //@Column(nullable = false)
        @NotNull
        boolean canRead,
        //@Column(nullable = false)
        @NotNull
        boolean canEdit
) {
}
