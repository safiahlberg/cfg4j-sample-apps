package org.cfg4j.sample;

public interface DatabasePoolConfig {
    String url();
    Integer maxPoolSize();
    Long connectionTimeoutMs();
    Long idleTimeoutMs();
    Long maxLifetimeMs();
}
