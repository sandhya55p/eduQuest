package com.eduquest.service;

import com.eduquest.entity.Badge;

import java.util.List;

public interface BadgeService {
    Badge createBadge(Badge badge);
    List<Badge> getAllBadges();
    Badge getBadgeById(Long id);
    Badge updateBadge(Long id, Badge badge);
    void deleteBadge(Long id);
    List<Badge> getBadgesByUser(Long userId);

}
