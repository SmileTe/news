package com.github.SmileTe.controller;

import com.github.SmileTe.dto.CreateFeedDto;
import com.github.SmileTe.dto.FeedDto;
import com.github.SmileTe.dto.UpdateFeedDto;
import com.github.SmileTe.service.FeedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feeds")
@AllArgsConstructor
//@Tag()
public class FeedController {
    private final FeedService feedService;

    @Operation(summary = "...", description = "...",
            responses = {@ApiResponse(responseCode = "200", description = "..."),
                        @ApiResponse(responseCode = "404", description = "..."),
                        @ApiResponse(responseCode = "400", description = "...")
    })
    @PatchMapping("{id}")
    public FeedDto patch(@PathVariable("id") Long id, @RequestBody @Valid UpdateFeedDto updateFeedDto) {
        return feedService.patch(id, updateFeedDto);
    }
    @PostMapping
    public FeedDto create(@RequestBody @Valid CreateFeedDto createFeedDto){
        return feedService.create(createFeedDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
         feedService.delete(id);
         return ResponseEntity.noContent().build();
    }




    }
