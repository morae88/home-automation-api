package com.teamtreehouse.core;

import com.teamtreehouse.control.ControlRepository;
import com.teamtreehouse.device.Device;
import com.teamtreehouse.device.DeviceRepository;
import com.teamtreehouse.room.Room;
import com.teamtreehouse.room.RoomRepository;
import com.teamtreehouse.user.User;
import com.teamtreehouse.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseLoader implements ApplicationRunner{
    private final RoomRepository rooms;
    private final UserRepository users;

    public DatabaseLoader(RoomRepository rooms, UserRepository users, DeviceRepository devices, ControlRepository controls) {
        this.rooms = rooms;
        this.users = users;
    }


    @Autowired
    public DatabaseLoader(RoomRepository rooms, UserRepository users) {
        this.rooms = rooms;
        this.users = users;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User("Admin", "admin", new String[] {"ROLE_USER", "ROLE_ADMIN"}, "admin");

        List<Room> roomsInHouse = Arrays.asList(
          new Room("Kitchen", 450),
          new Room("Living Room", 800),
          new Room("Family Room", 500),
          new Room("Bedroom", 400)
        );

        rooms.save(roomsInHouse);
        users.save(user);
    }
}
