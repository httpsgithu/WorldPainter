/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pepsoft.worldpainter.plugins;

import java.util.Properties;
import java.util.Set;
import java.util.UUID;

/**
 * A WorldPainter plugin.
 *
 * @author pepijn
 */
public interface Plugin {
    /**
     * Get the name of the plugin. Convenience method for (and must return the
     * same as):
     * 
     * <p>{@code getPoperties().getProperty(Plugin.PROPERTY_NAME)}
     * 
     * @return The name of the plugin.
     */
    String getName();
    
    /**
     * Get the version number of the plugin. Convenience method for (and must
     * return the same as):
     * 
     * <p>{@code getPoperties().getProperty(Plugin.PROPERTY_VERSION)}
     * 
     * @return The name of the plugin.
     */
    String getVersion();
    
    /**
     * Get the set of UUIDs this plugin is locked to, or {@code null} if
     * the plugin can be used by anyone. Convenience method for parsing the
     * result of:
     * 
     * <p>{@code getPoperties().getProperty(Plugin.PROPERTY_UUIDS)}
     * 
     * @return The set of UUIDs this plugin is locked to, or </code>null</code>
     *     if the plugin can be used by anyone.
     */
    Set<UUID> getUUIDs();
    
    /**
     * Deprecated. Use the {@code minimumHostVersion} property in the JSON descriptor instead. This will never be
     * invoked.
     */
    @Deprecated default String getMinimumWorldPainterVersion() {
        return getProperties().getProperty(PROPERTY_MINIMUM_WORLDPAINTER_VERSION);
    }
    
    /**
     * Get the properties of the plugin.
     * 
     * @return The properties of the plugin.
     */
    Properties getProperties();
    
    /**
     * The name of the plugin.
     */
    String PROPERTY_NAME    = "name";
    
    /**
     * The version number of the plugin.
     */
    String PROPERTY_VERSION = "version";
    
    /**
     * A comma-separated list of uuids that this plugin is locked to. Optional,
     * when not present the plugin can be used by anyone.
     */
    String PROPERTY_UUIDS   = "uuids";
    
    /**
     * Deprecated. Use the {@code minimumHostVersion} property in the JSON descriptor instead.
     */
    @Deprecated String PROPERTY_MINIMUM_WORLDPAINTER_VERSION = "minimumWorldPainterVersion";
}