package org.poolc.api.activity.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.poolc.api.activity.domain.Activity;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ActivityResponse {
    private final Long id;
    private final String title;
    private final HostResponse host;
    private final String classHour;
    private final LocalDate startDate;
    private final Boolean available;
    private final List<TagResponse> tags;
    private final Long hour;

    @JsonCreator
    public ActivityResponse(Activity activity) {
        this.id = activity.getId();
        this.title = activity.getTitle();
        this.host = new HostResponse(activity.getHost());
        this.classHour = activity.getClassHour();
        this.startDate = activity.getStartDate();
        this.available = activity.getAvailable();
        this.tags = activity.getTags().stream()
                .map(t -> new TagResponse(t))
                .collect(Collectors.toList());
        this.hour = activity.getHour();
    }
}