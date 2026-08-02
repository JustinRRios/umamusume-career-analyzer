package umasimulator.model.events;

import java.util.List;

public record EventChain(List<Event> events) implements EventPool { 
    //create with first in last out principle
}
