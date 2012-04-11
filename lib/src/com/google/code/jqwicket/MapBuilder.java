/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.code.jqwicket;

import java.util.HashMap;
import java.util.Map;

/**
 * Small helper class to build {@link Map}-s using "fluent interface".
 *
 * @author mkalina
 * @version $Id: $
 */
public class MapBuilder<K, V> {

    private Map<K, V> params;

    public MapBuilder() {
        this.params = new HashMap<K, V>();
    }

    public MapBuilder(Map<K, V> map) {
        this.params = new HashMap<K, V>(map);
    }

    public MapBuilder<K, V> add(K key, V value) {
        this.params.put(key, value);
        return this;
    }

    public MapBuilder<K, V> remove(K key) {
        this.params.remove(key);
        return this;
    }

    public Map<K, V> build() {
        return this.params;
    }

}
