package getphos.spring.spring_boot_web.repo;

import getphos.spring.spring_boot_web.entity.Singer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SingerRepository extends PagingAndSortingRepository<Singer, Long> {
}
