package com.batchScheduling.CompanyDetail.writer;

import java.time.LocalDate;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.batchScheduling.CompanyDetail.entity.Dailyloginsummary;
import com.batchScheduling.CompanyDetail.entity.UserDetails;
import com.batchScheduling.CompanyDetail.repository.DailyloginsummaryRepository;
import com.batchScheduling.CompanyDetail.repository.UserRepository;

public class UserWriter implements ItemWriter<UserDetails> {

    @Autowired
    private UserRepository userdetailrepo;

    @Autowired
    private DailyloginsummaryRepository dailyloginrepo;

    private boolean isFirstChunk = true;

    @Override
    public void write(Chunk<? extends UserDetails> userdetails) {

        String targetDate = LocalDate.now().minusDays(1).toString();

        
        Dailyloginsummary summary =
                dailyloginrepo.findById(1L).orElse(new Dailyloginsummary());

       
        if (isFirstChunk) {
            summary.setCount(0);
            isFirstChunk = false;
        }

        int count = summary.getCount();

        for (UserDetails user : userdetails) {

            userdetailrepo.save(user);

            if (targetDate.equals(user.getLoginDate().trim())) {
                count++;
            }
        }

        summary.setCount(count);
        dailyloginrepo.save(summary);
    }
}
