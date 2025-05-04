package com.app.nanny.infrastructure.config;

import com.app.nanny.domain.models.Location;
import com.app.nanny.infrastructure.factory.YamlPropertySourceFactory;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "locations")
@PropertySource(value = "classpath:mock/location.yml", factory = YamlPropertySourceFactory.class)
@Getter
public class LocationConfig {

    private Map<Long, Location> map = new HashMap<>();

    private Map<Long, Location> locations;

    public Map<Long, Location> getLocations() {
        return locations;
    }

    public Location getLocationById(Long id) {
        return map.get(id);
    }

}
