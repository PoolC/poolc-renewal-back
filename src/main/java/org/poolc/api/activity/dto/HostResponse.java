package org.poolc.api.activity.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import org.poolc.api.member.domain.Member;

@Getter
public class HostResponse {

    private final String name;

    @JsonCreator
    public HostResponse(Member member) {
        this.name = member.getName();
    }
}