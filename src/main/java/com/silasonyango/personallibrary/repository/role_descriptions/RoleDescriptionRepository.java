package com.silasonyango.personallibrary.repository.role_descriptions;

import com.silasonyango.personallibrary.models.role_descriptions.RoleDescriptionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDescriptionRepository extends JpaRepository<RoleDescriptionsEntity, Long> {
}
