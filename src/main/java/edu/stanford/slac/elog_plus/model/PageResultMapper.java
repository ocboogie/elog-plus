package edu.stanford.slac.elog_plus.model;

import edu.stanford.slac.elogplus.api.v1.dto.QueryPagedResultDTO;
import org.springframework.data.domain.Page;

public class PageResultMapper {
    static public <T> QueryPagedResultDTO<T> from(Page<T> source) {
        return QueryPagedResultDTO.<T>builder()
                .content(source.getContent())
                .empty(source.isEmpty())
                .first(source.isFirst())
                .last(source.isLast())
                .number(source.getNumber())
                .numberOfElements(source.getNumberOfElements())
                .size(source.getSize())
                .totalElements(source.getTotalElements())
                .totalPages(source.getTotalPages())
                .build();
    }
}
