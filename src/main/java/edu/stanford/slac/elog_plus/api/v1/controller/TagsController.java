package edu.stanford.slac.elog_plus.api.v1.controller;

import edu.stanford.slac.elog_plus.api.v1.dto.ApiResultResponse;
import edu.stanford.slac.elog_plus.api.v1.dto.TagDTO;
import edu.stanford.slac.elog_plus.service.LogbookService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController()
@RequestMapping("/v1/tags")
@AllArgsConstructor
@Schema(description = "Set of api that work on the tags")
public class TagsController {
    LogbookService logbookService;

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ApiResultResponse<List<TagDTO>> getAllTags(
            @Parameter(name = "logbooks", description = "The logbook for filter the tags")
            @RequestParam("logbooks") Optional<List<String>> logbooks
    ) {
        return ApiResultResponse.of(
                logbookService.getAllTagsByLogbooksName(logbooks.orElse(Collections.emptyList()))
        );
    }
}
