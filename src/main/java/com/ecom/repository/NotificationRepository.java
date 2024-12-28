package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {



}
