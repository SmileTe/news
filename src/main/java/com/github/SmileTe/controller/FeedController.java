package com.github.SmileTe.controller;

import com.github.SmileTe.dto.CreateFeedDto;
import com.github.SmileTe.dto.FeedDto;
import com.github.SmileTe.dto.UpdateFeedDto;
import com.github.SmileTe.entity.Category;
import com.github.SmileTe.service.FeedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feeds")
@AllArgsConstructor
//@Tag()
public class FeedController {
    private final FeedService feedService;

    @Operation(summary = "Изменить существующую новость",
            responses = {@ApiResponse(responseCode = "200", description = "Created"),
                        @ApiResponse(responseCode = "404", description = "Not Found"),
                        @ApiResponse(responseCode = "400", description = "Bad Request")

    },
    tags = "Feeds")
    @PatchMapping("{id}")
    public FeedDto patch(@PathVariable("id") Long id, @RequestBody @Valid UpdateFeedDto updateFeedDto) {
        return feedService.patch(id, updateFeedDto);
    }

    @Operation(summary = "Создать новую новость",
            responses = {@ApiResponse(responseCode = "200", description = "Created"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "400", description = "Bad Request")
            },
            tags = "Feeds")
    @PostMapping
    public FeedDto create(@RequestBody @Valid CreateFeedDto createFeedDto){
        return feedService.create(createFeedDto);
    }


    @Operation(summary = "Удалить существующую новость",
            responses = {@ApiResponse(responseCode = "200", description = "Created"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "400", description = "Bad Request")
            },
            tags = "Feeds")

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
         boolean result = feedService.delete(id);
        if (result) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{nameFeed}/{category}/{content}")
    @Operation(summary = "Получить существующую новость",
            responses = {@ApiResponse(responseCode = "200", description = "Done"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "400", description = "Bad Request")
            },
            tags = "Feeds")

    public ResponseEntity<Iterable<FeedDto>> findFeeds(

            @RequestParam( name = "nameFeed", required = false, defaultValue =  "") String nameFeed,
            @RequestParam( name = "category", required = false, defaultValue = "")String categoryFeed,
            @RequestParam( name = "content", required = false, defaultValue = "") String content
            ) {
            return ResponseEntity.ok(feedService.findFeeds(nameFeed, categoryFeed,content));
            }

    @GetMapping
    @Operation(summary = "Получить список новостей",
            responses = {@ApiResponse(responseCode = "200", description = "Done"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "400", description = "Bad Request")
            },
            tags = "Feeds")

    public ResponseEntity<Iterable<FeedDto>>  listFeeds(

            @RequestParam(value = "offset", defaultValue = "0") Integer offset,
            @RequestParam(value = "limit", defaultValue = "5") Integer limit
    ) {
        return ResponseEntity.ok(feedService.listFeeds(offset, limit));
    }

    }
