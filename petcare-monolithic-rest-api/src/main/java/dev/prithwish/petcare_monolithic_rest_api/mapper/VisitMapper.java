package dev.prithwish.petcare_monolithic_rest_api.mapper;

import dev.prithwish.petcare_monolithic_rest_api.model.Visit;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.VisitReqDto;
import dev.prithwish.petcare_monolithic_rest_api.rest.dto.VisitResDto;

public class VisitMapper {
    public static Visit toVisit(VisitReqDto visitReqDto) {
        Visit visit = new Visit();
        visit.setDate(visitReqDto.getDate());
        visit.setDescription(visitReqDto.getDescription());
        return visit;
    }

    public static VisitResDto toVisitResDto(Visit visit) {
        VisitResDto visitResDto = new VisitResDto();
        visitResDto.setId(visit.getId());
        visitResDto.setDate(visit.getDate());
        visitResDto.setDescription(visit.getDescription());
        return visitResDto;
    }
}
