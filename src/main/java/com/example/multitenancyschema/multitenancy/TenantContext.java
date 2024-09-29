package com.example.multitenancyschema.multitenancy;

public class TenantContext {

    public static final String DEFAULT_SCHEMA = "db_multitenancy";

    private static final ThreadLocal<String> currentTenant = ThreadLocal.withInitial(() -> DEFAULT_SCHEMA);

    public static void setCurrentTenant(String tenant) {
        currentTenant.set("empresa_%s".formatted(tenant));
    }

    public static String getCurrentTenant() {
        return currentTenant.get();
    }

    public static void clear() {
        currentTenant.remove();
    }

}