package org.wicketstuff.gae;

import org.apache.wicket.pageStore.memory.DataStoreEvictionStrategy;

/**
 * @author mkalina
 * @version $Id$
 */
public interface GaeApplication {

    DataStoreEvictionStrategy getEvictionStrategy();
}
