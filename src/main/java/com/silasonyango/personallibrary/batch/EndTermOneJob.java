package com.silasonyango.personallibrary.batch;

import com.silasonyango.personallibrary.models.role_descriptions.RoleDescriptionsEntity;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class EndTermOneJob {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job addRoleDescription(Step processRoles) {
        return jobBuilderFactory.get("addRoleDescription").incrementer(new RunIdIncrementer()).flow(processRoles).end().build();
    }

    @Bean
    public ProcessEndTermOne processEndTermOne() {
        return new ProcessEndTermOne();
    }

    @Bean
    public RepositoryItemReader<RoleDescriptionsEntity> reader() {
        Map<String, Sort.Direction> sortMap = new HashMap<>();
        sortMap.put("roleId", Sort.Direction.ASC);
        RepositoryItemReader<RoleDescriptionsEntity> reader = new RepositoryItemReader<RoleDescriptionsEntity>();
        reader.setMethodName("findAll");
        reader.setSort(sortMap);
        return reader;
    }

    @Bean
    public Step processRoles(RepositoryItemReader<RoleDescriptionsEntity> reader, ProcessEndTermOne processEndTermOne) {
        return stepBuilderFactory.get("processRoles")
                .<RoleDescriptionsEntity, RoleDescriptionsEntity>chunk(1)
                .reader(reader)
                .processor(processEndTermOne)
//                .writer()
                .build();
    }

}
