package poolc.poolc.domain;

import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Table(name = "ProjectMember")
public class ProjectMember {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "projectID", referencedColumnName = "ID")
    private Project project;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "memberUUID", referencedColumnName = "UUID")
    private Member member;
}
