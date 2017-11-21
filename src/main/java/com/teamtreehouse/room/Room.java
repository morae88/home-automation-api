package com.teamtreehouse.room;

import com.teamtreehouse.core.BaseEntity;
import com.teamtreehouse.device.Device;
import com.teamtreehouse.user.User;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room extends BaseEntity{
    @NotNull
    @NotEmpty
    private String name;

    @Max(value = 1000, message = "Maximum room area is 1000 sq ft")
    private Integer area;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Device> devices;

    @ManyToMany
    private List<User> administrators;

    protected Room() {
        super();
        devices = new ArrayList<>();
        administrators = new ArrayList<>();
    }

    public Room(String name, int area) {
        this();
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void addDevice(Device device) {
        device.setRoom(this);
        devices.add(device);
    }

    public List<User> getAdministrators() {
        return administrators;
    }

    public void addAdministrator(User administrator) {
        administrators.add(administrator);
    }
}
