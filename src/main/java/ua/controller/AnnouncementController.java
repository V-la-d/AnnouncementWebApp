package ua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.model.Announcement;
import ua.service.AnnouncementService;

import java.util.List;

@Controller
public class AnnouncementController {

    private final AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping("/allannouncement")
    public String mainMenu(Model model) {
        List<Announcement> announcement = announcementService.announcementList();
        model.addAttribute("announcement", announcement);
        return "allannouncement";
    }

    @GetMapping("/mainmenu")
    public String mainmenu() {
        return "mainmenu";
    }

    @GetMapping("/deleteannouncement/{id}")
    public String deleteAnnouncement(@PathVariable("id") Integer id) {
        announcementService.deleteByIdAnnouncement(id);
        return "redirect:/allannouncement";
    }

    @GetMapping("/editannouncement/{id}")
    public String editAnnouncementFrom(@PathVariable("id") Integer integer, Model model) {
        Announcement announcement = announcementService.findById(integer);
        model.addAttribute("announcement", announcement);
        return "/editannouncement";
    }

    @PostMapping("/editannouncement")
    public String editAnnouncement(Announcement announcement) {
        announcementService.saveAnnouncement(announcement);
        return "redirect:/allannouncement";
    }

    @GetMapping("/createannouncement")
    public String createAnnouncementForm(Announcement announcement) {
        return "createannouncement";
    }

    @PostMapping("/cereateannouncement")
    public String createAnnouncement(Announcement announcement) {
        announcementService.saveAnnouncement(announcement);
        return "redirect:/allannouncement";
    }

    @GetMapping("/showwithdetails")
    public String showWithDetails(Model model) {
        List<Announcement> announcements = announcementService.showTop3WithDetails();
        model.addAttribute("announcement", announcements);
        return "showwithdetails";
    }


}
