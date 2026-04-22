package ru.skypro.homework.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.ad.Ad;
import ru.skypro.homework.dto.ad.Ads;
import ru.skypro.homework.dto.ad.CreateOrUpdateAd;
import ru.skypro.homework.dto.ad.ExtendedAd;
import ru.skypro.homework.service.AdService;

@RestController
@RequestMapping("/ads")
public class AdsController {

    private final AdService adService;

    public AdsController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping
    public Ads getAllAds() {
        return adService.getAllAds();
    }

    @PostMapping
    public Ad addAd(@RequestBody CreateOrUpdateAd request,
                    @RequestParam Integer userId) {
        return adService.createAd(request, userId);
    }

    @GetMapping("/{id}")
    public ExtendedAd getAd(@PathVariable Integer id) {
        return adService.getExtendedAd(id);
    }

    @PatchMapping("/{id}")
    public Ad updateAd(@PathVariable Integer id,
                       @RequestBody CreateOrUpdateAd request) {
        return adService.updateAd(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteAd(@PathVariable Integer id) {
        adService.deleteAd(id);
    }

    @GetMapping("/me")
    public Ads getAdsMe() {
        return adService.getMyAds();
    }

    @PatchMapping("/{id}/image")
    public void updateImage(@PathVariable Integer id) {
        adService.updateImage(id);
    }
}
