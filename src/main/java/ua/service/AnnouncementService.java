package ua.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.model.Announcement;
import ua.repository.AnnouncementRepository;

import java.util.List;

@Service
public class AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    @Autowired
    public AnnouncementService(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    public Announcement saveAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    public Announcement findById(Integer integer) {
        return announcementRepository.getOne(integer);
    }


    public void deleteByIdAnnouncement(Integer integer) {
        announcementRepository.deleteById(integer);
    }

    public List<Announcement> announcementList() {
        return announcementRepository.findAll();
    }

    public List<Announcement> showTop3WithDetails() {
        return announcementRepository.showTop3AnnouncementWithDetails();
    }
}


