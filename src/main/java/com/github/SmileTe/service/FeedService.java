package com.github.SmileTe.service;

import com.github.SmileTe.dto.CreateFeedDto;
import com.github.SmileTe.dto.FeedDto;
import com.github.SmileTe.dto.UpdateFeedDto;
import com.github.SmileTe.entity.Category;
import com.github.SmileTe.entity.Feed;
import com.github.SmileTe.exception.CategoryNotFoundExcepion;
import com.github.SmileTe.exception.FeedNotFoundExcepion;
import com.github.SmileTe.mapper.FeedMapper;
import com.github.SmileTe.repository.CategoryRepository;
import com.github.SmileTe.repository.FeedRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeedService {

    public final FeedRepository feedRepository;
    public final CategoryRepository categoryRepository;
    private final FeedMapper feedMapper;


    public FeedDto patch(Long id, UpdateFeedDto updateFeedDto) {
        Feed feed = feedRepository.findById(id).orElseThrow(() -> new FeedNotFoundExcepion(id));
        feedMapper.patch(feed, updateFeedDto);
        return feedMapper.toDto(feedRepository.save(feed));
    }
    public FeedDto create(CreateFeedDto createFeedDto){
        Feed feed = new Feed();
        feedMapper.create(feed, createFeedDto);
//        Long category_id = createFeedDto.getCategoryDto().getId();
//        Category category = categoryRepository.findById(category_id).orElseThrow(() -> new CategoryNotFoundExcepion(category_id));
//        feed.setCategory(category);
        return  feedMapper.toDto(feedRepository.save(feed));
    }

    public void delete(Long id){
        Feed feed = feedRepository.findById(id).orElseThrow(() -> new FeedNotFoundExcepion(id));

        feedRepository.delete(feed);
        feedMapper.toDto(feed);//!!!!м.б. лишнее

    }


}
