package it.epicode.events;

public interface Mapper <D, S>{
    S map(D input);
}
