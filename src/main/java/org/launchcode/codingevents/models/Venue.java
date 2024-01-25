package org.launchcode.codingevents.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Venue extends AbstractEntity{
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @ManyToMany(mappedBy = "venues")
    private final List<Event> events = new ArrayList<>();

    public Venue(String name) {
        this.name = name;
    }

    public Venue() {}

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }
}
