package com.github.SmileTe.mapper;

import com.github.SmileTe.dto.CreateFeedDto;
import com.github.SmileTe.dto.FeedDto;
import com.github.SmileTe.dto.UpdateFeedDto;
import com.github.SmileTe.entity.Feed;
import lombok.NoArgsConstructor;
import org.mapstruct.*;
import org.mapstruct.MappingConstants.ComponentModel;

import java.util.List;

@Mapper(componentModel = ComponentModel.SPRING)

public interface FeedMapper {
    @Mapping(source = "name",target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patch(@MappingTarget Feed target, UpdateFeedDto source);

    @Mapping(source = "name",target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    //@Mapping(source = "source.categoryDto", target = "category")
    void create(@MappingTarget Feed target, CreateFeedDto source);

    List<FeedDto> listFeedToFeedDTO(List<Feed> feed);

    FeedDto toDto(Feed feed);
}
