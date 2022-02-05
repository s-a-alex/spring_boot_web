package getphos.spring.spring_boot_web.dao;


import getphos.spring.spring_boot_web.entity.Singer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SingerService {
    List<Singer> findAll();
    Page<Singer> findAll(Pageable pageable);
    Singer findById(Long id);
    Singer save(Singer singer);
}
