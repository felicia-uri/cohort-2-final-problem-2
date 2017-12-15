package edu.cnm.deepdive.springdatarestpeople.membership;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "memberships", path = "memberships")
public interface MembershipRepository extends PagingAndSortingRepository<Membership, Long> {

}
