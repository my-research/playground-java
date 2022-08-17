package com.wonit.springbootplayground;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "test")
@PropertySource(value = "classpath:application.properties", factory = CustomPropertySourceFactory.class)
public class SomeProps {

    private String name;

    private List<String> aliases;

    public String getName() {
        return name;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAliases() {
        return aliases;
    }
}
