package it.epicode.events.services;

import it.epicode.events.entities.Event;
import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> getEvent();

    Optional<Event> getEvent(Long id);

    Event save(Event eventi);

    Optional<Event> update(Long eventId, Event eventi);

    Optional<Event> delete(Long eventId);
}
