/*
 * Copyright 2015 Norbert Potocki (norbert.potocki@nort.pl)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cfg4j.sample;

import org.cfg4j.provider.ConfigurationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class MainController implements CommandLineRunner {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(MainController.class, args);
  }

  @Autowired
  private ConfigurationProvider configurationProvider;

  public void run(String... args) throws Exception {
    Boolean wasAwake = false;

    // ReksioConfig reksioConfig = configurationProvider.bind("reksio", ReksioConfig.class);
    DatabasePoolConfig databasePoolConfig = configurationProvider.bind("databasePool", DatabasePoolConfig.class);
    SearchConfig searchConfig = configurationProvider.bind("search", SearchConfig.class);

    while (true) {

      System.out.println("Search default Query: " + searchConfig.defaultQuery());
      System.out.println("Database Pool url: " + databasePoolConfig.url());

      Thread.sleep(3000);
    }
  }
}
