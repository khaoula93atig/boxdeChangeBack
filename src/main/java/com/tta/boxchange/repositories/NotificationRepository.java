package com.tta.boxchange.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tta.boxchange.entities.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
	
	Page<Notification> findAllByChannel(String channel, Pageable pageable);

    @Modifying
    @Query(value = "update notification set read_Date = now() "
            + " where channel = ?1 and sender = ?2 and read_Date is null", nativeQuery = true)
    void sendReadReceipt(String channel, String username);

}
