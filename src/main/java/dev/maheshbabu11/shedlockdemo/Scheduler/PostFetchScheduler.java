package dev.maheshbabu11.shedlockdemo.Scheduler;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
class PostFetchScheduler {

    final PostFetchService postFetchService;

    PostFetchScheduler(PostFetchService postFetchService) {
        this.postFetchService = postFetchService;
    }

    @Scheduled(cron = "0 */1 * ? * *")
    @SchedulerLock(name = "fetchPosts", lockAtMostFor = "PT4M", lockAtLeastFor = "PT4M")
    void fetchPosts() {
        postFetchService.fetchPosts();
    }
}
