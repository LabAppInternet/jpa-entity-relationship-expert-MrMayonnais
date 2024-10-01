package cat.tecnocampus.notes2425.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public record Note(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        @ManyToOne
        @JoinColumn(name = "owner_id")
        UserLab owner,
        //@Column(nullable= false)
        @NotNull
        String title,
        //@Column(nullable= false)
        @NotNull
        String content,
        @CreatedDate @Column(nullable=false, updatable = false)
        LocalDateTime creationDate,
        @ManyToMany
                @JoinTable(
                        name = "note_tag",
                        joinColumns = @JoinColumn(name = "note_id"),
                        inverseJoinColumns = @JoinColumn(name = "tag_name")
                )
        Set<Tag> tags
) {
}
