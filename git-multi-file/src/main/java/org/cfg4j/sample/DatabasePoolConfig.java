package org.cfg4j.sample;

public interface DatabasePoolConfig {
    String url();
    int maxPoolSize();
    long connectionTimeoutMs();
    long idleTimeoutMs();
    long maxLifetimeMs();
}
