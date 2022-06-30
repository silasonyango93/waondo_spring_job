package com.silasonyango.personallibrary.batch;

import com.silasonyango.personallibrary.models.role_descriptions.RoleDescriptionsEntity;
import org.slf4j.Logger;
import org.springframework.batch.item.ItemProcessor;

public class ProcessEndTermOne implements ItemProcessor<RoleDescriptionsEntity, RoleDescriptionsEntity> {

    private Logger logger;

    @Override
    public RoleDescriptionsEntity process(RoleDescriptionsEntity roleDescriptionsEntity) throws Exception {
        System.out.println(
                "hello"
        );


        return null;
    }
}
