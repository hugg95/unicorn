package org.lncwwn.unicorn.conf;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * config seed for spider
 * Created by victor on 12/23/14.
 */
public class CrawlerSeedConfig {

    private Set<String> seeds;

    public Set<String> getSeeds() {
        return seeds;
    }

    public void setSeeds( Set<String> seeds ) {
        this.seeds = seeds;
    }

    // for test, no practical use
    @PostConstruct
    public void printSeed() {
        for (String seed: seeds) {
            System.out.println(seed);
        }
    }
}
