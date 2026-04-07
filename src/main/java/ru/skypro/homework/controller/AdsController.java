package ru.skypro.homework.controller;

import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.ad.Ad;
import ru.skypro.homework.dto.ad.Ads;
import ru.skypro.homework.dto.ad.CreateOrUpdateAd;
import ru.skypro.homework.dto.ad.ExtendedAd;

@RestController
@RequestMapping("/ads")
public class AdsController {

    @GetMapping
    public Ads getAllAds() {
        return new Ads();
    }

    @PostMapping
    public Ad addAd(CreateOrUpdateAd request) {
        return new Ad();
    }

    @GetMapping("/{id}")
    public ExtendedAd getAd(@PathVariable Integer id) {
        return new ExtendedAd();
    }

    @PatchMapping("/{id}")
    public Ad updateAd(@PathVariable Integer id, @RequestBody CreateOrUpdateAd request) {
        return new Ad();
    }

    @DeleteMapping("/{id}")
    public void deleteAd(@PathVariable Integer id) {
    }

    @GetMapping("/me")
    public Ads getAdsMe() {
        return new Ads();
    }

    @PatchMapping("/{id}/image")
    public void updateImage(@PathVariable Integer id) {
    }
}
