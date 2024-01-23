package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.EventCategory;
import org.launchcode.codingevents.models.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Chris Bay
 */
@Repository
public interface VenueRepository extends CrudRepository<Venue, Integer> {

}