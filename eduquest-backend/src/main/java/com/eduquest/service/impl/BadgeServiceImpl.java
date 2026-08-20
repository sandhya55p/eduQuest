package com.eduquest.service.impl;

import com.eduquest.entity.Badge;
import com.eduquest.repository.BadgeRepository;
import com.eduquest.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadgeServiceImpl implements BadgeService {
    @Autowired
    private BadgeRepository badgeRepository;

    @Override
    public Badge createBadge(Badge badge) {
        return badgeRepository.save(badge);
    }

    @Override
    public List<Badge> getAllBadges() {
        return badgeRepository.findAll();
    }

    @Override
    public Badge getBadgeById(Long id) {
        return badgeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Badge not found"));
    }

    @Override
    public Badge updateBadge(Long id, Badge badge) {

        Badge existing = getBadgeById(id);

        existing.setBadgeName(badge.getBadgeName());
        existing.setDescription(badge.getDescription());
        existing.setIcon(badge.getIcon());
        existing.setRarity(badge.getRarity());
        existing.setUnlocked(badge.getUnlocked());
        existing.setUser(badge.getUser());

        return badgeRepository.save(existing);
    }

    @Override
    public void deleteBadge(Long id) {
        badgeRepository.deleteById(id);
    }

    @Override
    public List<Badge> getBadgesByUser(Long userId) {
        return badgeRepository.findByUserId(userId);
    }
}
