package edu.stanford.slac.elog_plus.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "edu.stanford.slac.elogs-plus.storage")
public class StorageProperties {
    private String url;
    private String bucket;
    private String secret;
    private String key;
}
