package org.poolc.api.project.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.poolc.api.project.dto.UpdateProjectRequest;

import java.util.List;

@Getter
public class ProjectUpdateValues {
    private final String name;
    private final String description;
    private final String genre;
    private final String duration;
    private final String thumbnailURL;
    private final String body;
    List<String> memberLoginIDs;

    @JsonCreator
    public ProjectUpdateValues(UpdateProjectRequest request) {
        this.name = request.getName();
        this.description = request.getDescription();
        this.genre = request.getGenre();
        this.duration = request.getDuration();
        this.thumbnailURL = request.getThumbnailURL();
        this.body = request.getBody();
        this.memberLoginIDs = request.getMemberLoginIDs();
    }
}
