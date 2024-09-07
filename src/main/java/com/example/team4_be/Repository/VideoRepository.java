package com.example.team4_be.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.team4_be.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
