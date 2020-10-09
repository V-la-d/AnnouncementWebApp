package ua.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.model.Announcement;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
    @Query(value = "select * from Announcement a where  (a.title,a.description) in " +
            "(select a.title,a.description from Announcement a  group by a.title, a.description having count(*)>1) ", nativeQuery = true)
    List<Announcement> allAnnouncementWithDetails(Pageable p);

    default List<Announcement> showTop3AnnouncementWithDetails() {
        return allAnnouncementWithDetails(PageRequest.of(0, 3));
    }
}