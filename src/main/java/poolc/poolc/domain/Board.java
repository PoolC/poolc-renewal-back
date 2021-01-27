package poolc.poolc.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "Board")
@Getter @Setter
public class Board {
    @Id @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "name", columnDefinition = "varchar(40)", nullable = false, unique = true)
    private String name;

    @Column(name = "URLPath", columnDefinition = "varchar(40)", nullable = false, unique = true)
    private String urlPath;

    @Column(name = "readPermission", columnDefinition = "varchar(10)", nullable = false)
    private String readPermission;

    @Column(name = "writePermission", columnDefinition = "varchar(10)", nullable = false)
    private String writePermission;

    @Column(name = "createdAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updatedAt", nullable = false)
    private LocalDateTime updatedAt;


}