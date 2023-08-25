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
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.expression.Expression;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class FeedService {

    public final FeedRepository feedRepository;
    public final CategoryRepository categoryRepository;
    private final FeedMapper feedMapper;
    @PersistenceContext
    EntityManager em;


    public FeedDto patch(Long id, UpdateFeedDto updateFeedDto) {
        Feed feed = feedRepository.findById(id).orElseThrow(() -> new FeedNotFoundExcepion(id));
        feedMapper.patch(feed, updateFeedDto);
        return feedMapper.toDto(feedRepository.save(feed));
    }

    public FeedDto create(CreateFeedDto createFeedDto) {
        Feed feed = new Feed();
        feedMapper.create(feed, createFeedDto);
        Category category = categoryRepository.findById(createFeedDto.getCategory_id()).orElseThrow(() -> new CategoryNotFoundExcepion(createFeedDto.getCategory_id()));
        feed.setCategory(category);
        return feedMapper.toDto(feedRepository.save(feed));
    }

    public boolean delete(Long id) {
        Feed feed = feedRepository.findById(id).orElseThrow(() -> new FeedNotFoundExcepion(id));
        try {
            feedRepository.delete(feed);
            //feedMapper.toDto(feed);//!!!!м.б. лишнее
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<FeedDto> findFeeds(String name, String category, String content) {
        //   return feedRepository.findListByName(name);
        List<Feed> feedList = findFeedsByNameCriteryContent(name, category, content);
        List<FeedDto> feedDTOList = feedMapper.listFeedToFeedDTO(feedList);
        return feedDTOList;
    }

    List<Feed> findFeedsByNameCriteryContent(String name, String category, String content) {
        // EntityManager em = new Entity;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Feed> cq = cb.createQuery(Feed.class);

        Root<Feed> feed = cq.from(Feed.class);
        ArrayList<Predicate> predicates = new ArrayList<>();


        if (!name.isBlank() && !name.isEmpty()) {
            Predicate titlePredicate = cb.like(feed.get("name"), "%" + name + "%");
            predicates.add(titlePredicate);
        }
        if (!content.isBlank() && !content.isEmpty()) {
            Predicate contentPredicate = cb.like(feed.get("content"), "%" + content + "%");
            predicates.add(contentPredicate);
        }

        if (!category.isBlank() && !category.isEmpty()) {
            Predicate contentPredicate = cb.like(feed.get("category"), "%" + category + "%");
            predicates.add(contentPredicate);
        }

        if (predicates.size() == 3) {
            cq.where(predicates.get(0), predicates.get(1), predicates.get(2));
        } else if (predicates.size() == 2) {
            cq.where(predicates.get(0), predicates.get(1));
        } else if (predicates.size() == 1) {
            cq.where(predicates.get(0));
        }

        TypedQuery<Feed> query = em.createQuery(cq);
        return query.getResultList();
    }
}
