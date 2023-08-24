package com.github.SmileTe.controller;

import com.github.SmileTe.dto.CreateFeedDto;
import com.github.SmileTe.dto.FeedDto;
import com.github.SmileTe.dto.UpdateFeedDto;
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

    @GetMapping
    public ResponseEntity<Iterable<FeedDto>> findFeeds(
            //@Parameter(description = "", example = "пример заполнение:ВАська")
            @RequestParam(required = false, name = "nameFeed") String nameFeed
           // @RequestParam(required = false, name = "breed") String breed
    ) {
       // if (nameFeed != null && !nameFeed.isBlank()) {
            return ResponseEntity.ok(feedService.findFeeds(nameFeed));
       // }
//        if (breed != null && !breed.isBlank()) {
//            return ResponseEntity.ok(catService.findCatByBreed(breed));
//        }
       // return ResponseEntity.ok();
       // return  new
    }



    }
