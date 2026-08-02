package umasimulator.model.events;

import java.util.List;

public record Event (List<Option> options) implements EventPool {
    
}
