/*
 * Copyright 2018 Red Hat, Inc.
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

package org.jboss.shamrock.example.test;

import static org.hamcrest.Matchers.is;

import org.jboss.shamrock.test.ShamrockTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;

@RunWith(ShamrockTest.class)
public class DataSourceTransactionTestCase {

    @Test
    public void testTransactionalAnnotation() {
        RestAssured.when().get("/rest/datasource/txninterceptor0").then()
                .body(is("PASSED"));

        RestAssured.when().get("/rest/datasource/txninterceptor1").then()
                .statusCode(500);

        RestAssured.when().get("/rest/datasource/txninterceptor2").then()
                .body(is("PASSED"));
    }

}