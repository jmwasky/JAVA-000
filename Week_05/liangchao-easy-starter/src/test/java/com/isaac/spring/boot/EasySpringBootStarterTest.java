/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.isaac.spring.boot;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EasySpringBootStarterTest.class)
@SpringBootApplication
@ActiveProfiles("dev")
public class EasySpringBootStarterTest {

    @Resource
    private EasySpringbootConfiguration beanConfiguration;

    @Test
    public void assertAutoConfiguration() {
        assertThat(beanConfiguration.studentConfiguration().getId(), Is.is(121));
        assertThat(beanConfiguration.studentConfiguration().getName(), Is.is("configName"));
    }
}
