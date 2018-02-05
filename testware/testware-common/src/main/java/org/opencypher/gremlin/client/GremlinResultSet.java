/*
 * Copyright (c) 2018 "Neo4j, Inc." [https://neo4j.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.opencypher.gremlin.client;

import org.apache.tinkerpop.gremlin.driver.Result;
import org.apache.tinkerpop.gremlin.driver.ResultSet;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public final class GremlinResultSet {
    private GremlinResultSet() {
    }

    public static List<Result> resultSetSync(ResultSet resultSet) {
        return resultSet.all().join();
    }

    @SuppressWarnings("unchecked")
    public static List<Map<String, Object>> resultSetAsMap(ResultSet resultSet) {
        return resultSetSync(resultSet).stream()
            .map(result -> (Map<String, Object>) result.get(Map.class))
            .collect(toList());
    }
}