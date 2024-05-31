package it.epicode.events.services;


import it.epicode.events.entities.Event;
import it.epicode.events.repositories.EventRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepository eventrep;
    public List<Event> getEvent() {
        return eventrep.findAll();
    }

    @Override
    public Optional<Event> getEvent(Long id) {
        try {
            return eventrep.findById(id);
        }catch (Exception ex){
            log.error(String.format("evento con id = non trovato",id),ex);
            return Optional.empty();
        }
    }

    @Override
    public Event save(Event event) {
        try {
            return eventrep.save(event);
        }catch (Exception ex){
            log.error(String.format("salvataggio non riuscito di",event),ex);
            return null;
        }
    }

    @Override
    public Optional<Event> update(Long eventId, Event event) {
        try{
            var eve = eventrep.findById(eventId).orElseThrow();
            eve.builder()
                    .withDate(eve.getDate())
                    .withDescription(eve.getDescription())
                    .withPlace(eve.getPlace())
                    .withPlacesAvailable(eve.getPlacesAvailable())
                    .withTitle(eve.getTitle())
                    .build();
            return Optional.of(eventrep.save(eve));
        }
        catch (NoSuchElementException ex){
            log.error(String.format("evento con id = %s non trovato", eventId), ex);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Event> delete(Long eventId) {
        try{
            var dip = eventrep.findById(eventId).orElseThrow();
            eventrep.delete(dip);
            return Optional.of(dip);
        }catch (NoSuchElementException ex){
            log.error(String.format("evento non trovato con id = %s",eventId),ex);
            throw new RuntimeException("non trovo l'evento...");
        }catch (Exception ex){
            log.error(String.format("errore eliminazione evento con id = %s",eventId),ex);
            throw new RuntimeException();
        }
    }
}
