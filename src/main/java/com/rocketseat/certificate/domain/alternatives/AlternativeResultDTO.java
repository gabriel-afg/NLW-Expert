package com.rocketseat.certificate.domain.alternatives;

import lombok.Builder;

import java.util.UUID;

@Builder
public record AlternativeResultDTO(
        UUID id,
        String description
) {
    public AlternativeResultDTO(Alternatives alternatives){
        this(
                alternatives.getId(),
                alternatives.getDescription()
        );
    }
}
