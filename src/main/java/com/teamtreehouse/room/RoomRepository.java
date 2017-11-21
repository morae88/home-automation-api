package com.teamtreehouse.room;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

public interface RoomRepository extends PagingAndSortingRepository<Room, Long> {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Room save(@Param("room") Room room);


}
